package seedu.duke;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image image) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load the dialog box view.", exception);
        }

        dialog.setText(text);
        displayPicture.setImage(image);
    }

    /**
     * Repositions the avatar to the left of the message.
     */
    private void flip() {
        ObservableList<Node> children = FXCollections.observableArrayList(getChildren());
        Collections.reverse(children);
        getChildren().setAll(children);
        setAlignment(Pos.TOP_LEFT);
        dialog.getStyleClass().add("reply-label");
    }

    /**
     * Adds a command-specific style class to Duke's response bubble.
     *
     * @param commandType command family returned by Duke.
     */
    private void changeDialogStyle(String commandType) {
        switch (commandType) {
        case "AddCommand":
            dialog.getStyleClass().add("add-label");
            break;
        case "ChangeMarkCommand":
            dialog.getStyleClass().add("marked-label");
            break;
        case "DeleteCommand":
            dialog.getStyleClass().add("delete-label");
            break;
        default:
            break;
        }
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
        return getDukeDialog(text, image, "");
    }

    /**
     * Creates a left-aligned dialog box for a Duke message and styles it by command type.
     *
     * @param text message to display.
     * @param image avatar to display alongside the message.
     * @param commandType command family used to style the response.
     * @return a styled dialog box for Duke.
     */
    public static DialogBox getDukeDialog(String text, Image image, String commandType) {
        DialogBox dialogBox = new DialogBox(text, image);
        dialogBox.flip();
        dialogBox.changeDialogStyle(commandType);
        return dialogBox;
    }
}
