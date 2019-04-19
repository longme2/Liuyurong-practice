package com.dao;

import com.hibernate.room.RoomTableEntity;
import com.service.hotel.Room;

/**
 * 版本：V1.1
 * 将方法分开写，缺陷 大量赘余代码
 */

public interface RoomDao {
    /**
     * 返回值说明 若为 -1 表示 目前该类型套房已经没有空闲  -->查
     * @param roomType
     * @return Int 空闲房间号
     */
    public Room getFreeRoom(String roomType);

    /**
     * 更新房间状态       -->改
     * @param roomId
     * @return Boolean 更新是否成功
     */
    public Boolean updateRoom(int roomId);

    /**
     * 保存一个房间 实体
     * @param roomTableEntity
     * @return Boolean 保存是否成功
     */
    public Boolean save(RoomTableEntity roomTableEntity);

    /**
     * 删除一个房间数据
     * @param roomTableEntity
     * @return  Boolean 删除是否成功
     */
    public Boolean del(RoomTableEntity roomTableEntity);
}
