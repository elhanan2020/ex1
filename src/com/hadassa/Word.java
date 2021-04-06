
package com.hadassa;


/**
 * the role of this class is to get many word from a file and to check
 * if  the html page contain all of them
 */

 public class Word implements Command{
    /**
     * boolean members
     */
    private boolean contain = true;
    String entierString;
    private final String commande;
    private final String urls;
    private final String content;
    /**
     * the word constructor
     *
     * @param commandline from what check it
     */
     public Word(String commandline)throws Exception{
         entierString = commandline;
         String[] command =validatorCommand(commandline.split(" "));
         commande = command[0];
         urls = command[1];
         content= command[2];
    }

    /**
     * its function that check if all given word is in a given html page
     * @throws Exception if all word of the file are in the text of the html page
     */
    public  boolean checkTheValidityCommand()throws  Exception{
        Type types = new Type(entierString);
        types.checkTheValidityCommand();
        Url url = new Url(commande,urls);
        checkTheUrl(url);
        if(contain)
            return true;
        return false;
    }
    /**
     *
     * @param url the url to check
     * @throws Exception if all word of the file are in the text of the html page
     */
    private void checkTheUrl(Url url)throws Exception{
        FileOfWords words = new FileOfWords(content);
        String htmlword = url.getHtmlString();
        String fileword[] = words.GetTheWord();
        for (int i = 0; i < fileword.length ; i++)
            if(!htmlword.contains(fileword[i])) {
                contain = false;
                break;
            }
    }

    private String[] validatorCommand(String[] command)throws IllegalArgumentException ,MyExeption{
        if(command[0].length() > 1 )
            throw new MyExeption("invallid command");
        if (!(command.length == 3))
            throw new IllegalArgumentException("false");
        return command;
    }
}

