package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_playlist implements Initializable {
    // Size of list...number of entries present in list
    public static int listsize = 0;
    // List in which song details are stored
    private static ObservableList<playlist> lists = FXCollections.observableArrayList();
    // For Playlist
    @FXML
    private TableView<playlist> table;
    @FXML
    private TableColumn<playlist, Integer> id1;
    @FXML
    private TableColumn<playlist, String> name1;
    @FXML
    private TableColumn<playlist, String> path1;
    @FXML
    private TableColumn<playlist, Integer> size1;

    public static ObservableList<playlist> getLists() {
        return lists;
    }

    public static void setLists(ObservableList<playlist> list) {
        lists = list;
    }

    public static int getListsize() {
        return listsize;
    }

    static void setListsize(int listsize) {
        Controller_playlist.listsize = listsize;
    }


    // Get path of Song
    static String getLocation(int index) {
        return String.valueOf(lists.get(index).getPath1());
    }

    // Get Id of song
    public static String getId(int index) {
        return String.valueOf(lists.get(index).getId1());
    }

    // List Initialization code
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id1.setCellValueFactory(new PropertyValueFactory<>("id1"));
        name1.setCellValueFactory(new PropertyValueFactory<>("name1"));
        path1.setCellValueFactory(new PropertyValueFactory<>("path1"));
        size1.setCellValueFactory(new PropertyValueFactory<>("size1"));

        table.setItems(lists);

    }


}
