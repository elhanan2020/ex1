package com.hadassa;

import java.util.Scanner;

/**
 * This class is responsible to get a command from the user and to check his validity
 */
public class Input {

    private static String myInput;
    private static String[] command ;

    /**
     * this contractor dont initialize anythink
     */
    public Input(){}

    /**
     * this function is responsible to get from the user his request to split it and to call to the function to check his validity
     */
    public void settingString(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter  a command");
        myInput = myObj.nextLine();
        command = myInput.split(" ");
    }

    /**
     * this function check the type member and factory for all valid type his own class By transferring the three argument(type ,url ,content type)  to the constructor
     * @return the suitable class
     * @throws MyExeption if the Type is not allowed
     */
    public static Command  checkValid() throws MyExeption{
        if (command[0].equals("l") ) {
            return new Language(myInput);
        }
        if (command[0].equals("i")) {
            return new Image(myInput);
        }
        if (command[0].equals("w"))
            return new Word(myInput);

        if (command[0].equals("t"))
            return new Type(myInput);

        if(command[0].equals("q"))
            return new Quit(myInput);

        throw new MyExeption("invalid command",true);
    }


}
