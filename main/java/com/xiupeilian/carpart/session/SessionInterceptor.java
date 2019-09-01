package com.xiupeilian.carpart.session;

import com.xiupeilian.carpart.model.Menu;
import com.xiupeilian.carpart.model.SysUser;
import com.xiupeilian.carpart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Description: session拦截、权限控制
 * @Author: Tu Xu
 * @CreateDate: 2019/8/21 13:59
 * @Version: 1.0
 **/
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    /**
     * session过滤以及权限控制
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//      //获取请求的目标资源路径
//        String path=request.getRequestURI();
//        //判断资源路径是不是登录才可以访问的
//        if(path.contains("login")||path.contains("upLoad")){
//            return true;
//        }else {
//            //意味着需要进行session过滤以及权限控制
//            HttpSession session=request.getSession(false);
//           if(null==session){
//               //session==null
//               response.sendRedirect(request.getContextPath()+"login/toLogin");
//                return false;
//           }else {
//                //session不为null
//               if(session.getAttribute("user")==null){
//                   //session=不为空，但是不包含user
//                   response.sendRedirect( request.getContextPath()+"/login/toLogin");
//                   return false;
//               }else{
//                   //意味着用户登陆过，进行权限拦截//
//                   //查询出用户对应的用户权限
//                   SysUser user=(SysUser) session.getAttribute("user");
//                   List<Menu> menuList=userService.findMenusById(user.getId());
//                   //每一个导航菜单都有一个权限关键字，就是分包路径
//                   boolean check=false;
//                   for(Menu menu:menuList){
//                       //如果用户请求的资源路径包含了自己所拥有的导航中的权限关键字，正常访问。
//
//                       if(path.contains(menu.getMenuKey())){
//                            check=true;
//                       }
//                   }
//                   //如果check为true正常访问，如果为false，非法访问。
//                   if(check){
//                        return  true;
//                   }else {
//                       //登录成功，但是非法访问
//                       response.sendRedirect(request.getContextPath()+"/login/noauth");
//                       return  false;
//                   }
//               }
//           }
//
//        }
        return  true;

    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
           request.setAttribute("ctx",request.getContextPath());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
