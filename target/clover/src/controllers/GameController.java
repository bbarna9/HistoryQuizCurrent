/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package controllers;

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
public class GameController {public static class __CLR4_4_17hw7hwkoot95cb{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u0062\u0061\u0072\u006e\u0061\u002f\u0053\u007a\u006f\u0066\u0074\u0076\u0065\u0072\u0066\u0065\u006a\u0065\u006c\u0073\u007a\u0074\u0065\u0073\u002f\u0048\u0069\u0073\u0074\u006f\u0072\u0079\u0051\u0075\u0069\u007a\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1621026381794L,8589935092L,9789,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

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

    public void newQuestion(){try{__CLR4_4_17hw7hwkoot95cb.R.inc(9716);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9717);int temp = Integer.parseInt(questionNumberDisplay.getText()) + 1;
        __CLR4_4_17hw7hwkoot95cb.R.inc(9718);questionNumberDisplay.setText(Integer.toString(temp));

        __CLR4_4_17hw7hwkoot95cb.R.inc(9719);Random random = new Random();
        __CLR4_4_17hw7hwkoot95cb.R.inc(9720);int rand = random.nextInt(70);

        __CLR4_4_17hw7hwkoot95cb.R.inc(9721);String[] data = personalxmlreader.XmlReader(rand);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9722);questionDisplay.setText(data[0]);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9723);answerBlock.setText(data[1]);

        __CLR4_4_17hw7hwkoot95cb.R.inc(9724);timer();
    }finally{__CLR4_4_17hw7hwkoot95cb.R.flushNeeded();}}

    public void setScores(){try{__CLR4_4_17hw7hwkoot95cb.R.inc(9725);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9726);int answer = Integer.parseInt(answerBlock.getText());
        __CLR4_4_17hw7hwkoot95cb.R.inc(9727);int answer1 = Integer.parseInt(useranswer1.getText());
        __CLR4_4_17hw7hwkoot95cb.R.inc(9728);int answer2 = Integer.parseInt(useranswer2.getText());

        __CLR4_4_17hw7hwkoot95cb.R.inc(9729);int temp1 = answer-answer1;
        __CLR4_4_17hw7hwkoot95cb.R.inc(9730);int temp2 = answer-answer2;

        __CLR4_4_17hw7hwkoot95cb.R.inc(9731);if((((temp1 < 0)&&(__CLR4_4_17hw7hwkoot95cb.R.iget(9732)!=0|true))||(__CLR4_4_17hw7hwkoot95cb.R.iget(9733)==0&false))){{
            __CLR4_4_17hw7hwkoot95cb.R.inc(9734);temp1 = temp1 * -1;
        }

        }__CLR4_4_17hw7hwkoot95cb.R.inc(9735);if((((temp2 < 0)&&(__CLR4_4_17hw7hwkoot95cb.R.iget(9736)!=0|true))||(__CLR4_4_17hw7hwkoot95cb.R.iget(9737)==0&false))){{
            __CLR4_4_17hw7hwkoot95cb.R.inc(9738);temp2 = temp2 * -1;
        }

        }__CLR4_4_17hw7hwkoot95cb.R.inc(9739);if ((((temp1 < temp2)&&(__CLR4_4_17hw7hwkoot95cb.R.iget(9740)!=0|true))||(__CLR4_4_17hw7hwkoot95cb.R.iget(9741)==0&false)))
            {__CLR4_4_17hw7hwkoot95cb.R.inc(9742);player1Score.setText(Integer.toString(Integer.parseInt(player1Score.getText()) + 1));
        }else
            {__CLR4_4_17hw7hwkoot95cb.R.inc(9743);player2Score.setText(Integer.toString(Integer.parseInt(player2Score.getText()) + 1));
    }}finally{__CLR4_4_17hw7hwkoot95cb.R.flushNeeded();}}

    public void nextQuestionAsked(){try{__CLR4_4_17hw7hwkoot95cb.R.inc(9744);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9745);newQuestion();
        __CLR4_4_17hw7hwkoot95cb.R.inc(9746);seconds = startingTime;
        __CLR4_4_17hw7hwkoot95cb.R.inc(9747);int num = Integer.parseInt(questionNumberDisplay.getText());
        __CLR4_4_17hw7hwkoot95cb.R.inc(9748);useranswer1.setText(Integer.toString(0));
        __CLR4_4_17hw7hwkoot95cb.R.inc(9749);useranswer2.setText(Integer.toString(0));
        __CLR4_4_17hw7hwkoot95cb.R.inc(9750);if((((num == 5)&&(__CLR4_4_17hw7hwkoot95cb.R.iget(9751)!=0|true))||(__CLR4_4_17hw7hwkoot95cb.R.iget(9752)==0&false))) {{
            __CLR4_4_17hw7hwkoot95cb.R.inc(9753);nextQuestionButton.setVisible(false);
        }
    }}finally{__CLR4_4_17hw7hwkoot95cb.R.flushNeeded();}}

    public void initdata(String userName1, String userName2) {try{__CLR4_4_17hw7hwkoot95cb.R.inc(9754);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9755);this.userName1 = userName1;
        __CLR4_4_17hw7hwkoot95cb.R.inc(9756);this.userName2 = userName2;
        __CLR4_4_17hw7hwkoot95cb.R.inc(9757);usernameLabel.setText("Current users: " + this.userName1 + " and " + this.userName2);
    }finally{__CLR4_4_17hw7hwkoot95cb.R.flushNeeded();}}

    public void timer(){try{__CLR4_4_17hw7hwkoot95cb.R.inc(9758);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9759);answerBlock.setVisible(false);

        __CLR4_4_17hw7hwkoot95cb.R.inc(9760);useranswer1.setEditable(true);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9761);useranswer2.setEditable(true);

        __CLR4_4_17hw7hwkoot95cb.R.inc(9762);Timeline time = new Timeline();
        __CLR4_4_17hw7hwkoot95cb.R.inc(9763);time.setCycleCount(Timeline.INDEFINITE);
            __CLR4_4_17hw7hwkoot95cb.R.inc(9764);if((((time!=null)&&(__CLR4_4_17hw7hwkoot95cb.R.iget(9765)!=0|true))||(__CLR4_4_17hw7hwkoot95cb.R.iget(9766)==0&false)))
                {__CLR4_4_17hw7hwkoot95cb.R.inc(9767);time.stop();
        }__CLR4_4_17hw7hwkoot95cb.R.inc(9768);KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {try{__CLR4_4_17hw7hwkoot95cb.R.inc(9769);
                __CLR4_4_17hw7hwkoot95cb.R.inc(9770);timeDisplay.setText(String.valueOf(seconds));
                    __CLR4_4_17hw7hwkoot95cb.R.inc(9771);if ((((seconds<=0)&&(__CLR4_4_17hw7hwkoot95cb.R.iget(9772)!=0|true))||(__CLR4_4_17hw7hwkoot95cb.R.iget(9773)==0&false)))
                        {__CLR4_4_17hw7hwkoot95cb.R.inc(9774);time.stop();
                }__CLR4_4_17hw7hwkoot95cb.R.inc(9775);seconds--;
                __CLR4_4_17hw7hwkoot95cb.R.inc(9776);if((((seconds==-1)&&(__CLR4_4_17hw7hwkoot95cb.R.iget(9777)!=0|true))||(__CLR4_4_17hw7hwkoot95cb.R.iget(9778)==0&false))) {{
                    __CLR4_4_17hw7hwkoot95cb.R.inc(9779);answerBlock.setVisible(true);
                    __CLR4_4_17hw7hwkoot95cb.R.inc(9780);useranswer1.setEditable(false);
                    __CLR4_4_17hw7hwkoot95cb.R.inc(9781);useranswer2.setEditable(false);
                    __CLR4_4_17hw7hwkoot95cb.R.inc(9782);setScores();
                }
            }}finally{__CLR4_4_17hw7hwkoot95cb.R.flushNeeded();}}
        });
        __CLR4_4_17hw7hwkoot95cb.R.inc(9783);time.getKeyFrames().add(frame);
        __CLR4_4_17hw7hwkoot95cb.R.inc(9784);time.playFromStart();

        __CLR4_4_17hw7hwkoot95cb.R.inc(9785);seconds = startingTime;
    }finally{__CLR4_4_17hw7hwkoot95cb.R.flushNeeded();}}

    @FXML
    public void initialize() {try{__CLR4_4_17hw7hwkoot95cb.R.inc(9786);

        __CLR4_4_17hw7hwkoot95cb.R.inc(9787);newQuestion();

        __CLR4_4_17hw7hwkoot95cb.R.inc(9788);beginGame = Instant.now();

        //timer();

        //newQuestion();
    }finally{__CLR4_4_17hw7hwkoot95cb.R.flushNeeded();}}


}
