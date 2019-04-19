package com.dao.tool.impl;

import com.dao.tool.DaoTool;
import com.hibernate.admin.AdminTableEntity;
import com.hibernate.order.OrderTableEntity;
import com.hibernate.room.RoomTableEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DaoToolImpl implements DaoTool {

    @Override
    public Boolean dataOperation(Object object, String operation) {
        return null;
    }

    /**
     *  增 删 方法
     * @param adminTableEntity
     * @param operation
     * @return
     */
    public Boolean dataOperation(AdminTableEntity adminTableEntity, String operation) {
        SessionFactory sf = null;
        Session session = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            // 增 改 删
            if (operation.equalsIgnoreCase("增加") | operation.equalsIgnoreCase("修改")){
                session.saveOrUpdate(adminTableEntity);
            }
            if (operation.equalsIgnoreCase("删除")){
                session.delete(adminTableEntity);
            }
            tran.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            sf.close();
        }
    }

    public Boolean dataOperation(RoomTableEntity roomTableEntity, String operation) {
        SessionFactory sf = null;
        Session session = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            // 增 改 删
            if (operation.equalsIgnoreCase("增加") | operation.equalsIgnoreCase("修改")){
                session.saveOrUpdate(roomTableEntity);
            }
            if (operation.equalsIgnoreCase("删除")){
                session.delete(roomTableEntity);
            }
            tran.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            sf.close();
        }
    }

    public Boolean dataOperation(OrderTableEntity orderTableEntity, String operation) {
        SessionFactory sf = null;
        Session session = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            // 增 改 删
            if (operation.equalsIgnoreCase("增加") | operation.equalsIgnoreCase("修改")){
                session.saveOrUpdate(orderTableEntity);
            }
            if (operation.equalsIgnoreCase("删除")){
                session.delete(orderTableEntity);
            }
            tran.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            sf.close();
        }
    }
}
