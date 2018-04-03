package com.study.controller.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.model.Dictionarydata;
import com.study.model.vo.OrderDetailVo;
import com.study.service.DictdataService;
import com.study.service.OrderService;

@Api(value="SummaryViewController",description="汇总统计")
@Controller
public class SummaryViewController {
  @Autowired
  private DictdataService dictdataService;
  @Autowired
  private OrderService orderService;
  @RequestMapping("/day/{menuName}/{id}")
  public String day(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OrderDetailVo orderDetailVo,String store ){
   
    if("".equals(orderDetailVo.getOrderStatus())||orderDetailVo.getOrderStatus()==null){
      orderDetailVo.setOrderStatus(2+"");
    }
    if("".equals(store)||store==null){
      orderDetailVo.setOrderType(0);
    }else{
      orderDetailVo.setOrderType(Integer.parseInt(store));
    }
    List<OrderDetailVo> summary = orderService.getSummary(orderDetailVo);
    request.setAttribute("summary", summary);
    request.setAttribute("vo", orderDetailVo);
    request.setAttribute("store", store);
    List<Dictionarydata> dicts = dictdataService.selectDictdataByParentId(null, null);
    request.setAttribute("dicts", dicts);
    return "day/day";
  }
}
