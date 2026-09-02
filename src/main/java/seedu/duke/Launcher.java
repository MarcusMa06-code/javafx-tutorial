package seedu.duke;

import javafx.application.Application;

/**
 * Launches the JavaFX application to avoid JavaFX classpath issues.
 */
public class Launcher {

    /**
     * Launches the graphical Duke application.
     *
     * @param args command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
