package com.telstra.codechallenge.repostries.service;

import com.google.gson.Gson;
import com.telstra.codechallenge.repostries.pojo.Items;
import com.telstra.codechallenge.repostries.pojo.Repositories;
import com.telstra.codechallenge.repostries.pojo.RepostriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.*;

/**
 * @author abhay ranjan
 * this is service class which is makint=g connection with 3rd parties
 * */
@Service
public class SpringBootRepoService {

    @Value("${repository.base.url}")
    private String baseUrl;

    @Value("${repository.url}")
    private String repo;


    @Autowired
    private RestTemplate template;
/**
 * this methode is getting all the repostries from specific url and mapping to custom response
 *
 * */
    public List<Repositories> getAllRepoService() {
        UriComponentsBuilder builder= UriComponentsBuilder
                .fromUriString(baseUrl+repo)
                .queryParam("q","tetris+language:assembly")
                .queryParam("sort","stars")
                .queryParam("order","desc");
        String result =template.getForObject(builder.toUriString(),String.class );
        Gson gsonObj = new Gson();
        RepostriesResponse repositories= gsonObj.fromJson(result, RepostriesResponse.class);
        if (result==null){
            throw new RuntimeException("no record found");
        }
        List<Repositories> list=getRequiredData(repositories);
        Comparator<Repositories> comparator= Comparator.comparing(Repositories::getWatchers_count);
        Collections.sort(list, comparator.reversed());
        return list;
    }

    private List<Repositories> getRequiredData(RepostriesResponse repositories) {
        List<Repositories> repositoriesList= new ArrayList<>();
        List<Items> list= repositories.getItems();
        for(Items items:list){
            Repositories repositories1= new Repositories();
            repositories1.setName(items.getName());
            repositories1.setDescription(items.getDescription());
            repositories1.setHtml_url(items.getHtml_url());
            repositories1.setLanguage(items.getLanguage());
            repositories1.setWatchers_count(items.getWatchers_count());
            repositoriesList.add(repositories1);
        }
        return repositoriesList;
    }


}
