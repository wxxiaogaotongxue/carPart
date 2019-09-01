package com.xiupeilian.carpart.service.impl;

import com.xiupeilian.carpart.mapper.NewsMapper;
import com.xiupeilian.carpart.model.News;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsService implements com.xiupeilian.carpart.service.NewsService {
	@Autowired
	private NewsMapper newsMapper;
	@Override
	public List<News> findNewsAll() {
		return newsMapper.findNewsAll();
	                 }
}
