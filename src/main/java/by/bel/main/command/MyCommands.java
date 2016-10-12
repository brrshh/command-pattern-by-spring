package by.bel.main.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Barys_Shliaha on 12-Oct-16.
 */
public interface MyCommands {

    Map<String, Object> doCommand(HttpServletRequest req, HttpServletResponse resp);
}
