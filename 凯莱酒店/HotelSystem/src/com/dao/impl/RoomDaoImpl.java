package com.dao.impl;

import com.dao.RoomDao;
import com.hibernate.order.OrderTableEntity;
import com.hibernate.room.RoomTableEntity;
import com.service.hotel.Room;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    /**
     * 得到所以房间状态
     * @return
     */
    public  List<RoomTableEntity> getRoomList(){
        SessionFactory sf = null;
        Session session = null;

        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("from RoomTableEntity");
            //2、使用Query对象的list方法得到数据集合
            List<RoomTableEntity> roomList = query.list();

            tran.commit();
            return roomList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
            sf.close();
        }
    }
    /**
     * 实现对房间状态的更新
     * @param roomId
     * @return Boolean 是否更新成功
     */
    @Override
    public Boolean updateRoom(int roomId) {

        //// 给常量赋值
        // 加载配置文件
        Configuration conf = new Configuration().configure();
        //// 生成factory对象
        SessionFactory sf = conf.buildSessionFactory();
        // 3. 创建session对象
        Session session = sf.openSession();
        RoomTableEntity roomTableEntity = (RoomTableEntity) session.get(RoomTableEntity.class,roomId);
        if (roomTableEntity != null){
            roomTableEntity.setRoomStatus("繁忙");
            Transaction tran = session.beginTransaction();
            session.update(roomTableEntity);
            tran.commit();
            return true;
        }
        session.close();
        return false;
    }

    /**
     * 实现对房间状态的更新
     * @param roomId
     * @param status
     * @return Boolean 是否更新成功
     */
    public Boolean updateRoom(int roomId, String status) {

        //// 给常量赋值
        // 加载配置文件
        Configuration conf = new Configuration().configure();
        //// 生成factory对象
        SessionFactory sf = conf.buildSessionFactory();
        // 3. 创建session对象
        Session session = sf.openSession();
        RoomTableEntity roomTableEntity = (RoomTableEntity) session.get(RoomTableEntity.class,roomId);
        if (roomTableEntity != null){
            roomTableEntity.setRoomStatus(status);
            Transaction tran = session.beginTransaction();
            session.update(roomTableEntity);
            tran.commit();
            return true;
        }
        session.close();
        return false;
    }

    /**
     * 返回值说明 若RoomId为 -1 表示 目前该类型套房已经没有空闲
     * @param roomType
     * @return Room 空闲房间号
     */
    @Override
    public Room getFreeRoom(String roomType){

        Room room = new Room();
        room.setRoomId(-1);
        StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
        //// 生成factory对象
        SessionFactory factory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        // 3. 创建session对象
        Session session = factory.openSession();
        session.beginTransaction();
        //下面是核心代码
        Criteria c= session.createCriteria(RoomTableEntity.class);//1. 通过session的createCriteria创建一个Criteria 对象
        c.add(Restrictions.like("roomType", "%"+roomType+"%"));//2. Criteria.add 增加约束。 在本例中增加一个对name的模糊查询(like)
        List<RoomTableEntity> roomList = c.list();//3. 调用list()方法返回查询结果的集合

        for (RoomTableEntity r : roomList) {
            if (r.getRoomStatus().equalsIgnoreCase("空闲")){
                room.setRoomId(r.getRoomId());
                room.setRoomType(r.getRoomType());
                room.setRoomPrice(r.getRoomPrice());
                room.setRoomCashpledge(r.getRoomCashpledge());
                room.setRoomPayment(r.getRoomPayment());
                break;
            }
        }
        session.getTransaction().commit();
        session.close();
        factory.close();
        return room;
    }

    /**
     * 保存一个房间 实体
     * @param roomTableEntity
     * @return Boolean 保存是否成功
     */
    public Boolean save(RoomTableEntity roomTableEntity){
        SessionFactory sf = null;
        Session session = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            session.save(roomTableEntity);

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

    /**
     * 删除一个房间数据
     * @param roomTableEntity
     * @return  Boolean 删除是否成功
     */
    public Boolean del(RoomTableEntity roomTableEntity){
        SessionFactory sf = null;
        Session session = null;
        try {
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            Transaction tran = session.beginTransaction();
            session.delete(roomTableEntity);

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
