package com.shun.cweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.shun.cservice.LinkManService;
import com.shun.cservice.impl.LinkManServiceImpl;
import com.shun.domain.Linkman;


/**
 * @author czs
 * @version 创建时间：2018年2月16日  下午5:10:45 
 */
//ListLinkMan
public class _4_ListLinkMan_显示联系人 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LinkManService linkManService = new LinkManServiceImpl();
		
		String lkm_name = request.getParameter("lkm_name");
		
		List<Linkman> linkmans = null;

		if (lkm_name != null && !"".equals(lkm_name)) {// 说明是带着条件来的
			// 创建离线查询对象
			DetachedCriteria dc = DetachedCriteria.forClass(Linkman.class);
			dc.add(Restrictions.like("lkm_name", "%" + lkm_name + "%"));// 添加条件
			// 将离线查询对象传递到service层
			linkmans = linkManService.getAllLinkMan(dc);
		} else {
			// 获得所有的linkman
			linkmans = linkManService.getAllLinkMan();
		}

		request.setAttribute("linkmans", linkmans);
		
//		response.sendRedirect("jsp/linkman/list.jsp");
		
		request.getRequestDispatcher("jsp/linkman/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}