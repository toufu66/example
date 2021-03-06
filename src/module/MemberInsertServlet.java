package module;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_club.Member;
import db_club.MemberDAO;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO edao  = new MemberDAO();
		//int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address=request.getParameter("address");
		Member e = new Member(0,name,address) ;
    	edao.insert(name,address);
    	request.setAttribute("e", e);
		RequestDispatcher rd = request.getRequestDispatcher("/mlist");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
