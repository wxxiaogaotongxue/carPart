package com.xiupeilian.carpart.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiupeilian.carpart.model.Brand;
import com.xiupeilian.carpart.model.Items;
import com.xiupeilian.carpart.model.Parts;
import com.xiupeilian.carpart.service.BrandService;
import com.xiupeilian.carpart.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/public")
public class PublicItemsControllter {
	@Autowired
	private ItemsService itemsService;
	@Autowired
	private BrandService brandService;
	@RequestMapping("/publicItems")
	public  String publicItems(Items items, Integer pageSize, Integer pageNo, HttpServletRequest request){
		pageSize=pageSize==null?8:pageSize;
		pageNo=pageNo==null?1:pageNo;
		//开始分页查询
		PageHelper.startPage(pageNo,pageSize);
		//查询满足条件的全部数据即可
		List<Items> itemsList=itemsService.findItemsByQueryVo(items);
		//封装，底层使用动态代理
		PageInfo<Items> page=new PageInfo<>(itemsList);

		//页面当中有一些数据需要初始化，品牌
		List<Brand> brandList=brandService.findBrandAll();
		List<Parts> partsList=brandService.findPartsAll();
		//品牌列表配件类别存储。
		request.setAttribute("brandList",brandList);
		request.setAttribute("partsList",partsList);
		request.setAttribute("page",page);
		//搜索分页数据回显
		request.setAttribute("items",items);
		return "public/publicItems";
	}
}
