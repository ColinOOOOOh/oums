package com.oums.dao;

import java.io.Serializable;

import com.oums.bean.po.BasePo;

public interface IBaseDao {
	
	/**
	 * ��
	 * @param po
	 * @return
	 */
	abstract <T extends BasePo> Serializable add(T po); 
	
	/**
	 * ɾ
	 * @param po
	 */
	abstract <T extends BasePo> void delete(T po); 
	
	/**
	 * ��(����Id)
	 * @param id
	 * @return
	 */
	abstract <T extends BasePo> T findById(Class<T> poClass, Integer id);
	
	/**
	 * ��
	 * @param po
	 */
	abstract <T extends BasePo> void update(T po); 
}
