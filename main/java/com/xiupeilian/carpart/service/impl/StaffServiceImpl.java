package com.xiupeilian.carpart.service.impl;/**
 * @ProjectName: carPart
 * @Package: com.xiupeilian.carpart.service.impl
 * @ClassName: StaffServiceImpl
 * @Author: sunflower
 * @Description:
 * @Date: 2019/8/30 11:01
 * @Version: 1.0
 */

import com.xiupeilian.carpart.mapper.SysUserMapper;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Xiao Gao Student
 * @CreateDate: 2019/8/30 11:01 
 * @Version: 1.0
 **/
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public List<SysUser> findUserByVo(SysUser user) {
        return sysUserMapper.findUserByVo(user);
    }
}
