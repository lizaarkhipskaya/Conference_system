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
    },
    CONFERENCE_INFO{
        {
            this.command = new ConferenceInfoCommand();
        }
    },
    CONFERENCE_LIST{
        {
            this.command = new GetConferenceList();
        }
    },
    MAIN_PAGE{
        {
            this.command = new GetMainPageCommand();
        }
    },
    ADD_SPEECH{
        {
            this.command = new AddSpeechCommand();
        }
    },
    SPEAKER_LIST{
        {
            this.command = new GetSpeakerListCommand();
        }
    },
    CHANGE_LANGUAGE{
        {
            this.command = new ChangeLanguageCommand();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }
}