package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	private final static String propertyFilePath = "./src/test/resources/config/config.properties";

	public static void loadConfig() throws Throwable {
		try {
			FileInputStream fis;
			fis = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static String getBrowserType() {
		String browser = properties.getProperty("browser");
		//Loggerload.info("Get property BrowserType");
		System.out.println("Get property BrowserType");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the config.properties file.");
	}

	/*public static String getApplicationUrl() {
		String url = properties.getProperty("app_url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the config.properties file.");
	}

	public static String getBrowserType() {
		String browser = properties.getProperty("browser");
		//Loggerload.info("Get property BrowserType");
		System.out.println("Get property BrowserType");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}*/

public static String getApplicationUrl(){
		String url = properties.getProperty("baseurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
		
}

public static String loginPageURL(){
	String url = properties.getProperty("loginURL");
	if (url != null)
		return url;
	else
		throw new RuntimeException("url not specified in the Configuration.properties file.");
}

public static String dashboardPageURL(){
	String url = properties.getProperty("dashboardURL");
	if (url != null)
		return url;
	else
		throw new RuntimeException("url not specified in the Configuration.properties file.");
}

public static String manageClassURL(){
	String url = properties.getProperty("classURL");
	if (url != null)
		return url;
	else
		throw new RuntimeException("url not specified in the Configuration.properties file.");
}

public static String studentClassURL(){
	String url = properties.getProperty("studentURL");
	if (url != null)
		return url;
	else
		throw new RuntimeException("url not specified in the Configuration.properties file.");
}

public static String adminUsername(){
	String user = properties.getProperty("username");
	if (user != null)
		return user;
	else
		throw new RuntimeException("username is not specified in the configuration .properties file");
}

public static String adminPassword(){
	String pass = properties.getProperty("password");
	if (pass != null)
		return pass;
	else
		throw new RuntimeException("password is not specified in the configuration .properties file");
}

public static String getExcelFilePath(){
	String pass = properties.getProperty("excelpath");
	if (pass != null)
		return pass;
	else
		throw new RuntimeException("password is not specified in the configuration .properties file");
}
public static String getResetUrl() {
	String url = properties.getProperty("reseturl");
	if (url != null)
		return url;
	else
		throw new RuntimeException("url not specified in the Configuration.properties file.");

}

}