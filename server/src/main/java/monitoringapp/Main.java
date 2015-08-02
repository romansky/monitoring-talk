package monitoringapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends AbstractHandler {

	Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
	private static WebMonitorMXBeanImpl monitorMXBean = null;

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		org.slf4j.MDC.put("target", target);
		logger.info("Got a new request; path:" + target);

		if (target.equals("") || target.equals("/")) {
			monitorMXBean.incNumRootRequestsCounter();
		}
		monitorMXBean.incNumRequestCounter();

		Timer.time("handling message", () -> {
			response.setContentType("text/html; charset=utf-8");
			try {
				response.getWriter().println("<h1>Pong</h1>");
				response.setStatus(HttpServletResponse.SC_OK);
			} catch (IOException e) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				e.printStackTrace();
			}
			baseRequest.setHandled(true);
			return null;
		});

	}

	public static void main(String[] args) throws Exception {
		monitorMXBean = WebMonitorMXBeanImpl.getInstance();
		Jmxer.registerMBean(monitorMXBean,"web");
		Server server = new Server(8000);
		server.setHandler(new Main());
		server.start();
		server.join();
	}
}
