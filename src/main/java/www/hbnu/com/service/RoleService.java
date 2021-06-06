package www.hbnu.com.service;

import www.hbnu.com.domain.Role;

import java.util.List;

/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/20 14:31
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
public interface RoleService {
    //查询
    List<Role> getAllRole(int page, int size);
    //用户加载时候查询role展示角色
    List<Role> getAllRoles();

    //添加
    void save(Role role);

    //删除按钮删除
    void delete(Integer r_id);

    //修改
    //通过id查询值
    Role findRoleById(Integer rid);
    //修改
    void updateRole(Role role);

    List<Role> selectByName(int page, int size);
}
