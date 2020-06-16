package com.example.navigater.model;

import java.util.ArrayList;
import java.util.List;

public class Program {

    ArrayList<String> pro_content;


    public ArrayList<String> getPro_content() {
        return pro_content;
    }

    public void setPro_content(String content) {
        pro_content.add(content);
    }

    public Program(ArrayList<String> pro_content) {
        this.pro_content = pro_content;
    }

    public Program() {
    }
}