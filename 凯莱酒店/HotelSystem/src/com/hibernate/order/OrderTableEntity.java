package com.hibernate.order;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_table", schema = "hotel_system", catalog = "")
public class OrderTableEntity {
    private long orderId;
    private Integer orderRoomId;
    private String orderClientName;
    private String orderClientSex;
    private String orderClientId;
    private String orderDate;
    private String oderLeaveDate;
    private String orderHotelType;
    private Double orderCashpledge;
    private Double orderHotelPrice;
    private Double orderHotelPayment;

    @Id
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_room_id", nullable = true)
    public Integer getOrderRoomId() {
        return orderRoomId;
    }

    public void setOrderRoomId(Integer orderRoomId) {
        this.orderRoomId = orderRoomId;
    }

    @Basic
    @Column(name = "order_client_name", nullable = true, length = 255)
    public String getOrderClientName() {
        return orderClientName;
    }

    public void setOrderClientName(String orderClientName) {
        this.orderClientName = orderClientName;
    }

    @Basic
    @Column(name = "order_client_sex", nullable = true, length = 255)
    public String getOrderClientSex() {
        return orderClientSex;
    }

    public void setOrderClientSex(String orderClientSex) {
        this.orderClientSex = orderClientSex;
    }

    @Basic
    @Column(name = "order_client_id", nullable = true, length = 255)
    public String getOrderClientId() {
        return orderClientId;
    }

    public void setOrderClientId(String orderClientId) {
        this.orderClientId = orderClientId;
    }

    @Basic
    @Column(name = "order_date", nullable = true, length = 255)
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "oder_leave_date", nullable = true, length = 255)
    public String getOderLeaveDate() {
        return oderLeaveDate;
    }

    public void setOderLeaveDate(String oderLeaveDate) {
        this.oderLeaveDate = oderLeaveDate;
    }

    @Basic
    @Column(name = "order_hotel_type", nullable = true, length = 255)
    public String getOrderHotelType() {
        return orderHotelType;
    }

    public void setOrderHotelType(String orderHotelType) {
        this.orderHotelType = orderHotelType;
    }

    @Basic
    @Column(name = "order_cashpledge", nullable = true, precision = 0)
    public Double getOrderCashpledge() {
        return orderCashpledge;
    }

    public void setOrderCashpledge(Double orderCashpledge) {
        this.orderCashpledge = orderCashpledge;
    }

    @Basic
    @Column(name = "order_hotel_price", nullable = true, precision = 0)
    public Double getOrderHotelPrice() {
        return orderHotelPrice;
    }

    public void setOrderHotelPrice(Double orderHotelPrice) {
        this.orderHotelPrice = orderHotelPrice;
    }

    @Basic
    @Column(name = "order_hotel_payment", nullable = true, precision = 0)
    public Double getOrderHotelPayment() {
        return orderHotelPayment;
    }

    public void setOrderHotelPayment(Double orderHotelPayment) {
        this.orderHotelPayment = orderHotelPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderTableEntity that = (OrderTableEntity) o;
        return orderId == that.orderId &&
                Objects.equals(orderRoomId, that.orderRoomId) &&
                Objects.equals(orderClientName, that.orderClientName) &&
                Objects.equals(orderClientSex, that.orderClientSex) &&
                Objects.equals(orderClientId, that.orderClientId) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(oderLeaveDate, that.oderLeaveDate) &&
                Objects.equals(orderHotelType, that.orderHotelType) &&
                Objects.equals(orderCashpledge, that.orderCashpledge) &&
                Objects.equals(orderHotelPrice, that.orderHotelPrice) &&
                Objects.equals(orderHotelPayment, that.orderHotelPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderRoomId, orderClientName, orderClientSex, orderClientId, orderDate, oderLeaveDate, orderHotelType, orderCashpledge, orderHotelPrice, orderHotelPayment);
    }

    @Override
    public String toString() {
        return orderClientName + "..." + orderClientId + "..." + orderClientSex + "..." + orderDate + "..." +
                oderLeaveDate + "..." + orderHotelType + "..." +orderRoomId + "..." + orderCashpledge + "..." +
                orderHotelPrice + "..." + orderHotelPayment + "..." + orderId;
    }
}
