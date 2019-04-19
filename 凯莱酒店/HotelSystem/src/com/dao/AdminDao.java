package com.dao;

import com.hibernate.admin.AdminTableEntity;
import com.service.admin.Admin;

import java.util.List;

public interface AdminDao {
    /**
     * 登录验证
     * @param account
     * @param password
     * @return Boolean 是否登陆成功
     */
    public Boolean loginVerify(int account, String password);

    /**
     * 增加一个管理员账号
     * @param adminTableEntity
     * @return  Boolean 是否保存成功
     */
    public Boolean save(AdminTableEntity adminTableEntity);

    /**
     * 删除一个管理员 实体
     * @param adminTableEntity
     * @return  Boolean 删除是否成功
     */
    public Boolean del(AdminTableEntity adminTableEntity);

    /**
     * 修改一个管理员实体
     * @param adminTableEntity
     * @return  Boolean 修改是否成功
     */
    public Boolean revision(AdminTableEntity adminTableEntity);

    /**
     * 得到全体 管理员账号
     * @return List<AdminTableEntity> admin 集合
     */
    public List<AdminTableEntity> getAdmin();
}
