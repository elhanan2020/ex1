package com.hadassa;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * this program work like web proxy with four kind of command
 * @author elhanan buff
 * id:342689536
 */

public class Main {
    /**
     * its the main function where we are getting from the user many request until get the command "q"
     * @param args
     */
    public static void main(String[] args) {
        Input theCommand = new Input();
        boolean Exit = false;
        while(!Exit) {
            try {
                theCommand.settingString();
                Command command = theCommand.checkValid();
                System.out.println(command.checkTheValidityCommand());
            }
            catch (MyExitExeption e) {
                Exit = true;
            }
            catch (MalformedURLException e) {
                System.err.println("bad url");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (IOException e) {
                System.err.println("error");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
