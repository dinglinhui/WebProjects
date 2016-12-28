package org.paswork.application.hr.user.dao;

import java.util.List;

import org.paswork.application.hr.user.model.UserModel;
import org.paswork.application.hr.user.model.UserQueryModel;
import org.paswork.framework.support.dao.hibernate.IBaseDao;




public interface UserDao extends IBaseDao<UserModel, Integer> {
    
    List<UserModel> query(int pn, int pageSize, UserQueryModel command);

    int countQuery(UserQueryModel command);

}
