package com.hadassa;

import java.util.Scanner;

/**
 * This class is responsible to get a command from the user and to check his validity
 */
public class Input {

    private static String my_input[];
    private static char command ;

    /**
     * this contractor dont initialize anythink
     */
    public Input(){};

    /**
     * this function is responsible to get from the user his request to split it and to call to the function to check his validity
     * @throws Exception if is not a valid command or if the syntax is worst
     */
    public void settingString()throws Exception {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter  a command");
        my_input = myObj.nextLine().split(" ");
        validatorCommand();
        command = my_input[0].charAt(0);
    }

    /**
     * this function check the type member and factory for all valid type his own class By transferring the three argument(type ,url ,content type)  to the constructor
     * @return the suitable class
     * @throws MyExeption if the Type is not allowed
     */
    public static Command checkValid() throws MyExeption {
        if (command=='l') {
            return new Language(my_input[0],my_input[1],my_input[2]);
        }
        if (command=='i') {
            return new Image(my_input[0],my_input[1]);
        }

        if (command =='w')
            return new Word(my_input[0],my_input[1],my_input[2]);

        if (command =='t')
            return new Type(my_input[0],my_input[1],my_input[2]);

        throw new MyExeption();
    }

    /**
     *  this function checks if for the command "w" and "l" I received no more or less 3 arguments and for the command "i" I only received 2 arguments. in the same way it checks if I received the command "q" then it throws an exception to terminate the program.
     *  so if it checks if the command is written in uppercase then it will throw an "invalid command" exception
     * @throws Exception if the command is invalid
     */
    private void validatorCommand() throws Exception{
        if (Character.isUpperCase(my_input[0].charAt(0)) || my_input[0].length() > 1)
            throw new Exception("invallid command");

        if ((!(my_input.length == 3)&&(my_input[0].charAt(0)=='w'||my_input[0].charAt(0)=='l'||my_input[0].charAt(0)=='t'))||(!(my_input.length == 2)&&(my_input[0].charAt(0)=='i')))
            throw new IllegalArgumentException("false");
        if(my_input[0].charAt(0)=='q')
            throw new MyExitExeption();
    }


}
