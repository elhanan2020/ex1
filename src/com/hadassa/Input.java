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
    public Input(){};

    /**
     * this function is responsible to get from the user his request to split it and to call to the function to check his validity
     * @throws Exception if is not a valid command or if the syntax is worst
     */
    public void settingString()throws Exception {
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
    public static Command  checkValid() throws Exception{
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

        throw new MyExeption("invallid command");
    }

    /**
     *  this function checks if for the command "w" and "l" I received no more or less 3 arguments and for the command "i" I only received 2 arguments. in the same way it checks if I received the command "q" then it throws an exception to terminate the program.
     *  so if it checks if the command is written in uppercase then it will throw an "invalid command" exception
     * @throws Exception if the command is invalid
     */
  /*  private void validatorCommand() throws Exception{
        if (Character.isUpperCase(my_input[0].charAt(0)) || my_input[0].length() > 1)
            throw new Exception("invallid command");

        if ((!(my_input.length == 3)&&(my_input[0].charAt(0)=='w'||my_input[0].charAt(0)=='l'||my_input[0].charAt(0)=='t'))||(!(my_input.length == 2)&&(my_input[0].charAt(0)=='i')))
            throw new IllegalArgumentException("false");

    }
*/

}
