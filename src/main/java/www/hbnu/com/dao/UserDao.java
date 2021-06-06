package www.hbnu.com.dao;

import org.apache.ibatis.annotations.Param;
import www.hbnu.com.domain.User;

import java.util.List;
/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/20 14:26
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
public interface UserDao {
    //查询
    List<User> findAllUser();
    //添加用户
    Integer save(User user);
    //添加用户的关系
    void saveUR(@Param(value = "id") Integer id,@Param(value = "roleId") long roleId);


    //先删除ur关系表
    void deleteUR(Integer u_id);
    //删除user
    void delete(Integer u_id);

    //修改
    User findUserById(Integer uid);
    void update(User user);

    //登录
    User login(User user);

    //检索
    List<User> selectByName();
}
