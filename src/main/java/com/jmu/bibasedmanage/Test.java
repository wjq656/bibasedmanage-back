package com.jmu.bibasedmanage;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.jmu.bibasedmanage.dao.BmOperationDao;
import com.jmu.bibasedmanage.dao.BmRoleDao;
import com.jmu.bibasedmanage.dao.BmRoleOperationDao;
import com.jmu.bibasedmanage.pojo.BmOperation;
import com.jmu.bibasedmanage.pojo.BmRole;
import org.apache.commons.collections.map.HashedMap;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.json.Json;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.roles;

/**
 * Created by WJQ on 2018/1/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class Test {

    @Autowired
    private BmOperationDao operationDao;

    @Autowired
    private BmRoleOperationDao roleOperationDao;
    @Autowired
    private BmRoleDao roleDao;
    @org.junit.Test
    public void test(){
        System.out.println(111);
       /* PageBounds pageBounds = new PageBounds();
        pageBounds.setPage(0);
        pageBounds.setLimit(5);
        Map<String, Object> map = new HashedMap() ;
        List<BmRole> roles =roleDao.selectByPage(pageBounds,map);
        List<Map<String,Object>> operations =operationDao.selectByPage(pageBounds,map);*/
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> map1= new HashedMap();
        map1.put("id","1231321");
        map1.put("roleId","1231321");
        map1.put("operationId","1231321");
        Map<String,Object> map2= new HashedMap();
        map2.put("id","1d2asdas1321");
        map2.put("roleId","123asda1321");
        map2.put("operationId","asdasd321");
        Map<String,Object> map3= new HashedMap();
        map3.put("id","hasdasas1321");
        map3.put("roleId","asda1321");
        map3.put("operationId","asdasdd321");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        int i = roleOperationDao.insertList(list);
        System.out.println(JSON.toJSONString(i));
    }
}
