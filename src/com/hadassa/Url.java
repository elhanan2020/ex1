package com.hadassa;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;
import java.net.*;
import java.io.*;

public class Url {
    private  final String addresse;
    private  final String tipe;
    private  Elements imageElement;
    private  String stringWord;

    /**
     * our constructor
     * @param type the type of the actually command
     * @param addresses  the url tho the actually request that i want to check
     */
    public  Url(String type,String addresses) {
        addresse = addresses;
        tipe = type;
    }

    /**
     * this function open connection with url and return a ype of this url
     * @return the content type of the given url
     * @throws MyExeption in case of troubles to open connection to this url
     */
    public String readUrl()throws MyExeption {
        try {
            URL urlAdress = new URL(addresse);
            URLConnection connection = urlAdress.openConnection();
            String content = connection.getContentType();
            if(content == null)
                throw new MyExeption("error",true);
            return content;
        }
        catch (MalformedURLException e){
            throw new MyExeption("bad url",true);
        }
        catch (IOException e){
            throw new MyExeption("error with the url",true);
        }
    }

    /**
     * this function use jsoup to open connection with url and for "i" command
     * extract all img tag and for "w" and "l" extract all text
     * @throws  MyExeption if the url is not valid
     */
    private void isInto()throws MyExeption {
        try {
            Document document = Jsoup.connect(addresse).get();
            if(tipe.equals("i")){
                imageElement = document.select("img");
            }
            if(tipe.equals("w")||tipe.equals("l"))
                stringWord = document.text();

        } catch (IllegalArgumentException e) {
           throw new MyExeption("bad url",true);
        }
        catch (IOException ex) {
            throw new MyExeption("error",true);
        }

    }


    /**
     *  this function call to the "isInto" function to extract the html text and return it
     * @return string of all text in the html page
     * @throws MyExeption if the url is not correct
     */
    public String getHtmlString()throws MyExeption{
        isInto();
        return stringWord.toLowerCase();
    }

    /**
     *this function call to the "isInto" function to get all image tag of  the html code and return it
     * @return all tag element of kind "image" of the html page
     * @throws MyExeption if the url is not vallid
     */
    public Elements getImage()throws MyExeption{
        isInto();
        return imageElement;
    }
}
