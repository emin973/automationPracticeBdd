package com.automationpractice.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
public class AppProperties {
    
    private final static Logger logger = Logger.getLogger(AppProperties.class);
    private static Properties properties = getProperties();
    
    public static final String AUTOMATION_PRACTICE_BASE_URL = properties.getProperty("automation_practice_base_url");
    public static final String BROWSER_TYPE = properties.getProperty("browser_type");
    
    private static Properties getProperties () {
        Properties properties = new Properties();
        
        try {
            String filePath = System.getProperty("user.dir") + 
                    "/src/test/resources/properties/config.properties";
            InputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch ( IOException e ) {
            logger.error(e.getMessage());
        }
        return properties;
    }
}
