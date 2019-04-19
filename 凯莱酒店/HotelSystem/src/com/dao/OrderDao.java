package com.dao;

import com.hibernate.order.OrderTableEntity;
import com.service.order.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderDao接口
 * 方法：增删改查
 */
public interface OrderDao {
    /**
     * 保存一个订单
     * @param order
     * @return Boolean 保存是否成功
     */
    public Boolean save(Order order);

    /**
     * 提取所有订单信息
     * @param
     * @return ArrayList 所有订单集合
     */
    public List<OrderTableEntity> findAll();

    /**
     * 提取某人所有订单
     * @param name
     * @return  Order 订单类型
     */
    public  List<OrderTableEntity> find(String name);

    /**
     * 删除一个订单订单     取消一个订单
     * @param orderId
     * @return  Boolean 删除是否成功
     */
    public Boolean del(long orderId);

    /**
     * 修改某订单信息
     * @param orderTableEntity
     * @return  Boolean 返回修改是否成功
     */
    public Boolean revise(OrderTableEntity orderTableEntity);

}
