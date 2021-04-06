package com.hadassa;

/**
 *
 */
public class Type implements Command{
    private final String command;
    private final String urls;
    private final String content;
    public Type(String command1,String url1,String content1){
        command =command1;
        urls = url1;
        content= content1;
}

    /**
     * this function get from the  url instance his content type and check if the contain type of
     * the user match with the contain type of the  given url
     * @throws Exception if is contained
     */

    public  boolean checkTheValidityCommand()throws  Exception{
        Url url = new Url(command,urls);
        if (url.readUrl().contains(content))
            return true;
        return false;
    }
}
