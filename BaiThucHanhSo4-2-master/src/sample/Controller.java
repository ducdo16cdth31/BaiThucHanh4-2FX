package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextArea txtText;
    public Label lblTic;
    public Label lblSec;
    public Label lblMin;
    public Label lblHour;

    ArrayList<TimeModel> listTime = new ArrayList<>();
    int ms = 0;
    public int sec = 0;
    String strSec = "00";
    public int min = 0;
    String strMin = "00";
    public int hour = 0;
    String strHour = "00";
    boolean isState = false;
    public Button btnBatDau;
    public Button btnDung;
    private AnimationTimer timer;
    public void BatDauClick(ActionEvent actionEvent) {
        btnDung.setDisable(false);
        timer.start();

    }

    public void DungClick(ActionEvent actionEvent) {
        timer.stop();
        listTime.add(new TimeModel(lblSec.getText(), lblMin.getText(), lblHour.getText()));
        int index = 0;
        String msg = "";
        String strTime = "";
        txtText.clear();
        for (TimeModel timeModel : listTime) {
            index++;
            strTime = index + ". " + timeModel.getHour() + ":" + timeModel.getMinute() + ":" + timeModel.getSecond() + "\n";
            msg += strTime;
        }
        txtText.setText(msg);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timerTick();
    }


    private void timerTick() {
        timer = new AnimationTimer() {
            private long lastTime = 0;
            @Override
            public void handle(long now) {
                if (lastTime != 0) {
                    if (now > lastTime + 1_000_000_000) {
                        sec++;
                        if (sec >= 60) {
                            min++;
                            sec = 0;
                        }
                        if (min >= 60) {
                            hour++;
                            min = 0;
                        }
                        if (hour >= 99) {
                            timer.stop();
                        }

                        if (sec < 10) {
                            strSec = "0" + sec;
                        } else {
                            strSec = sec + "";
                        }

                        if (min < 10) {
                            strMin = "0" + min;
                        } else {
                            strMin = min + "";
                        }

                        if (hour < 10) {
                            strHour = "0" + hour;
                        } else {
                            strHour = hour + "";
                        }
                        lblSec.setText(strSec);
                        lblMin.setText(strMin);
                        lblHour.setText(strHour);
                        lastTime = now;
                    }
                } else {
                    lastTime = now;

                }
            }

            @Override
            public void stop() {
                super.stop();
                lastTime = 0;
                sec = 0;
                min = 0;
                hour = 0;
            }
        };
    }
}
