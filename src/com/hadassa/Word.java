
package com.hadassa;


/**
 * the role of this class is to get many word from a file and to check
 * if  the html page contain all of them
 */

 public class Word implements Command{
    /**
     * boolean members
     */
    private boolean empty = false ;
    private boolean contain = true;
    private final String entierString;
    private final String commande;
    private final String urls;
    private final String content;

    /**
     * the word constructor
     *
     * @param commandline from what check it
     */
     public Word(String commandline)throws MyExeption{
         entierString = commandline;
         String[] command =validatorCommand(commandline.split(" "));
         commande = command[0];
         urls = command[1];
         content= command[2];
    }

    /**
     * its function that check if all given word is in a given html page
     * @return if all word of the file are in the text of the html page we return true else we return false
     * @throws MyExeption if happen error
     */
    public  boolean checkTheValidityCommand()throws  MyExeption{
        Type types = new Type(entierString);
        types.checkTheValidityCommand();
        Url url = new Url(commande,urls);
        checkTheUrl(url);
        return contain || empty;
    }
    /**
     *
     * @param url the url to check
     * @throws MyExeption if all word of the file are in the text of the html page
     */
    private void checkTheUrl(Url url)throws MyExeption{
        FileOfWords words = new FileOfWords(content);
        String htmlWord = url.getHtmlString();
        String[] fileWord = words.GetTheWord();
        if(words.isEmpty())
            empty = true;
        else
            for (String s : fileWord)
                if (!htmlWord.contains(s)) {
                    contain = false;
                    break;
                }
    }

    private String[] validatorCommand(String[] command)throws MyExeption{
        if(command[0].length() > 1 )
            throw new MyExeption("invalid command",true);
        if (!(command.length == 3))
            throw new MyExeption("false",false);
        return command;
    }
}

