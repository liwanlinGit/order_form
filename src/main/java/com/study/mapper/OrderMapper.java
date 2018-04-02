package com.study.mapper;

import java.util.List;
import java.util.Map;

import com.study.model.Order;
import com.study.model.vo.OrderDetailVo;
import com.study.util.MyMapper;

public interface OrderMapper extends MyMapper<Order> {
  
  public List<Order> getOrdersByAll(Order order);
  
  public Integer getOrderMaxId();
  
  public String getOrderNumber(Map<String, Object> map);
  
  public List<OrderDetailVo> getSummary(OrderDetailVo detailVo);
}