package com.hadassa;

/**
 * this program work like web proxy with four kind of command
 * @author elhanan buff
 * id:342689536
 */

public class Main {
    /**
     * its the main function where we are getting from the user many request until get the command "q"
     * @param args empty
     */
    public static void main(String[] args) {
        Input theCommand = new Input();
        while(true) {
            try {
                theCommand.settingString();
                Command command = theCommand.checkValid();
                System.out.println(command.checkTheValidityCommand());
            }
            catch (MyExitExeption e) {
                break;
            }
            catch (MyExeption e) {
                e.printMessage();
            }
        }
    }
}
