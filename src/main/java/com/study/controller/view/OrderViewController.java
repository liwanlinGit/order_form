package com.study.controller.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.Dictionarydata;
import com.study.model.Order;
import com.study.service.DictdataService;
import com.study.service.OrderService;
import com.study.util.bean.MenuBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="OrderViewController",description="订单操作页面跳转")
@Controller
public class OrderViewController {
  @Autowired
  private OrderService orderService;
  @Autowired
  private DictdataService dictdataService;
  
  @ApiOperation(value="跳转添加、修改",notes="跳转添加、修改")
  @ApiImplicitParams({
    @ApiImplicitParam(name="orderId",value="订单id",required=false,dataType="int",paramType="query"),
    @ApiImplicitParam(name="menuName",value="当前tab名称",required=false,dataType="string",paramType="query"),
    @ApiImplicitParam(name="parentMenuName",value="父页面tab名称",required=false,dataType="string",paramType="query")
  })
  @RequestMapping(value="/orders/add")
  public String add(HttpServletRequest request,@RequestParam(value="orderId",required=false)Integer orderId,@ModelAttribute MenuBean bean){
    
    request.setAttribute("menu", bean);
    
    List<Dictionarydata> dicts = dictdataService.selectDictdataByParentId(null, null);
    request.setAttribute("dicts", dicts);
    if(orderId!=null){
      request.setAttribute("orderId", orderId);
      Order order = orderService.selectByKey(orderId);
      request.setAttribute("order", order);
      return "orders/orders_edit";
    }else{
      Integer orderMaxId = orderService.getOrderMaxId();
      request.setAttribute("orderId", orderMaxId==null?1:orderMaxId+1);
      return "orders/orders_add";
    }
    
  }
}
