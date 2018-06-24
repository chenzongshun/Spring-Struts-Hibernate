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
 * @version ����ʱ�䣺2018��2��14��  ����8:59:21 
 */
//AddLinkman
public class _3_AddLinkMan_�����ϵ�� extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LinkManService linkManService = new LinkManServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1��ò�������װ��LinkMan������
		Linkman linkman = new Linkman();
		try {
			BeanUtils.populate(linkman, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//2����service����LinkMan����
		linkManService .save(linkman);
		
		//3�ض���LinkMan���б�
		response.sendRedirect("ListLinkMan");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}