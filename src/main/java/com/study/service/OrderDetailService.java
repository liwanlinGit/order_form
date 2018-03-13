package com.study.service;

import java.util.List;

import com.study.model.OrderDetail;
import com.study.util.bean.PageBean;

public interface OrderDetailService extends IService<OrderDetail> {
  public List<OrderDetail> getDetailsByOrderId(OrderDetail orderId,PageBean bean);
}
