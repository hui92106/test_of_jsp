package com.test;

public class aaa {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        Integer c = 0;
        for (a = 1; a < 10; a++) {
            for (b = 1; b <= a; b++) {
                c= a*b;
                if(c<10){
                    System.out.print(b+" * "+a+" = "+c + "  ");
                }else{
                    System.out.print(b+" * "+a+" ="+c + "  ");
                }
            }
            System.out.println("");
        }
    }
}
