package controller.command;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class AddConferenceCommandTest {
    private AddConferenceCommand addConferenceCommand;
    @Before public  void setUp(){
        addConferenceCommand = new AddConferenceCommand();
    }
    @Test
    public void isDateValidate() {
        assertEquals(addConferenceCommand.isDateValidate(Timestamp.valueOf("2019-05-05 22:00:00")),false);
    }
}