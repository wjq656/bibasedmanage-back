package com.jmu.bibasedmanage;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.jmu.bibasedmanage.dao.BmOperationDao;
import com.jmu.bibasedmanage.dao.BmRoleDao;
import com.jmu.bibasedmanage.pojo.BmOperation;
import com.jmu.bibasedmanage.pojo.BmRole;
import org.apache.commons.collections.map.HashedMap;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.json.Json;
import java.util.List;
import java.util.Map;

/**
 * Created by WJQ on 2018/1/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class Test {

    @Autowired
    private BmOperationDao operationDao;

    @Autowired
    private BmRoleDao roleDao;
    @org.junit.Test
    public void test(){
        System.out.println(111);
        PageBounds pageBounds = new PageBounds();
        pageBounds.setPage(0);
        pageBounds.setLimit(5);
        Map<String, Object> map = new HashedMap() ;
        List<BmRole> roles =roleDao.selectByPage(pageBounds,map);
        List<Map<String,Object>> operations =operationDao.selectByPage(pageBounds,map);
        System.out.println(JSON.toJSONString(operations));
        System.out.println(JSON.toJSONString(roles));
    }
}
