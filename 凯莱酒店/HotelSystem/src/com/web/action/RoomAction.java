package com.web.action;

import com.dao.impl.RoomDaoImpl;
import com.hibernate.room.RoomTableEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.service.room.Room;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RoomAction extends ActionSupport {
    private List<RoomTableEntity> roomTableEntityList;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String update(){
        HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
        int roomId = Integer.parseInt(httpServletRequest.getParameter("roomId"));
        String roomStatus = httpServletRequest.getParameter("status");
        RoomDaoImpl roomDao = new RoomDaoImpl();
        if (roomStatus.equalsIgnoreCase("空闲")){
            roomDao.updateRoom(roomId,"繁忙");
        }else{
            roomDao.updateRoom(roomId,"空闲");
        }
        return "updatesuccess";
    }
    public String finddel(){
        Room room = new Room();
        roomTableEntityList = room.getRoomList(1,10);
        return "finddelsuccess";
    }
    public String find(){
        Room room = new Room();
        roomTableEntityList = room.getRoomList(1,10);
        return SUCCESS;
    }
    public List<RoomTableEntity> getRoomTableEntityList() {
        return roomTableEntityList;
    }

    public void setRoomTableEntityList(List<RoomTableEntity> roomTableEntityList) {
        this.roomTableEntityList = roomTableEntityList;
    }
}
