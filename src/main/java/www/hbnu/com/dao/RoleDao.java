package www.hbnu.com.dao;

import www.hbnu.com.domain.Role;

import java.util.List;

/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/20 14:28
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
public interface RoleDao {
    //查询
    List<Role> findAllRole();

    //添加
    void save(Role role);
    //user的rolename查询
    List<Role> findByUserId(int u_id);

    //删除
    //先删除ur关系表的数据
    void deleteUR(Integer r_id);
    //再删除role表的数据
    void delete(Integer r_id);

    //修改
    //先根据id来查询role的信息
    Role findRoleById(Integer rid);
    //修改
    void updateRole(Role role);

    List<Role> selectByName();
}
