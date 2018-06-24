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
* @version 创建时间：2018年4月10日 下午11:00:21 
*/
@Controller
@Scope("prototype") // 如果设置了这个那么就是叫多例模式，那么实例化这个类的时候将会是被动的，需要时创建
//如果不设置的话就是默认的单例模式，那么在容器启动的时候就会被实例化，所以在做测试的时候需要去除掉这个属性
public class UserAction extends BaseAction<BcUser> {
	private static final long serialVersionUID = 1L;
	// 属性注入获得客户端发送的验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 用户登陆
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		// 拿到存储到session的验证码
		String fwqYzm = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		// TODO 记得放开跳过验证码
		if (StringUtils.isNotBlank(checkcode) && checkcode.trim().equals(fwqYzm)) {// 验证码成功
//		if (true) {// 验证码成功
			//使用shiro框架提供的方式进行认证操作    
			Subject subject =  SecurityUtils.getSubject();
			// 获得model中已经封装好的账号密码
			String username = super.model.getUsername();
			String password = super.model.getPassword();
			password = MD5Utils.md5(password);				//记得加密验证，因为数据库存储的不是明文
			// 创建用户名密码令牌对象
			AuthenticationToken token = new UsernamePasswordToken(username,password);
			// 由于这个方法方法没有返回值，所以需要用try，catch的方式来包裹验证的方法
            try {
            	subject.login(token);					// 执行登陆
            	/*
            	 * 这个Subject在认证的时候会调用安全管理器对象（Shiro SecurityManager）进行认证
            	 * 但由于安全管理器需要用到Realm，所以需要自己创建一个class实现Realm这个接口
            	 * 不过一般为了简便省事，所以一般直接继承Realm的子类AuthorizingRealm
            	 * 这个项目的Realm创建在/Logistics_bos-service/src/main/java/shun/bos/realm/BOSRealm.java
            	 */
            } catch (UnknownAccountException e ) {
    			this.addActionError("用户未注册");
    			return LOGIN;// 返回的常量就是小写的"login"
            } catch (IncorrectCredentialsException e ) {
    			this.addActionError("密码错误!!");
    			return LOGIN;// 返回的常量就是小写的"login"
            } catch (LockedAccountException e ) {
    			this.addActionError("该账户不可用~");
    			return LOGIN;// 返回的常量就是小写的"login"
            } catch (ExcessiveAttemptsException e ) {
    			this.addActionError("尝试次数超限!!");
    			return LOGIN;// 返回的常量就是小写的"login"
            }
            /**
             * 通过subject取出user对象，在Realm类里我写了这么一句
             * AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
             * 所以取的出来
             */
            BcUser user = (BcUser) subject.getPrincipal();
            // 将user对象存入session域
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "index";								// shiro框架没有抛出异常说明认证成功
		}else {// 验证码失败跳回登录界面 
			this.addActionError("验证码错误！");
			return LOGIN;// 返回的常量就是小写的"login"
		}
	}
	
	/**
	 * 用户登陆，在没有用shiro框架之前用的方法，作为备份，以防修改出错
	 * @return
	 * @throws Exception
	 */
	public String login_old() throws Exception {
		// 拿到存储到session的验证码
		String fwqYzm = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if (StringUtils.isNotBlank(checkcode) && checkcode.trim().equals(fwqYzm)) {// 验证码成功
			// 由于账号密码已经封装到了model里面了，所以直接传递到service层去校验
			boolean result = userService.check(this.model);
			if (result) {
				return "index";
			}else {
				this.addActionError("账号或密码错误！");
				return LOGIN;
			}
		}else {// 验证码失败跳回登录界面 
			this.addActionError("验证码错误！");
			return LOGIN;// 返回的常量就是小写的"login"
		}
	}
	
	/**
	 * 注销用户功能
	 * @return
	 * @throws Exception
	 */
	public String loginOut() throws Exception {
		// 清除session中的user对象
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		// 销毁session域
		// ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	/**
	 * 用户修改密码
	 * @throws Exception
	 */
	public void updatePassword() throws Exception {
		// 一定要设置好返回给客户端的类型，如果不设置的话默认就是返回一个对象
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		int aaa = 1; // 定义成功标志
		try {// model对象中封装了客户端传来的密码，但是userid一定要从session域中去取得，客户端没有上传id
			userService.updateUserPwd(model.getPassword(),BOSUtils.getUser().getId());
		} catch (Exception e) { // 如果修改失败就需要把aaa这个标志设置成为0，那么客户端发现返回值不为1的话就会做出对应的操作
			aaa = 0;
		}
		// 给客户端反应
		ServletActionContext.getResponse().getWriter().write(aaa);
	}
	
	private String[] roleIds;
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	
	/**
	 * 添加一个用户
	 * @throws Exception
	 */
	public String add() throws Exception {
		userService.save(super.model,roleIds);
		return "list";
	}
	
	/**
	 * 显示用户列表
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		userService.pageQuery(super.pageBean);
		super.objectToJson(super.pageBean, new String[] { "qpNoticebills", "userRoles", "password" });
	}
}
