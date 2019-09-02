package com.xiupeilian.carpart.service.impl;

import com.xiupeilian.carpart.constant.SysConstant;
import com.xiupeilian.carpart.mapper.CompanyMapper;
import com.xiupeilian.carpart.mapper.MenuMapper;
import com.xiupeilian.carpart.mapper.RoleMapper;
import com.xiupeilian.carpart.mapper.SysUserMapper;
import com.xiupeilian.carpart.model.Company;
import com.xiupeilian.carpart.model.Menu;
import com.xiupeilian.carpart.model.Role;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.UserService;
import com.xiupeilian.carpart.util.SHA1Util;
import com.xiupeilian.carpart.vo.LoginVo;
import com.xiupeilian.carpart.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public SysUser findUserByLoginNameAndPassword(LoginVo vo) {
		return userMapper.findUserByLoginNameAndPassword(vo);
	}

	@Override
	public List<Menu> findMenusById(int id) {
		return menuMapper.findMenusByUserId(id);
	}

	@Override
	public SysUser findUserByLoginNameAndEmail(LoginVo vo) {
		return userMapper.findUserByLoginNameAndEmail(vo);
	}

	@Override
	public void updateUser(SysUser user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public SysUser findUserByLoginName(String name) {
		return userMapper.findUserByLoginName(name);
	}


	@Override
	public SysUser findUserByPhone(String phone) {
		return userMapper.findUserByPhone(phone);
	}

	@Override
	public SysUser findUserByEmail(String email) {
		return userMapper.findUserByEmail(email);
	}

	@Override
	public Company findCompanyByName(String companyname) {
		return companyMapper.findCompanyByName(companyname);
	}

	@Override
	public void addRegsiter(RegisterVo vo) {
		//�Ȳ�����ҵ��
		Company company=new Company();
		company.setAddress(vo.getAddress());
		company.setCity(vo.getCity());
		company.setCompanyCode(UUID.randomUUID().toString());
		company.setCompanyName(vo.getCompanyname());
		company.setCounty(vo.getContry());
		company.setCreateTime(new Date());
		company.setLeader(vo.getUsername());
		company.setMain(vo.getMain());
		company.setPhone(vo.getPhone());
		company.setZone1(vo.getZone1());
		company.setZone2(vo.getZone2());
		company.setTel1(vo.getTel1());
		company.setTel2(vo.getTel2());
		company.setPrime(vo.getPrime());
		company.setSingleParts(vo.getSingleParts());
		company.setQq(vo.getQq());
		companyMapper.insertSelective(company);

		//�ٲ����û���
		SysUser user=new SysUser();
		user.setPassword(SHA1Util.encode(vo.getPassword()));
		user.setCompanyId(company.getId());
		user.setCreateTime(new Date());
		user.setEmail(vo.getEmail());
		user.setLoginName(vo.getLoginName());
		user.setManageLevel(1);
		user.setPhone(vo.getPhone());
		user.setRoleId(SysConstant.ROLE_ADMIN);
		user.setUsername(vo.getUsername());
		userMapper.insertSelective(user);
	}

	@Override
	public Role findRoleByRoleId(Integer roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public SysUser findUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addStaff(SysUser user) {
		userMapper.insert(user);
	}

	@Override
	public void updatePasswordById(Integer id) {
		userMapper.updatePasswordById(id);
	}


}
