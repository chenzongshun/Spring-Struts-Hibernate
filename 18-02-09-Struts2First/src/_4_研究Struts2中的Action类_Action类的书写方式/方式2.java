package _4_研究Struts2中的Action类_Action类的书写方式;

import com.opensymphony.xwork2.Action;

/**
 * @author 顺
 * @version 2018年2月10日 下午12:32:15
 */
// 方式2：实现接口Action
// 实现Action。com.opensymphony.xwork2.Action;的，因为它就是struts2的前身
// 接口里面有execute方法，提供了action规范
// 这样很好的提示了这个方法应该是public的，返回值为String的，不能带参数的，能够抛异常的
// Action接口里面还预置了一些字符串，可以在返回结果时使用，为了方便
// 但是也不常用，最常用的是第三种

public class 方式2 implements Action {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
