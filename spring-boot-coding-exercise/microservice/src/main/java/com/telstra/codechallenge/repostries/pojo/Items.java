package com.telstra.codechallenge.repostries.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author abhay ranjan
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Items {
    private int id;
    private String node_id;
    private String name;
    private String full_name;
    private Owner owner;
    private boolean Private;
    private String html_url;
    private String description;
    private boolean fork;
    private String url;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String homepage;
    private int size;
    private String stargazers_count;
    private int watchers_count;
    private String language;
    private int forks_count;
    private int open_issues_count;
    private String master_branch;
    private String default_branch;
    private double score;


}
