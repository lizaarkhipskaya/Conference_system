package controller.command;


import model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);
    public Command getCommand(HttpServletRequest request){
        Command command = new DefaultCommand();
        String commandName = request.getRequestURI().replaceAll(".*/app*.", "");
        System.out.println("command name"+commandName);
        try {
            command = CommandEnum.valueOf(commandName.toUpperCase()).getCommand();
        }catch (IllegalArgumentException e){
            LOGGER.warn("User"+((User)request.getAttribute("user")).toString()+"tried to execute not supported command",e);
        }

        return command;
    }
}
