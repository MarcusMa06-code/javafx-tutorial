package seedu.duke;

/**
 * Represents the Duke chatbot's application logic.
 */
public class Duke {

    /**
     * Returns Duke's response to a user message.
     *
     * @param input message received from the user.
     * @return Duke's reply to the message.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }
}
