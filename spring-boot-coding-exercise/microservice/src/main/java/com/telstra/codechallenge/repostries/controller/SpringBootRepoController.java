package com.telstra.codechallenge.repostries.controller;

import com.telstra.codechallenge.repostries.service.SpringBootRepoService;
import com.telstra.codechallenge.repostries.pojo.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author abhay ranjan
 * this is controller class
 * */
@RestController
public class SpringBootRepoController {
    @Autowired
    private SpringBootRepoService repoService;

/**
 * this method is calling service class without any parameter
 * using Get method
 * */
    @GetMapping("/repostries")
    public List<Repositories> getAllRepostries() {
        List<Repositories> list = repoService.getAllRepoService();

        return list;
    }

}
