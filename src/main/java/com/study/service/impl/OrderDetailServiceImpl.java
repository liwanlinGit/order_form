package com.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.study.mapper.OrderDetailMapper;
import com.study.model.OrderDetail;
import com.study.service.OrderDetailService;
import com.study.util.PageBeanUtil;
import com.study.util.bean.PageBean;

@Service(value="orderDetailService")
public class OrderDetailServiceImpl extends BaseService<OrderDetail> implements OrderDetailService{

  @Autowired
  private OrderDetailMapper orderDetailMapper;
  @Override
  public List<OrderDetail> getDetailsByOrderId(OrderDetail orderDetail,PageBean bean) {
    if(PageBeanUtil.pageBeanIsNotEmpty(bean)){
      PageHelper.startPage(bean.getPage(), bean.getRows());
    }
    List<OrderDetail> detailsByOrderId = orderDetailMapper.getDetailsByOrderId(orderDetail);
    return detailsByOrderId;
  }

}
