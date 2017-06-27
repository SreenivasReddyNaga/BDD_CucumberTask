package org.epam.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	
	 private final static Logger logger = Logger.getLogger(PropertiesUtil.class);
	 
	 
	 public Properties getProperties(final String fileName) {

	        Properties prop = new Properties();
	        InputStream input = null;

	        try {	            
	            input = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);          
	            prop.load(input);
	            logger.info("PROPERTIES FILE '" + fileName + "' LOADED SUCCESSFULLY");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } finally {
	            if (input != null) {
	                try {
	                    input.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        return prop;

	    }

}
