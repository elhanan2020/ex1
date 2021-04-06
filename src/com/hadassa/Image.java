package com.hadassa;

import org.jsoup.select.Elements;

public class Image implements Command{
    private final String command;
    private final String urls;
    public Image(String command1,String url1){
        command =command1;
        urls = url1;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public boolean checkTheValidityCommand()throws  Exception{
        Url url = new Url(command,urls);
        Elements elmImg= url.getImage();
        if(!elmImg.isEmpty())
            return true;
        return false;
    }
}
