package com.hadassa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOfWords {
    public String File ;
    public String lines ;
    public FileOfWords(String file){
        File = file;
        lines = "";
    }

    public String[] GetTheWord() throws  Exception{
        String Myword[] = {""};
        extractWords();
        Myword = lines.split(" ");
        return Myword;
    }

    private void extractWords()throws  Exception {
        BufferedReader reader = new BufferedReader(new FileReader(File));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                lines += line + " ";
            }
            if(lines.isEmpty())
                throw  new MyExeption();
            lines = lines.toLowerCase();
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
}
