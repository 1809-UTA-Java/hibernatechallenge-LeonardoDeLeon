package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.revature.model.Users;
import com.revature.repository.ErsDao;
import com.revature.util.HibernateUtil;

@SuppressWarnings("serial")
@WebServlet("/users")
public class UsersServlet extends HttpServlet {

	List<Users> users;
	ErsDao ers = new ErsDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		users = ers.getUsers();
		resp.setContentType("text/xml");
		ObjectMapper om = new XmlMapper();
		String obj = om.writeValueAsString(users);
		// String obj = om.writeValueAsString(ers.getUserByName("bob"));
		PrintWriter pw = resp.getWriter();
		pw.print(obj);
		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		ObjectMapper om = new XmlMapper();
//		Users postUsers = (Users) om.readValue(req.getInputStream(), Users.class);
//		PrintWriter pw = resp.getWriter();
//		pw.print(ers.saveAnimal(postUsers));
//		pw.close();
	}
	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}
