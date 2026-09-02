package seedu.duke;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a dialog box containing a message and its speaker's avatar.
 */
public class DialogBox extends HBox {

    /**
     * Creates a dialog box with the specified message and avatar.
     *
     * @param text message to display.
     * @param image avatar to display alongside the message.
     */
    public DialogBox(String text, Image image) {
        Label messageLabel = new Label(text);
        ImageView displayPicture = new ImageView(image);
        getChildren().addAll(messageLabel, displayPicture);
    }
}
