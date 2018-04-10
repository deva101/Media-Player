package sample;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import static sample.Controller_playlist.*;

public class Controller implements Initializable {
    // For Toggle button status...which button is active...(true for Play) and (false for Pause)
    private static boolean status = false;
    // Current music Pointer...
    private static int pointer = -1;
    private static double sound = 100;
    private static boolean full = false;
    // Containers
    @FXML
    private MenuBar menu;
    @FXML
    private VBox bottom;
    @FXML
    private BorderPane bpane;
    // Buttons
    @FXML
    private Button s;
    // For Video
    @FXML
    private MediaView mv;
    private Media me;
    private MediaPlayer mp;
    // For Volume Slider
    @FXML
    private Slider volume;
    // Sound Image icon(in Bottom Right)
    @FXML
    private ImageView imageView;
    // For Video Tracking (Video Progress Bar)
    @FXML
    private Slider video_bar;
    @FXML
    private TextField video_dur;
    // For Toggle Button
    @FXML
    private Button playpause;
    // Button to tell whether to loop current song or not
    @FXML
    private Button loop_btn;
    private boolean loop = true;
    // Keyboard Shortcut
    private boolean Mute = false;
    private double rate = 1;
    // Default Song (Initialize it first)
    private String path = new File("C:\\Users\\Devansh\\Videos\\abc.mp4").getAbsolutePath();

    public void initialize(URL location, ResourceBundle resources) {
        // Setting up Video Pane
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mv.setMediaPlayer(mp);

        mp.setAutoPlay(true);
        mp.setRate(rate);

        // Media Player's default Volume
        mp.setVolume(sound / 100);

        // Toggle Loop button
        loop_btn.setOnMouseClicked(event -> LoopToggle());

        // Aspect Ratio of Media Player
        DoubleProperty width = mv.fitWidthProperty();
        width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));

//        mv.setPreserveRatio(true);
        mv.minHeight(0);
        mv.minWidth(0);

        DoubleProperty height = mv.fitHeightProperty();
        height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));

        // Sound icon...Bottom Right
        Change_volume_button();

        // Video Duration
        mp.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            int millis = ((int) newTime.toMillis());
            TimeZone tz = TimeZone.getTimeZone("UTC");
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
            df.setTimeZone(tz);
            String time = df.format(new Date(millis));
            video_dur.setText(time);

        });

        //Video Progress Bar
        mp.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            if (!video_bar.isValueChanging()) {
                video_bar.setValue((newTime.toMillis() / video_bar.getMax()) * 100);
                video_bar.setValue((newTime.toMillis() / Max_Duration()) * 100);
            }
        });


        // Toggle Play and Pause Button
        playpause.setText("Pause");
        playpause.setOnMouseClicked(event -> {
            if (status) {
                status = false;
                mp.play();
                playpause.setText("Pause");
            } else {
                status = true;
                mp.pause();
                playpause.setText("Play");
            }
        });

        // Pause/Play on double Click
        bpane.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() == 2) {
                    FullScreen();
                }
            }
        });

        // Volume Button
        volume.setValue(mp.getVolume() * 100);
        volume.valueProperty().addListener(observable -> {
            // Set value of volume
            sound = volume.getValue();

            mp.setVolume(volume.getValue() / 100);

            // Change Volume button icon
            Change_volume_button();
        });

        // Play either next song or repeat same song
        mp.setOnEndOfMedia(() -> {
            Loop();
            Set_Default_Sound(sound);
        });

    }

    // Same functionality as 'initialize method'
    private void PlayRequestedSong(String location) {
        // Setting up Video Pane
        me = new Media(new File(location).toURI().toString());
        mp = new MediaPlayer(me);
        mv.setMediaPlayer(mp);

        mp.setAutoPlay(true);
        mp.setRate(rate);

        // Media Player's default Volume
        mp.setVolume(sound / 100);

        // Toggle Loop button
        loop_btn.setOnMouseClicked(event -> LoopToggle());


        // Aspect Ratio of Media Player
        DoubleProperty width = mv.fitWidthProperty();
        width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));

//        mv.setPreserveRatio(true);
        mv.minHeight(0);
        mv.minWidth(0);

        DoubleProperty height = mv.fitHeightProperty();
        height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));

        // Sound icon...Bottom Right
        Change_volume_button();

        // Video Duration
        mp.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            int millis = ((int) newTime.toMillis());
            TimeZone tz = TimeZone.getTimeZone("UTC");
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
            df.setTimeZone(tz);
            String time = df.format(new Date(millis));
            video_dur.setText(time);
        });

        //Video Progress Bar
        mp.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            if (!video_bar.isValueChanging()) {
                video_bar.setValue((newTime.toMillis() / video_bar.getMax()) * 100);
                video_bar.setValue((newTime.toMillis() / Max_Duration()) * 100);
            }
        });

        // Toggle Play and Pause Button
        playpause.setText("Pause");
        playpause.setOnMouseClicked(event -> {
            if (status) {
                status = false;
                mp.play();
                playpause.setText("Pause");
            } else {
                status = true;
                mp.pause();
                playpause.setText("Play");
            }
        });

        // Pause/Play on double Click
        bpane.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() == 2) {
                    FullScreen();
                }
            }
        });

        //Volume Button
        volume.setValue(sound);
        volume.valueProperty().addListener(observable -> {
            // Set value of volume
            sound = volume.getValue();

            mp.setVolume(sound / 100);

            // Change Volume button
            Change_volume_button();

        });

        // Play either next song or repeat same song
        mp.setOnEndOfMedia(() -> {
            Loop();
            Set_Default_Sound(sound);
        });

    }


    // Changes Volumn button on bottom right corner
    private void Change_volume_button() {
        // Change Volume button
        File file;

        if (sound == 0) {
            file = new File("src/icons/mute.png");
        } else if (sound > 50) {
            file = new File("src/icons/high.png");
        } else {
            file = new File("src/icons/med.png");
        }

        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    // Synchronise Video Bar...return maximum duration of currently playing video
    private double Max_Duration() {
        String s[] = mp.getStopTime().toString().split(" ");
        String d = "1";

        if (!s[0].equals("UNKNOWN"))
            d = String.valueOf(Math.round(Double.parseDouble(s[0]) + 1.0));

        return Double.parseDouble(d);
    }


    //####################### Buttons in VBox ###################################
    public void Pause_Play() {
        // Toggle Play and Pause Button
        if (mp != null) {
            if (status) {
                status = false;
                mp.play();
                playpause.setText("Pause");
            } else {
                status = true;
                mp.pause();
                playpause.setText("Play");
            }
        }


    }

    public void Previous(ActionEvent event) {
        // If more songs present 'behind' the current song
        if ((pointer - 1) > -1) {
            pointer--;

            // Initial Video to be played
            String path = getLocation(pointer);

            // Stop the song of previous instance
            Stop(event);

            PlayRequestedSong(path);

            // Set toggle button to Pause as autoplay is ON
            status = false;
            playpause.setText("Pause");
        }

    }

    public void Stop(ActionEvent event) {
        mp.stop();

        // Set toggle button to Play as video is paused
        status = true;
        playpause.setText("Play");
    }

    public void Next(ActionEvent event) {
        // If more songs present 'ahead' of current song
        if ((pointer + 1) < Controller_playlist.getListsize()) {
            pointer++;

            // Location of next video to be played
            String path = getLocation(pointer);

            Stop(event);

            // Play next Video
            PlayRequestedSong(path);

            // Set toggle button to Pause as autoplay is ON
            status = false;
            playpause.setText("Pause");
        }

    }


    public void FullScreen() {
        // Toggle the value of static variable 'full'
        full = !full;

        // Maximize or not based on 'full' variable's value
//        Main.window.setFullScreen(Controller.full);
        Main.window.setMaximized(Controller.full);

    }

    public void Playlistfun() throws IOException {
        // Load new Scene for Playlist
        new Main().load_playlist();
    }

    private void LoopToggle() {
        // Toggle the value of variable 'loop'...to check whether to loop current song or not
        loop = !loop;
    }

    private void Loop() {
        // if value of 'loop' is true, song is looped again
        if (loop) {
            mp.seek(Duration.ZERO);
        } else {
            Next(null);
        }
    }

    private void Set_Default_Sound(double vol) {
        // Sound value is to be maintained on changing the video
        volume.setValue(vol * 100);
    }

    public void Random() {
        // Shuffle the Playlist
        Collections.shuffle(Controller_playlist.getLists());
    }


    //####################### Menu Bar ###################################
    // Selecting multiple songs to be played
    public void Multiple() {
        FileChooser fc = new FileChooser();
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);

        if (selectedFiles != null) {
            for (int i = 0; i < selectedFiles.size(); i++) {
                getLists().add(new playlist((getListsize() + 1), selectedFiles.get(i).getName(), selectedFiles.get(i).getPath(), (int) selectedFiles.get(i).getTotalSpace()));
                setListsize(getListsize() + 1);
            }
        }
    }

    // Saving songs in 'playlist.ser'
    public void Save() throws IOException {
        // Serialization
        try {
            // write object to file
            FileOutputStream fos = new FileOutputStream("playlist.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (playlist temp : Controller_playlist.getLists()) {
                oos.writeUTF(temp.getName1());
                oos.writeUTF(temp.getPath1());
                oos.writeInt(temp.getSize1());
            }
            // Marker to tell end of file
            oos.writeUTF("EOF");

            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error during Serialization...");
        }

        System.out.println("File Successfully Serialized");
    }

    // Load songs from 'playlist.ser'
    public void Load() throws IOException {
        // Deserialization
        FileInputStream fis = new FileInputStream("playlist.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        playlist p;
        String a2;
        while (!(a2 = ois.readUTF()).equals("EOF")) {
            // get the value
            int a1 = Controller_playlist.getListsize() + 1;
            String a3 = ois.readUTF();
            int a4 = ois.readInt();

            // set values obtained in variable p
            p = new playlist(a1, a2, a3, a4);

            // add value in List
            Controller_playlist.getLists().add(p);

            // Increase size of playlist
            Controller_playlist.listsize++;
        }

        System.out.println("File Deserialized");
    }

    // Close the application
    public void Close() {
        Platform.exit();
        System.exit(0);
    }

    // About us page
    public void About() throws IOException {
        new Main().load_about();
    }


    //####################### Keyboard Shortcuts ###################################
    public void ShortCut(javafx.scene.input.KeyEvent event) {
//            System.out.println(event.getCode());

        switch (event.getCode()) {
            // For Muting
            case M:
                Mute = !Mute;
                if (Mute) {
                    sound = 0;
                    mp.setVolume(sound);
                    Change_volume_button();
                    volume.setValue(sound);
                } else {
                    sound = 100;
                    mp.setVolume(sound / 100);
                    Change_volume_button();
                    volume.setValue(sound);
                }
                break;

            // To increase speed...MAX = 2.0
            case CLOSE_BRACKET:
                if ((rate + 0.1) <= 2.0)
                    rate += 0.1;

                mp.setRate(rate);
                break;

            // To decrease the speed...MAX = 0+
            case OPEN_BRACKET:
                if ((rate - 0.1) > 0.0)
                    rate -= 0.1;

                mp.setRate(rate);
//                    System.out.println(rate);
                break;

            // For Full Screen Mode
            case F:
                FullScreen();
                break;

        }

    }

}
