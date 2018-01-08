package com.jmu.bibasedmanage.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.jmu.bibasedmanage.pojo.BmOperation;
import com.jmu.bibasedmanage.pojo.BmOperationAndGroup;
import com.jmu.bibasedmanage.pojo.BmRole;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public interface BmOperationDao {
    int deleteByPrimaryKey(String id);

    int insert(BmOperation record);

    int insertSelective(BmOperation record);

    BmOperation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BmOperation record);

    int updateByPrimaryKey(BmOperation record);


    //通过roleId查询operation
    List<BmOperation> selectByRoleId(String roleId);
    List<Map<String,Object>> selectByPage(PageBounds pageBounds, Map<String, Object> map);
    List<BmOperation> selectByOperationId(String roleId);
}