package com.web.action;

import com.dao.impl.AdminDaoImpl;
import com.hibernate.admin.AdminTableEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.service.admin.Admin;

import java.util.List;

public class AdminAction extends ActionSupport {

    private List<AdminTableEntity> adminTableEntityList;
    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String finddel(){
        AdminDaoImpl adminDao = new AdminDaoImpl();
        adminTableEntityList = adminDao.getAdmin();
        return "findelsuccess";
    }
    public String find(){
        AdminDaoImpl adminDao = new AdminDaoImpl();
        adminTableEntityList = adminDao.getAdmin();
        return SUCCESS;
    }

    public List<AdminTableEntity> getAdminTableEntityList() {
        return adminTableEntityList;
    }

    public void setAdminTableEntityList(List<AdminTableEntity> adminTableEntityList) {
        this.adminTableEntityList = adminTableEntityList;
    }
}
