package com.hadassa;

/**
 *
 */
public class Type implements Command{
    private final String commande;
    private final String urls;
    private final String content;
    public Type(String commandline)throws Exception{
        String[] command =validatorCommand(commandline.split(" "));
        commande = command[0];
        urls = command[1];
        content= command[2];
}

    /**
     * this function get from the  url instance his content type and check if the contain type of
     * the user match with the contain type of the  given url
     * @throws Exception if is contained
     */

    public  boolean checkTheValidityCommand()throws  Exception{
        Url url = new Url(commande,urls);
        if (url.readUrl().startsWith(content))
            return true;
        return false;
    }
    private String[] validatorCommand(String[] command)throws IllegalArgumentException ,MyExeption{
        if( command[0].length() > 1 )
            throw new MyExeption("invallid command");
        if (!(command.length == 3))
            throw new IllegalArgumentException("false");
        return command;
    }
}
