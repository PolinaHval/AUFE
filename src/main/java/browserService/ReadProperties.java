package browserService;


import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    protected Properties properties;

    public ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL() {
        return properties.getProperty("URL");
    }

    public String getApiURL() {
        return properties.getProperty("apiURL");
    }

    public String getBrowserName() {
        return properties.getProperty("browserType");
    }

    public boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public String getUserName() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("psw");
    }

    public String getName() {
        return properties.getProperty("name");
    }

    public String getNewName() {
        return properties.getProperty("newName");
    }

}