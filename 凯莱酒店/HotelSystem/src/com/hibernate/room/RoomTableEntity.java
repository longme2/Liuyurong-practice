package com.hibernate.room;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_table", schema = "hotel_system", catalog = "")
public class RoomTableEntity {
    private String roomType;
    private int roomId;
    private String roomStatus;
    private Double roomPrice;
    private Double roomCashpledge;
    private Double roomPayment;

    @Basic
    @Column(name = "room_type", nullable = true, length = 255)
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Id
    @Column(name = "room_id", nullable = false)
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "room_status", nullable = true, length = 255)
    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Basic
    @Column(name = "room_price", nullable = true, precision = 0)
    public Double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Basic
    @Column(name = "room_cashpledge", nullable = true, precision = 0)
    public Double getRoomCashpledge() {
        return roomCashpledge;
    }

    public void setRoomCashpledge(Double roomCashpledge) {
        this.roomCashpledge = roomCashpledge;
    }

    @Basic
    @Column(name = "room_payment", nullable = true, precision = 0)
    public Double getRoomPayment() {
        return roomPayment;
    }

    public void setRoomPayment(Double roomPayment) {
        this.roomPayment = roomPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomTableEntity that = (RoomTableEntity) o;
        return roomId == that.roomId &&
                Objects.equals(roomType, that.roomType) &&
                Objects.equals(roomStatus, that.roomStatus) &&
                Objects.equals(roomPrice, that.roomPrice) &&
                Objects.equals(roomCashpledge, that.roomCashpledge) &&
                Objects.equals(roomPayment, that.roomPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomType, roomId, roomStatus, roomPrice, roomCashpledge, roomPayment);
    }

    @Override
    public String toString() {
        return roomId + "..." + roomType + "..." + roomCashpledge + "..." + roomPrice +"..." +roomPayment + "..." +
                roomStatus;
    }
}
