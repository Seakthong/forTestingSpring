package com.test.nothing.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//@Repository
public class CategoryNewRepo {
//    @Autowired
//    private DataSource dataSource;
//    public void showCategory(){
//        try {
//            Connection connection = dataSource.getConnection();
//            Statement statement = connection.createStatement();
//            String sql = "SELECT * FROM tbarticles";
//            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next()){
//                System.out.println("ID : "+rs.getString(1) +" / Name : "+rs.getString(2));
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
