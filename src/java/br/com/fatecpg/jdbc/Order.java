/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MohamadTarif
 */
public class Order {
    private int num;
    private Date salesDate;
    private double shippingCost;
    
    public static ArrayList<Order> getList(int customerId) throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        Connection con = DriverManager.getConnection(url,"app","app");
        String SQL = "SELECT * FROM PURCHASE_ORDER WHERE CUSTOMER_ID = ?";
        PreparedStatement st = con.prepareStatement(SQL);
        st.setInt(1, customerId);
        ResultSet rs = st.executeQuery();
        ArrayList<Order> list = new ArrayList<>();
        while(rs.next()){
            Order o = new Order(rs.getInt("ORDER_NUM"), rs.getDate("SALES_DATE"), rs.getDouble("SHIPPING_COST"));
            list.add(o);
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }


    public Order(int num, Date salesDate, double shippingCost) {
        this.num = num;
        this.salesDate = salesDate;
        this.shippingCost = shippingCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }
    
    
}
