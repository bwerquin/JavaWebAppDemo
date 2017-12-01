package fr.insee.demo.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerConfig extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7852516054619312011L;

	public void init(ServletConfig config) throws ServletException {
		try {
			super.init(config);
			// TODO Externalize the parameter
			BeanConfig beanConfig = new BeanConfig();
			beanConfig.setTitle("API Demo");
			beanConfig.setVersion("0.1");
			beanConfig.setDescription("Java Api (Rest) for CI demo with Travis");
			beanConfig.setSchemes(new String[] { "http" });
			beanConfig.setBasePath("/javaWebApp/api");
			beanConfig.setHost("localhost:8080");
			beanConfig.setResourcePackage("fr.insee.demo.webservice");
			beanConfig.setScan(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
