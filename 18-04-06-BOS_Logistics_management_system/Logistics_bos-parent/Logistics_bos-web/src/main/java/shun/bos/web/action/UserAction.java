package shun.bos.web.action;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import shun.bos.domain.BcUser;
import shun.bos.service.IUserService;
import shun.bos.utils.BOSUtils;
import shun.bos.utils.MD5Utils;
import shun.bos.web.action.base.BaseAction;

/**
* @author czs
* @version ����ʱ�䣺2018��4��10�� ����11:00:21 
*/
@Controller
@Scope("prototype") // ��������������ô���ǽж���ģʽ����ôʵ����������ʱ�򽫻��Ǳ����ģ���Ҫʱ����
//��������õĻ�����Ĭ�ϵĵ���ģʽ����ô������������ʱ��ͻᱻʵ�����������������Ե�ʱ����Ҫȥ�����������
public class UserAction extends BaseAction<BcUser> {
	private static final long serialVersionUID = 1L;
	// ����ע���ÿͻ��˷��͵���֤��
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	@Autowired
	private IUserService userService;
	
	/**
	 * �û���½
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		// �õ��洢��session����֤��
		String fwqYzm = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		// TODO �ǵ÷ſ�������֤��
		if (StringUtils.isNotBlank(checkcode) && checkcode.trim().equals(fwqYzm)) {// ��֤��ɹ�
//		if (true) {// ��֤��ɹ�
			//ʹ��shiro����ṩ�ķ�ʽ������֤����    
			Subject subject =  SecurityUtils.getSubject();
			// ���model���Ѿ���װ�õ��˺�����
			String username = super.model.getUsername();
			String password = super.model.getPassword();
			password = MD5Utils.md5(password);				//�ǵü�����֤����Ϊ���ݿ�洢�Ĳ�������
			// �����û����������ƶ���
			AuthenticationToken token = new UsernamePasswordToken(username,password);
			// ���������������û�з���ֵ��������Ҫ��try��catch�ķ�ʽ��������֤�ķ���
            try {
            	subject.login(token);					// ִ�е�½
            	/*
            	 * ���Subject����֤��ʱ�����ð�ȫ����������Shiro SecurityManager��������֤
            	 * �����ڰ�ȫ��������Ҫ�õ�Realm��������Ҫ�Լ�����һ��classʵ��Realm����ӿ�
            	 * ����һ��Ϊ�˼��ʡ�£�����һ��ֱ�Ӽ̳�Realm������AuthorizingRealm
            	 * �����Ŀ��Realm������/Logistics_bos-service/src/main/java/shun/bos/realm/BOSRealm.java
            	 */
            } catch (UnknownAccountException e ) {
    			this.addActionError("�û�δע��");
    			return LOGIN;// ���صĳ�������Сд��"login"
            } catch (IncorrectCredentialsException e ) {
    			this.addActionError("�������!!");
    			return LOGIN;// ���صĳ�������Сд��"login"
            } catch (LockedAccountException e ) {
    			this.addActionError("���˻�������~");
    			return LOGIN;// ���صĳ�������Сд��"login"
            } catch (ExcessiveAttemptsException e ) {
    			this.addActionError("���Դ�������!!");
    			return LOGIN;// ���صĳ�������Сд��"login"
            }
            /**
             * ͨ��subjectȡ��user������Realm������д����ôһ��
             * AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
             * ����ȡ�ĳ���
             */
            BcUser user = (BcUser) subject.getPrincipal();
            // ��user�������session��
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "index";								// shiro���û���׳��쳣˵����֤�ɹ�
		}else {// ��֤��ʧ�����ص�¼���� 
			this.addActionError("��֤�����");
			return LOGIN;// ���صĳ�������Сд��"login"
		}
	}
	
	/**
	 * �û���½����û����shiro���֮ǰ�õķ�������Ϊ���ݣ��Է��޸ĳ���
	 * @return
	 * @throws Exception
	 */
	public String login_old() throws Exception {
		// �õ��洢��session����֤��
		String fwqYzm = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if (StringUtils.isNotBlank(checkcode) && checkcode.trim().equals(fwqYzm)) {// ��֤��ɹ�
			// �����˺������Ѿ���װ����model�����ˣ�����ֱ�Ӵ��ݵ�service��ȥУ��
			boolean result = userService.check(this.model);
			if (result) {
				return "index";
			}else {
				this.addActionError("�˺Ż��������");
				return LOGIN;
			}
		}else {// ��֤��ʧ�����ص�¼���� 
			this.addActionError("��֤�����");
			return LOGIN;// ���صĳ�������Сд��"login"
		}
	}
	
	/**
	 * ע���û�����
	 * @return
	 * @throws Exception
	 */
	public String loginOut() throws Exception {
		// ���session�е�user����
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		// ����session��
		// ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	/**
	 * �û��޸�����
	 * @throws Exception
	 */
	public void updatePassword() throws Exception {
		// һ��Ҫ���ú÷��ظ��ͻ��˵����ͣ���������õĻ�Ĭ�Ͼ��Ƿ���һ������
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		int aaa = 1; // ����ɹ���־
		try {// model�����з�װ�˿ͻ��˴��������룬����useridһ��Ҫ��session����ȥȡ�ã��ͻ���û���ϴ�id
			userService.updateUserPwd(model.getPassword(),BOSUtils.getUser().getId());
		} catch (Exception e) { // ����޸�ʧ�ܾ���Ҫ��aaa�����־���ó�Ϊ0����ô�ͻ��˷��ַ���ֵ��Ϊ1�Ļ��ͻ�������Ӧ�Ĳ���
			aaa = 0;
		}
		// ���ͻ��˷�Ӧ
		ServletActionContext.getResponse().getWriter().write(aaa);
	}
	
	private String[] roleIds;
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	
	/**
	 * ���һ���û�
	 * @throws Exception
	 */
	public String add() throws Exception {
		userService.save(super.model,roleIds);
		return "list";
	}
	
	/**
	 * ��ʾ�û��б�
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		userService.pageQuery(super.pageBean);
		super.objectToJson(super.pageBean, new String[] { "qpNoticebills", "userRoles", "password" });
	}
}
