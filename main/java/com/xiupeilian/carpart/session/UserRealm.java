package com.xiupeilian.carpart.session;/**
 * @ProjectName: carPart
 * @Package: com.xiupeilian.carpart.session
 * @ClassName: UserRealm
 * @Author: sunflower
 * @Description:
 * @Date: 2019/8/29 14:50
 * @Version: 1.0
 */

import com.xiupeilian.carpart.model.Menu;
import com.xiupeilian.carpart.model.Role;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.UserService;
import com.xiupeilian.carpart.util.SHA1Util;
import com.xiupeilian.carpart.vo.LoginVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Xiao Gao Student
 * @CreateDate: 2019/8/29 14:50 
 * @Version: 1.0
 **/
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

/**
 * @Description: 授权的方法（subject第一次访问需要权限才可以访问url的时候）
 * @Author:      sunflower
 * @Param:       [principalCollection]
 * @Return       org.apache.shiro.authz.AuthorizationInfo
  **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user=(SysUser)principalCollection.getPrimaryPrincipal();
        ///查询出该用户所有的权限信息和角色信息。
        //查角色
        Role role=userService.findRoleByRoleId(user.getRoleId());
        List<String> roleList=new ArrayList<>();
        roleList.add(role.getRoleEnglishName());
        //查权限信息（菜单）
        List<Menu> menuList=userService.findMenusById(user.getId());
        List<String> permisstionList=new ArrayList<>();
        for (Menu menu:menuList){
            //存入权限的关键字
            permisstionList.add(menu.getMenuKey());
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        info.addStringPermissions(permisstionList);
        //封装了该用户的权限信息
        return info;
    }
/**
 * @Description: 登录认证的方法
 * @Author:      sunflower
 * @Param:       [authenticationToken]
 * @Return       org.apache.shiro.authc.AuthenticationInfo
  **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        //查询数据库，判断用户名密码是否存在
        LoginVo vo=new LoginVo();
        vo.setPassword(SHA1Util.encode(new String(token.getPassword())));
        vo.setLoginName(token.getUsername());
        SysUser user=userService.findUserByLoginNameAndPassword(vo);
        if (user==null){
            //认证失败，，新建一个异常
            throw new AccountException("2");
        }else {
            //返回用户的认证成功之后的身份信息给
            AuthenticationInfo info = new SimpleAuthenticationInfo(user, token.getPassword(), getName());
            return info;

        }
    }
}
