package com.web.action;

import com.dao.impl.OrderDaoImpl;
import com.dao.impl.RoomDaoImpl;
import com.hibernate.order.OrderTableEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.hotel.Room;
import com.service.order.Order;
import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.HttpServer;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class OrderAction extends ActionSupport {
    /**
     * 拦截，并完成下单操作
     * @return  Order 返回一个订单
     * @throws Exception
     */

    public static final String Fail = "fail";
    private Order order;
    private String name;
    private String id;
    private String date;
    private  String sex;
    private String hotel;
    private String leavedate;

    private  List<OrderTableEntity> orderList;


    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String del(){
        HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
        String orderId = httpServletRequest.getParameter("orderId");
        OrderDaoImpl orderDao = new OrderDaoImpl();
        if (orderDao.del(Long.parseLong(orderId))){
            return "delsuccess";
        }
        System.out.println("删除");
        return ERROR;
    }
    public String finddel(){
        Order order = new Order();
        orderList = order.getOrderList(1,7);
        return "finddelsuccess";
    }
    public String find(){
        Order order = new Order();
        orderList = order.getOrderList(1,10);
        for (OrderTableEntity o: orderList) {
            System.out.println(o.toString() );
        }
        return "findsuccess";
    }
    public String save(){
        //传入姓名 住房类型 在数据库中找到空闲住房 完成订单
        Room room = new RoomDaoImpl().getFreeRoom(getHotel());
        Order order = new Order();

        if (room.getRoomId() == -1){
            return Fail;
        }else{
            // 对订单进行赋值
            order.setOrderId(order.getStringOrderID(getDate(), getLeavedate(), getId()));
            order.setOrderRoomId(room.getRoomId());
            order.setOrderClientName(getName());
            order.setOrderClientSex(getSex());
            order.setOrderClientId(getId());
            order.setOrderDate(getDate());
            order.setOderLeaveDate(getLeavedate());
            order.setOrderHotelType(getHotel());
            order.setOrderCashpledge(room.getRoomCashpledge());
            order.setOrderHotelPrice(room.getRoomPrice());
            order.setOrderHotelPayment(room.getRoomPayment());
            setOrder(order);
            //压入值栈 栈顶
            //使用 Action 特性取代次句：Action中所有的属性，默认压入值栈
            //ServletActionContext.getContext().getValueStack().push(order);
            //将订单信息存入数据库 成功 则到成功页面  若失败则转重新预定页
            OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
            Boolean b = orderDaoImpl.save(order);
            //更新房间状态
            Boolean b2 = new RoomDaoImpl().updateRoom(room.getRoomId());
            if (b & b2){
                return SUCCESS;
            }else {
                return Fail;
            }
        }
    }

    public List<OrderTableEntity> getOrderList() {
        return orderList;
    }

    public void setList(List<OrderTableEntity> orderList) {
        this.orderList = orderList;
    }

    /**
     * 下面均为 get set方法
     * @return
     */

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public String getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

}
