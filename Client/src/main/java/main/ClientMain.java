package main;

import configuration.ClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientMain {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ClientConfiguration.class);
    }

}
