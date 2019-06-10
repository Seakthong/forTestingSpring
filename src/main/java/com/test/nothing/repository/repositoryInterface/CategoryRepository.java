package com.test.nothing.repository.repositoryInterface;

import com.test.nothing.repository.model.Article;
import com.test.nothing.repository.model.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {
    @Insert("INSERT INTO tblcategories (name) VALUES(#{name})")
    public void add(Category category);

    @Select("SELECT * FROM tblcategories")
    @Results({
//            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    public List<Category> findAll();

    @Select("SELECT * FROM tblcategories WHERE id = #{id}")
    @Results({
//            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    public Category findOne(int id);
}
