package com.example.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class PostLogger {
    private String filePath;

    public PostLogger(String path){
        this.filePath = path;
        File logFile = new File(path);
        try {
            if (logFile.createNewFile()) {
                System.out.println("Log file created: " + logFile.getName());
            } else {
                System.out.println("Log file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String line){
        Path p = Paths.get(filePath);
        String s = System.lineSeparator() + line;
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p,
                StandardOpenOption.APPEND))) {
            out.write(s.getBytes());
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public String readHistory(){
        String content = null;
        try {
            content = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(content);
        return content;
    }

}
