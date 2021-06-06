package www.hbnu.com.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import www.hbnu.com.dao.RoleDao;
import www.hbnu.com.domain.Role;
import www.hbnu.com.domain.User;
import www.hbnu.com.service.RoleService;

import java.util.List;

/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/20 14:23
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

//    非分页的
    /*@RequestMapping("/getAllRole")
    @ResponseBody
    public ModelAndView getAllRole() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.getAllRole();
        //设置模型
        modelAndView.addObject("roleList", roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }*/

    //user-list查询的数据展示
    @RequestMapping("/getAllRole")
    @ResponseBody
    public ModelAndView getAllRole(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                   @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.getAllRole(page, size);
        //pageinfo就是分页的bean
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);

        //设置模型
        modelAndView.addObject("roleList", pageInfo);
        //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    //添加
    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/getAllRole";
    }

    //删除
    @RequestMapping("/deleteRoleById/{r_id}")
    public String deleteRoleById(@PathVariable("r_id") Integer r_id) {
        roleService.delete(r_id);
        return "redirect:/role/getAllRole";
    }

    //根据Id查询信息
    @RequestMapping("/findRoleById/{rid}")
    @ResponseBody
    public ModelAndView findRoleById(@PathVariable("rid") Integer rid) {
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findRoleById(rid);
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role-update");
        return modelAndView;
    }

    //修改ById
    @RequestMapping("/updateById")
    public String updateById(Role role) {
        roleService.updateRole(role);
        return "redirect:/role/getAllRole";
    }

    //查询Byid
    @RequestMapping("/selectByName")
    @ResponseBody
    public ModelAndView selectByName(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                     @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.selectByName(page, size);
        //pageinfo就是分页的bean
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
        modelAndView.addObject("roleList", pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
}
