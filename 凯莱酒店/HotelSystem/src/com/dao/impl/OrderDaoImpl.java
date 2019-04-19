package com.dao.impl;

import com.dao.OrderDao;
import com.hibernate.order.OrderTableEntity;
import com.service.order.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.hibernate.order.OrderTableEntity;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现OderDao类
 *
 */
public class OrderDaoImpl implements OrderDao {

    /**
     * 保存一个订单  -->增
     * @param order
     * @return Boolean 保存是否成功
     */
    @Override
    public Boolean save(Order order) {
        try {
            //// 给常量赋值
            // 加载配置文件
            StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
            //// 生成factory对象
            SessionFactory factory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            // 3. 创建session对象
            Session session = factory.openSession();
            // 4. 开启事务
            Transaction tran = session.beginTransaction();
            // 5. 编写保存的代码
            OrderTableEntity orderTableEntity = new OrderTableEntity();

            orderTableEntity.setOrderId(order.getOrderId());
            orderTableEntity.setOrderRoomId(order.getOrderRoomId());
            orderTableEntity.setOrderClientName(order.getOrderClientName());
            orderTableEntity.setOrderClientSex(order.getOrderClientSex());
            orderTableEntity.setOrderClientId(order.getOrderClientId());
            orderTableEntity.setOrderDate(order.getOrderDate());
            orderTableEntity.setOderLeaveDate(order.getOderLeaveDate());
            orderTableEntity.setOrderHotelType(order.getOrderHotelType());
            orderTableEntity.setOrderCashpledge(order.getOrderCashpledge());
            orderTableEntity.setOrderHotelPrice(order.getOrderHotelPrice());
            orderTableEntity.setOrderHotelPayment(order.getOrderHotelPayment());

            // 保存数据，操作对象就相当于操作数据库的表结构
            session.save(orderTableEntity);

            // 6. 提交事务
            tran.commit();

            // 7. 释放资源
            session.close();
            factory.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 提取所有订单   -->查
     * @return  ArrayList<Order>
     */
    @Override
    public List<OrderTableEntity> findAll() {
        SessionFactory sf = null;
        Session session = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("from OrderTableEntity");
            //2、使用Query对象的list方法得到数据集合
            List<OrderTableEntity> list = query.list();
            //3、返回客户所有订单列表
            tran.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sf.close();
        }
        return null;
    }

    /**
     * 提取某人所有订单   -->查
     * @param name
     * @return  订单列表 订单类型
     */
    @Override
    public List<OrderTableEntity> find(String name) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tran = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            tran = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("from OrderTableEntity where orderClientName like ?");
            // 2、填写上一步中占位符的内容
            query.setParameter(0, name);
            // 3、使用Query对象的list方法得到数据集合
            List<OrderTableEntity> list = query.list();
            // 3、返回该人所有订单
            for (OrderTableEntity orderTableEntity:list) {
                System.out.println(orderTableEntity.toString());
            }
            tran.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sf.close();
        }
        return null;
    }

    /**
     * 删除一个订单   -->删
     * @param orderId
     * @return
     */
    @Override
    public Boolean del(long orderId) {
        SessionFactory sf = null;
        Session session = null;
        try {
            // 1. 先加载配置文件
            // 简写的方法，默认加载src目录下hibernate.cfg.xml的配置文件
            Configuration config = new Configuration().configure();

            // 2. 创建SessionFactory对象
            sf = config.buildSessionFactory();
            // 3. 创建session对象
            session = sf.openSession();
            // 4. 开启事务
            Transaction tran = session.beginTransaction();
            // 5. 编写实体
            //找到该条数据，返回一个实体
            OrderTableEntity orderTableEntity = session.get(OrderTableEntity.class,orderId);
            //如果不等于空  删除  如果空 则表示无此 实体，无需删除
            if(orderTableEntity != null){
                //从数据库中删除
                session.delete(orderTableEntity);
                //6.提交该事物
                tran.commit();
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            // 7. 释放资源
            session.close();
            sf.close();
        }
        return false;
    }

    /**
     * 修改一个订单  ->改
     * @param orderTableEntity
     * @return
     */
    @Override
    public Boolean revise(OrderTableEntity orderTableEntity) {
        SessionFactory sf = null;
        Session session = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            //如果存在更新    不存在 增加
            session.saveOrUpdate(orderTableEntity);
            tran.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sf.close();
        }
        return null;
    }
}
