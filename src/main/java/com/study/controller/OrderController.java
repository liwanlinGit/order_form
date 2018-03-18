package com.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.study.model.Order;
import com.study.model.OrderDetail;
import com.study.model.User;
import com.study.service.OrderDetailService;
import com.study.service.OrderService;
import com.study.util.ResultUtil;
import com.study.util.bean.DataGridResultInfo;
import com.study.util.bean.PageBean;


@Api(value="OrderController",description="订单操作API")
@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;
  @Autowired
  private OrderDetailService orderDetailService;
  
  
  @ApiOperation(value="获取所有的订单数据",notes="获取所有的订单数据，返回grid")
  @ApiImplicitParams({
    @ApiImplicitParam(name="rows",value="一页多少条",required=true,dataType="int",paramType="query"),
    @ApiImplicitParam(name = "page", value = "当前页码", required = true,dataType = "int" ,paramType = "query"),
  })
  @RequestMapping(value="/orders/getData",method=RequestMethod.GET)
  public DataGridResultInfo getData(@ModelAttribute PageBean bean,@ModelAttribute Order order,HttpServletRequest request){
    User user = (User)request.getSession().getAttribute("userSession");
    order.setOrderSingle(user.getId()+"");
    List<Order> ordersByAll = orderService.getOrdersByAll(order, bean);
    PageInfo<Order> info=new PageInfo<Order>(ordersByAll);
    return ResultUtil.createDataGridResult(info.getTotal(),info.getList());
  }
  
  @ApiOperation(value="添加保存",notes="添加保存API")
  @RequestMapping(value="/orders/add",method=RequestMethod.POST)
  public String add(@ModelAttribute Order orders,@RequestParam String details){
    try {
      orderService.addOrderAndDetail(orders, details);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
  }
  
  @ApiOperation(value="修改保存",notes="添加保存API")
  @RequestMapping(value="/orders/edit",method=RequestMethod.POST)
  public String edit(@ModelAttribute Order orders,@RequestParam String details){
    try {
      orderService.updateOrderAndDetail(orders, details);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
  }
  @ApiOperation(value="订单状态", notes="修改订单状态API")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "id", value = "数据id", required = true ,dataType = "string" ,paramType = "query")
  })
  @RequestMapping(value = "/orders/off",method={RequestMethod.GET})
  public String off(@RequestParam(value="id") String id,HttpServletRequest request){
    try{
     SimpleDateFormat orderReviewTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Order selectByKey = orderService.selectByKey(Integer.parseInt(id));
    selectByKey.setOrderStatus("1");
    User user = (User)request.getSession().getAttribute("userSession");
    selectByKey.setOrderReview(user.getId()+"");
    selectByKey.setOrderReviewTime(orderReviewTime.format(new Date()));
    orderService.updateNotNull(selectByKey);
    return "success";
    }catch (Exception e){
      e.printStackTrace();
      return "fail";
  }
    
  }
  @RequestMapping(value = "/orders/on",method={RequestMethod.GET})
  public String on(@RequestParam(value="id") String id,HttpServletRequest request){
    try{
    Order selectByKey = orderService.selectByKey(Integer.parseInt(id));
    selectByKey.setOrderStatus(null);
    selectByKey.setOrderReview(null);
    selectByKey.setOrderReviewTime(null);
    orderService.updateAll(selectByKey);
    return "success";
    }catch (Exception e){
      e.printStackTrace();
      return "fail";
  }
    
  }
  @ApiOperation(value="订单数据类别", notes="删除订单数据API")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "数据id", required = true ,dataType = "string" ,paramType = "query")
  })
  @RequestMapping(value = "/orders/delete",method={RequestMethod.DELETE})
  public String delete(@RequestParam(value="ids") String ids){
      try{
         if(ids!=null){
           String[] idsArry=ids.split(",");
           for (String id : idsArry) {
             orderService.delete(Integer.parseInt(id));
             OrderDetail orderId=new OrderDetail();
             orderId.setOrderId(Integer.parseInt(id));
             List<OrderDetail> detailsByOrderId = orderDetailService.getDetailsByOrderId(orderId, null);
             if(detailsByOrderId!=null&&detailsByOrderId.size()>0){
               for (OrderDetail orderDetail : detailsByOrderId) {
                 orderDetailService.delete(orderDetail.getDetailId());
              }
             }
          }
         }
          return "success";
      }catch (Exception e){
          e.printStackTrace();
          return "fail";
      }
  }
  
  @RequestMapping(value = "/orders/print1")
  public void print(@RequestParam(value="id") String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
    Order bean=new Order();
    User user = (User)request.getSession().getAttribute("userSession");
    bean.setOrderSingle(user.getId()+"");
    bean.setOrderId(Integer.parseInt(id));
    List<Order> ordersByAll = orderService.getOrdersByAll(bean, null);
    Order order=ordersByAll.get(0);
    OrderDetail detail =new OrderDetail();
    detail.setOrderId(Integer.parseInt(id));
    List<OrderDetail> details = orderDetailService.getDetailsByOrderId(detail, null);
    XWPFDocument document= new XWPFDocument();
    String path = request.getSession().getServletContext().getRealPath("/");
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName=dateFormat.format(new Date())+".docx";
    FileOutputStream out = new FileOutputStream(new File(path+File.separator+fileName));  
  //添加标题  
    XWPFParagraph titleParagraph = document.createParagraph();  
    //设置段落居中  
    titleParagraph.setAlignment(ParagraphAlignment.CENTER);  

    XWPFRun titleParagraphRun = titleParagraph.createRun();  
    titleParagraphRun.setText("盼盼散热器北京分公司提货单");  
    titleParagraphRun.setColor("000000");  
    titleParagraphRun.setFontSize(20);  


    /*//段落  
    XWPFParagraph firstParagraph = document.createParagraph();  
    XWPFRun run = firstParagraph.createRun();  
    run.setText("Java POI 生成word文件。");  
    run.setColor("696969");  
    run.setFontSize(16);  */

    //设置段落背景颜色  
   /* CTShd cTShd = run.getCTR().addNewRPr().addNewShd();  
    cTShd.setVal(STShd.CLEAR);  
    cTShd.setFill("97FFFF");  */


    //换行  
    /*XWPFParagraph paragraph1 = document.createParagraph();  
    XWPFRun paragraphRun1 = paragraph1.createRun();  
    paragraphRun1.setText("\r");  */


    //基本信息表格  
    XWPFTable infoTable = document.createTable();  
    //去表格边框  
    infoTable.getCTTbl().getTblPr().unsetTblBorders();  


    //列宽自动分割  
    CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();  
    infoTableWidth.setType(STTblWidth.DXA);  
    infoTableWidth.setW(BigInteger.valueOf(9072));  


    //表格第一行  
    XWPFTableRow infoTableRowOne = infoTable.getRow(0);  
    infoTableRowOne.addNewTableCell().setText("合同编号:"+(order.getOrderContractNumber()==null?"":order.getOrderContractNumber()));  
    infoTableRowOne.addNewTableCell().setText("经销商:"+(order.getStoreName()==null?"":order.getStoreName()));
    infoTableRowOne.addNewTableCell().setText("订货日期"+(order.getOrderDate()==null?"":order.getOrderDate()));

    /*//表格第二行  
    XWPFTableRow infoTableRowTwo = infoTable.createRow();  
    infoTableRowTwo.getCell(0).setText("姓名");  
    infoTableRowTwo.getCell(1).setText(": seawater");  

    //表格第三行  
    XWPFTableRow infoTableRowThree = infoTable.createRow();  
    infoTableRowThree.getCell(0).setText("生日");  
    infoTableRowThree.getCell(1).setText(": xxx-xx-xx");  

    //表格第四行  
    XWPFTableRow infoTableRowFour = infoTable.createRow();  
    infoTableRowFour.getCell(0).setText("性别");  
    infoTableRowFour.getCell(1).setText(": 男");  

    //表格第五行  
    XWPFTableRow infoTableRowFive = infoTable.createRow();  
    infoTableRowFive.getCell(0).setText("现居地");  
    infoTableRowFive.getCell(1).setText(": xx");  */


    //两个表格之间加个换行  
    XWPFParagraph paragraph = document.createParagraph();  
    XWPFRun paragraphRun = paragraph.createRun();  
    paragraphRun.setText("\r");  



    //工作经历表格  
    XWPFTable ComTable = document.createTable();  


    //列宽自动分割  
    CTTblWidth comTableWidth = ComTable.getCTTbl().addNewTblPr().addNewTblW();  
    comTableWidth.setType(STTblWidth.DXA);  
    comTableWidth.setW(BigInteger.valueOf(9072));  

    //表格第一行  
    XWPFTableRow comTableRowOne = ComTable.getRow(0);  
    comTableRowOne.getCell(0).setText("序号");  
    comTableRowOne.addNewTableCell().setText("系列");  
    comTableRowOne.addNewTableCell().setText("型号");  
    comTableRowOne.addNewTableCell().setText("片数");
    comTableRowOne.addNewTableCell().setText("组数");
    comTableRowOne.addNewTableCell().setText("颜色");
    comTableRowOne.addNewTableCell().setText("进水方式");
    comTableRowOne.addNewTableCell().setText("接口口径");
    comTableRowOne.addNewTableCell().setText("备注");

    for (int i=0;i< details.size(); i++) {
      XWPFTableRow comTableRow = ComTable.createRow();
      comTableRow.getCell(0).setText((i+1)+"");  
      comTableRow.getCell(1).setText(details.get(i).getDetailSeriesName()==null?"":details.get(i).getDetailSeriesName());  
      comTableRow.getCell(2).setText(details.get(i).getDetailModelName()==null?"":details.get(i).getDetailModelName());  
      comTableRow.getCell(3).setText(details.get(i).getDetailNumber()==null?"":details.get(i).getDetailNumber()+""); 
      comTableRow.getCell(4).setText(details.get(i).getDetailNumberGroup()==null?"":details.get(i).getDetailNumberGroup()+"");
      comTableRow.getCell(5).setText(details.get(i).getDetailColorName()==null?"":details.get(i).getDetailColorName());
      comTableRow.getCell(6).setText(details.get(i).getDetailWaterTypeName()==null?"":details.get(i).getDetailWaterTypeName());
      comTableRow.getCell(7).setText(details.get(i).getDetailInterfaceCaliberName()==null?"":details.get(i).getDetailInterfaceCaliberName());
      comTableRow.getCell(8).setText(details.get(i).getDetailRemark()==null?"":details.get(i).getDetailRemark());
    }
    
    XWPFParagraph paragraph1 = document.createParagraph();  
    XWPFRun paragraphRun1 = paragraph1.createRun();  
    paragraphRun1.setText("\r");  
    
  //基本信息表格  
    XWPFTable infoTable2 = document.createTable();  
    //去表格边框  
    infoTable2.getCTTbl().getTblPr().unsetTblBorders();  

    //列宽自动分割  
    CTTblWidth infoTableWidth2 = infoTable2.getCTTbl().addNewTblPr().addNewTblW();  
    infoTableWidth2.setType(STTblWidth.DXA);  
    infoTableWidth2.setW(BigInteger.valueOf(9072));  
    XWPFTableRow infoTableRowOne1 = infoTable2.getRow(0);  
    infoTableRowOne1.addNewTableCell().setText("审核人:"+(order.getOrderReviewName()==null?"":order.getOrderReviewName()));
    infoTableRowOne1.addNewTableCell().setText("审核日期:"+(order.getOrderReviewTime()==null?"":order.getOrderReviewTime()));
    document.write(out);  
    out.close();
    InputStream inStream = new FileInputStream(path+File.separator+fileName);// 文件的存放路径
    // 设置输出的格式
    response.reset();
    response.setContentType("bin");
    response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
    // 循环取出流中的数据
    byte[] b = new byte[100];
    int len;
        while ((len = inStream.read(b)) > 0)
            response.getOutputStream().write(b, 0, len);
        inStream.close();
    
  }
}
