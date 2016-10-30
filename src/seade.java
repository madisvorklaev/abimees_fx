/*
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public static class seade {
    private final SimpleStringProperty tootja;
    private final SimpleStringProperty nimi;
    private double voolutarve;
    private int kanaleid;
    ArrayList tableData = new ArrayList();

    kasutajaliides Kasutajaliides = new kasutajaliides();
    int SeadmeKogus = Kasutajaliides.seadmeKogus();
    String SeadmeNimi = Kasutajaliides.seadmeNimi();

    private seade(String manuf, String name, double power, int chan) {
        this.tootja = new SimpleStringProperty(manuf);
        this.nimi = new SimpleStringProperty(name);
        this.voolutarve = new power;
        this.kanaleid = new chan;
    }

    public String getTootja() {
        return tootja.get();
    }
    public void setTootja(String manuf) {
        tootja.set(manuf);
    }

    public String getNimi() {
        return nimi.get();
    }
    public void setNimi(String name) {
        nimi.set(name);
    }

    public Double getVoolutarve() {
        return voolutarve.get();
    }
    public void setVoolutarve(Double power) {
        voolutarve.set(power);
    }
    public Double getVoolutarve() {
        return voolutarve.get();
    }

    public void setKanaleid(int chan) {
        kanaleid.set(chan);
    }

    public void makeArrayList() {
        for (int i = 0; i < SeadmeKogus; i++) {
            tableData.add(SeadmeNimi);
        }
    }

    final ObservableList<seade> tableData = FXCollections.observableArrayList(

            new seade("Jacob", "Smith", "jacob.smith@example.com")
                );

}
*/