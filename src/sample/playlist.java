package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class playlist implements Serializable {
    // Column to be used in TableView
    private SimpleIntegerProperty id1;
    private SimpleStringProperty name1;
    private SimpleStringProperty path1;
    private SimpleIntegerProperty size1;

    // Constructor
    playlist(Integer ids, String names, String paths, int sizes) {
        this.id1 = new SimpleIntegerProperty(ids);
        this.name1 = new SimpleStringProperty(names);
        this.path1 = new SimpleStringProperty(paths);
        this.size1 = new SimpleIntegerProperty(sizes);
    }

    // Get Song id
    public Integer getId1() {
        return id1.get();
    }

    // Get Song Name
    public String getName1() {
        return name1.get();
    }

    // Get Song Path
    public String getPath1() {
        return path1.get();
    }

    // Get Song Size
    public Integer getSize1() {
        return size1.get();
    }

    public String toString() {
        return "ID:" + id1 + "\nName:" + name1 + "\nPath:" + path1 + "\nSize:" + size1 + "\n";
    }

}