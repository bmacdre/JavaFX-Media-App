/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medaiApplett;

import java.io.File;
import javafx.application.Application;
import static javafx.application.Platform.runLater;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Duration;

/**
 *
 * @author Brendan
 */
public class MedaiApplett extends Application {

    MediaPlayer mediaPlayer;
    private Label time;
    Duration duration;
    Button fsButton = new Button();
    Scene scene;
    Media media;
    double width;
    double height;
    MediaView mediaView;

    @Override
    public void start(Stage primaryStage) {

        scene = setScene(this.width, this.height);

        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);

        fsButton.setOnAction((ActionEvent e) -> {
            if (primaryStage.isFullScreen()) {
                primaryStage.setFullScreen(false);
            } else {
                primaryStage.setFullScreen(true);
            }
        });

        primaryStage.show();

    }

    public Scene setScene(double width, double height) {
        this.height = height;
        this.width = width;
        String path = "D:\\Users\\Brendan\\Downloads\\Quality music dls\\Oct. 2016\\Nujabes Lady Brown.mp3";
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(false);

        mediaView = new MediaView(mediaPlayer);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(0.5);
        dropShadow.setOffsetY(0.5);
        dropShadow.setColor(Color.WHITE);
        mediaView.setEffect(dropShadow);

        BorderPane borderPane = new BorderPane(mediaView, null, null, addToolBar(), null);
        borderPane.setStyle("-fx-background-color: BLACK");
        scene = new Scene(borderPane, 640, 480);
        scene.setFill(Color.BLACK);
        return scene;
    }

    private HBox addToolBar() {
        HBox toolBar = new HBox();
        toolBar.setPadding(new Insets(20));
        toolBar.setAlignment(Pos.CENTER);
        toolBar.alignmentProperty().isBound();
        toolBar.setSpacing(5);
        toolBar.setStyle("-fx-background-color: Black");
        ////////////////////////////////////////////////////////////////////////
        // Buttons Start Below
        // PlayButton
        Image playButtonImage = new Image(getClass().getResourceAsStream("Play.png"));
        Button playButton = new Button();
        playButton.setGraphic(new ImageView(playButtonImage));
        playButton.setStyle("-fx-background-color: Black");

        playButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.play();
        });

        playButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            playButton.setStyle("-fx-background-color: Black");
            playButton.setStyle("-fx-body-color: Black");
        });

        playButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            playButton.setStyle("-fx-background-color: Black");
        });

        ///////////////
        // Pause Button
        Image pauseButtonImage = new Image(getClass().getResourceAsStream("Pause.png"));
        Button pauseButton = new Button();
        pauseButton.setGraphic(new ImageView(pauseButtonImage));
        pauseButton.setStyle("-fx-background-color: Black");

        pauseButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.pause();
        });

        pauseButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            pauseButton.setStyle("-fx-background-color: Black");
            pauseButton.setStyle("-fx-body-color: Black");
        });

        pauseButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            pauseButton.setStyle("-fx-background-color: Black");
        });

        ///////////////////
        // FastForward Button
        Image ffImage = new Image(getClass().getResourceAsStream("Fast Forward.png"));
        Button ffButton = new Button();
        ffButton.setGraphic(new ImageView(ffImage));
        ffButton.setStyle("-fx-background-color: Black");

        ffButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().multiply(1.5));
        });

        ffButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            ffButton.setStyle("-fx-background-color: Black");
            ffButton.setStyle("-fx-body-color: Black");
        });

        ffButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            ffButton.setStyle("-fx-background-color: Black");
        });

        //////////////
        // Rewind Button
        Image rwButtonImage = new Image(getClass().getResourceAsStream("Rewind.png"));
        Button rwButton = new Button();
        rwButton.setGraphic(new ImageView(rwButtonImage));
        rwButton.setStyle("-fx-background-color: Black");

        rwButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().divide(1.5));
        });

        rwButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            rwButton.setStyle("-fx-background-color: Black");
            rwButton.setStyle("-fx-body-color: Black");
        });

        rwButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            rwButton.setStyle("-fx-background-color: Black");
        });

        //////////////
        // End Button
        Image endButtonImage = new Image(getClass().getResourceAsStream("End.png"));
        Button endButton = new Button();
        endButton.setGraphic(new ImageView(endButtonImage));
        endButton.setStyle("-fx-background-color: Black");

        endButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.getTotalDuration();
            mediaPlayer.stop();
        });

        endButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            endButton.setStyle("-fx-background-color: Black");
            endButton.setStyle("-fx-body-color: Black");
        });

        endButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            endButton.setStyle("-fx-background-color: Black");
        });

        //////////////
        // Folder Button
        Image folderButtonImage = new Image(getClass().getResourceAsStream("Folder.png"));
        Button folderButton = new Button();
        folderButton.setGraphic(new ImageView(folderButtonImage));
        folderButton.setStyle("-fx-background-color: Black");

        folderButton.setOnAction((ActionEvent e) -> {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("all", "*.*"),
                    new FileChooser.ExtensionFilter("mp4", "*.mp4"),
                    new FileChooser.ExtensionFilter("flv", "*.flv"),
                    new FileChooser.ExtensionFilter("jpeg", "*.jpg"),
                    new FileChooser.ExtensionFilter("mp3", "*.mp3")
            );
            File file = fc.showOpenDialog(null);
            String path = file.getAbsolutePath();
            path = path.replace("\\", "/");
            media = new Media(new File(path).toURI().toString());
            mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            mediaView.setMediaPlayer(mediaPlayer);
        });

        folderButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            folderButton.setStyle("-fx-background-color: Black");
            folderButton.setStyle("-fx-body-color: Black");
        });

        folderButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            folderButton.setStyle("-fx-background-color: Black");
        });

        //////////////
        // Repeat Button
        Image repeatButtonImage = new Image(getClass().getResourceAsStream("Repeat.png"));
        Button repeatButton = new Button();
        repeatButton.setGraphic(new ImageView(repeatButtonImage));
        repeatButton.setStyle("-fx-background-color: Black");

        repeatButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.setOnEndOfMedia(new Runnable() {
                public void run() {
                    mediaPlayer.seek(Duration.ZERO);
                }
            });
            mediaPlayer.play();
        });

        repeatButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            repeatButton.setStyle("-fx-background-color: Black");
            repeatButton.setStyle("-fx-body-color: Black");
        });

        repeatButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            repeatButton.setStyle("-fx-background-color: Black");
        });

        //////////////
        // Skip to Start Button
        Image stsButtonImage = new Image(getClass().getResourceAsStream("Skip to Start.png"));
        Button stsButton = new Button();
        stsButton.setGraphic(new ImageView(stsButtonImage));
        stsButton.setStyle("-fx-background-color: Black");

        stsButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });

        stsButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            stsButton.setStyle("-fx-background-color: Black");
            stsButton.setStyle("-fx-body-color: Black");
        });

        stsButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            stsButton.setStyle("-fx-background-color: Black");
        });

        //////////////
        // Stop Button
        Image stopButtonImage = new Image(getClass().getResourceAsStream("Stop.png"));
        Button stopButton = new Button();
        stopButton.setGraphic(new ImageView(stopButtonImage));
        stopButton.setStyle("-fx-background-color: Black");

        stopButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.stop();
        });

        stopButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            stopButton.setStyle("-fx-background-color: Black");
            stopButton.setStyle("-fx-body-color: Black");
        });

        stopButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            stopButton.setStyle("-fx-background-color: Black");
        });

        //////////////
        // Stop Button
        Image fsButtonImage = new Image(getClass().getResourceAsStream("Fullscreen.png"));
        fsButton.setGraphic(new ImageView(fsButtonImage));
        fsButton.setStyle("-fx-background-color: Black");

        fsButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            fsButton.setStyle("-fx-background-color: Black");
            fsButton.setStyle("-fx-body-color: Black");
        });

        fsButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            fsButton.setStyle("-fx-background-color: Black");
        });

        time = new Label();
        time.setTextFill(Color.AQUAMARINE);
        time.setPrefWidth(80);

        mediaPlayer.currentTimeProperty().addListener((Observable ov) -> {
            updateValues();
        });

        mediaPlayer.setOnReady(() -> {
            duration = mediaPlayer.getMedia().getDuration();
            updateValues();
        });

        toolBar.getChildren().addAll(folderButton, stsButton, rwButton, playButton, pauseButton, ffButton, endButton, repeatButton, stopButton, time, fsButton);
        return toolBar;
    }

    protected void updateValues() {
        if (time != null) {
            runLater(() -> {
                Duration currentTime = mediaPlayer.getCurrentTime();
                time.setText(formatTime(currentTime, duration));

            });
        }
    }

    private static String formatTime(Duration elapsed, Duration duration) {

        if (elapsed.greaterThan(Duration.ZERO) && duration.greaterThan(Duration.ZERO)) {
            long duration_ms = (long) Math.floor(duration.toMillis());
            long elapsed_ms = (long) Math.floor(elapsed.toMillis());

            return String.format("%s%sof%s" , "Duration", milliToHourFormat(elapsed_ms), milliToHourFormat(duration_ms));
        } else {
            return "";
        }
    }

    private static String milliToHourFormat(long milliseconds) {
        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        StringBuffer sb = new StringBuffer();
        if (hours > 0) {
            sb.append(hours);
            sb.append(":");
        }
        if (minutes < 10) {
            sb.append("0");
            sb.append(minutes);
            sb.append(":");
        } else {
            sb.append(minutes);
            sb.append(":");
        }
        if (seconds < 10) {
            sb.append("0");
            sb.append(seconds);
        } else {
            sb.append(seconds);
        }
        return sb.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
