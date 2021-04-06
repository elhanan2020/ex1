package com.hadassa;

public class quit implements Command {
    public quit(String commandline)throws MyExeption{
        validatorCommand(commandline.split(" "));
    };
    public void validatorCommand (String[] command)throws MyExeption{
        if(command[0].length() > 1 && command.length > 1 )
            throw new MyExeption ("invallid command");

    }
    public boolean checkTheValidityCommand()throws MyExitExeption{
        throw new MyExitExeption();
    }
}
