package com.study.mapper;

import java.util.List;

import com.study.model.OrderDetail;
import com.study.util.MyMapper;

public interface OrderDetailMapper extends MyMapper<OrderDetail> {
  
  public List<OrderDetail> getDetailsByOrderId(OrderDetail orderDetail);
}