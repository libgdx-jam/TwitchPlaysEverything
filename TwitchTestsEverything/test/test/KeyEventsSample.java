package test;
/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * A sample that demonstrates various key events and their usage. Type in the
 * text box to view the triggered events: key pressed, key typed and key 
 * released. Pressing the Shift, Ctrl, and Alt keys also trigger events.
 *
 * @see javafx.scene.input.KeyCode
 * @see javafx.scene.input.KeyEvent
 * @see javafx.event.EventHandler
 */
public class KeyEventsSample extends Application {

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        //create a console for logging key events
        final ListView<String> console = new ListView<String>(FXCollections.<String>observableArrayList());
        // listen on the console items and remove old ones when we get over 10 items
        console.getItems().addListener(new ListChangeListener<String>() {
            @Override public void onChanged(Change<? extends String> change) {
                while (change.next()) {
                    if (change.getList().size() > 20) change.getList().remove(0);
                }
            }
        });
        // create text box for typing in
        final TextField textBox = new TextField();
        textBox.setPromptText("Write here");
        textBox.setStyle("-fx-font-size: 34;");
        //add a key listeners
        textBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                console.getItems().add("Key Pressed: " + ke.getText());
            }
        });
        textBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                console.getItems().add("Key Released: " + ke.getText());
            }
        });
        textBox.setOnKeyTyped(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                String text = "Key Typed: " + ke.getCharacter();
                if (ke.isAltDown()) {
                    text += " , alt down";
                }
                if (ke.isControlDown()) {
                    text += " , ctrl down";
                }
                if (ke.isMetaDown()) {
                    text += " , meta down";
                }
                if (ke.isShiftDown()) {
                    text += " , shift down";
                }
                console.getItems().add(text);
            }
        });
        VBox vb = new VBox(10);
        vb.getChildren().addAll(textBox, console);
        root.getChildren().add(vb);
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}