package com.shun._7_hibernate中的Criteria语法_语法过时待修;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
//条件查询
//HQL语句中,不可能出现任何数据库相关的信息的
// > 							gt
// >=						ge
// <							lt
// <=						le
// ==						eq
// !=							ne
// in							in
// between and		between
// like 						like
// is not null 			isNotNull
// is null					isNull
// or							or
// and						and

//Criteria离线查询
public class _5_Criteria离线查询语法 {
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	//_4_ListLinkMan_显示联系人.java中有Criteria离线查询
	
	@SuppressWarnings("unchecked")
	@Test
	//基本查询
	public void fun1(){
		
		//-----------------假装这里是Web层与Service层--------------------------

		//创建离线查询对象Detached：分离的分开的
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		dc.add(Restrictions.idEq(1l));//拼装条件，方法全部与普通Criteria一致

		//-----------------假装这里是Web层与Service层--------------------------
		
		
		//------------------这里是Dao层-------------------------
		
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		
		//3 与session关联
		Criteria executableCriteria = dc.getExecutableCriteria(session);
		
		List<Customer> list = executableCriteria.list();
		
		System.out.println(list);
		 
		//------------------这里是Dao层-------------------------
		tx.commit();
		session.close();	
	}	 
}
