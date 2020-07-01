package com.telstra.codechallenge.repostries.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author abhay ranjan
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RepostriesResponse {
    private int total_count;
    private boolean incomplete_results;
    private List<Items> items;
}
