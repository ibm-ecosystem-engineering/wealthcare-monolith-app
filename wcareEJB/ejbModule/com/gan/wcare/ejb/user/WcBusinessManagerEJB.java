package com.gan.wcare.ejb.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gan.wcare.common.CommonConstants;
import com.gan.wcare.common.DateUtil;
import com.gan.wcare.common.LogUtil;
import com.gan.wcare.ejb.model.CustomError;
import com.gan.wcare.jpa.dao.WcBusinessManagerDao;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.dao.WcBusinessManagerDao;
import com.gan.wcare.jpa.entity.WcBusinessManager;
import com.gan.wcare.jpa.entity.WcUsers;
import com.gan.wcare.jpa.entity.WcBusinessManager;

@Stateless
public class WcBusinessManagerEJB {

	WcUsersDao wcUsersDao = new WcUsersDao();
	WcBusinessManagerDao wcBusinessManagerDao = new WcBusinessManagerDao();
    WcBusinessManagerDao  wealthManagerDao  = new WcBusinessManagerDao();
	

    @EJB
    private WcUsersEJB usersService;
    @EJB
    private ImageServiceEJB imageService;
 

    public List<WcBusinessManager> findAll() {
        List<WcBusinessManager> list = wealthManagerDao.findAll();
      
        return list;
    }

    public Object create(WcBusinessManager wcBusinessManager) {

        wcBusinessManagerDao.save(wcBusinessManager);

        return wcBusinessManager;
    }

    public WcBusinessManager update(WcBusinessManager wcBusinessManager) {
        LogUtil.log("WcBusinessManagerService : update : " + wcBusinessManager.getId());


        wcBusinessManagerDao.save(wcBusinessManager);
        wcBusinessManager = find(wcBusinessManager.getId());
        return wcBusinessManager;
    }

    public WcBusinessManager find(Integer id) {
        WcBusinessManager wcBusinessManager = wcBusinessManagerDao.findById(id);
        return wcBusinessManager;
    }

    public WcBusinessManager delete(int id) {

        LogUtil.log("WcBusinessManagerService : delete : " + id);

        WcBusinessManager wcBusinessManager = find(id);
        if(wcBusinessManager != null){
            wcBusinessManagerDao.delete(id);
        }
        return wcBusinessManager;
    }

    public WcBusinessManager findOneByWcUserId(Integer id) {
        return wcBusinessManagerDao.findOneByUserId(id);
    }
}
