package com.telstra.codechallenge.repostries.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author abhay ranjan
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Repositories {
    private String html_url;
    private int watchers_count;
    private String language;
    private String description;
    private String name;
}
