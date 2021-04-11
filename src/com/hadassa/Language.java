package com.hadassa;

/**
 * the role of this class is to check trow a algorithm to define
 * if a  html page given is in english or no
 */
public class Language implements Command{
    private final String commande;
    private final String urls;
    private final double[] alphabet = new double[26];
    private double totalnum = 0;
    private double variance=0;
    public Language(String commandline)throws  MyExeption{
        String[] command =validatorCommand(commandline.split(" "));
        commande = command[0];
        urls = command[1];
        if (!command[2].equals("english"))
            throw new MyExeption("false",false);
    }

    /**
     *this function call to algo function and alphabetic sorting function that calculate the variance
     *  of all letter if it s smaller that 0.004 its men that the page is in english
     * @throws MyExeption to mean that the result of the command is true
     */
    public  boolean checkTheValidityCommand()throws  MyExeption{
        double[] var = {0.0748,0.0134,0.0411,0.0308,0.1282,0.0240,0.0185,0.0414,0.0725,0.0014,0.0053,0.0403,0.0340,
                0.0673,0.0785,0.0314,0.0010,0.0609,0.0614,0.1002,0.0316,0.0108,0.0131,0.0044,0.0127,0.0011};
        Url url = new Url(commande,urls);
        String Webpage = url.getHtmlString().toLowerCase();

        sortAlphLetter(Webpage);

        algoEnglish(var);

        return variance <= 0.004;
    }

    /**
     * function that calculate the variance of the letter of this html page
     * @param var the frequency of all letter in english language
     */
    private void algoEnglish(double[] var){
        for (int i = 0; i < alphabet.length; i++) {
            double varX = alphabet[i] / totalnum;
            variance += Math.pow(var[i]- varX,2);
           }
    }

    /**
     * function that count how  many times each letter appears
     * @param Webpage string of all word of the html page
     *                Character.isLetter(Webpage.charAt(i))
     */
    private void sortAlphLetter(String Webpage){
        for (int i = 0; i <Webpage.length() ; i++) {

            if(Webpage.charAt(i) >= 'a' && Webpage.charAt(i) <= 'z' )
            {
                alphabet[((int)Webpage.charAt(i))-97]++;
                totalnum++;
            }
        }
    }

    private String[] validatorCommand(String[] command)throws MyExeption{
        if( command[0].length() > 1 )
            throw new MyExeption("invalid command",true);
        if (!(command.length == 3))
            throw new MyExeption("false",false);
        return command;
    }
}
