package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
public class LaunchController {

    @FXML
    private TextField usernameTextfield1;

    @FXML
    private TextField usernameTextfield2;

    @FXML
    private Label errorLabel;

    public void startGame(ActionEvent actionEvent) throws IOException {
        if (usernameTextfield1.getText().isEmpty() || usernameTextfield2.getText().isEmpty()) {
            errorLabel.setText("Either one or both of the usernames are empty!");
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<GameController>getController().initdata(usernameTextfield1.getText(), usernameTextfield2.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            //stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
            log.info("Usernames are set to {} and {}, loading game scene.", usernameTextfield1.getText(), usernameTextfield2.getText());
        }

    }
}
