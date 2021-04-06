package laba4;

import java.io.IOException;
@WebServlet{name="Calc", urlPatterns="/JavaCalc"} // Связывание сервлета с URL
public class Calculator extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributedAndCalculate(request);
		
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	private static class RequestCalc {
		private final String radius_calc;
		private int result;
		
		private RequestCalc (String radius) {
			this.radius_calc = radius;
		}
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("radius"));
		}
		public void setAsRequestAttributeAndCalculate(HttpServletRequest request) {
			request.setAttribute("radius_result", radius_calc);
			int radius_try;
			try {
			radius_try=Integer.parseInt(radius_calc);
			}
			catch (NumberFormatException e) {
				radius_try=0;
			}
		result=radius_try;
		request.setAttribute("result", result);
		}
		}	
}
