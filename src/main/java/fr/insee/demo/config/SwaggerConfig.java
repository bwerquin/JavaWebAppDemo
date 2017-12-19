package fr.insee.demo.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerConfig extends HttpServlet {

	
	private static final long serialVersionUID = 7852516054619312011L;

	public void init(ServletConfig config) throws ServletException {
		try {
			super.init(config);
			BeanConfig beanConfig = new BeanConfig();
			
			
			Properties props = getEnvironmentProperties();
			String host = props.getProperty("fr.insee.demo.api.host");
			
			
			beanConfig.setHost(host);
			beanConfig.setTitle("API Demo");
			beanConfig.setVersion("0.1");
			beanConfig.setDescription("Java Api (Rest) for CI demo with Travis");
			beanConfig.setSchemes(new String[] { "http" });
			beanConfig.setBasePath(props.getProperty("fr.insee.demo.api.name"));
	        beanConfig.setHost(props.getProperty("fr.insee.demo.api.host"));
			beanConfig.setResourcePackage("fr.insee.demo.webservice");
			beanConfig.setScan(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 private Properties getEnvironmentProperties() throws IOException {
	        Properties props = new Properties();

	        String propsPath = "env/demo.properties";
	        props.load(getClass()
	                .getClassLoader()
	                .getResourceAsStream(propsPath));
	        
	        File f2 = new File(String.format("%s/webapps/%s", System.getProperty("catalina.base"), "production.properties"));
	        if(f2.exists() && !f2.isDirectory()) {
	            FileReader r2 = new FileReader(f2);
	            props.load(r2);
	            r2.close();
	        }
	        return props;
	    }
	
	
}
