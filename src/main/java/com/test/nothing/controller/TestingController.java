package com.test.nothing.controller;

import com.test.nothing.repository.CategoryNewRepo;
import com.test.nothing.repository.model.Article;
import com.test.nothing.repository.repositoryInterface.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping("/article")
public class TestingController {
//    @Autowired
//    DataSource dataSource;
//    @Autowired
//    CategoryNewRepo categoryNewRepo;
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping(value = "/add/{title}/{description}/{author}/{create_date}/{thumbnail}/{category_id}")
    @ResponseBody
    public String inserting(@PathVariable String title, @PathVariable String description, @PathVariable String author, @PathVariable String create_date, @PathVariable String thumbnail, @PathVariable int category_id){
        Article article=new Article(title, description, author, create_date, thumbnail, category_id);
        articleRepository.add(article);
        return "INSERTING";
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public String deleting(@PathVariable int id){
        articleRepository.delete(id);
        return "DELETING";
    }

    @GetMapping(value = "/show")
    @ResponseBody
    public String  Testing(){
        String all = "";
        for(int i=0; i<articleRepository.findAll().size(); i++){
            all += articleRepository.findAll().get(i).toString()+"\n";
        }
        return all;
    }

//    void crudJDBC(){
//        try(Connection connection = dataSource.getConnection()){
//            String sql = "SELECT * FROM tblarticles ";
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next()){
//                System.out.println(rs.getInt(1) + " : " + rs.getString(2));
//            }
//        }
//        catch(SQLException sql){}
//    }
}































