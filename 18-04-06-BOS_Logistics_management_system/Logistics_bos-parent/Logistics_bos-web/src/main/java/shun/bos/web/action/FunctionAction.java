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
* @version 创建时间：2018年4月26日 上午11:03:28 
*/
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<AuthFunction> {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IFunctionService functionService;

	/**
	 * 为function_add.jsp添加权限页的添加父级权限combox准备数据
	 * @throws Exception
	 */
	public void listAjax() throws Exception {
		List<AuthFunction> list = functionService.findAll();
		String[] excludesArgs = new String[] { "authRoles","authFunction"};
		
		   //属性过滤器对象
		   SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		
		   //属性排斥集合,强调某些属性不需要或者一定不能被序列化
		   Set<String> excludes = filter.getExcludes();
		
		   //属性包含集合,强调仅需要序列化某些属性.具体用哪一个,看实际情况.此处我用的前者
		   //Set<String> includes = filter.getIncludes();
		
		   //排除不需序列化的属性
			if (excludesArgs != null) {
				for (String string : excludesArgs) {
					excludes.add(string);
				}
			}
		
		   //调用fastJson的方法,对象转json,
		   //参数一:需要被序列化的对象
		   //参数二:用于过滤属性的过滤器
		   //参数三:关闭循环引用,若不加这个,页面无法展示重复的属性值
		   String string = JSON.toJSONString(list, filter,SerializerFeature.DisableCircularReferenceDetect);
		   string = string.replace("\"name\"", "\"text\"");
		   string = string.replace("\"authFunctions\"", "\"children\"");
		   System.out.println(string);
		   //页面回写
		   ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		   try {
			   ServletActionContext.getResponse().getWriter().print(string);
		   } catch (IOException e) {
		      e.printStackTrace();
		   }
	}
	
	/**
	 * 为role_add.jsp页的ztree准备数据，其实就是复制了上面的方法，注释掉了将name改为text的代码
	 * @throws Exception
	 */
	public void rolelistFunctionAjax() throws Exception {
		List<AuthFunction> list = functionService.findAll();
		String[] excludesArgs = new String[] { "authRoles","authFunction"};
		
		   //属性过滤器对象
		   SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		
		   //属性排斥集合,强调某些属性不需要或者一定不能被序列化
		   Set<String> excludes = filter.getExcludes();
		
		   //属性包含集合,强调仅需要序列化某些属性.具体用哪一个,看实际情况.此处我用的前者
		   //Set<String> includes = filter.getIncludes();
		
		   //排除不需序列化的属性
			if (excludesArgs != null) {
				for (String string : excludesArgs) {
					excludes.add(string);
				}
			}
		
		   //调用fastJson的方法,对象转json,
		   //参数一:需要被序列化的对象
		   //参数二:用于过滤属性的过滤器
		   //参数三:关闭循环引用,若不加这个,页面无法展示重复的属性值
		   String string = JSON.toJSONString(list, filter,SerializerFeature.DisableCircularReferenceDetect);
//		   string = string.replace("\"name\"", "\"text\"");
		   string = string.replace("\"authFunctions\"", "\"children\"");
		   System.out.println(string);
		   //页面回写
		   ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		   try {
			   ServletActionContext.getResponse().getWriter().print(string);
		   } catch (IOException e) {
		      e.printStackTrace();
		   }
	}
	
	/**
	 * 为bos主界面添加菜单，根据用户id查询所拥有的权限来展示菜单树
	 * @return
	 * @throws Exception
	 */
	public void findMenu() throws Exception {
		BcUser user = BOSUtils.getUser();
		List<AuthFunction> list = null;
		// 如果是admin和shun就授予全部权限
		if (user.getUsername().equals("admin") || user.getUsername().equals("shun")) {
			list = functionService.findAllMenu();
		}else {		// 否则根据用户id查询所拥有的权限
			list = functionService.findMenuByUserId(user.getId());
		}
		String[] excludesArgs = new String[] { "authRoles", "authFunction" };
		super.objectToJson(list, excludesArgs);
		
//		   //属性过滤器对象
//		   SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
//		
//		   //属性排斥集合,强调某些属性不需要或者一定不能被序列化
//		   Set<String> excludes = filter.getExcludes();
//		
//		   //属性包含集合,强调仅需要序列化某些属性.具体用哪一个,看实际情况.此处我用的前者
//		   //Set<String> includes = filter.getIncludes();
//		
//		   //排除不需序列化的属性
//			if (excludesArgs != null) {
//				for (String string : excludesArgs) {
//					excludes.add(string);
//				}
//			}
//		
//		   //调用fastJson的方法,对象转json,
//		   //参数一:需要被序列化的对象
//		   //参数二:用于过滤属性的过滤器
//		   //参数三:关闭循环引用,若不加这个,页面无法展示重复的属性值
//		   String string = JSON.toJSONString(list, filter,SerializerFeature.DisableCircularReferenceDetect);
//		   System.out.println(string);
//		   //页面回写
//		   ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
//		   try {
//			   ServletActionContext.getResponse().getWriter().print(string);
//		   } catch (IOException e) {
//		      e.printStackTrace();
//		   }
	}
	
	
	/**
	 * 添加一个权限
	 * @return
	 * @throws Exception 
	 */
	public String add() throws Exception {
		// 判断这个对象不等于空是有意义的，防止坏心思的人在地址栏假造访问数据，这样带来安全隐患
		if (super.model != null && super.model.getAuthFunction().getId().equals("")) {
			// super.model.getAuthFunction().setId(null);
			// 当时想着也没错，这个对象要设置成为空行就是将这个对象里面的id设置为null就了，结果抛出外键约束，没想到的是需要将对象里面的对象直接清空
			super.model.setAuthFunction(null);
		}
		functionService.add(super.model);
		return "list";
	}
	
	/**
	 * 显示所有的权限数据数据
	 * @return
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		// 由于页面传入的Page被封装到了model的page里面了，所以PageBean里面的CurrentPage封装失败，所以需要取出来赋值给pagebean
		super.pageBean.setCurrentPage(Integer.parseInt(super.model.getPage()));
		functionService.pageQuery(super.pageBean);
		super.objectToJson(super.pageBean, new String[]{"authFunction","authFunctions","authRoles"});
	}
}
