package com.google.news.api.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.news.api.entity.Article;
import com.google.news.api.entity.News;

@Service
public class NewsService {
	
	@Autowired
	private RestTemplate restTemplate;

	private String url = "https://newsapi.org/v2/everything?q=tesla&from=2022-06-04&sortBy=publishedAt&apiKey=c242699b623c443f9ae90c45d97b0a12";
	
	public News getAllNews(){
		return restTemplate.getForObject(url, News.class);
	}
	
	public News getNewsByKeyword(String keyword) {
		News news = restTemplate.getForObject(url, News.class);
		List<Article> articles = news.getArticles().stream().filter(e->e.getTitle().contains(keyword)).collect(Collectors.toList());
		news.setArticles(articles);
		news.setTotalResults(articles.size());
		return news;
	}
}
