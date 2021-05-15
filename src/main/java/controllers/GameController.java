package controllers;

import javafx.scene.control.TextField;
import lombok.NonNull;
import models.personalXmlReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
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

    private String userName1;
    private String userName2;
    private Instant beginGame;
    private final int startingTime = 5;
    private int seconds = startingTime;
    public personalXmlReader personalxmlreader = new personalXmlReader();

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

    public void newQuestion(){
        int temp = Integer.parseInt(questionNumberDisplay.getText()) + 1;
        questionNumberDisplay.setText(Integer.toString(temp));

        Random random = new Random();
        int rand = random.nextInt(70);

        String[] data = personalxmlreader.XmlReader(rand);
        questionDisplay.setText(data[0]);
        answerBlock.setText(data[1]);

        timer();
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

        if (temp1 < temp2)
            player1Score.setText(Integer.toString(Integer.parseInt(player1Score.getText()) + 1));
        else
            player2Score.setText(Integer.toString(Integer.parseInt(player2Score.getText()) + 1));
    }

    public void nextQuestionAsked(){
        newQuestion();
        seconds = startingTime;
        int num = Integer.parseInt(questionNumberDisplay.getText());
        useranswer1.setText("");
        useranswer2.setText("");
        if(num == 5) {
            nextQuestionButton.setVisible(false);
        }
    }

    public void initdata(String userName1, String userName2) {
        this.userName1 = userName1;
        this.userName2 = userName2;
        usernameLabel.setText("Current users: " + this.userName1 + " and " + this.userName2);
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
                    setScores();
                }
            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();

        seconds = startingTime;
    }

    @FXML
    public void initialize() {

        newQuestion();

        beginGame = Instant.now();

        //timer();

        //newQuestion();
    }


}
