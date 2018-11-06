package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import utilidades.Conexion;
import utilidades.login;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/conecta")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String mensaje = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		String rutaJSP = "";
		switch (opcion) {
		case "1":
			rutaJSP = "mensaje";
			opcion1(request);
			break;
		case "2":
			rutaJSP = "libros";
			ArrayList<Libro> libros = Conexion.getAllLibros();
			break;
		case "3":
			rutaJSP = "login";
			break;
			
		case "4":
			
		default:
			break;
		}
		request.getRequestDispatcher("jsp/" + rutaJSP + ".jsp").forward(request, response);
	}

	public void opcion1(HttpServletRequest request) {

		Connection cnx = Conexion.conectar("localhost:3306", "eShop", "root", "12345678");
		if (cnx == null)
			mensaje = "Error de conexi�n...";
		else
			mensaje = "Conectado con exito...";
		request.setAttribute("mensaje", mensaje);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean login(HttpServletRequest request) {
		login Login = new login();
		return Login.checkUrs(request.getParameter("uname"), request.getParameter("psw"));
		
	}

}
