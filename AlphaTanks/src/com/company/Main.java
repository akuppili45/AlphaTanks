package com.company;
import javax.swing.*;
public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(1500,1000);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new Game());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
