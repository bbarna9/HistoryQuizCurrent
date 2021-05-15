/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package controllers;

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
public class GameController {public static class __CLR4_4_18fx8fxkopvm4ak{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u0062\u0061\u0072\u006e\u0061\u002f\u0053\u007a\u006f\u0066\u0074\u0076\u0065\u0072\u0066\u0065\u006a\u0065\u006c\u0073\u007a\u0074\u0065\u0073\u002f\u0048\u0069\u0073\u0074\u006f\u0072\u0079\u0051\u0075\u0069\u007a\u0043\u0075\u0072\u0072\u0065\u006e\u0074\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1621090812357L,8589935092L,11043,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

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

    public void newQuestion(){try{__CLR4_4_18fx8fxkopvm4ak.R.inc(10941);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10942);nextQuestionButton.setVisible(false);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10943);onlyDigits(useranswer1);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10944);onlyDigits(useranswer2);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10945);int temp = Integer.parseInt(questionNumberDisplay.getText()) + 1;
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10946);questionNumberDisplay.setText(Integer.toString(temp));

        __CLR4_4_18fx8fxkopvm4ak.R.inc(10947);Random random = new Random();
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10948);int rand = random.nextInt(70);

        __CLR4_4_18fx8fxkopvm4ak.R.inc(10949);String[] data = personalxmlreader.XmlReader(rand);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10950);questionDisplay.setText(data[0]);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10951);answerBlock.setText(data[1]);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10952);timer();
    }finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}

    public void onlyDigits(TextField typed){try{__CLR4_4_18fx8fxkopvm4ak.R.inc(10953);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10954);typed.textProperty().addListener((observable, oldValue, newValue) -> {
            __CLR4_4_18fx8fxkopvm4ak.R.inc(10955);if((((!newValue.matches("\\d*"))&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(10956)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(10957)==0&false))){{
                __CLR4_4_18fx8fxkopvm4ak.R.inc(10958);typed.setText(newValue.replaceAll("[^\\d]",""));
            }
        }});
    }finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}

    public void setScores(){try{__CLR4_4_18fx8fxkopvm4ak.R.inc(10959);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10960);int answer = Integer.parseInt(answerBlock.getText());
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10961);int answer1 = Integer.parseInt(useranswer1.getText());
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10962);int answer2 = Integer.parseInt(useranswer2.getText());

        __CLR4_4_18fx8fxkopvm4ak.R.inc(10963);int temp1 = answer-answer1;
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10964);int temp2 = answer-answer2;

        __CLR4_4_18fx8fxkopvm4ak.R.inc(10965);if((((temp1 < 0)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(10966)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(10967)==0&false))){{
            __CLR4_4_18fx8fxkopvm4ak.R.inc(10968);temp1 = temp1 * -1;
        }

        }__CLR4_4_18fx8fxkopvm4ak.R.inc(10969);if((((temp2 < 0)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(10970)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(10971)==0&false))){{
            __CLR4_4_18fx8fxkopvm4ak.R.inc(10972);temp2 = temp2 * -1;
        }

        }__CLR4_4_18fx8fxkopvm4ak.R.inc(10973);if((((answer1 == answer2)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(10974)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(10975)==0&false))){{
            __CLR4_4_18fx8fxkopvm4ak.R.inc(10976);player1Score = player1Score;
            __CLR4_4_18fx8fxkopvm4ak.R.inc(10977);player2Score = player2Score;
        }
        }else {__CLR4_4_18fx8fxkopvm4ak.R.inc(10978);if ((((answer2 == 0 | temp1 < temp2)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(10979)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(10980)==0&false)))
            {__CLR4_4_18fx8fxkopvm4ak.R.inc(10981);player1Score.setText(Integer.toString(Integer.parseInt(player1Score.getText()) + 1));
        }else {__CLR4_4_18fx8fxkopvm4ak.R.inc(10982);if ((((answer1 == 0 | temp2 < temp1)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(10983)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(10984)==0&false)))
            {__CLR4_4_18fx8fxkopvm4ak.R.inc(10985);player2Score.setText(Integer.toString(Integer.parseInt(player2Score.getText()) + 1));

        }}}__CLR4_4_18fx8fxkopvm4ak.R.inc(10986);score1 = Integer.parseInt(player1Score.getText());
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10987);score2 = Integer.parseInt(player2Score.getText());

    }finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}

    public void nextQuestionAsked(){try{__CLR4_4_18fx8fxkopvm4ak.R.inc(10988);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10989);newQuestion();
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10990);seconds = startingTime;
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10991);int num = Integer.parseInt(questionNumberDisplay.getText());
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10992);useranswer1.setText("0");
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10993);useranswer2.setText("0");
        __CLR4_4_18fx8fxkopvm4ak.R.inc(10994);if((((num == 2)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(10995)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(10996)==0&false))) {{
            __CLR4_4_18fx8fxkopvm4ak.R.inc(10997);nextQuestionButton.setVisible(false);
            __CLR4_4_18fx8fxkopvm4ak.R.inc(10998);getResultsButton.setVisible(true);
        }
    }}finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}

    public void timer(){try{__CLR4_4_18fx8fxkopvm4ak.R.inc(10999);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11000);answerBlock.setVisible(false);

        __CLR4_4_18fx8fxkopvm4ak.R.inc(11001);useranswer1.setEditable(true);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11002);useranswer2.setEditable(true);

        __CLR4_4_18fx8fxkopvm4ak.R.inc(11003);Timeline time = new Timeline();
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11004);time.setCycleCount(Timeline.INDEFINITE);
            __CLR4_4_18fx8fxkopvm4ak.R.inc(11005);if((((time!=null)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(11006)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(11007)==0&false)))
                {__CLR4_4_18fx8fxkopvm4ak.R.inc(11008);time.stop();
        }__CLR4_4_18fx8fxkopvm4ak.R.inc(11009);KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {try{__CLR4_4_18fx8fxkopvm4ak.R.inc(11010);
                __CLR4_4_18fx8fxkopvm4ak.R.inc(11011);timeDisplay.setText(String.valueOf(seconds));
                    __CLR4_4_18fx8fxkopvm4ak.R.inc(11012);if ((((seconds<=0)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(11013)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(11014)==0&false)))
                        {__CLR4_4_18fx8fxkopvm4ak.R.inc(11015);time.stop();
                }__CLR4_4_18fx8fxkopvm4ak.R.inc(11016);seconds--;
                __CLR4_4_18fx8fxkopvm4ak.R.inc(11017);if((((seconds==-1)&&(__CLR4_4_18fx8fxkopvm4ak.R.iget(11018)!=0|true))||(__CLR4_4_18fx8fxkopvm4ak.R.iget(11019)==0&false))) {{
                    __CLR4_4_18fx8fxkopvm4ak.R.inc(11020);answerBlock.setVisible(true);
                    __CLR4_4_18fx8fxkopvm4ak.R.inc(11021);useranswer1.setEditable(false);
                    __CLR4_4_18fx8fxkopvm4ak.R.inc(11022);useranswer2.setEditable(false);
                    __CLR4_4_18fx8fxkopvm4ak.R.inc(11023);nextQuestionButton.setVisible(true);
                    __CLR4_4_18fx8fxkopvm4ak.R.inc(11024);setScores();
                }
            }}finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}
        });
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11025);time.getKeyFrames().add(frame);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11026);time.playFromStart();

        __CLR4_4_18fx8fxkopvm4ak.R.inc(11027);seconds = startingTime;
    }finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}

    public void showResults(ActionEvent actionEvent) throws IOException {try{__CLR4_4_18fx8fxkopvm4ak.R.inc(11028);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11029);FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/results.fxml"));
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11030);Parent root = fxmlLoader.load();
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11031);fxmlLoader.<ResultController>getController().initdata(username1, username2, score1, score2);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11032);Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //stage.getIcons().add(icon);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11033);stage.setScene(new Scene(root));
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11034);stage.show();
    }finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}

    public void initdata(String userName1, String userName2) {try{__CLR4_4_18fx8fxkopvm4ak.R.inc(11035);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11036);username1 = userName1;
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11037);username2 = userName2;
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11038);usernameLabel.setText("Current users: " + username1 + " and " + username2);
        __CLR4_4_18fx8fxkopvm4ak.R.inc(11039);getResultsButton.setVisible(false);
    }finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}

    @FXML
    public void initialize() {try{__CLR4_4_18fx8fxkopvm4ak.R.inc(11040);

        __CLR4_4_18fx8fxkopvm4ak.R.inc(11041);newQuestion();

        __CLR4_4_18fx8fxkopvm4ak.R.inc(11042);beginGame = Instant.now();
    }finally{__CLR4_4_18fx8fxkopvm4ak.R.flushNeeded();}}
}
