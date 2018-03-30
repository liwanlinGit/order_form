package com.study.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.study.model.Order;
import com.study.model.OrderDetail;
import com.study.service.OrderDetailService;
import com.study.service.OrderService;
import com.study.util.ResultUtil;
import com.study.util.bean.DataGridResultInfo;
import com.study.util.bean.PageBean;

@Api(value="OrderDetailController",description="订单明细操作API")
@RestController
public class OrderDetailController {

  @Autowired
  private OrderDetailService orderDetailService;
  @Autowired
  private OrderService orderService;
  
  @ApiOperation(value="获取所有的订单数据",notes="获取所有的订单数据，返回grid")
  @ApiImplicitParams({
    @ApiImplicitParam(name="orderId",value="订单id",required=true,dataType="int",paramType="query"),
    @ApiImplicitParam(name="rows",value="一页多少条",required=true,dataType="int",paramType="query"),
    @ApiImplicitParam(name = "page", value = "当前页码", required = true,dataType = "int" ,paramType = "query"),
  })
  @RequestMapping(value="/orderDetails/getData",method=RequestMethod.GET)
  public DataGridResultInfo getData(@ModelAttribute PageBean bean,@RequestParam(value="orderId",required=true)Integer orderId ){
    OrderDetail detail =new OrderDetail();
    detail.setOrderId(orderId);
    List<OrderDetail> detailsByOrderId = orderDetailService.getDetailsByOrderId(detail, bean);
    PageInfo<OrderDetail> info=new PageInfo<OrderDetail>(detailsByOrderId);
    return ResultUtil.createDataGridResult(info.getTotal(),info.getList());
  }
  @RequestMapping(value="/orderDetails/getDataTree",method=RequestMethod.GET)
  public List<OrderDetail> getDataTree(@RequestParam(value="orderId",required=true)Integer orderId ){
    OrderDetail detail =new OrderDetail();
    detail.setOrderId(orderId);
    List<OrderDetail> detailsByOrderId = orderDetailService.getDetailsByOrderId(detail, null);
    return detailsByOrderId;
  }
  @ApiOperation(value="订单明细", notes="删除订单明细数据API")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "数据id", required = true ,dataType = "string" ,paramType = "query")
  })
  @RequestMapping(value = "/orderDetails/delete",method={RequestMethod.DELETE})
  public String delete(@RequestParam(value="ids") String ids){
      try{
         if(ids!=null){
           String[] idsArry=ids.split(",");
           for (String id : idsArry) {
             OrderDetail orderDetail = orderDetailService.selectByKey(Integer.parseInt(id));
             Order selectByKey = orderService.selectByKey(orderDetail.getOrderId());
             selectByKey.setOrderSalesAmount(selectByKey.getOrderSalesAmount()-orderDetail.getDetailMoney());
             orderService.updateNotNull(selectByKey);
             orderDetailService.delete(Integer.parseInt(id));
          }
         }
          return "success";
      }catch (Exception e){
          e.printStackTrace();
          return "fail";
      }
  }
}
