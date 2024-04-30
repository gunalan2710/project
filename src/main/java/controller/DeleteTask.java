package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.User;
@WebServlet("/delete")
public class DeleteTask extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int taskid = Integer.parseInt(req.getParameter("id"));
		Dao dao = new Dao();
		
		
		try {
			int res = dao.deleteTaskById(taskid);
		
		if(res>0) {
			User u = (User)req.getSession().getAttribute("user");
			req.setAttribute("tasks", dao.getalltasksByUserId(u.getUserid()));
			req.getRequestDispatcher("home.jsp").include(req, resp);
		}
		else {
			resp.getWriter().println("failed");
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
