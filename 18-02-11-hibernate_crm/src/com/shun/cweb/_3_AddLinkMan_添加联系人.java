package com.shun.cweb;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.shun.cservice.LinkManService;
import com.shun.cservice.impl.LinkManServiceImpl;
import com.shun.domain.Linkman;

/**
 * @author czs
 * @version 创建时间：2018年2月14日  下午8:59:21 
 */
//AddLinkman
public class _3_AddLinkMan_添加联系人 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LinkManService linkManService = new LinkManServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1获得参数并封装到LinkMan对象中
		Linkman linkman = new Linkman();
		try {
			BeanUtils.populate(linkman, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//2调用service保存LinkMan对象
		linkManService .save(linkman);
		
		//3重定向到LinkMan的列表
		response.sendRedirect("ListLinkMan");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}