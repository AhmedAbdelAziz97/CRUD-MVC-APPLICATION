package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Emp;
import Model.EmpControllerUtil;
import Model.EmpDB;

/**
 * Servlet implementation class EmpControllerServlet
 */
@WebServlet("/EmpControllerServlet")
public class EmpControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		String action = request.getParameter("action") ==null ? "" : request.getParameter("action");
		String page = "index.jsp";
		System.out.println("action : " + action);
		Object result;
		Emp e = new Emp();
		if (action.equalsIgnoreCase("save")) {

			e = EmpControllerUtil.GetInf(request);
			result = EmpDB.save(e);
			result = EmpDB.getAllEmployees();
			page = "index.jsp";

		} else if (action.equalsIgnoreCase("update")) {
			
			e = EmpControllerUtil.GetInf(request);
			result = EmpDB.update(e);
			page = "index.jsp";

		} else if (action.equalsIgnoreCase("delete")) {

			e = EmpControllerUtil.GetInf(request);
			result = EmpDB.delete(e.getId());
			result = EmpDB.getAllEmployees();
			page = "index.jsp";
		} else {
			result = EmpDB.getAllEmployees();
			page = "index.jsp";
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
