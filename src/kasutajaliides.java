/* http://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
   http://docs.oracle.com/javafx/2/ui_controls/table-view.htm
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;

public class kasutajaliides extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    /*
        andmebaas Andmebaas = new andmebaas();
        Andmebaas.createDatabase();
        Andmebaas.openFile();
        Andmebaas.readFile();
        Andmebaas.closeFile();
        ArrayList NimiAndmebaasist = Andmebaas.nimiAndmebaasist
        */

    // Nupud - tekstiväljad
    final Button button = new Button("Lisa");
    final TextField vool = new TextField("");
    final TextField kanaleid = new TextField("");
    final TextField seadmeid = new TextField("1");
    private TableView patch = new TableView();



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Java projekt 1.0");
        Scene scene = new Scene(new Group());
        primaryStage.setWidth(500);
        primaryStage.setHeight(700);

        // Drop-down menüüd
        final ComboBox tootjaComboBox = new ComboBox();
                tootjaComboBox.getItems().addAll(
                        "tootjaAndmebaasist1",
                        "tootjaAndmebaasist2"
                );
        final ComboBox seadmeComboBox = new ComboBox();
               // seadmeComboBox.setItems(NimiAndmebaasist);
                seadmeComboBox.getItems().addAll(
                         "nimiAndmebaasist1",
                         "nimiAndmebaasist2"
        );

        // Tabeli pealkiri
        final Label label = new Label("Patch list");
        label.setFont(new Font("Arial", 16));

        // Tabel
        patch.setEditable(false);

        TableColumn jrk = new TableColumn("Nr");
        TableColumn seadmeNimi = new TableColumn("Seadme nimi");
        TableColumn aadress = new TableColumn("Aadress");

        patch.getColumns().addAll(jrk, seadmeNimi, aadress);

        //Layout
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Vali tootja: "), 0, 0);
        grid.add(tootjaComboBox, 0, 1);
        grid.add(new Label("Vali seade: "), 0, 2);
        grid.add(seadmeComboBox, 0, 3);
        grid.add(new Label("Mitu seadet: "), 0, 4);
        grid.add(seadmeid, 0, 5);
        grid.add(button, 1, 5);
        grid.add(label, 0, 7);
        grid.add(patch, 0, 8);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}