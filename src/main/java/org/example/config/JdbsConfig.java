package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbsConfig {

    private  final  static  String url="jdbc:postgresql://localhost:5432/postgres";
    private final  static String username="postgres";
    private  final  static String password = "1234";



    public  static Connection getConnection() {
        Connection connection;
        try {
      connection = DriverManager.getConnection(url,
                    username,
                    password);
            System.out.println("Connect");
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw  new RuntimeException(e);
        }return connection;
    }



}
