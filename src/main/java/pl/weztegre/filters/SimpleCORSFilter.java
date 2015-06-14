package pl.weztegre.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* Filtr CORS.
*/
@Component
public class SimpleCORSFilter implements Filter {

	/**
	* Metoda doFilter blokuje żądania z obcych domen, które nie spełniają zdefiniowanych tutaj warunków.
	*/
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE, PUT");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
		chain.doFilter(req, res);
	}

	/**
	* Metoda inicjalizuje instancję klasy
	* @param filterConfig Obiekt zawierający ustawienia filtra
	*/
	public void init(FilterConfig filterConfig) {
	}

	/**
	* Destruktor klasy
	*/
	public void destroy() {
	}

}