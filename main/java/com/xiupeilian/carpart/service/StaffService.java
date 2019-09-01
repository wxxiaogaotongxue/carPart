package com.xiupeilian.carpart.service;/**
 * @ProjectName: carPart
 * @Package: com.xiupeilian.carpart.service
 * @ClassName: StaffService
 * @Author: sunflower
 * @Description:
 * @Date: 2019/8/30 11:01
 * @Version: 1.0
 */

import com.xiupeilian.carpart.model.SysUser;

import java.util.List;

/**
 * @Description:
 * @Author: Xiao Gao Student
 * @CreateDate: 2019/8/30 11:01 
 * @Version: 1.0
 **/
public interface StaffService {
    List<SysUser> findUserByVo(SysUser user);
}
