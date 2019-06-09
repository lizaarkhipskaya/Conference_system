package controller.command;

import com.sun.webkit.WebPage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class SignOutCommandTest {
    private SignOutCommand signOutCommand;

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    @Before public void setUp(){
        MockitoAnnotations.initMocks(this);
        signOutCommand = new SignOutCommand();
    }
    @Test
    public void execute() {

        when(request.getSession()).thenReturn(session);

        String resultPage = signOutCommand.execute(request);
        assertEquals("redirect:/index.jsp",resultPage);
    }
}