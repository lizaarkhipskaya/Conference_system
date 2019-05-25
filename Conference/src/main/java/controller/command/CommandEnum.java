package controller.command;

public enum CommandEnum {
    DEFAULT {
        {
            this.command = new DefaultCommand();
        }
    },
    MAP{
        {
            this.command = new MapCommand();
        }
    },
    SIGN_IN{
        {
            this.command = new SignInCommand();
        }
    },
    SIGN_UP{
        {
            this.command = new SignUpCommand();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }
}