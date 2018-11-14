package com.ak98neon.configure;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class AnnotationConfig {
    public static ApplicationContext getAnnotationConfig() {
        return new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}