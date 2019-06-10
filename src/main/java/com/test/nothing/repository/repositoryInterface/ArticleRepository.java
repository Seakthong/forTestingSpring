package com.test.nothing.repository.repositoryInterface;

import com.test.nothing.repository.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {
    @Insert("INSERT INTO tblarticles (title, description, author, create_date, thumbnail, category_id) VALUES(#{title},#{description},#{author},#{create_date},#{thumbnail},#{category_id})")
    public void add(Article article);

    //@Select("SELECT a.title, a.description, a.author, a.create_date, a.category_id, c.name FROM tblarticles AS a INNER JOIN tblcategories AS c ON a.id = c.id WHERE a.id = #{id}")
    @Select("SELECT * FROM tblarticles where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
//            @Result(property = "description",column = "description"),
//            @Result(property = "author",column = "author"),
//            @Result(property = "create_date",column = "create_date"),
//            @Result(property = "thumbnail",column = "thumbnail"),
    })
    public Article findOne(int id);

    @Select("SELECT a.title, a.description, a.author, a.create_date, a.category_id, c.name FROM tblarticles AS a INNER JOIN tblcategories AS c ON a.category_id = c.id ORDER BY a.id ASC")
    @Results({
        @Result(property = "id",column = "id"),
        @Result(property = "title",column = "title"),
        @Result(property = "description",column = "description"),
        @Result(property = "author",column = "author"),
        @Result(property = "create_date",column = "create_date"),
        @Result(property = "thumbnail",column = "thumbnail"),
        @Result(property = "category.id",column = "category_id"),
        @Result(property = "category.name",column = "name"),
    })
    public List<Article> findAll();

    @Delete("DELETE FROM tblarticles WHERE id = #{id}")
    public void delete(int id);

//    UPDATE tblarticles SET title='#{title}', description='#{description}', author='#{author}', create_date='#{create_date}', thumbnail='#{thumbnail}', category_id=#{category_id} where id =#{id};
    @Update("UPDATE tblarticles SET title='#{title}', description='#{description}', author='#{title}', create_date='#{create_date}', thumbnail='${thumbnail}', category_id=#{category_id}  WHERE id=#{id}")
    public void update(int id, Article article);
}
