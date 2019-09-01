package com.xiupeilian.carpart.service.impl;

import com.xiupeilian.carpart.mapper.ItemsMapper;
import com.xiupeilian.carpart.model.Items;
import com.xiupeilian.carpart.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public Items findItemByid(int i) {
		return itemsMapper.selectByPrimaryKey(i);
	}

	@Override
	public List<Items> findItemsByQueryVo(Items items) {
		return itemsMapper.findItemsByQueryVo(items);
	}




}
