package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.BankUsers;
import com.revature.util.HibernateUtil;

public class BankUsersDao {
	public List<BankUsers> getBankUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from users").list();
	}
	public BankUsers getBankUsersByUsername(String aName) {
		BankUsers found = null;
		List<BankUsers> bankUsers = new ArrayList<BankUsers>();
		Session session = HibernateUtil.getSession();
		
		bankUsers = session.createQuery(
				"from Users where username = :nameVar")
				.setString("nameVar", aName).list();
		if (!bankUsers.isEmpty()) {
			found = bankUsers.get(0);
		}
		return found;
	}
	public int saveBankUsers(BankUsers b) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (Integer) session.save(b);
		tx.commit();
		return result;
	}
	
	public static void main (String [] args) {
		BankUsersDao budao = new BankUsersDao();
		List<BankUsers> bankUsersList = budao.getBankUsers();
	
		for (BankUsers bu : bankUsersList)
			System.out.println(bu.toString());
	}
}




