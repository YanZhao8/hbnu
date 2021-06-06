package www.hbnu.com.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import www.hbnu.com.domain.Role;
import www.hbnu.com.domain.User;
import www.hbnu.com.service.RoleService;
import www.hbnu.com.service.UserService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/20 12:20
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @Description: //user-list查询的数据展示
     * @Param: [page, size]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: yanzhao
     * @Date: 2021/6/2 9:58
     **/
    @RequestMapping("/getAllUsers")
    @ResponseBody
    public ModelAndView getAllUsers(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                    @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        List<User> allUsers = userService.getAllUsers(page, size);
        //pageinfo就是分页的bean
        PageInfo<User> pageInfo = new PageInfo<User>(allUsers);
        modelAndView.addObject("users", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }


    @Autowired
    private RoleService roleService;

    /**
     * @Description: 保存 的展示角色对象数据
     * @Param: []
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: yanzhao
     * @Date: 2021/6/2 9:58
     **/
    @RequestMapping("/saveUI")
    @ResponseBody
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.getAllRoles();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    //保存
    @RequestMapping("/save")
    public String save(User user, long[] roleIds) {
        userService.save(user, roleIds);
        return "redirect:/user/getAllUsers";
    }

    /**
     * @Description: 删除ByID 更久id来删除
     * @Param: [u_id]
     * @return: java.lang.String
     * @Author: yanzhao
     * @Date: 2021/6/2 10:00
     **/
    //删除ByID
    @RequestMapping("/deleteUserById/{u_id}")
    public String deleteUserById(@PathVariable("u_id") Integer u_id) {
        userService.delete(u_id);
        return "redirect:/user/getAllUsers";
    }

    /**
     * @Description: //修改
     *               先回写数据
     *               再做修改
     * @Param: [uid]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: yanzhao
     * @Date: 2021/6/2 10:01
     **/
    //修改
    //回写数据
    @RequestMapping("/findUserById/{uid}")
    @ResponseBody
    public ModelAndView findUserById(@PathVariable("uid") Integer uid) {
        ModelAndView modelAndView = new ModelAndView();
        //查询会写用户user的数据
        User user = userService.findUserById(uid);
        modelAndView.addObject("user", user);
        //角色的rolename列表
        List<Role> roleList = roleService.getAllRoles();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-update");
        return modelAndView;
    }
    //更改数据
    @RequestMapping("/update")
    public String update(User user, long[] roleIds) {
        userService.update(user, roleIds);
        return "redirect:/user/getAllUsers";
    }

    /**
     * @Description: 登录查询数据库
     * @Param: [user]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: yanzhao
     * @Date: 2021/6/2 10:01
     **/
    //登录
    @RequestMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        User u = userService.login(user);
        // 6.判断是否登录成功
        if (u != null){
            //成功
            modelAndView.addObject("user",u);
            modelAndView.setViewName("main");
        }else{
            //失败
            //提示信息
            modelAndView.addObject("loginmsg","用户名或密码输入错误");
            //跳转登录页面
            modelAndView.setViewName("forward:/login.jsp");
        }
        return modelAndView;
    }







   /* //登录 方法二
    @RequestMapping("/login")
    public String login(HttpServletRequest request,User user){
        User u = userService.login(user);
        if (u != null){
            //成功
            request.setAttribute("user", u);
            return "forward:/views/main.jsp";
        }else{
            //失败
            //提示信息
            request.setAttribute("loginmsg","用户名或密码输入错误");
            //跳转登录页面
            return "forward:/login.jsp";
        }
    }*/


    /*@RequestMapping("/selectByName")
    @ResponseBody
    public ModelAndView selectByName(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                    @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.selectByName(page, size);
        //pageinfo就是分页的bean
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        modelAndView.addObject("users", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }*/

}
