package controller.command;

import controller.manager.PathManager;
import model.entity.User;
import model.exeption.ReRegisterOnConferenceExeption;
import model.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class RegistrationOnConferenceCommandTest {
    private RegistrationOnConferenceCommand registrationOnConferenceCommand;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        registrationOnConferenceCommand = new RegistrationOnConferenceCommand();
    }
    @Test
    public void execute() throws ReRegisterOnConferenceExeption {
        when(request.getParameter("id")).thenReturn(""+6);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(new User.Builder()
                                                                    .setId(16).build());
        String resultString = registrationOnConferenceCommand.execute(request);
        assertEquals(PathManager.getProperty("conference_info_with_id")+6,resultString);
    }
}