package com.xiupeilian.carpart.service.impl;

import com.xiupeilian.carpart.mapper.CityMapper;
import com.xiupeilian.carpart.model.City;
import com.xiupeilian.carpart.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Tu Xu
 * @CreateDate: 2019/8/26 10:44
 * @Version: 1.0
 **/
@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityMapper cityMapper;


	/**
	 * @Description: ָ���÷����ķ���ֵ���ᱻspring-cache cachemanager���л���,��Ҫָ��ʹ����һ������
	 * @Author:      Administrator
	 * @Param:       [parentId]
	 * @Return       java.util.List<com.xiupeilian.carpart.model.City>
	 **/
	@Cacheable(value="canglaoshi")

	public List<City> findCitysByparentId(Integer parentId) {
		return cityMapper.findCitiesByParentId( parentId);
	}

	@Override
	public City findCitysById(Integer province) {
		return cityMapper.selectByPrimaryKey(province);
	}

	/**
	 * @Description: ��Ҫ��������ֶ�ά������(ɾ�������)
	 * @Author:      Administrator
	 * @Param:       [id]
	 * @Return       void
	 **/

	@CacheEvict(value="canglaoshi",allEntries = true)
	public void deleteCityById(int id) {
		cityMapper.deleteByPrimaryKey(id);
	}



}
