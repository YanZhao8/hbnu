package www.hbnu.com.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.hbnu.com.dao.RoleDao;
import www.hbnu.com.domain.Role;
import www.hbnu.com.service.RoleService;

import java.util.List;

/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/20 14:31
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    //查询
    @Override
    public List<Role> getAllRole(int page, int size) {
        PageHelper.startPage(page,size);
        List<Role> roleList = roleDao.findAllRole();
        return roleList;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList = roleDao.findAllRole();
        return roleList;
    }

    //保存
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    //删除ByID
    @Override
    public void delete(Integer r_id) {
        roleDao.deleteUR(r_id);
        roleDao.delete(r_id);
    }

    //修改
    @Override
    public Role findRoleById(Integer rid) {
        Role role = roleDao.findRoleById(rid);
        return role;
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public List<Role> selectByName(int page, int size) {
        PageHelper.startPage(page,size);
        List<Role> roleList = roleDao.selectByName();
        return roleList;
    }

}
