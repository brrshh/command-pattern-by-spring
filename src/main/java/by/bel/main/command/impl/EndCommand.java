package by.bel.main.command.impl;

import by.bel.main.command.MyCommands;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Barys_Shliaha on 12-Oct-16.
 */
@Component("END")
public class EndCommand implements MyCommands {
    @Override
    public Map<String, Object> doCommand(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("messages", " END Command");
        return model;
    }
}
