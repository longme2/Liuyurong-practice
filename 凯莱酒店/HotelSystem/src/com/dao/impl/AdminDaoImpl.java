package com.dao.impl;

import com.dao.AdminDao;
import com.hibernate.admin.AdminTableEntity;
import com.hibernate.order.OrderTableEntity;
import com.service.admin.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    /**
     * 登录验证
     * @param account
     * @param password
     * @return Boolean 是否登陆成功
     */
    @Override
    public Boolean loginVerify(int account, String password) {
        System.out.println(account + "-----------"+ password);
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        AdminTableEntity adminTableEntity = session.get(AdminTableEntity.class,account);
        System.out.println(adminTableEntity);

        if (adminTableEntity != null){
            if (password.equalsIgnoreCase(adminTableEntity.getPassword())){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * 增加一个管理员账号
     * @param adminTableEntity
     * @return  Boolean 是否保存成功
     */
    public Boolean save(AdminTableEntity adminTableEntity){
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
            session.save(adminTableEntity);
            tran.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            // 7. 释放资源
            session.close();
            sf.close();
        }
    }

    /**
     * 删除一个管理员 实体
     * @param adminTableEntity
     * @return  Boolean 删除是否成功
     */
    public Boolean del(AdminTableEntity adminTableEntity){
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
            AdminTableEntity ate = session.get(AdminTableEntity.class,adminTableEntity.getAccount());
            //如果不等于空  删除  如果空 则表示无此 实体，无需删除
            if(ate!= null){
                //从数据库中删除
                session.delete(ate);
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
     * 修改一个管理员实体
     * @param adminTableEntity
     * @return  Boolean 修改是否成功
     */
    public Boolean revision(AdminTableEntity adminTableEntity){
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
            session.saveOrUpdate(adminTableEntity);
            tran.commit();
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
     * 得到全体 管理员账号
     * @return List<AdminTableEntity> admin 集合
     */
    public List<AdminTableEntity> getAdmin(){
        SessionFactory sf = null;
        Session session = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("from AdminTableEntity");
            //2、使用Query对象的list方法得到数据集合
            List<AdminTableEntity> list = query.list();
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
}
