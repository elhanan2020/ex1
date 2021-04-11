package com.hadassa;

import org.jsoup.select.Elements;

public class Image implements Command{
    private final String commande;
    private final String urls;
    public Image(String commandline)throws MyExeption{
        String[] command =validatorCommand(commandline.split(" "));
        commande = command[0];
        urls = command[1];
    }

    /**
     *
     * @return EGSDFGRS
     * @throws MyExeption BXFB
     */
    public boolean checkTheValidityCommand()throws  MyExeption{
        Url url = new Url(commande,urls);
        Elements elmImg= url.getImage();
        return !elmImg.isEmpty();
    }

    private String[] validatorCommand(String[] command)throws MyExeption{
        if(command[0].length() > 1 )
            throw new MyExeption("invalid command",true);
        if (!(command.length == 2))
            throw new MyExeption("false",false);
        return command;
    }
}
