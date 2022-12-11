package cn.cc.demo.mapper.user;

import cn.cc.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * mysql数据库
 *
 * @author nc
 * 2022/11/9
 */
@Mapper
public interface UserMapper {
    List<Map<String, Object>> getUser();
}
