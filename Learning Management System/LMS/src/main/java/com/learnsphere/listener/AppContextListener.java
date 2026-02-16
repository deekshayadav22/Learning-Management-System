package com.learnsphere.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("LearnSphere application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("LearnSphere application stopped");
    }
}
