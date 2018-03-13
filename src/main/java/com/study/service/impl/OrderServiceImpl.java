package com.study.service.impl;

import java.util.List;








import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.study.mapper.OrderDetailMapper;
import com.study.mapper.OrderMapper;
import com.study.model.Order;
import com.study.model.OrderDetail;
import com.study.service.OrderService;
import com.study.util.PageBeanUtil;
import com.study.util.bean.PageBean;

@Service(value="orderService")
public class OrderServiceImpl extends BaseService<Order> implements OrderService {

  @Autowired
  private OrderMapper orderMapper;
  @Autowired
  private OrderDetailMapper orderDetailMapper;
  
  @Override
  public List<Order> getOrdersByAll(Order order, PageBean bean) {
    if(PageBeanUtil.pageBeanIsNotEmpty(bean)){
      PageHelper.startPage(bean.getPage(), bean.getRows());
    }
    List<Order> ordersByAll = orderMapper.getOrdersByAll(order);
    return ordersByAll;
  }

  @Override
  public Integer getOrderMaxId() {
    return orderMapper.getOrderMaxId();
  }

  @Override
  public void addOrderAndDetail(Order order, String detail) {
    if(detail!=null){
      JSONArray fromObject = JSONArray.fromObject(detail);
      for (int i = 0; i < fromObject.length(); i++) {  
        JSONObject jsonObject2 = fromObject.getJSONObject(i);
        OrderDetail bean = (OrderDetail) JSONObject.toBean(jsonObject2, OrderDetail.class);
        if(bean!=null){
          orderDetailMapper.insert(bean);
        }
        }
      }
    orderMapper.insert(order);
    
  }

  @Override
  public void updateOrderAndDetail(Order order, String detail) {
    if(detail!=null){
      JSONArray fromObject = JSONArray.fromObject(detail);
      for (int i = 0; i < fromObject.length(); i++) {  
        JSONObject jsonObject2 = fromObject.getJSONObject(i);
        OrderDetail bean = (OrderDetail) JSONObject.toBean(jsonObject2, OrderDetail.class);
          if(bean!=null){
            if(bean.getDetailId()!=null){
              orderDetailMapper.updateByPrimaryKey(bean);
            }else{
              orderDetailMapper.insert(bean);
            }
          }
        }
      }
    
    orderMapper.updateByPrimaryKey(order);
  }


}
