package controller.command;


import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public Command getCommand(HttpServletRequest request){
        Command command = new DefaultCommand();
        String commandName = request.getRequestURI().replaceAll(".*/guest*.|.*/admin*.|.*/speaker*.|.*/user*.|", "");
        System.out.println(commandName);
        try {
            command = CommandEnum.valueOf(commandName.toUpperCase()).getCommand();
        }catch (IllegalArgumentException e){
            //log
        }

        return command;
    }
}
