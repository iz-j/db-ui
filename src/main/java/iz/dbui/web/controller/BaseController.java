package iz.dbui.web.controller;

import iz.dbui.web.spring.jdbc.StatementManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String redirectToConnections() {
		logger.trace("#redirectToConnections");
		return "redirect:/connections";
	}

	@RequestMapping(value = "/abortSql", method = RequestMethod.POST)
	public void abortSql() {
		logger.trace("#abortSql");
		StatementManager.abortAllExecutions();
	}

}
