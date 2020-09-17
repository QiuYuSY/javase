package com.xsr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int time = 1;
        String input = s.nextLine();

        while(s.nextLine().equals(input)){
            time++;
        }
        if(time > 2){
            System.out.println(time-2);
            return;
        }
        System.out.println("oJ Group Great Again!");

    }
}