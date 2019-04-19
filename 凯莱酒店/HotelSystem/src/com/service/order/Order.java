package com.service.order;


import com.dao.impl.OrderDaoImpl;
import com.hibernate.order.OrderTableEntity;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Order类   订单类
 * 方法：
 */
public class Order extends OrderTableEntity {

    public ArrayList<OrderTableEntity> getOrderList(int index, int number){
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<OrderTableEntity> list = orderDao.findAll();
        ArrayList<OrderTableEntity> orderTableEntityArrayList = new ArrayList<>();
        int i = index;
        for (OrderTableEntity o:list) {
            orderTableEntityArrayList.add(o);
            i++;
            if (i == index + number){
                return orderTableEntityArrayList;
            }
        }
        return orderTableEntityArrayList;
    }
    /**
     * 返回订单号
     * @param date
     * @param leaveDate
     * @param id
     * @return int 订单
     */
    public int getStringOrderID(String date,String leaveDate, String id){
        int orderID = -1;
        //订单组成 = 入住天数 + 身份证最后四位 + 入住月日
        //原因 入住天数 一定是非负数，所以在string -> int时不会出现，位数损失,保证九位订单
        //若身份证以 x 结束 则直接替换为0
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format.parse(date);
            Date date2 = format.parse(leaveDate);
            int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
            orderID = Integer.parseInt(Integer.toString(days % 10) + id.substring(14).replace("x", "0") +
                    date.split("-")[1] + date.split("-")[2]);

        }catch (Exception e){
            e.printStackTrace();
        }
        return orderID;
    }
}
