package com.forest.widget_daily;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.converter.IntegerStringConverter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class StopwatchDailyController {

    private static final String FORMAT_TIME = "%02d:%02d";

    private static final String FORMAT_TIME_INFORMATION = "Tiempo: " + FORMAT_TIME;

    @FXML
    public VBox vBoxDevelopers;

    @FXML
    private VBox vBoxFront;

    @FXML
    public VBox vBoxBackend;

    @FXML
    public VBox vBoxTlYPo;

    @FXML
    public Label preDailyLabel;

    @FXML
    private Label stopwatchLabel1;

    @FXML
    private Label stopwatchLabel2;

    @FXML
    private Label stopwatchLabel3;

    @FXML
    private Label stopwatchLabel4;

    @FXML
    private Label stopwatchLabel5;

    @FXML
    private Label stopwatchLabel6;

    @FXML
    private Label stopwatchLabel7;

    @FXML
    private Label stopwatchLabel8;

    @FXML
    private Label stopwatchLabel9;

    @FXML
    private Label stopwatchLabel10;

    @FXML
    private Label stopwatchLabel11;

    @FXML
    public Label timeLabel;

    @FXML
    public Button preDailyButton;

    @FXML
    private Button stopwatchButton1;

    @FXML
    private Button stopwatchButton2;

    @FXML
    private Button stopwatchButton3;

    @FXML
    private Button stopwatchButton4;

    @FXML
    private Button stopwatchButton5;

    @FXML
    private Button stopwatchButton6;

    @FXML
    private Button stopwatchButton7;

    @FXML
    private Button stopwatchButton8;

    @FXML
    private Button stopwatchButton9;

    @FXML
    private Button stopwatchButton10;

    @FXML
    private Button stopwatchButton11;

    @FXML
    private Button pauseStopwatchButton;

    @FXML
    private Button musicButton;

    @FXML
    public TextField secondsInputField;
    
    private int secondsStopwatch;
    
    private Timer timer;

    private boolean isPausedTimer = false;
    
    private MediaPlayer mediaPlayer;

    @FXML
    private void initialize(){
        String alarmSoundUrl = Objects.requireNonNull(getClass().getResource("alarma-good-morning-ringtones.mp3")).toExternalForm();
        Media sound = new Media(alarmSoundUrl);
        mediaPlayer = new MediaPlayer(sound);
        secondsStopwatch = 150;
        timeLabel.setText(String.format(FORMAT_TIME_INFORMATION, (secondsStopwatch / 60), (secondsStopwatch % 60)));

        TextFormatter<Integer> textFormatter = new TextFormatter<>(new IntegerStringConverter(), secondsStopwatch,
                c -> {
                    if (c.getControlNewText().matches("\\d*")) {
                        return c;
                    } else {
                        return null;
                    }
                });
        secondsInputField.setTextFormatter(textFormatter);
        secondsInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                secondsStopwatch = Integer.parseInt(newValue);
                timeLabel.setText(String.format(FORMAT_TIME_INFORMATION, (secondsStopwatch / 60), (secondsStopwatch % 60)));
            }
        });

        sortRandom(vBoxDevelopers);
        sortRandom(vBoxFront);
        sortRandom(vBoxBackend);
    }
    
    private void sortRandom(final VBox vBox) {
        List<Node> children = new ArrayList<>(vBox.getChildren());
        Collections.shuffle(children);
        vBox.getChildren().setAll(children);
    }
    
    @FXML
    protected void onStartPreDailyButtonClick() {
        preDailyButton.setDisable(true);
        startTimer(preDailyLabel);
    }

    @FXML
    protected void onStartStopwatch1ButtonClick() {
        stopwatchButton1.setDisable(true);
        startTimer(stopwatchLabel1);
    }

    @FXML
    protected void onStartStopwatch2ButtonClick() {
        stopwatchButton2.setDisable(true);
        startTimer(stopwatchLabel2);
    }

    @FXML
    protected void onStartStopwatch3ButtonClick() {
        stopwatchButton3.setDisable(true);
        startTimer(stopwatchLabel3);
    }

    @FXML
    protected void onStartStopwatch4ButtonClick() {
        stopwatchButton4.setDisable(true);
        startTimer(stopwatchLabel4);
    }

    @FXML
    protected void onStartStopwatch5ButtonClick() {
        stopwatchButton5.setDisable(true);
        startTimer(stopwatchLabel5);
    }

    @FXML
    protected void onStartStopwatch6ButtonClick() {
        stopwatchButton6.setDisable(true);
        startTimer(stopwatchLabel6);
    }

    @FXML
    protected void onStartStopwatch7ButtonClick() {
        stopwatchButton7.setDisable(true);
        startTimer(stopwatchLabel7);
    }

    @FXML
    protected void onStartStopwatch8ButtonClick() {
        stopwatchButton8.setDisable(true);
        startTimer(stopwatchLabel8);
    }

    @FXML
    protected void onStartStopwatch9ButtonClick() {
        stopwatchButton9.setDisable(true);
        startTimer(stopwatchLabel9);
    }

    @FXML
    protected void onStartStopwatch10ButtonClick() {
        stopwatchButton10.setDisable(true);
        startTimer(stopwatchLabel10);
    }

    @FXML
    protected void onStartStopwatch11ButtonClick() {
        stopwatchButton11.setDisable(true);
        startTimer(stopwatchLabel11);
    }
    
    @FXML
    protected void onStopMusicButtonClick() {
        mediaPlayer.stop();
    }
    
    @FXML
    protected void onPauseStopwatchButtonClick() {
        isPausedTimer = !isPausedTimer;
        final String pathButton = isPausedTimer ? "boton-de-play.png" : "boton-de-pausa.png";
        setGraphicButton(pathButton, pauseStopwatchButton);
    }

    @FXML
    protected void onStopStopwatchButtonClick() {
        if (timer != null) {
            timer.cancel();
        }
        stopwatchButton1.setDisable(true);
        stopwatchButton2.setDisable(true);
        stopwatchButton3.setDisable(true);
        stopwatchButton4.setDisable(true);
        stopwatchButton5.setDisable(true);
        stopwatchButton6.setDisable(true);
        stopwatchButton7.setDisable(true);
        stopwatchButton8.setDisable(true);
        stopwatchButton9.setDisable(true);
        stopwatchButton10.setDisable(true);
        stopwatchButton11.setDisable(true);
        preDailyButton.setDisable(true);
        pauseStopwatchButton.setDisable(true);
        musicButton.setDisable(true);
        mediaPlayer.stop();
    }
    
    private void setGraphicButton(String path, Button button) {
        ImageView playImageView = new ImageView(new Image(getClass().getResourceAsStream(path)));
        playImageView.setFitHeight(18);
        playImageView.setFitWidth(18);
        button.setGraphic(playImageView);
    }

    private void startTimer(Label stopwatchLabel) {
        if (timer != null) {
            timer.cancel();
        }
        mediaPlayer.stop();
        isPausedTimer = false;
        pauseStopwatchButton.setDisable(false);
        secondsInputField.setDisable(true);
        setGraphicButton("boton-de-pausa.png", pauseStopwatchButton);

        timer = new Timer();
        final AtomicReference<Integer> secondsAtomicReference = new AtomicReference<>(secondsStopwatch);

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if (isPausedTimer) {
                    return;
                }
                secondsAtomicReference.set(secondsAtomicReference.get()-1);
                updateLabel(secondsAtomicReference.get(), stopwatchLabel);

                if (secondsAtomicReference.get() == 0) {
                    playAlarm();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    private void updateLabel(int seconds, Label stopwatchLabel) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        String symbol = "";
        
        if (seconds > (secondsStopwatch * 0.75)) {
            stopwatchLabel.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));
            stopwatchLabel.setTextFill(Color.WHITE);
        } else if (seconds > (secondsStopwatch * 0.50)) {
            stopwatchLabel.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(0), Insets.EMPTY)));
            stopwatchLabel.setTextFill(Color.WHITE);
        } else if (seconds > (secondsStopwatch * 0.25)) {
            stopwatchLabel.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(0), Insets.EMPTY)));
            stopwatchLabel.setTextFill(Color.BLACK);
        } else if (seconds > 0) {
            stopwatchLabel.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(0), Insets.EMPTY)));
            stopwatchLabel.setTextFill(Color.BLACK);
        } else {
            stopwatchLabel.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0), Insets.EMPTY)));
            stopwatchLabel.setTextFill(Color.BLACK);

            symbol = " - ";
            minutes *= -1;
            remainingSeconds *= -1;
        }

        AtomicReference<String> finalSymbol = new AtomicReference<>(symbol);
        AtomicInteger finalMinutes = new AtomicInteger(minutes);
        AtomicInteger finalRemainingSeconds = new AtomicInteger(remainingSeconds);
        Platform.runLater(() -> stopwatchLabel.setText(finalSymbol.get() + String.format(FORMAT_TIME, finalMinutes.get(), finalRemainingSeconds.get())));
    }

    private void playAlarm() {
        mediaPlayer.play();
    }

    public void close() {
        if (timer != null) {
            timer.cancel();
        }
        mediaPlayer.stop();
    }
}