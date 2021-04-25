package laba4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //связывание сервлета с URL
public class Calculator extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calculator = RequestCalc.fromRequestParameters(request);
		Calculator.setAsRequestAttributeAndCalculate(request);
		
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	private static class RequestCalc {
		private final String radius_calc;
		private double result;
		
		private RequestCalc (String radius) {
			this.radius_calc = radius;
		}
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("radius"));
		}
		public void setAsRequestAttributeAndCalculate(HttpServletRequest request) {
			request.setAttribute("radius_result", radius_calc);
			double radius_try;
			try {
			radius_try=Double.parseDouble(radius_calc);
			}
			catch (NumberFormatException e) {
				radius_try=0;
			}
		result=radius_try*2*Math.PI;
		String results = String.format("%.2f",result);
		request.setAttribute("results", results);
		}
		}	
}
