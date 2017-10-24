package mainservlet.models;

import mainservlet.Phone;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by student on 16.10.2017.
 */
public class PhoneModel {


    public ArrayList<Phone> getSelectPhone(String SQL){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList <Phone> phones = new ArrayList<Phone>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://192.168.10.86/db?useSSL=false&user=mysql&password=123456&useUnicode=true&characterEncoding=utf-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Phone phone = new Phone();
                phone.setId(rs.getInt("id"));
                phone.setName(rs.getString("name"));
                phone.setPhone(rs.getString("phone"));
                phone.setAdress(rs.getString("adress"));
                phones.add(phone);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
        return phones;
    }

    public ArrayList<Phone> getAllPhones(){

       return getSelectPhone("select * from phones");
    }

//    public ArrayList<Phone> getPhones(String SQL){
//        ArrayList <Phone> phones = new ArrayList<Phone>();
//        this.getSelectPhone(SQL);
//        try {
//            while (this.rs.next()) {
//                Phone phone = new Phone();
//                phone.setId(rs.getInt("id"));
//                phone.setName(rs.getString("name"));
//                phone.setPhone(rs.getString("phone"));
//                phone.setAdress(rs.getString("adress"));
//                phones.add(phone);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return phones;
//    }
}
