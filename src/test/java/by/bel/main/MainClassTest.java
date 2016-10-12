package by.bel.main;

import by.bel.main.command.CommandResolver;
import by.bel.main.command.MyCommands;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Barys_Shliaha on 12-Oct-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainClassTest {

    @Autowired
    private CommandResolver commandResolver;

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyList() {
        new ArrayList<>().get(0);
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testUnknownCommand() throws Exception {
        Assert.notNull(commandResolver);
        String action = "UNKNOWN-COMMAND";
        MyCommands commands = commandResolver.getCommand(action);
    }

    @Test
    public void testDOCommand() throws Exception {
        Assert.notNull(commandResolver);
        String action = "DO";
        MyCommands commands = commandResolver.getCommand(action);
        Map<String, Object> actualModel = commands.doCommand(new MockHttpServletRequest(), new MockHttpServletResponse());
        Assert.notNull(actualModel.get("messages"));
        Assert.isTrue(((String) actualModel.get("messages")).contains("DO"));
    }

    @Test
    public void testSTARTCommand() throws Exception {
        Assert.notNull(commandResolver);
        String action = "START";
        MyCommands commands = commandResolver.getCommand(action);
        Map<String, Object> actualModel = commands.doCommand(new MockHttpServletRequest(), new MockHttpServletResponse());
        Assert.notNull(actualModel.get("messages"));
        Assert.isTrue(((String) actualModel.get("messages")).contains("START"));
        Assert.doesNotContain((String) actualModel.get("messages"), "DO");
    }

    @Test
    public void testENDCommand() throws Exception {
        Assert.notNull(commandResolver);
        String action = "END";
        MyCommands commands = commandResolver.getCommand(action);
        Map<String, Object> actualModel = commands.doCommand(new MockHttpServletRequest(), new MockHttpServletResponse());
        Assert.notNull(actualModel.get("messages"));
        Assert.isTrue(((String) actualModel.get("messages")).contains("END"));
        Assert.doesNotContain((String) actualModel.get("messages"), "START");
        Assert.doesNotContain((String) actualModel.get("messages"), "DO");
    }

}