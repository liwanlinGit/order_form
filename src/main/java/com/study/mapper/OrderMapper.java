package com.study.mapper;

import java.util.List;

import com.study.model.Order;
import com.study.util.MyMapper;

public interface OrderMapper extends MyMapper<Order> {
  
  public List<Order> getOrdersByAll(Order order);
  
  public Integer getOrderMaxId();
}