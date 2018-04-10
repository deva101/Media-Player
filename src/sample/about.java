package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class about implements Initializable {
    @FXML
    ScrollPane lbl;
    @FXML
    Hyperlink fb;
    @FXML
    Button license;
    @FXML
    Button youtube;

    // false means 'label' has default text
    private boolean license_lbl = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Text t = new Text("When history reaches a turning point, there are those who watch and those who act. We at YourStory are both observers and participants in the making of new economic history. The purpose of our existence is to evaluate, expound and showcase the awesome spark of creation in every entrepreneur and changemaker.\n" +
                "\n" +
                "Our passion for entrepreneurship and its resounding global resonance is only matched by the zeal to bring our peers onto a single platform for a free-flowing exchange of ideas and visions. We work from all over India to bring the best and the brightest entrepreneurs into the limelight they deserve");
        lbl.setContent(t);
    }


    // Link to our fb page
    public void fb_link(ActionEvent e) {

        fb.setOnAction(t -> {
            Application app = new Application() {
                @Override
                public void start(Stage primaryStage) {

                }
            };

            app.getHostServices().showDocument("https://eclipse.org");
        });

    }

    // License to be written in label
    public void license_fun() {
        Text t;
        license_lbl = !license_lbl;

        if (!license_lbl) {
            t = new Text("When history reaches a turning point, there are those who watch and those who act. We at YourStory are both observers and participants in the making of new economic history. The purpose of our existence is to evaluate, expound and showcase the awesome spark of creation in every entrepreneur and changemaker.\n" +
                    "\n" +
                    "Our passion for entrepreneurship and its resounding global resonance is only matched by the zeal to bring our peers onto a single platform for a free-flowing exchange of ideas and visions. We work from all over India to bring the best and the brightest entrepreneurs into the limelight they deserve");

            license.setText("License");
        } else {

            t = new Text("                    GNU GENERAL PUBLIC LICENSE\n" +
                    "                       Version 1, April 2018\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed condimentum, dui quis pharetra tincidunt, purus mi vestibulum neque, in placerat quam eros at mi. Duis luctus, odio vitae pharetra lacinia, nulla mauris porta mauris, ut condimentum sem justo quis justo. Mauris nibh nisi, commodo at sapien non, ultricies gravida justo. Vestibulum vestibulum odio at accumsan condimentum. Duis a lacinia ipsum. In non ex ante. Nam sit amet aliquet elit. Fusce ex mauris, porta in lacus quis, malesuada malesuada elit. Etiam sodales leo vitae viverra luctus. Proin euismod nunc nisi, in sodales quam sagittis in. Suspendisse eget consectetur libero, tristique aliquam odio. Nam ante lorem, ultrices nec tellus a, accumsan fringilla dui. In facilisis rhoncus ipsum. Ut euismod diam eget fringilla mattis. Vestibulum ac mi dolor.\n" +
                    "\n" +
                    "Etiam volutpat molestie ornare. Integer aliquet enim lobortis, placerat sem vel, efficitur sapien. Sed eu rhoncus lorem. Aliquam molestie sagittis nibh, eget imperdiet nisl eleifend non. Suspendisse tristique quam quis nisi consectetur aliquam. Curabitur sed sagittis tellus. Phasellus ut lacus ac lorem lobortis dignissim vitae quis felis. Donec at urna luctus, laoreet lorem sed, dictum lacus. In vel massa ut ante tempus molestie ac at eros. Maecenas a nibh sit amet nunc sollicitudin laoreet. Sed dignissim imperdiet iaculis. Nam eget neque non ex molestie cursus a sit amet massa. Ut at congue orci, non euismod urna.\n" +
                    "\n" +
                    "Proin accumsan posuere dapibus. Nulla tincidunt rhoncus blandit. Aliquam fermentum feugiat velit, eu laoreet leo tempus sed. Nullam pulvinar interdum ipsum sed venenatis. Nunc vitae gravida felis. Duis ullamcorper lacus vitae lacus blandit ultrices. Pellentesque elit ligula, semper id maximus sed, lobortis a lectus. Morbi ultrices ut lorem non viverra. Proin eget mi mi. Donec nisi quam, porttitor et magna nec, lacinia convallis urna. Etiam efficitur elit nisi, sit amet posuere orci finibus nec. Donec pulvinar eros sed pellentesque tempus. Nunc quis turpis justo.\n" +
                    "\n" +
                    "Aenean et volutpat nunc. Pellentesque commodo eget mi nec venenatis. Aliquam ante libero, finibus ac consequat vitae, consequat id eros. Fusce luctus enim eget sem laoreet, in viverra quam gravida. Praesent placerat nunc ac urna ornare, nec pulvinar turpis condimentum. Nulla semper, velit a tincidunt imperdiet, metus nisi porta risus, sed facilisis purus risus id odio. Donec tempor vitae elit vitae accumsan. Quisque sollicitudin mauris non nulla ornare, facilisis facilisis elit pretium. Curabitur pretium varius bibendum.\n" +
                    "\n" +
                    "Proin et molestie felis. Mauris tempor enim nulla, vitae volutpat tellus feugiat id. Nullam bibendum, dolor nec vehicula iaculis, arcu metus sollicitudin sem, et tincidunt dolor justo eget velit. Suspendisse ut elit ligula. Phasellus a elit in nunc pellentesque rutrum nec non orci. Vestibulum ac nisi sodales sapien placerat gravida id vel lacus. Aenean eget orci fringilla, condimentum arcu a, pellentesque urna. \n" +
                    "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed condimentum, dui quis pharetra tincidunt, purus mi vestibulum neque, in placerat quam eros at mi. Duis luctus, odio vitae pharetra lacinia, nulla mauris porta mauris, ut condimentum sem justo quis justo. Mauris nibh nisi, commodo at sapien non, ultricies gravida justo. Vestibulum vestibulum odio at accumsan condimentum. Duis a lacinia ipsum. In non ex ante. Nam sit amet aliquet elit. Fusce ex mauris, porta in lacus quis, malesuada malesuada elit. Etiam sodales leo vitae viverra luctus. Proin euismod nunc nisi, in sodales quam sagittis in. Suspendisse eget consectetur libero, tristique aliquam odio. Nam ante lorem, ultrices nec tellus a, accumsan fringilla dui. In facilisis rhoncus ipsum. Ut euismod diam eget fringilla mattis. Vestibulum ac mi dolor.\n" +
                    "\n" +
                    "Etiam volutpat molestie ornare. Integer aliquet enim lobortis, placerat sem vel, efficitur sapien. Sed eu rhoncus lorem. Aliquam molestie sagittis nibh, eget imperdiet nisl eleifend non. Suspendisse tristique quam quis nisi consectetur aliquam. Curabitur sed sagittis tellus. Phasellus ut lacus ac lorem lobortis dignissim vitae quis felis. Donec at urna luctus, laoreet lorem sed, dictum lacus. In vel massa ut ante tempus molestie ac at eros. Maecenas a nibh sit amet nunc sollicitudin laoreet. Sed dignissim imperdiet iaculis. Nam eget neque non ex molestie cursus a sit amet massa. Ut at congue orci, non euismod urna.\n" +
                    "\n" +
                    "Proin accumsan posuere dapibus. Nulla tincidunt rhoncus blandit. Aliquam fermentum feugiat velit, eu laoreet leo tempus sed. Nullam pulvinar interdum ipsum sed venenatis. Nunc vitae gravida felis. Duis ullamcorper lacus vitae lacus blandit ultrices. Pellentesque elit ligula, semper id maximus sed, lobortis a lectus. Morbi ultrices ut lorem non viverra. Proin eget mi mi. Donec nisi quam, porttitor et magna nec, lacinia convallis urna. Etiam efficitur elit nisi, sit amet posuere orci finibus nec. Donec pulvinar eros sed pellentesque tempus. Nunc quis turpis justo.\n" +
                    "\n" +
                    "Aenean et volutpat nunc. Pellentesque commodo eget mi nec venenatis. Aliquam ante libero, finibus ac consequat vitae, consequat id eros. Fusce luctus enim eget sem laoreet, in viverra quam gravida. Praesent placerat nunc ac urna ornare, nec pulvinar turpis condimentum. Nulla semper, velit a tincidunt imperdiet, metus nisi porta risus, sed facilisis purus risus id odio. Donec tempor vitae elit vitae accumsan. Quisque sollicitudin mauris non nulla ornare, facilisis facilisis elit pretium. Curabitur pretium varius bibendum.\n" +
                    "\n" +
                    "Proin et molestie felis. Mauris tempor enim nulla, vitae volutpat tellus feugiat id. Nullam bibendum, dolor nec vehicula iaculis, arcu metus sollicitudin sem, et tincidunt dolor justo eget velit. Suspendisse ut elit ligula. Phasellus a elit in nunc pellentesque rutrum nec non orci. Vestibulum ac nisi sodales sapien placerat gravida id vel lacus. Aenean eget orci fringilla, condimentum arcu a, pellentesque urna. ");

            license.setText("Default Message");
        }
        lbl.setFitToWidth(true);
        lbl.setContent(t);

        t.setStyle("-fx-font: normal bold 20px 'serif' ");
    }

    // Link to our Youtube page
    public void youtube_link() {
        youtube.setOnAction(t -> {
            Application app = new Application() {
                @Override
                public void start(Stage primaryStage) {

                }
            };

            app.getHostServices().showDocument("https://eclipse.org");
        });


    }


}
