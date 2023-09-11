import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.*;

import jakarta.servlet.annotation.*;

@WebServlet("/displayFactorial")
public class Task1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<title>Factorial Table</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<caption>Factorial Table</caption>");
        out.println("<thead><tr><th>Number</th><th>Factorial</th></tr></thead>");
        out.println("<tbody>");
        for (int i = 1; i <= 10; i++) {
            long factorial = calculateFactorial(i);
            out.println("<tr><td>" + i + "</td><td>" + factorial + "</td></tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
	}

	private long calculateFactorial(int n) {
		 if (n == 0 || n == 1) {
	            return 1;
	        } else {
	            return n * calculateFactorial(n - 1);
	        }
	}
	
	
}
