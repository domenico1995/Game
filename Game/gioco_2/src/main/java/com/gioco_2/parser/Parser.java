
package com.gioco_2.parser;

import com.gioco_2.type.Command;
import java.util.List;

public class Parser {

    private int checkForCommand(String token, List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().equals(token) || commands.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    public ParserOutput parse(String command, List<Command> commands) {
        String cmd = command.toLowerCase().trim();
        String[] tokens = cmd.split("\\s+");
        if (tokens.length > 0) {
            int ic = checkForCommand(tokens[0], commands);
            if (ic > -1) {
                return new ParserOutput(commands.get(ic));
            } else {
                return new ParserOutput(null);
            }
        } else {
            return null;
        }
    }

}
