package seedu.duke;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

        messageLabel.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        setAlignment(Pos.TOP_RIGHT);

        getChildren().addAll(messageLabel, displayPicture);
    }

    /**
     * Repositions the avatar to the left of the message.
     */
    private void flip() {
        ObservableList<Node> children = FXCollections.observableArrayList(getChildren());
        Collections.reverse(children);
        getChildren().setAll(children);
        setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Creates a right-aligned dialog box for a user message.
     *
     * @param text message to display.
     * @param image avatar to display alongside the message.
     * @return a dialog box for the user.
     */
    public static DialogBox getUserDialog(String text, Image image) {
        return new DialogBox(text, image);
    }

    /**
     * Creates a left-aligned dialog box for a Duke message.
     *
     * @param text message to display.
     * @param image avatar to display alongside the message.
     * @return a dialog box for Duke.
     */
    public static DialogBox getDukeDialog(String text, Image image) {
        DialogBox dialogBox = new DialogBox(text, image);
        dialogBox.flip();
        return dialogBox;
    }
}
