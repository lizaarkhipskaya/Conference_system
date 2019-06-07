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
    UP_COMING_CONFERENCES {
        {
            this.command = new GetUpComingConferenceList();
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
    },
    SIGN_OUT{
        {
            this.command = new SignOutCommand();
        }
    },
    REGISTRATION_ON_CONFERENCE{
        {
            this.command = new RegistrationOnConferenceCommand();
        }
    },
    TODAY_CONFERENCES{
        {
            this.command = new GetTodayConferenceList();
        }
    },
    PAST_CONFERENCES{
        {
            this.command = new GetPastConferenceList();
        }
    }
;


    Command command;

    public Command getCommand() {
        return command;
    }
}