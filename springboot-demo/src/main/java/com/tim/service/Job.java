package com.tim.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class Job {
    @Value("classpath:apk.yml")
    private Resource resource1;
    private Resource classPathResource = new ClassPathResource("app.yml");

    @Scheduled(cron = "0/10 * * * * ? ")
    public void execute() throws IOException {
        InputStream in = resource1.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuffer detail = new StringBuffer();
        String s;
        while ((s = reader.readLine()) != null) {
            detail.append(s);
        }
        System.out.println("path = " +  resource1.getURL().getPath());
        System.out.println("resource = " + detail.toString());
        in.close();
        reader.close();
    }
}
