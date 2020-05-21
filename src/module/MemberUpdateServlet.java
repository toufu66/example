
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
@WebServlet("/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO edao  = new MemberDAO();
		int id = Integer.parseInt(request.getParameter("mid"));
		Member m = edao.findByMid(id);
		request.setAttribute("m",m);
		RequestDispatcher rd = request.getRequestDispatcher("/update_confirm.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO edao  = new MemberDAO();
		//System.out.println(request.getParameter("mid"));
		String idstr = request.getParameter("mid");
		//System.out.println(idstr);System.out.println(idstr);System.out.println(idstr);
		int id = Integer.parseInt(idstr);
		String name = request.getParameter("name");
		String address=request.getParameter("address");
		//Member e = new Member(0,name,address) ;
    	edao.update(id,name,address);
    	//request.setAttribute("e", e);
		RequestDispatcher rd = request.getRequestDispatcher("/mlist");
		rd.forward(request, response);

	}

}
