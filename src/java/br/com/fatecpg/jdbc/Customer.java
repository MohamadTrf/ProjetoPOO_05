
package br.com.fatecpg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MohamadTarif
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    
    
    public static Customer getCustomer(int id) throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        Connection con = DriverManager.getConnection(url,"app","app");
        String  SQL = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        PreparedStatement st = con.prepareStatement(SQL);
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        Customer c = null;
        if(rs.next()){
            c = new Customer(
                    rs.getInt("CUSTOMER_ID"),rs.getString("NAME"), rs.getString("EMAIL"));   
        
          
        }
        rs.close();
        st.close();
        con.close();
        return c;
    }
    
    public static ArrayList<Customer> getList() throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        Connection con = DriverManager.getConnection(url,"app","app");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER");
        ArrayList<Customer> list = new ArrayList<>();
        while(rs.next()){
            Customer c = new Customer(
                    rs.getInt("CUSTOMER_ID"),rs.getString("NAME"), rs.getString("EMAIL"));   
        
            list.add(c);
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }
    
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
