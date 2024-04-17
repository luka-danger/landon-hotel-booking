package edu.wgu.d387_sample_code.il8n;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;

public class WelcomeMessage {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
            properties.load(stream);
            System.out.println(properties.getProperty("welcome"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
