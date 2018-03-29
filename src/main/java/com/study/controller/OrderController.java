package com.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
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
  public DataGridResultInfo getData(@ModelAttribute PageBean bean,@ModelAttribute Order order,HttpServletRequest request,String store){
    User user = (User)request.getSession().getAttribute("userSession");
    if(!"0001".equals(user.getUsername())){
      order.setOrderSingle(user.getId()+"");
    }
    if("".equals(order.getOrderStatus())||order.getOrderStatus()==null){
      order.setOrderStatus(2+"");
    }
    if("".equals(store)||store==null){
      order.setOrderType(0);
    }else{
      order.setOrderType(Integer.parseInt(store));
    }
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
    if(!"0001".equals(user.getUsername())){
      bean.setOrderSingle(user.getId()+"");
    }
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
  if(details!=null&&details.size()>0){
  
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
  
  
  @RequestMapping(value = "/orders/excel")
  public void excel(@RequestParam(value="id") String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
    Order bean=new Order();
    User user = (User)request.getSession().getAttribute("userSession");
    if(!"0001".equals(user.getUsername())){
      bean.setOrderSingle(user.getId()+"");
    }
    bean.setOrderId(Integer.parseInt(id));
    List<Order> ordersByAll = orderService.getOrdersByAll(bean, null);
    Order order=ordersByAll.get(0);
    OrderDetail detail =new OrderDetail();
    detail.setOrderId(Integer.parseInt(id));
    List<OrderDetail> details = orderDetailService.getDetailsByOrderId(detail, null);
    String sheetName = "盼盼散热器北京分公司提货单";  
    String titleName = "盼盼散热器北京分公司提货单";  
    String fileName = "盼盼散热器北京分公司提货单";  
    int columnNumber = 9;  
    int[] columnWidth = { 10, 20, 30,30,30,30,30,30,30 };  
    String[] columnName = { "序号", "系列", "型号" , "片数", "组数", "颜色", "进水方式", "接口口径", "备注"};  
    ExportWithResponse(sheetName, titleName, fileName,  
            columnNumber, columnWidth, columnName,response,details,order);  
    
    
  }
  public void ExportWithResponse(String sheetName, String titleName,  
      String fileName, int columnNumber, int[] columnWidth,  
      String[] columnName, HttpServletResponse response,List<OrderDetail> orderDetail,Order order) throws Exception {  
  if (columnNumber == columnWidth.length&& columnWidth.length == columnName.length) {  
      // 第一步，创建一个webbook，对应一个Excel文件  
      HSSFWorkbook wb = new HSSFWorkbook();  
      // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
      HSSFSheet sheet = wb.createSheet(sheetName);  
      // sheet.setDefaultColumnWidth(15); //统一设置列宽  
      for (int i = 0; i < columnNumber; i++)   
      {  
          for (int j = 0; j <= i; j++)   
          {  
              if (i == j)   
              {  
                  sheet.setColumnWidth(i, columnWidth[j] * 256); // 单独设置每列的宽  
              }  
          }  
      }  
      // 创建第0行 也就是标题  
      HSSFRow row1 = sheet.createRow((int) 0);  
      row1.setHeightInPoints(50);// 设备标题的高度  
      // 第三步创建标题的单元格样式style2以及字体样式headerFont1  
      HSSFCellStyle style2 = wb.createCellStyle();  
      style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
      style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
     /* style2.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index); */ 
      /*style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  */
      HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式  
      headerFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
      headerFont1.setFontName("黑体"); // 设置字体类型  
      headerFont1.setFontHeightInPoints((short) 15); // 设置字体大小  
      style2.setFont(headerFont1); // 为标题样式设置字体样式  

      HSSFCell cell1 = row1.createCell(0);// 创建标题第一列  
      sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,  
              columnNumber - 1)); // 合并列标题  
      cell1.setCellValue(titleName); // 设置值标题  
      cell1.setCellStyle(style2); // 设置标题样式  

      
      
      sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 2));
      sheet.addMergedRegion(new CellRangeAddress(1, 1, 3, 5));
      sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, 8));
      HSSFRow rowOne = sheet.createRow((int) 1);  
      rowOne.setHeightInPoints(30);// 设置表头高度  
      
      
      // 创建第1行 也就是表头  
      HSSFRow row = sheet.createRow((int) 2);  
      row.setHeightInPoints(37);// 设置表头高度  
       
      
      // 第四步，创建表头单元格样式 以及表头的字体样式  
      HSSFCellStyle style = wb.createCellStyle();  
      style.setWrapText(true);// 设置自动换行  
      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
      style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式  

      style.setBottomBorderColor(HSSFColor.BLACK.index);  
      style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
      style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
      style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
      style.setBorderTop(HSSFCellStyle.BORDER_THIN);  

      HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式  
      headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
      headerFont.setFontName("黑体"); // 设置字体类型  
      headerFont.setFontHeightInPoints((short) 10); // 设置字体大小  
      style.setFont(headerFont); // 为标题样式设置字体样式  
      
      for (int i = 0; i < columnNumber; i++) {
        HSSFCell cellOne = rowOne.createCell(i);
        cellOne.setCellStyle(style);
      }  
        
      HSSFCell cellOne = rowOne.createCell(0);  
      cellOne.setCellValue("合同编号:"+(order.getOrderContractNumber()==null?"":order.getOrderContractNumber()));  
      cellOne.setCellStyle(style);
      HSSFCell cellTwo = rowOne.createCell(3);  
      cellTwo.setCellValue("经销商:"+(order.getStoreName()==null?"":order.getStoreName()));  
      cellTwo.setCellStyle(style);
      HSSFCell cellThree = rowOne.createCell(6);  
      cellThree.setCellValue("订货日期:"+(order.getOrderDate()==null?"":order.getOrderDate()));  
      cellThree.setCellStyle(style);
      // 第四.一步，创建表头的列  
      for (int i = 0; i < columnNumber; i++)   
      {  
          HSSFCell cell = row.createCell(i);  
          cell.setCellValue(columnName[i]);  
          cell.setCellStyle(style);  
      }  

      // 第五步，创建单元格，并设置值  
      if(orderDetail!=null&&orderDetail.size()>0){
        
      
      for (int i = 0; i < orderDetail.size(); i++)   
      {  
          row = sheet.createRow((int) i + 3);  
          // 为数据内容设置特点新单元格样式1 自动换行 上下居中  
          HSSFCellStyle zidonghuanhang = wb.createCellStyle();  
          zidonghuanhang.setWrapText(true);// 设置自动换行  
          zidonghuanhang.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式  

          // 设置边框  
          zidonghuanhang.setBottomBorderColor(HSSFColor.BLACK.index);  
          zidonghuanhang.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
          zidonghuanhang.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
          zidonghuanhang.setBorderRight(HSSFCellStyle.BORDER_THIN);  
          zidonghuanhang.setBorderTop(HSSFCellStyle.BORDER_THIN);  

          // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中  
          HSSFCellStyle zidonghuanhang2 = wb.createCellStyle();  
          zidonghuanhang2.setWrapText(true);// 设置自动换行  
          zidonghuanhang2  
                  .setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个上下居中格式  
          zidonghuanhang2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  

          // 设置边框  
          zidonghuanhang2.setBottomBorderColor(HSSFColor.BLACK.index);  
          zidonghuanhang2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
          zidonghuanhang2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
          zidonghuanhang2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
          zidonghuanhang2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
          HSSFCell datacell1 = row.createCell(0);
          datacell1.setCellValue(i+1);  
          datacell1.setCellStyle(zidonghuanhang2); 
          HSSFCell datacell2 = row.createCell(1);
          datacell2.setCellValue(orderDetail.get(i).getDetailSeriesName()==null?"":orderDetail.get(i).getDetailSeriesName());  
          datacell2.setCellStyle(zidonghuanhang2);
          HSSFCell datacell3 = row.createCell(2);
          datacell3.setCellValue(orderDetail.get(i).getDetailModelName()==null?"":orderDetail.get(i).getDetailModelName());  
          datacell3.setCellStyle(zidonghuanhang2);
          HSSFCell datacell4 = row.createCell(3);
          datacell4.setCellValue(orderDetail.get(i).getDetailNumber()==null?"":orderDetail.get(i).getDetailNumber()+"");  
          datacell4.setCellStyle(zidonghuanhang2);
          HSSFCell datacell5 = row.createCell(4);
          datacell5.setCellValue(orderDetail.get(i).getDetailNumberGroup()==null?"":orderDetail.get(i).getDetailNumberGroup()+"");  
          datacell5.setCellStyle(zidonghuanhang2);
          HSSFCell datacell6 = row.createCell(5);
          datacell6.setCellValue(orderDetail.get(i).getDetailColorName()==null?"":orderDetail.get(i).getDetailColorName());  
          datacell6.setCellStyle(zidonghuanhang2);
          HSSFCell datacell7 = row.createCell(6);
          datacell7.setCellValue(orderDetail.get(i).getDetailWaterTypeName()==null?"":orderDetail.get(i).getDetailWaterTypeName());  
          datacell7.setCellStyle(zidonghuanhang2);
          HSSFCell datacell8 = row.createCell(7);
          datacell8.setCellValue(orderDetail.get(i).getDetailInterfaceCaliberName()==null?"":orderDetail.get(i).getDetailInterfaceCaliberName());  
          datacell8.setCellStyle(zidonghuanhang2);
          HSSFCell datacell9 = row.createCell(8);
          datacell9.setCellValue(orderDetail.get(i).getDetailRemark()==null?"":orderDetail.get(i).getDetailRemark());  
          datacell9.setCellStyle(zidonghuanhang2);
      }  
      
      }
      sheet.addMergedRegion(new CellRangeAddress((orderDetail==null?0:orderDetail.size())+3, (orderDetail==null?0:orderDetail.size())+3, 0, 3));
      sheet.addMergedRegion(new CellRangeAddress((orderDetail==null?0:orderDetail.size())+3, (orderDetail==null?0:orderDetail.size())+3, 4, 8));
      HSSFRow last = sheet.createRow((int) orderDetail.size()+3); 
      for (int i = 0; i < columnNumber; i++) {
        HSSFCell cellLast = last.createCell(i);
        cellLast.setCellStyle(style);
      } 
      last.setHeightInPoints(30);// 设置表头高度  
      HSSFCell celllast1 = last.createCell(0);  
      celllast1.setCellValue("审核人:"+(order.getOrderReviewName()==null?"":order.getOrderReviewName()));  
      celllast1.setCellStyle(style);
      HSSFCell celllast2 = last.createCell(4);  
      celllast2.setCellValue("审核日期:"+(order.getOrderReviewTime()==null?"":order.getOrderReviewTime()));  
      celllast2.setCellStyle(style);
      // 第六步，将文件存到浏览器设置的下载位置  
      String filename = fileName + ".xls";  
      response.setContentType("application/ms-excel;charset=UTF-8");  
      response.setHeader("Content-Disposition", "attachment;filename="  
              .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));  
      OutputStream out = response.getOutputStream();  
      try {  
          wb.write(out);// 将数据写出去  
          String str = "导出" + fileName + "成功！";  
          System.out.println(str);  
      } catch (Exception e) {  
          e.printStackTrace();  
          String str1 = "导出" + fileName + "失败！";  
          System.out.println(str1);  
      } finally {  
          out.close();  
      }  
  } else {  
      System.out.println("列数目长度名称三个数组长度要一致");  
  }  

}  
}
