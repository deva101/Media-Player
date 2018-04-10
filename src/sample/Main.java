package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    // Save reference of 'main Stage'
    public static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        Scene scene_main = new Scene(root, 600, 450);
        primaryStage.setScene(scene_main);
        primaryStage.setTitle("DV Player");

        // Add this line for logo
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("../icons/main.png")));

        primaryStage.show();

    }

    // Loading the Playlist
    public void load_playlist() throws IOException {
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("playlist.fxml"));
        primaryStage.setTitle("Playlist");
        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.show();
    }

    // Loading About us page
    public void load_about() throws IOException {
        Stage ps = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        Scene scene = new Scene(root, 369, 391);
        ps.setTitle("About Us");
        ps.initModality(Modality.APPLICATION_MODAL);
        ps.setScene(scene);

        // Set styling
        scene.getStylesheets().clear();
        scene.getStylesheets().add("https://ssl.gstatic.com/docs/script/css/add-ons1.css");

        ps.showAndWait();

    }
}
