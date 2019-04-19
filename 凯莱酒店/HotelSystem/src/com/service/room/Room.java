package com.service.room;

import com.dao.impl.RoomDaoImpl;
import com.hibernate.room.RoomTableEntity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<RoomTableEntity> roomTableEntityArrayList;

    public Room() {
        this.roomTableEntityArrayList = new RoomDaoImpl().getRoomList();
    }

    public List<RoomTableEntity> getRoomTableEntityArrayList() {
        return roomTableEntityArrayList;
    }

    public ArrayList<RoomTableEntity> getRoomList(int index, int number){
        ArrayList<RoomTableEntity> roomList = new ArrayList<>();
        int i = 0;
        for (RoomTableEntity r: getRoomTableEntityArrayList()) {
            if (r != null){
                roomList.add(r);
                i++;
                if (i == index + number){
                    return roomList;
                }
            }
        }
        return roomList;
    }
}
