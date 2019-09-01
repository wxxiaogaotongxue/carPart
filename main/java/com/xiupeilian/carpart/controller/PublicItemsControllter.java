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
		//��ʼ��ҳ��ѯ
		PageHelper.startPage(pageNo,pageSize);
		//��ѯ����������ȫ�����ݼ���
		List<Items> itemsList=itemsService.findItemsByQueryVo(items);
		//��װ���ײ�ʹ�ö�̬����
		PageInfo<Items> page=new PageInfo<>(itemsList);

		//ҳ�浱����һЩ������Ҫ��ʼ����Ʒ��
		List<Brand> brandList=brandService.findBrandAll();
		List<Parts> partsList=brandService.findPartsAll();
		//Ʒ���б�������洢��
		request.setAttribute("brandList",brandList);
		request.setAttribute("partsList",partsList);
		request.setAttribute("page",page);
		//������ҳ���ݻ���
		request.setAttribute("items",items);
		return "public/publicItems";
	}
}
