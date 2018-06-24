package shun.bos.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import shun.bos.domain.BcStaff;
import shun.bos.utils.PageBean;

/**
 * @author czs
 * @version 创建时间：2018年4月10日 下午1:00:21 持久层通用接口
 */
public interface IBaseDao<T> {

	public void save(T entity);

	public void delete(T entity);

	public void update(T entity);

	/*
	 * Serializable覆盖了所有能够作为id的类型，这些类型的特点都是它的实现类
	 * 八大基本数据类型的包装类都实现了Serializable，String也是
	 */
	public T findById(Serializable id);

	public List<T> findAll();
	
	/**
	 * 执行更新
	 * @param queryName
	 * @param objects
	 */
	public void executeUpdate(String queryName, Object...objects);
	

	/**
	 * 将查询的数据放到这个pageBean里面去
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);
	
	/**
	 * 保存或修改对象
	 * @param entity
	 */
	void saveOrUpdate(T entity);
	
	/**
	 * 根据条件查询对象
	 * @return
	 */
	List<T> findByDetachedCriteria(DetachedCriteria detachedCriteria);
}
