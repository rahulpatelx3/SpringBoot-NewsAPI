package com.google.news.api.entity;

import lombok.Data;
import java.util.*;

@Data
public class News {
	private String status;
    private Integer totalResults;
    private List<Article> articles;
}
