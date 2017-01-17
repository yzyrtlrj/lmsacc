package com.accenture.aflac.lms.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author jiaojiao.xiao
 *
 * @param <E> 实体的类型
 * @param <K> 主键的类型
 */
public interface BaseDao<E,K extends Serializable> {
	
	
    int add(E entity);
    
    int delete(E entity);
    
    int update(E entity);
    
    //根据主键进行查询
    E findById(K id);
    
    List<E> findAll();
    
    //分页查询，offset是从第几条记录开始，length是需要查询的数据条数
    List<E> findAll(int offset,int length);
    
    List<?> findByHQL(String hql,Object[] params);
    
    List<E> findBySQL(String sql);
    
    //统计数据在数据库中的总行数
  	int countRows();

}
