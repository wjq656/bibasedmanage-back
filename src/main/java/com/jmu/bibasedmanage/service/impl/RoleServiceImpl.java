package com.jmu.bibasedmanage.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.jmu.bibasedmanage.consts.CommonConst;
import com.jmu.bibasedmanage.dao.BmRoleDao;
import com.jmu.bibasedmanage.pojo.BmRole;
import com.jmu.bibasedmanage.pojo.BmStudent;
import com.jmu.bibasedmanage.service.RoleService;
import com.jmu.bibasedmanage.util.UUIDUtils;
import com.jmu.bibasedmanage.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by ljc on 2017/12/26.
 */
@Transactional
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private BmRoleDao bmRoleDao;
    public Page<BmRole> list(Map map, Page<BmRole> page) {
        PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        List<BmRole> students = bmRoleDao.selectByPage(pageBounds, map);
        page.setResult(students);
        page.setTotalCountByPageList((PageList) students);
        return page;
    }

   public String add(BmRole bmRole) {
        String id = UUIDUtils.generator();
        bmRole.setId(id);
        bmRoleDao.insertSelective(bmRole);
        return id;
    }

    public void update(BmRole bmRole) {
        bmRoleDao.updateByPrimaryKeySelective(bmRole);
    }

    public void delete(String id) {
        bmRoleDao.deleteByPrimaryKey(id);
    }

    public BmRole selectById(String roleId) {
        return bmRoleDao.selectByPrimaryKey(roleId);
    }
}
