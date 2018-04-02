package com.study.service.impl;

import java.math.BigDecimal;
import java.util.List;








import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.study.mapper.OrderDetailMapper;
import com.study.mapper.OrderMapper;
import com.study.model.Order;
import com.study.model.OrderDetail;
import com.study.model.vo.OrderDetailVo;
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
    BigDecimal bigDecimal=new BigDecimal("0");
    if(detail!=null){
      JSONArray fromObject = JSONArray.fromObject(detail);
      for (int i = 0; i < fromObject.length(); i++) {  
        JSONObject jsonObject2 = fromObject.getJSONObject(i);
        OrderDetail bean = (OrderDetail) JSONObject.toBean(jsonObject2, OrderDetail.class);
        if(bean!=null){
          bigDecimal=bigDecimal.add(new BigDecimal(bean.getDetailMoney()==null?"0":bean.getDetailMoney()+""));
          orderDetailMapper.insert(bean);
        }
        }
      }
    order.setOrderSalesAmount(bigDecimal.doubleValue());
    orderMapper.insert(order);
    
  }

  @Override
  public void updateOrderAndDetail(Order order, String detail) {
    BigDecimal bigDecimal=new BigDecimal("0");
    if(detail!=null){
      JSONArray fromObject = JSONArray.fromObject(detail);
      for (int i = 0; i < fromObject.length(); i++) {  
        JSONObject jsonObject2 = fromObject.getJSONObject(i);
        OrderDetail bean = (OrderDetail) JSONObject.toBean(jsonObject2, OrderDetail.class);
          if(bean!=null){
            bigDecimal=bigDecimal.add(new BigDecimal(bean.getDetailMoney()==null?"0":bean.getDetailMoney()+""));
            if(bean.getDetailId()!=null){
              orderDetailMapper.updateByPrimaryKey(bean);
            }else{
              orderDetailMapper.insert(bean);
            }
          }
        }
      }
    order.setOrderSalesAmount(bigDecimal.doubleValue());
    orderMapper.updateByPrimaryKey(order);
  }

  @Override
  public String getOrderNumber(Map<String, Object> map) {
    return orderMapper.getOrderNumber(map);
  }

  @Override
  public List<OrderDetailVo> getSummary(OrderDetailVo detailVo) {
    return orderMapper.getSummary(detailVo);
  }


}
