package mainservlet;

import mainservlet.models.PhoneModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by student on 16.10.2017.
 */
public class Main {

    public static void main(String[] args) {
         PhoneModel phoneModel = new PhoneModel();
        for(int i = 0; i < phoneModel.getAllPhones().size(); i++) {
            System.out.println(phoneModel.getAllPhones().get(i).getName());

        }
    }
}
