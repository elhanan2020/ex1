package com.hadassa;

/**
 * this exception class is a own exception that i used to concentrate
 * all exception that i catch over the program and get from then the message i want to print
 */
public class MyExeption extends Exception {

    private final String mymess;
    private final boolean kindMess;
    public MyExeption(String err,boolean kind) {
        mymess = err;
        kindMess = kind;
    }

    /**
     * this method print to the console
     * the message i want to chow and in witch color to show it in normal color or in  red color like the standard error
     */
    public void printMessage(){
        if(kindMess)
            System.err.println(mymess);
        else
            System.out.println(mymess);
    }
}
