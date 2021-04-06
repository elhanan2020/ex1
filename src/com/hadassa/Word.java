
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
    private final String command;
    private final String urls;
    private final String content;
    /**
     * the word constructor
     * @param command1 type of command
     * @param url1 url to check
     * @param content1 from what check it
     */
     public Word(String command1,String url1,String content1){
         command =command1;
         urls = url1;
         content= content1;
    }

    /**
     * its function that check if all given word is in a given html page
     * @throws Exception if all word of the file are in the text of the html page
     */
    public  boolean checkTheValidityCommand()throws  Exception{
        Type types = new Type(command,urls,content);
        types.checkTheValidityCommand();

        Url url = new Url(command,urls);
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
}

