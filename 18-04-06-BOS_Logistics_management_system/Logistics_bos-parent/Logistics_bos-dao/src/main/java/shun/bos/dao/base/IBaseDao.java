package shun.bos.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import shun.bos.domain.BcStaff;
import shun.bos.utils.PageBean;

/**
 * @author czs
 * @version ����ʱ�䣺2018��4��10�� ����1:00:21 �־ò�ͨ�ýӿ�
 */
public interface IBaseDao<T> {

	public void save(T entity);

	public void delete(T entity);

	public void update(T entity);

	/*
	 * Serializable�����������ܹ���Ϊid�����ͣ���Щ���͵��ص㶼������ʵ����
	 * �˴�����������͵İ�װ�඼ʵ����Serializable��StringҲ��
	 */
	public T findById(Serializable id);

	public List<T> findAll();
	
	/**
	 * ִ�и���
	 * @param queryName
	 * @param objects
	 */
	public void executeUpdate(String queryName, Object...objects);
	

	/**
	 * ����ѯ�����ݷŵ����pageBean����ȥ
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);
	
	/**
	 * ������޸Ķ���
	 * @param entity
	 */
	void saveOrUpdate(T entity);
	
	/**
	 * ����������ѯ����
	 * @return
	 */
	List<T> findByDetachedCriteria(DetachedCriteria detachedCriteria);
}
