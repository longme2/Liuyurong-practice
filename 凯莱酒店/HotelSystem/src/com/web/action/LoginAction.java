package com.web.action;

import com.dao.impl.AdminDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.order.Bill;

public class LoginAction extends ActionSupport {

    /**
     * 拦截器 拦截账号密码 完成登陆验证
     * @return
     * @throws Exception
     */
    private int account;
    private String password;

    @Override
    public String execute() throws Exception {
        System.out.println(getAccount() + "........" + getPassword());
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Bill bill = new Bill();
        if (adminDao.loginVerify(getAccount(), getPassword())){
            //得到值栈对象
            ValueStack valueStack = ActionContext.getContext().getValueStack();
            //将账单对象压入值栈
            valueStack.push(bill);
            System.out.println("登陆成功");
            return SUCCESS;
        }else {
            System.out.println("登陆失败");
            return "fail";
        }

    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
