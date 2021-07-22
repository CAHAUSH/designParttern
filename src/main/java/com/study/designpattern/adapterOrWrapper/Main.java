package com.study.designpattern.adapterOrWrapper;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\实现每天自动需管平台签出.txt");
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String line = bufferedReader.readLine();
        while (line!=null && !line.equals("")){
            System.out.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
