package www.hbnu.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.hbnu.com.dao.RoleDao;
import www.hbnu.com.dao.UserDao;
import www.hbnu.com.domain.Role;
import www.hbnu.com.domain.User;
import www.hbnu.com.service.UserService;

import java.util.List;

/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/19 13:23
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> getAllUsers(int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        List<User> userList = userDao.findAllUser();
        //封装userList 的每一个roleList数据
        for (User user : userList) {
            int u_id = user.getId();
            //id作为参数查当前id对应的role的集合
            List<Role> roles = roleDao.findByUserId(u_id);
            user.setRoleList(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, long[] roleIds) {
        //1.先存入数据到user表
        userDao.save(user);
        //2.相ur关系表存入（多条）数据
        for (long roleId : roleIds) {
            userDao.saveUR(user.getId(), roleId);
        }
    }


    @Override
    public void update(User user, long[] roleIds) {
        userDao.update(user);
        userDao.deleteUR(user.getId());
        for (long roleId : roleIds) {
            userDao.saveUR(user.getId(),roleId);
        }
    }

    @Override
    public void delete(Integer u_id) {
        //先删除ur关系表的数据
        userDao.deleteUR(u_id);
        //再删除user表的数据
        userDao.delete(u_id);
    }

    @Override
    public User findUserById(Integer uid) {
        User user = userDao.findUserById(uid);
        List<Role> roles = roleDao.findByUserId(uid);
        user.setRoleList(roles);
        return user;
    }

    @Override
    public User login(User user) {
        User u = userDao.login(user);
        return u;
    }

    @Override
    public List<User> selectByName(int page, int size) {
        PageHelper.startPage(page, size);
        List<User> userList = userDao.selectByName();
        //封装userList 的每一个roleList数据
        for (User user : userList) {
            int u_id = user.getId();
            //id作为参数查当前id对应的role的集合
            List<Role> roles = roleDao.findByUserId(u_id);
            user.setRoleList(roles);
        }
        return userList;
    }


}
