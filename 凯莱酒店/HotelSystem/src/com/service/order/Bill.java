package com.service.order;

import com.dao.impl.OrderDaoImpl;
import com.hibernate.order.OrderTableEntity;

import java.util.List;


public class Bill {
    private int orderNumber = 0;
    private double orderAggregateAmonut = 0.0;
    private List<OrderTableEntity> orderTableEntityList;

    public Bill() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        this.orderTableEntityList = orderDao.findAll();
    }

    public List<OrderTableEntity> getOrderTableEntityList() {
        return orderTableEntityList;
    }

    public void setOrderTableEntityList(List<OrderTableEntity> orderTableEntityList) {
        this.orderTableEntityList = orderTableEntityList;
    }

    public int getOrderNumber() {
        return getOrderTableEntityList().size();
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderAggregateAmonut() {
        for (OrderTableEntity o: getOrderTableEntityList()) {
            orderAggregateAmonut = orderAggregateAmonut + o.getOrderHotelPrice();
        }
        return orderAggregateAmonut;
    }

    public void setOrderAggregateAmonut(double orderAggregateAmonut) {
        this.orderAggregateAmonut = orderAggregateAmonut;
    }
}
