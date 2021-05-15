package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.NonNull;
import models.personalXmlReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.time.Instant;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameController {

    private String username1;
    private String username2;
    private Instant beginGame;
    private final int startingTime = 5;
    private int seconds = startingTime;
    public personalXmlReader personalxmlreader = new personalXmlReader();
    public int score1;
    public int score2;


    @FXML
    public Label questionDisplay;

    @FXML
    public Label answerBlock;

    @FXML
    public Label player1Score;

    @FXML
    public Label player2Score;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label questionNumberDisplay;

    @FXML
    private Label timeDisplay;

    @FXML
    private TextField useranswer1;

    @FXML
    private TextField useranswer2;

    @FXML
    private Button nextQuestionButton;

    @FXML
    private Button getResultsButton;

    public void newQuestion(){
        nextQuestionButton.setVisible(false);
        onlyDigits(useranswer1);
        onlyDigits(useranswer2);
        int temp = Integer.parseInt(questionNumberDisplay.getText()) + 1;
        questionNumberDisplay.setText(Integer.toString(temp));

        Random random = new Random();
        int rand = random.nextInt(70);

        String[] data = personalxmlreader.XmlReader(rand);
        questionDisplay.setText(data[0]);
        answerBlock.setText(data[1]);
        timer();
    }

    public void onlyDigits(TextField typed){
        typed.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.matches("\\d*")){
                typed.setText(newValue.replaceAll("[^\\d]",""));
            }
        });
    }

    public void setScores(){
        int answer = Integer.parseInt(answerBlock.getText());
        int answer1 = Integer.parseInt(useranswer1.getText());
        int answer2 = Integer.parseInt(useranswer2.getText());

        int temp1 = answer-answer1;
        int temp2 = answer-answer2;

        if(temp1 < 0){
            temp1 = temp1 * -1;
        }

        if(temp2 < 0){
            temp2 = temp2 * -1;
        }

        if(answer1 == answer2){
            player1Score = player1Score;
            player2Score = player2Score;
        }
        else if (answer2 == 0 | temp1 < temp2)
            player1Score.setText(Integer.toString(Integer.parseInt(player1Score.getText()) + 1));
        else if (answer1 == 0 | temp2 < temp1)
            player2Score.setText(Integer.toString(Integer.parseInt(player2Score.getText()) + 1));

        score1 = Integer.parseInt(player1Score.getText());
        score2 = Integer.parseInt(player2Score.getText());

    }

    public void nextQuestionAsked(){
        newQuestion();
        seconds = startingTime;
        int num = Integer.parseInt(questionNumberDisplay.getText());
        useranswer1.setText("0");
        useranswer2.setText("0");
        if(num == 2) {
            nextQuestionButton.setVisible(false);
            getResultsButton.setVisible(true);
        }
    }

    public void timer(){
        answerBlock.setVisible(false);

        useranswer1.setEditable(true);
        useranswer2.setEditable(true);

        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
            if(time!=null)
                time.stop();
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timeDisplay.setText(String.valueOf(seconds));
                    if (seconds<=0)
                        time.stop();
                seconds--;
                if(seconds==-1) {
                    answerBlock.setVisible(true);
                    useranswer1.setEditable(false);
                    useranswer2.setEditable(false);
                    nextQuestionButton.setVisible(true);
                    setScores();
                }
            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();

        seconds = startingTime;
    }

    public void showResults(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/results.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<ResultController>getController().initdata(username1, username2, score1, score2);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //stage.getIcons().add(icon);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void initdata(String userName1, String userName2) {
        username1 = userName1;
        username2 = userName2;
        usernameLabel.setText("Current users: " + username1 + " and " + username2);
        getResultsButton.setVisible(false);
    }

    @FXML
    public void initialize() {

        newQuestion();

        beginGame = Instant.now();
    }
}
