package seedu.duke;

/**
 * Represents the Duke chatbot's application logic.
 */
public class Duke {

    private static final String ADD_COMMAND = "AddCommand";
    private static final String MARK_COMMAND = "ChangeMarkCommand";
    private static final String DELETE_COMMAND = "DeleteCommand";

    private String commandType = "";

    /**
     * Returns Duke's response to a user message.
     *
     * @param input message received from the user.
     * @return Duke's reply to the message.
     */
    public String getResponse(String input) {
        commandType = identifyCommandType(input);
        return "Duke heard: " + input;
    }

    /**
     * Returns the type of the most recently received command.
     *
     * @return command type used to style Duke's latest response.
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * Identifies the command family from the first word of the input.
     *
     * @param input message received from the user.
     * @return command family name used by the dialog stylesheet.
     */
    private String identifyCommandType(String input) {
        String normalizedInput = input.trim().toLowerCase();
        if (normalizedInput.startsWith("todo ")
                || normalizedInput.startsWith("deadline ")
                || normalizedInput.startsWith("event ")) {
            return ADD_COMMAND;
        }
        if (normalizedInput.startsWith("mark ")
                || normalizedInput.startsWith("unmark ")) {
            return MARK_COMMAND;
        }
        if (normalizedInput.startsWith("delete ")) {
            return DELETE_COMMAND;
        }
        return "";
    }
}
