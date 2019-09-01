package com.xiupeilian.carpart.service;

import com.xiupeilian.carpart.model.Items;

import java.util.List;

public interface ItemsService {
	Items findItemByid(int i);

	List<Items> findItemsByQueryVo(Items items);

}
