package com.converter;

import com.converter.type.Binary;
import com.converter.type.Morse;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    boolean swapOption = false;
    boolean themeOption = false;
    boolean convertEnded = false;

    @Override
    public void start(Stage Stage) {

        String[] options = {"Morse Code", "Binary Code"};
        ComboBox<String> list = new ComboBox<>(FXCollections.observableArrayList(options));
        list.setValue("Select Mode");
        // list.setTranslateX(60);
        list.setTranslateY(-150);

        TextField inputTf, outputTf;
        Label inputLb, outputLb;

        inputTf = new TextField();
        inputTf.setMaxSize(200, 0);
        // input.setTranslateX(-125);
        inputTf.setTranslateY(-80);
        inputTf.setDisable(true);

        inputLb = new Label("Input");
        inputLb.setTranslateX(-150);
        inputLb.setTranslateY(-80);

        outputTf = new TextField();
        outputTf.setMaxSize(200, 0);
        // outputTf.setTranslateX(125);
        outputTf.setTranslateY(20);
        outputTf.setDisable(true);
        outputTf.setEditable(false);

        outputLb = new Label("Output");
        outputLb.setTranslateX(-150);
        outputLb.setTranslateY(20);

        Button convertBtn, swapBtn, infoBtn, clearBtn, themeBtn;

        convertBtn = new Button();
        convertBtn.setText("Convert");
        // convertBtn.setPrefSize(100, 0);
        convertBtn.setTranslateY(100);
        convertBtn.setOnAction(e -> {
            String text = "";
            switch (list.getValue()) {
                case "Morse Code":
                    if (swapOption) {
                        text = Morse.convertFromMorse(inputTf.getText());
                    } else {
                        text = Morse.convertToMorse(inputTf.getText());
                    }
                    typeAnimation(text, outputTf);
                    break;

                case "Binary Code":
                    if (swapOption) {
                        if(!text.matches("[01]{8}")) {
                            // inputTf.setStyle("-fx-background-color: #cc0000; -fx-text-fill: #cccccc; -fx-font: normal bold 20px Monaco;");
                            break;
                        }
                        text = Binary.convertFromBinary(inputTf.getText());
                    } else {
                        text = Binary.convertToBinary(inputTf.getText());
                    }
                    typeAnimation(text, outputTf);
                    break;
            
                default:
                    break;
            }
        });

        Image swapImage, dark_themeImage, light_themeImage, infoImage;
        ImageView swapImageView, dark_themeImageView, light_themeImageView, infoImageView;

        swapImage = new Image(getClass().getResourceAsStream("/images/swap.png"));
        swapImageView = new ImageView(swapImage);
        swapImageView.setFitWidth(16);
        swapImageView.setPreserveRatio(true);
        swapImageView.setSmooth(true);
        swapImageView.setCache(true);
        swapBtn = new Button("",swapImageView);
        swapBtn.setDisable(true);
        // swapBtn.setTranslateX(60);
        swapBtn.setTranslateY(-30);
        swapBtn.setOnAction(e -> {
            String tempOutput = inputTf.getText();
            inputTf.setText(outputTf.getText());
            outputTf.setText(tempOutput);

            String tempPromt;

            if (swapOption) {
                swapOption = false;
                tempPromt = inputTf.getPromptText();
                inputTf.setPromptText(outputTf.getPromptText());
                outputTf.setPromptText(tempPromt);

            } else {
                swapOption = true;
                tempPromt = inputTf.getPromptText();
                inputTf.setPromptText(outputTf.getPromptText());
                outputTf.setPromptText(tempPromt);
            }
        });

        clearBtn = new Button("C");
        clearBtn.setTranslateX(75);
        clearBtn.setTranslateY(100);
        // clearBtn.setDisable(true);
        clearBtn.setOnAction(event -> {
            inputTf.clear();
            outputTf.clear();
            // clearBtn.setDisable(true);
        });

        // inputTf.textProperty().addListener(event -> {
        //     clearBtn.setDisable(false);
        // });

        list.setOnAction(e -> {
            switch (list.getValue()) {
                case "Morse Code":
                    inputTf.setPromptText("Normal");
                    outputTf.setPromptText("Morse");
                    swapOption = false;
                    inputTf.clear();
                    outputTf.clear();
                    break;

                case "Binary Code":
                    inputTf.setPromptText("Normal");
                    outputTf.setPromptText("Binary");
                    swapOption = false;
                    inputTf.clear();
                    outputTf.clear();
                    break;
            
                default:
                    break;
            }
            inputTf.setDisable(false);
            outputTf.setDisable(false);
            swapBtn.setDisable(false);
            outputTf.setText("");
        });

        // infoImage = new Image(getClass().getResourceAsStream("/images/info.png"));
        // infoImageView = new ImageView(infoImage);
        // infoImageView.setFitWidth(25);
        // infoImageView.setPreserveRatio(true);
        // infoImageView.setSmooth(true);
        // infoImageView.setCache(true);
        // infoBtn = new Button("",infoImageView);
        // infoBtn.setTranslateX(-220);
        // infoBtn.setTranslateY(-175);

        light_themeImage = new Image(getClass().getResourceAsStream("/images/light-mode.png"));
        light_themeImageView = new ImageView(light_themeImage);
        light_themeImageView.setFitWidth(25);
        light_themeImageView.setPreserveRatio(true);
        light_themeImageView.setSmooth(true);
        light_themeImageView.setCache(true);

        dark_themeImage = new Image(getClass().getResourceAsStream("/images/dark-mode.png"));
        dark_themeImageView = new ImageView(dark_themeImage);
        dark_themeImageView.setFitWidth(25);
        dark_themeImageView.setPreserveRatio(true);
        dark_themeImageView.setSmooth(true);
        dark_themeImageView.setCache(true);

        themeBtn = new Button("", light_themeImageView);
        // theme.setTranslateX(200);
        // theme.setTranslateY(355);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5, 5, 5, 5));
        root.getChildren().addAll(list);
        root.getChildren().addAll(inputTf, outputTf, inputLb, outputLb);
        root.getChildren().addAll(convertBtn, swapBtn, clearBtn, themeBtn);

        StackPane.setAlignment(themeBtn, Pos.BOTTOM_RIGHT);
        // StackPane.setAlignment(infoBtn, Pos.BOTTOM_RIGHT);
        // infoBtn.setTranslateX(-50);

        Scene scene = new Scene(root, 500, 400);

        themeBtn.setOnAction(e -> {
            if (themeOption) {
                // light
                themeOption = false;
                themeBtn.setGraphic(light_themeImageView);
                list.setStyle("-fx-background-color: #f2f2f2; -fx-font: normal bold 20px Monaco;");
                inputTf.setStyle("-fx-background-color: #f2f2f2; -fx-font: normal bold 20px Monaco;");
                outputTf.setStyle("-fx-background-color: #f2f2f2; -fx-font: normal bold 20px Monaco;");
                convertBtn.setStyle("-fx-background-color: #484b6a; -fx-text-fill: white; -fx-font: bold 20px Monaco;");
                // clearBtn.setStyle("-fx-background-color: #cc0000; -fx-text-fill: white; -fx-font: bold 20px Monaco;");
                // swapBtn.setStyle("-fx-background-color: #f2f2f2");
                inputLb.setStyle("-fx-text-fill: #1f2021; -fx-font: normal bold 20px Monaco;");
                outputLb.setStyle("-fx-text-fill: #1f2021; -fx-font: normal bold 20px Monaco;");
                scene.getRoot().setStyle("-fx-background-color: #d2d3db;");
            } else {
                // dark
                themeOption = true;
                themeBtn.setGraphic(dark_themeImageView);
                list.setStyle("-fx-background-color: #f2f2f2; -fx-font: normal bold 20px Monaco;");
                inputTf.setStyle("-fx-background-color: #353535; -fx-text-fill: #cccccc; -fx-font: normal bold 20px Monaco;");
                outputTf.setStyle("-fx-background-color: #353535; -fx-text-fill: #cccccc; -fx-font: normal bold 20px Monaco;");
                convertBtn.setStyle("-fx-background-color: #c38fff; -fx-text-fill: #000000; -fx-font: bold 20px Monaco;");
                inputLb.setStyle("-fx-text-fill: #cccccc; -fx-font: normal bold 20px Monaco;");
                outputLb.setStyle("-fx-text-fill: #cccccc; -fx-font: normal bold 20px Monaco;");
                scene.getRoot().setStyle("-fx-background-color: #121212;");
            }
        });

        list.setStyle("-fx-background-color: #f2f2f2; -fx-font: normal bold 20px Monaco;");
        inputTf.setStyle("-fx-background-color: #f2f2f2; -fx-font: normal bold 20px Monaco;");
        outputTf.setStyle("-fx-background-color: #f2f2f2; -fx-font: normal bold 20px Monaco;");
        convertBtn.setStyle("-fx-background-color: #484b6a; -fx-text-fill: white; -fx-font: bold 20px Monaco;");
        clearBtn.setStyle("-fx-background-color: #cc0000; -fx-text-fill: white; -fx-font: bold 20px Monaco;");
        swapBtn.setStyle("-fx-background-color: #f2f2f2");
        // infoBtn.setStyle("-fx-background-color: #f2f2f2;");
        themeBtn.setStyle("-fx-background-color: #f2f2f2;");
        inputLb.setStyle("-fx-text-fill: #1f2021; -fx-font: normal bold 20px Monaco;");
        outputLb.setStyle("-fx-text-fill: #1f2021; -fx-font: normal bold 20px Monaco;");
        scene.getRoot().setStyle("-fx-background-color: #d2d3db;");

        Stage.getIcons().add(new Image(App.class.getResourceAsStream("/images/swap.png")));
        Stage.setTitle("Multi Converter");
        Stage.setResizable(false);
        Stage.setScene(scene);
        Stage.show();
    }

    public void typeAnimation(String text, TextField outputTf) {
        Timeline timeline = new Timeline();
                        for (int i = 1; i <= text.length(); i++) {
                            int finalI = i;
                            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(150 * i), event -> {
                                outputTf.setText(text.substring(0, finalI));
                                outputTf.positionCaret(outputTf.getText().length());
                            }));
                        }
                        timeline.setCycleCount(1);
                        timeline.setOnFinished(event -> {
                        });
                        timeline.play();
    }
}

