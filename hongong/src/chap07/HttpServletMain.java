package chap07;

public class HttpServletMain {

	public static void main(String[] args) {
		method(new LoginServlet());
		method(new FilleDownloadServlet());

	}

	public static void method(HttpServlet servlet) {
		servlet.service();
	}

}
