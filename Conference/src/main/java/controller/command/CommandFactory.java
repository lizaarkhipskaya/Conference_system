package controller.command;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static Logger logger = LogManager.getLogger(CommandFactory.class);
    public Command getCommand(HttpServletRequest request){
        Command command = new DefaultCommand();
        String commandName = request.getRequestURI().replaceAll(".*/app*.", "");
        System.out.println("command name"+commandName);
        try {
            command = CommandEnum.valueOf(commandName.toUpperCase()).getCommand();
        }catch (IllegalArgumentException e){
            logger.error(e);
        }

        return command;
    }
}
