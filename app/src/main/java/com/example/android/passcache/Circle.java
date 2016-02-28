package com.example.android.passcache;

import java.util.Random;

/**
 * Created by kylewang on 2016-02-28.
 */
public class Circle {

    String title = "";
    String username = "";
    String password = "";
    int[] colorRGB = {0,0,0};

    /**
     * Constructor
     * @param username
     * @param password
     */
    public Circle(String title, String username, String password){
        this.title = title;
        this.username = username;
        this.password = password;
    }

    /**
     * Getter for title
     * @return
     */
    public String getTitle(){
        return title;
    }

    /**
     * Setter for title
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Getter for username
     * @return
     */
    public String getUsername(){
        return username;
    }

    /**
     * Setter for username
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Getter for password
     * @return
     */
    public String getPassword(){
        return password;
    }

    /**
     * Setter for password
     * @return
     */
    public void setPassword(){
        this.password = password;
    }

    /**
     * Create random color for the circle and retrieve the color RGB as int[]
     * @param
     */
    public int[] randomizeColor(){
        Random random = new Random();
        colorRGB[0] = random.nextInt(256);
        colorRGB[1] = random.nextInt(256);
        colorRGB[2] = random.nextInt(256);
        return colorRGB;
    }

    public static void main(String[] args){
        Circle circle = new Circle("Gmail", "abd", "123");
        circle.randomizeColor();
        System.out.println(circle.colorRGB[0]);
        System.out.println(circle.colorRGB[1]);
        System.out.println(circle.colorRGB[2]);
    }

}
