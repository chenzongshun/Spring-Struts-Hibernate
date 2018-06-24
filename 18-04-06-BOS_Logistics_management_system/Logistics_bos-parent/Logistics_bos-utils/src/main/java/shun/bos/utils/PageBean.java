package shun.bos.utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
* @author czs
* @version ����ʱ�䣺2018��4��15�� ����2:14:38
* ��ҳ�Ĺ����� 
*/
public class PageBean {

	private int currentPage;	// ��ǰҳ��
	private int pageSize;		// ÿҳ��ʾ����
	private DetachedCriteria detachedCriteria; // ��װ��������
	private int total;			// �ܼ�¼��
	private List<?> rows;		// ��ѯ���Ľ����
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
