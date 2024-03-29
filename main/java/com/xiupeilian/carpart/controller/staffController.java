package com.xiupeilian.carpart.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import com.xiupeilian.carpart.model.City;
import com.xiupeilian.carpart.model.Company;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.CityService;
import com.xiupeilian.carpart.service.CompanyService;
import com.xiupeilian.carpart.service.StaffService;
import com.xiupeilian.carpart.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
		import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class staffController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CityService cityService;
	@RequestMapping("/staffList")
	public  String staffList(Integer pageSize, Integer pageNum, HttpServletRequest request,SysUser user) throws IOException {
		pageSize=pageSize==null?8:pageSize;
		pageNum=pageNum==null?1:pageNum;
		System.out.println("pageNum"+pageNum);
		PageHelper.startPage(pageNum,pageSize);
		SysUser user1=(SysUser) SecurityUtils.getSubject().getPrincipal();
		user.setCompanyId(user1.getCompanyId());
		List<SysUser> userList=staffService.findUserByVo(user);
		PageInfo<SysUser> info=new PageInfo<>(userList);
		request.setAttribute("page",info);
		//搜索分页数据回显
		request.setAttribute("items",user);
		request.setAttribute("pageNum",pageNum);
		return "staff/staffList";
	}
	@RequestMapping("/toEditStaff")
	public  String editStaff(Integer id ,HttpServletRequest request){
		SysUser user=userService.findUserById(id);
		Company company=companyService.findCompanyByid(user.getCompanyId());
		request.setAttribute("company",company);
		City province= cityService.findCitysById(company.getProvince());
		request.setAttribute("province",province.getName());
		City city=  cityService.findCitysById(company.getCity());
		request.setAttribute("city",city.getName());
		City county=  cityService.findCitysById(company.getCounty());
		request.setAttribute("county",county.getName());
		request.setAttribute("user",user);
		request.setAttribute("id",id);
		return "staff/editStaff";

	}
	@RequestMapping("/editStaff")
	public String editStaff(SysUser user){
		userService.updateUser(user);
		return "redirect:/index/index";
	}
	@RequestMapping("/toAddStaff")
	public  String toAddStaff(){
		return "staff/addStaff";
	}
	@RequestMapping("/addStaff")
	public  String addStaff(SysUser user){
		SysUser user1=(SysUser)  SecurityUtils.getSubject().getPrincipal();
		SysUser user2=userService.findUserById(user1.getId());
		user.setLeader(user1.getUsername());
		user.setRoleId(4);
		user.setCreateTime(new Date());
		user.setUserStatus(0);
		user.setCompanyId(user2.getCompanyId());
		user.setManageLevel(0);
		userService.addStaff(user);
		return "redirect:/index/index";
	}
}
