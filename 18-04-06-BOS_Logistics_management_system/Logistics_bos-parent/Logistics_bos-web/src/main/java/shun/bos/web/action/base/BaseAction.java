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
* @version 创建时间：2018年4月10日 下午9:57:54
* 表现层通用实现类 
*/
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	// 开始封装分页的参数
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
	// 模型对象
	protected T model;
	
	/**
	 * 通过构造方法动态获取继承此类的实体类型，通过反射创建model对象
	 */
	public BaseAction(){
		ParameterizedType superClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superClass.getActualTypeArguments();
		// 获得BaseAction上声明的泛型数组
		@SuppressWarnings("unchecked")
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		try {
		// 通过反射创建对象
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		// 一定要记得把离线查询需要查询的类给写进去
		// 记得没有条件也要封装离线查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
	}
	
	@Override
	public T getModel() {
		return model;
	}

	/**
	 * 配置通用的，将整个对象转换
	 * @param pageBeanToJson		已经从数据库查好的PageBean对象，就是已经包含了结果集，和数据库总记录数
	 */
	protected void pageQueryJsonAll(PageBean pageBeanToJson) {
		// 任何时候都不能忘记设置返回的类型
		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
		String jsonString = JSONObject.toJSONString(pageBeanToJson);
		// 输出到客户端
		try {
			System.out.println(jsonString);
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 注意：一定要传入rows和total这两列，不然客户端的datagrid死人也接收不到数据！将PageBean分页中的"total","rows"转成json并返回给客户端的方法
	 * @param pageBeanToJson		已经从数据库查好的PageBean对象，就是已经包含了结果集，和数据库总记录数
	 * @param RequiredColumns		需要转换的字段。由于easyUi只需要"total","rows"这两列，所以就转吧
	 */
	protected void pageQueryJson(PageBean pageBeanToJson, String [] xuyaoColumn) {
		// 任何时候都不能忘记设置返回的类型
		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
		
		// 只转换这两列--------为什么是total和rows?，因为PageBean里面有这个字段，由于easyUi的数据表格需要这个列，所以PageBean取了这个名字
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PageBean.class, xuyaoColumn);
		String jsonString = JSONObject.toJSONString(pageBeanToJson,filter);
		// 输出到客户端
		try {
			System.out.println(jsonString);
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 配置通用的，将某个实体类对象的list集合中的某某字段转换成json并写回客户端
	 * @param pageBeanToJson		已经从数据库查好的XX集合
	 * @param RequiredColumns		需要转换的字段。
	 */
	protected void entityToJson(List<T> entity,String [] viewJsonColum) {
		
		// 任何时候都不能忘记设置返回的类型
		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
		
		// 只转换这两列--------为什么是total和rows?，因为PageBean里面有这个字段，由于easyUi的数据表格需要这个列，所以PageBean取了这个名字
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
				entity.size()==0 ? entity.getClass() : entity.get(0).getClass(), viewJsonColum);
//		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PageBean.class, viewJsonColum);
		String jsonString = JSONArray.toJSONString(entity,filter);
		
		// 输出到客户端
		try {
			System.out.println(jsonString);
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将对象序列化为json,并回写到客户端浏览器，需要传入不需要转换的属性的数组
	 * @param obj	待转换对象
	 * @param excludesArgs	不需要转换的属性的数组
	 */
	public void objectToJson(Object obj, String[] excludesArgs) {
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
	   String string = JSON.toJSONString(obj, filter,SerializerFeature.DisableCircularReferenceDetect);
	   System.out.println(string);
	   //页面回写
	   ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
	   try {
		   ServletActionContext.getResponse().getWriter().print(string);
	   } catch (IOException e) {
	      e.printStackTrace();
	   }
	}
}
