package com.exam.supermarket.config.configuration;

import com.exam.supermarket.exception.ConfigLoadException;
import lombok.Data;

import java.io.IOException;
import java.util.Properties;

@Data
public class AppConfig {

    private static AppConfig instance;

    private boolean debug;

    private static final String APP_CONFIG_PATH = "./application.properties";

    private AppConfig() {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(APP_CONFIG_PATH));
        } catch (IOException e) {
//            throw new ConfigLoadException("配置文件未找到");
            throw new ConfigLoadException("Configuration file not found");
        }
        this.debug = Boolean.parseBoolean(properties.getProperty("app.debug"));
    }

    public static synchronized AppConfig getConfig() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
}
