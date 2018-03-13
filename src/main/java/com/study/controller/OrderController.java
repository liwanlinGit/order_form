package com.study.controller;

import java.util.List;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


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
  public DataGridResultInfo getData(@ModelAttribute PageBean bean,@ModelAttribute Order order){
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
  
  
}
