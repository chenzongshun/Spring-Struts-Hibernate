package _4_研究Struts2中的Action类_Action类的书写方式;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 顺
 * @version 2018年2月10日 下午12:32:15
 */
// 方式3：继承一个类：ActionSupport
// 帮我们实现了Action,Validateable,ValidationAware,TextProvider,LocaleProvider,Serializable
// 如果需要用到这些接口的实现时，不需要自己来实现了

public class 方式3常用 extends ActionSupport {
	private static final long serialVersionUID = 6270948728636393928L;

}
