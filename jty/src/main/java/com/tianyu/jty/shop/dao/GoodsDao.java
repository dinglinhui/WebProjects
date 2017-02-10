package com.tianyu.jty.shop.dao;

import org.springframework.stereotype.Repository;

import com.tianyu.jty.common.persistence.HibernateDao;
import com.tianyu.jty.shop.entity.Goods;

/**
 * 商品DAO
 * @author ty
 * @date 2015年1月22日
 */
@Repository
public class GoodsDao extends HibernateDao<Goods, Integer>{

}
