package com.test.nothing.controller;

import com.test.nothing.repository.model.Category;
import com.test.nothing.repository.repositoryInterface.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = "/add/{name}")
    @ResponseBody
    public String addcat(@PathVariable String name){
        Category category = new Category(name);
        System.out.println(category.toString());
        categoryRepository.add(category);

        return name;
    }

    @GetMapping(value = "/show")
    @ResponseBody
    public String showcat(){
        String all = "";
        for(int i=0; i< categoryRepository.findAll().size(); i++){
            all += categoryRepository.findAll().get(i).toString()+"\n";
        }
        return all;
    }

    @GetMapping(value = "/show/{id}")
    @ResponseBody
    public String getCat(@PathVariable int id){
        return categoryRepository.findOne(id).toString();
    }


}
