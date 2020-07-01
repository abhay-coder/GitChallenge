package com.telstra.codechallenge.repostries.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author abhay ranjan
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Owner {
    private String login;
    private int id;
    private String node_id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String received_events_url;
    private String type;

}
