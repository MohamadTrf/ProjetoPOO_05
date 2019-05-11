
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
public class Manufacturer {
    private int manufacturer_id;
    private String name;
    private String city;
    private String state;
    private String email;

    public static ArrayList<Manufacturer> getManufacturer() throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        Connection con = DriverManager.getConnection(url,"app","app");
        String SQL = "SELECT * FROM MANUFACTURER";
        PreparedStatement st = con.prepareStatement(SQL);
        ResultSet rs = st.executeQuery();
        ArrayList<Manufacturer> list = new ArrayList<>();
        while(rs.next()){
            Manufacturer m = new Manufacturer(
                    rs.getInt("MANUFACTURER_ID"),rs.getString("NAME"), 
                    rs.getString("CITY"),rs.getString("STATE"),rs.getString("EMAIL"));   
        
            list.add(m);
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }
    
    
    public Manufacturer(int manufacturer_id, String name, String city, String state, String email) {
        this.manufacturer_id = manufacturer_id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.email = email;
    }

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
