package cn.cc.demo.mapper.blog;

import cn.cc.demo.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * sqlServer数据库
 *
 * @author nc
 * 2022/11/9
 */
@Mapper
public interface BlogMapper {
    List<Map<String, Object>> getBlog();
}
