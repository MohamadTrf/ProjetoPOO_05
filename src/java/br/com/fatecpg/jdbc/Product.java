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
 * @author sirlei
 */
public class Product {
        private int productId;
        private int preco;
        private String Descricao;

    public static ArrayList<Product> getProduct() throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        Connection con = DriverManager.getConnection(url,"app","app");
        String SQL = "SELECT * FROM PRODUCT";
        PreparedStatement st = con.prepareStatement(SQL);
        ResultSet rs = st.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while(rs.next()){
            Product p = new Product(
                    rs.getInt("PRODUCT_ID"),rs.getInt("PURCHASE_COST"), 
                    rs.getString("DESCRIPTION"));   
        
            list.add(p);
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }
        public Product(int productId, int preco, String Descricao) {
            this.productId = productId;
            this.preco = preco;
            this.Descricao = Descricao;
        }
        
        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getPreco() {
            return preco;
        }

        public void setPreco(int preco) {
            this.preco = preco;
        }

        public String getDescricao() {
            return Descricao;
        }

        public void setDescricao(String Descricao) {
            this.Descricao = Descricao;
        }
        
    }

