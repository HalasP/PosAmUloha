package sk.fiit.halas.posam.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InputProperties {

	private static InputProperties instance = null;
    private Properties properties;

    protected InputProperties() throws IOException{
        properties = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/resources/Properties");
		properties.load(input);
		if (input != null) {
			input.close();
		}
    }

    public static InputProperties getInstance() {
        if(instance == null) {
            try {
                instance = new InputProperties();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
