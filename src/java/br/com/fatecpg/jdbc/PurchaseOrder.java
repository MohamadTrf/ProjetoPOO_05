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
import java.util.ArrayList;

/**
 *
 * @author MohamadTarif
 */
public class PurchaseOrder {
    private int orderNumber;
    private int productId;
    private int quantity;

    
        public static ArrayList<PurchaseOrder> getPuchaseOrders(int costumerId) throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        Connection connection = DriverManager.getConnection(url, "app", "app");
        String sql = "SELECT * FROM PURCHASE_ORDER WHERE CUSTOMER_ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, costumerId);
        ResultSet results = statement.executeQuery();
        
        ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList();
        
        while (results.next()) {            
            PurchaseOrder produtos = new PurchaseOrder(
                    results.getInt("ORDER_NUM"),
                    results.getInt("PRODUCT_ID"),
                    results.getInt("QUANTITY")
            );
            purchaseOrderList.add(produtos);
            
        }
        
        return purchaseOrderList;
}
    
    public PurchaseOrder(int orderNumber, int productId, int quantity) {
        this.orderNumber = orderNumber;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    
}
