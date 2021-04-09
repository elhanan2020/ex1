package com.hadassa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class work on the file that i interested to extract from it a list of word
 */
public class FileOfWords {
    public String File ;
    public String lines ;
    public FileOfWords(String file){
        File = file;
        lines = "";
    }

    /**
     * this function return all word of the file
     * @return a array of string that contain all word
     * @throws Exception if appen error when open the file
     */
    public String[] GetTheWord() throws  Exception{
        String Myword[] ;
        extractWords();
        Myword = lines.split(" ");
        return Myword;
    }

    /**
     * this function extract from a file all word there are into and convert them to a lower case
     * @throws Exception if happen error when open the file
     */
    private void extractWords()throws  Exception {
        BufferedReader reader = new BufferedReader(new FileReader(File));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                lines += line + " ";
            }
            lines =lines.toLowerCase();
        }
        catch (IOException ioe) {
            System.out.println("error");
            throw new IOException();
        }finally {
            try {
                reader.close();
            }catch (IOException e){
                throw new IOException();
            }
        }

    }

    /**
     *this function check if in the file there is a word
     * @return return true if the file is empty else return false
     */
    public boolean isEmpty(){
        if(lines.isEmpty())
            return true;
        return false;
    }
}
