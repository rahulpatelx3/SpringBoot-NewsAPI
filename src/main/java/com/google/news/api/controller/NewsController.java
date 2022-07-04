package com.google.news.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.news.api.entity.News;
import com.google.news.api.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/")
	public ResponseEntity<News> getAllNews(){
		News news = this.newsService.getAllNews();
		return new ResponseEntity<News>(news,HttpStatus.OK);
	}
	
	@GetMapping("/{keyword}")
	public ResponseEntity<News> getNewsByKeyword(@PathVariable String keyword){
		News news = this.newsService.getNewsByKeyword(keyword);
		return new ResponseEntity<News>(news,HttpStatus.OK);
	}
}
