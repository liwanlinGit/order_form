package com.study.service;

import java.util.List;
import java.util.Map;

import com.study.model.Order;
import com.study.util.bean.PageBean;

public interface OrderService  extends IService<Order> {
  public List<Order> getOrdersByAll(Order order,PageBean bean);
  
  public Integer getOrderMaxId();
  
  public String getOrderNumber(Map<String, Object> map);
  public void addOrderAndDetail(Order order,String detail);
  public void updateOrderAndDetail(Order order,String detail);
}
