package org.paswork.application.hr.user.service;

import org.paswork.application.hr.user.model.UserModel;
import org.paswork.application.hr.user.model.UserQueryModel;
import org.paswork.framework.support.service.BaseService;
import org.paswork.framework.web.support.pagination.Page;



/**
 * User: dinglinhui
 * Date: 12-1-4 上午10:13
 * Version: 1.0
 */
public interface UserService extends BaseService<UserModel, Integer> {

    Page<UserModel> query(int pn, int pageSize, UserQueryModel command);
}
