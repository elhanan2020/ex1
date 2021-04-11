package com.hadassa;

/**
 *
 */
public class Type implements Command{
    private final String commande;
    private final String urls;
    private final String content;
    public Type(String commandline)throws MyExeption{
        String[] command =validatorCommand(commandline.split(" "));
        commande = command[0];
        urls = command[1];
        content= command[2];
}

    /**
     * this function get from the  url instance his content type and check if the contain type of
     * the user match with the contain type of the  given url
     * @throws MyExeption if is contained
     */

    public  boolean checkTheValidityCommand()throws  MyExeption{
        Url url = new Url(commande,urls);
        return url.readUrl().startsWith(content);
    }
    private String[] validatorCommand(String[] command)throws MyExeption{
        if( command[0].length() > 1 )
            throw new MyExeption("invalid command",true);
        if (!(command.length == 3))
            throw new MyExeption("false",false);
        return command;
    }
}
