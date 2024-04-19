package edu.wgu.d387_sample_code.il8n;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WelcomeMessage {

    static ExecutorService messageExecutor = Executors.newFixedThreadPool(2);
    static String welcomeMessage = "";

    public static void main(String[] args) {
        String welcomeMessage = getWelcomeMessage();
        System.out.println(welcomeMessage);
    }

    public static String getWelcomeMessage() {
        Properties properties = new Properties();
        welcomeMessage = "";
        messageExecutor.execute(() -> {
            try {
                InputStream streamFrench = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                properties.load(streamFrench);
                welcomeMessage = welcomeMessage + properties.getProperty("welcome");
                // System.out.println(properties.getProperty("welcome"));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(() -> {
            try {
                InputStream streamEnglish = new ClassPathResource("welcome_en_US.properties").getInputStream();
                properties.load(streamEnglish);
                welcomeMessage = welcomeMessage + properties.getProperty("welcome");
                // System.out.println(properties.getProperty("welcome"));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        try {
            Thread.sleep(1000) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // return properties.getProperty("welcome");
        return welcomeMessage;
    }
}
