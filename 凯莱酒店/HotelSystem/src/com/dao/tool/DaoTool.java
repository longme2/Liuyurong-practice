package com.dao.tool;

/**
 * 版本：V1.2
 * dao工具类，由于V1.1版本代码大量赘余，为避免大量赘余代码
 * 对AdminDao，RoomDao，OrderDao中的增删改查功能进行改写
 */
public interface DaoTool {
    /**
     * 传入对象 以及 对该对象的操作
     * @param object
     * @param operation
     * @return  Boolean 进行该操作是否成功
     */
    public Boolean dataOperation(Object object, String operation);

}
