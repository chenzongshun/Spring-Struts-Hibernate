package shun.bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��10�� ����9:57:54
* ���ֲ�ͨ��ʵ���� 
*/
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	// ��ʼ��װ��ҳ�Ĳ���
	protected int page;
	protected int rows;
	
	public void setPage(int page) {
		this.page = page;
		pageBean.setCurrentPage(page);
	}

	public void setRows(int rows) {
		this.rows = rows;
		pageBean.setPageSize(rows);
	}

	protected PageBean pageBean = new PageBean();
	
	private static final long serialVersionUID = 1L;
	// ģ�Ͷ���
	protected T model;
	
	/**
	 * ͨ�����췽����̬��ȡ�̳д����ʵ�����ͣ�ͨ�����䴴��model����
	 */
	public BaseAction(){
		ParameterizedType superClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superClass.getActualTypeArguments();
		// ���BaseAction�������ķ�������
		@SuppressWarnings("unchecked")
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		try {
		// ͨ�����䴴������
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		// һ��Ҫ�ǵð����߲�ѯ��Ҫ��ѯ�����д��ȥ
		// �ǵ�û������ҲҪ��װ���߲�ѯ����
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
	}
	
	@Override
	public T getModel() {
		return model;
	}

	/**
	 * ����ͨ�õģ�����������ת��
	 * @param pageBeanToJson		�Ѿ������ݿ��õ�PageBean���󣬾����Ѿ������˽�����������ݿ��ܼ�¼��
	 */
	protected void pageQueryJsonAll(PageBean pageBeanToJson) {
		// �κ�ʱ�򶼲����������÷��ص�����
		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
		String jsonString = JSONObject.toJSONString(pageBeanToJson);
		// ������ͻ���
		try {
			System.out.println(jsonString);
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ע�⣺һ��Ҫ����rows��total�����У���Ȼ�ͻ��˵�datagrid����Ҳ���ղ������ݣ���PageBean��ҳ�е�"total","rows"ת��json�����ظ��ͻ��˵ķ���
	 * @param pageBeanToJson		�Ѿ������ݿ��õ�PageBean���󣬾����Ѿ������˽�����������ݿ��ܼ�¼��
	 * @param RequiredColumns		��Ҫת�����ֶΡ�����easyUiֻ��Ҫ"total","rows"�����У����Ծ�ת��
	 */
	protected void pageQueryJson(PageBean pageBeanToJson, String [] xuyaoColumn) {
		// �κ�ʱ�򶼲����������÷��ص�����
		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
		
		// ֻת��������--------Ϊʲô��total��rows?����ΪPageBean����������ֶΣ�����easyUi�����ݱ����Ҫ����У�����PageBeanȡ���������
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PageBean.class, xuyaoColumn);
		String jsonString = JSONObject.toJSONString(pageBeanToJson,filter);
		// ������ͻ���
		try {
			System.out.println(jsonString);
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����ͨ�õģ���ĳ��ʵ��������list�����е�ĳĳ�ֶ�ת����json��д�ؿͻ���
	 * @param pageBeanToJson		�Ѿ������ݿ��õ�XX����
	 * @param RequiredColumns		��Ҫת�����ֶΡ�
	 */
	protected void entityToJson(List<T> entity,String [] viewJsonColum) {
		
		// �κ�ʱ�򶼲����������÷��ص�����
		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
		
		// ֻת��������--------Ϊʲô��total��rows?����ΪPageBean����������ֶΣ�����easyUi�����ݱ����Ҫ����У�����PageBeanȡ���������
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
				entity.size()==0 ? entity.getClass() : entity.get(0).getClass(), viewJsonColum);
//		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PageBean.class, viewJsonColum);
		String jsonString = JSONArray.toJSONString(entity,filter);
		
		// ������ͻ���
		try {
			System.out.println(jsonString);
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���������л�Ϊjson,����д���ͻ������������Ҫ���벻��Ҫת�������Ե�����
	 * @param obj	��ת������
	 * @param excludesArgs	����Ҫת�������Ե�����
	 */
	public void objectToJson(Object obj, String[] excludesArgs) {
	   //���Թ���������
	   SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
	
	   //�����ų⼯��,ǿ��ĳЩ���Բ���Ҫ����һ�����ܱ����л�
	   Set<String> excludes = filter.getExcludes();
	
	   //���԰�������,ǿ������Ҫ���л�ĳЩ����.��������һ��,��ʵ�����.�˴����õ�ǰ��
	   //Set<String> includes = filter.getIncludes();
	
	   //�ų��������л�������
		if (excludesArgs != null) {
			for (String string : excludesArgs) {
				excludes.add(string);
			}
		}
	
	   //����fastJson�ķ���,����תjson,
	   //����һ:��Ҫ�����л��Ķ���
	   //������:���ڹ������ԵĹ�����
	   //������:�ر�ѭ������,���������,ҳ���޷�չʾ�ظ�������ֵ
	   String string = JSON.toJSONString(obj, filter,SerializerFeature.DisableCircularReferenceDetect);
	   System.out.println(string);
	   //ҳ���д
	   ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
	   try {
		   ServletActionContext.getResponse().getWriter().print(string);
	   } catch (IOException e) {
	      e.printStackTrace();
	   }
	}
}
