package com.hadassa;

import org.jsoup.select.Elements;

public class Image implements Command{
    private final String commande;
    private final String urls;
    public Image(String commandline)throws Exception{
        String[] command =validatorCommand(commandline.split(" "));
        commande = command[0];
        urls = command[1];
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public boolean checkTheValidityCommand()throws  Exception{
        Url url = new Url(commande,urls);
        Elements elmImg= url.getImage();
        if(!elmImg.isEmpty())
            return true;
        return false;
    }
    private String[] validatorCommand(String[] command)throws IllegalArgumentException ,MyExeption{
        if(command[0].length() > 1 )
            throw new MyExeption("invallid command");
        if (!(command.length == 2))
            throw new IllegalArgumentException("false");
        return command;
    }
}
