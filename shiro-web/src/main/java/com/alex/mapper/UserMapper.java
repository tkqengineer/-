package com.alex.mapper;

import com.alex.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from users where username=#{username}")
    User getUserByName(@Param("username") String username);

    @Select("select resource.resource FROM users INNER JOIN user_role ON users.id=user_role.uid INNER JOIN `role_ resource` ON user_role.rid=`role_ resource`.roleid INNER JOIN resource ON `role_ resource`.rid=resource.id where users.username=#{username} ")
    List<String> getResourceByName(@Param("username") String username);

}
