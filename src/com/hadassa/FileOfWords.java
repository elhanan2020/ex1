package com.hadassa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
     * @throws MyExeption if appen error when open the file
     */
    public String[] GetTheWord() throws  MyExeption{
        String[] Myword ;
        try {
            extractWords();
        }
        catch (MyExeption e){
            throw new MyExeption("error",true);
        }
        catch (FileNotFoundException e){
            throw  new MyExeption("error dont found the file",true);
        }
        Myword = lines.split(" ");
        return Myword;
    }

    /**
     * this function extract from a file all word there are into and convert them to a lower case
     * @throws MyExeption if happen error when open the file
     */
    private void extractWords()throws  MyExeption ,FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(File));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                lines += line + " ";
            }
            lines =lines.toLowerCase();
        }
         catch (IOException ioe) {
             throw new MyExeption("error",true);
        }
        finally
         {
            try {
                reader.close();
            }catch (IOException e){
                System.err.println("error of closing file");
            }
        }

    }

    /**
     *this function check if in the file there is a word
     * @return return true if the file is empty else return false
     */
    public boolean isEmpty(){
        return lines.isEmpty();
    }
}
