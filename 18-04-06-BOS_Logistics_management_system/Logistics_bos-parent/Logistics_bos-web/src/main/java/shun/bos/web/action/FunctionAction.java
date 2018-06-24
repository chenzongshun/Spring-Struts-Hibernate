package shun.bos.web.action;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import shun.bos.domain.AuthFunction;
import shun.bos.domain.BcUser;
import shun.bos.service.IFunctionService;
import shun.bos.utils.BOSUtils;
import shun.bos.web.action.base.BaseAction;

/**
* @author czs
* @version ����ʱ�䣺2018��4��26�� ����11:03:28 
*/
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<AuthFunction> {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IFunctionService functionService;

	/**
	 * Ϊfunction_add.jsp���Ȩ��ҳ����Ӹ���Ȩ��combox׼������
	 * @throws Exception
	 */
	public void listAjax() throws Exception {
		List<AuthFunction> list = functionService.findAll();
		String[] excludesArgs = new String[] { "authRoles","authFunction"};
		
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
		   String string = JSON.toJSONString(list, filter,SerializerFeature.DisableCircularReferenceDetect);
		   string = string.replace("\"name\"", "\"text\"");
		   string = string.replace("\"authFunctions\"", "\"children\"");
		   System.out.println(string);
		   //ҳ���д
		   ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		   try {
			   ServletActionContext.getResponse().getWriter().print(string);
		   } catch (IOException e) {
		      e.printStackTrace();
		   }
	}
	
	/**
	 * Ϊrole_add.jspҳ��ztree׼�����ݣ���ʵ���Ǹ���������ķ�����ע�͵��˽�name��Ϊtext�Ĵ���
	 * @throws Exception
	 */
	public void rolelistFunctionAjax() throws Exception {
		List<AuthFunction> list = functionService.findAll();
		String[] excludesArgs = new String[] { "authRoles","authFunction"};
		
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
		   String string = JSON.toJSONString(list, filter,SerializerFeature.DisableCircularReferenceDetect);
//		   string = string.replace("\"name\"", "\"text\"");
		   string = string.replace("\"authFunctions\"", "\"children\"");
		   System.out.println(string);
		   //ҳ���д
		   ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		   try {
			   ServletActionContext.getResponse().getWriter().print(string);
		   } catch (IOException e) {
		      e.printStackTrace();
		   }
	}
	
	/**
	 * Ϊbos��������Ӳ˵��������û�id��ѯ��ӵ�е�Ȩ����չʾ�˵���
	 * @return
	 * @throws Exception
	 */
	public void findMenu() throws Exception {
		BcUser user = BOSUtils.getUser();
		List<AuthFunction> list = null;
		// �����admin��shun������ȫ��Ȩ��
		if (user.getUsername().equals("admin") || user.getUsername().equals("shun")) {
			list = functionService.findAllMenu();
		}else {		// ��������û�id��ѯ��ӵ�е�Ȩ��
			list = functionService.findMenuByUserId(user.getId());
		}
		String[] excludesArgs = new String[] { "authRoles", "authFunction" };
		super.objectToJson(list, excludesArgs);
		
//		   //���Թ���������
//		   SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
//		
//		   //�����ų⼯��,ǿ��ĳЩ���Բ���Ҫ����һ�����ܱ����л�
//		   Set<String> excludes = filter.getExcludes();
//		
//		   //���԰�������,ǿ������Ҫ���л�ĳЩ����.��������һ��,��ʵ�����.�˴����õ�ǰ��
//		   //Set<String> includes = filter.getIncludes();
//		
//		   //�ų��������л�������
//			if (excludesArgs != null) {
//				for (String string : excludesArgs) {
//					excludes.add(string);
//				}
//			}
//		
//		   //����fastJson�ķ���,����תjson,
//		   //����һ:��Ҫ�����л��Ķ���
//		   //������:���ڹ������ԵĹ�����
//		   //������:�ر�ѭ������,���������,ҳ���޷�չʾ�ظ�������ֵ
//		   String string = JSON.toJSONString(list, filter,SerializerFeature.DisableCircularReferenceDetect);
//		   System.out.println(string);
//		   //ҳ���д
//		   ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
//		   try {
//			   ServletActionContext.getResponse().getWriter().print(string);
//		   } catch (IOException e) {
//		      e.printStackTrace();
//		   }
	}
	
	
	/**
	 * ���һ��Ȩ��
	 * @return
	 * @throws Exception 
	 */
	public String add() throws Exception {
		// �ж�������󲻵��ڿ���������ģ���ֹ����˼�����ڵ�ַ������������ݣ�����������ȫ����
		if (super.model != null && super.model.getAuthFunction().getId().equals("")) {
			// super.model.getAuthFunction().setId(null);
			// ��ʱ����Ҳû���������Ҫ���ó�Ϊ���о��ǽ�������������id����Ϊnull���ˣ�����׳����Լ����û�뵽������Ҫ����������Ķ���ֱ�����
			super.model.setAuthFunction(null);
		}
		functionService.add(super.model);
		return "list";
	}
	
	/**
	 * ��ʾ���е�Ȩ����������
	 * @return
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		// ����ҳ�洫���Page����װ����model��page�����ˣ�����PageBean�����CurrentPage��װʧ�ܣ�������Ҫȡ������ֵ��pagebean
		super.pageBean.setCurrentPage(Integer.parseInt(super.model.getPage()));
		functionService.pageQuery(super.pageBean);
		super.objectToJson(super.pageBean, new String[]{"authFunction","authFunctions","authRoles"});
	}
}
