package com.hadassa;

/**
 * This class is an abstract class who is the base of all subclass like "word","language","image","type"
 */
public  interface Command {

     public abstract boolean checkTheValidityCommand()throws  Exception;
}
