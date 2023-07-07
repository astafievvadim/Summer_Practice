package javaFX;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logicPackage.Data;
import logicPackage.Result;
import logicPackage.SimpleLogicFirstVersion;

import java.text.ParseException;

public class MainController {
    public TableView<Result> table = new TableView<Result>();
    public Label timeSet;
    public Label valueSet;
    public TableColumn<Result, String> satellite = new TableColumn<>("satellite");
    public TableColumn<Result, String> station = new TableColumn<>("station");
    public TableColumn<Result, String> point = new TableColumn<>("point");
    public TableColumn<Result, String> timeWindow = new TableColumn<>("timeWindow");
    public TableColumn<Result, String> time = new TableColumn<>("time");
    public TableColumn<Result, String> value = new TableColumn<>("value");

    @FXML
    public void initialize() {
        initializeTableView();

    }
    public void StartButtonPressed(ActionEvent event) throws ParseException {

        Data data = new Data();
        SimpleLogicFirstVersion da = new SimpleLogicFirstVersion(data);
        ObservableList<Result> temp = da.getResult();

        timeSet.setText(Double.toString(da.getWastedTime()));
        valueSet.setText(Double.toString(da.getReceivedValue()));

        table.setItems(temp);


    }

    private void initializeTableView(){
        value.setCellValueFactory(new PropertyValueFactory<Result, String>("value"));
        time.setCellValueFactory(new PropertyValueFactory<Result, String>("time"));
        timeWindow.setCellValueFactory(new PropertyValueFactory<Result, String>("timeWindow"));
        point.setCellValueFactory(new PropertyValueFactory<Result, String>("point"));
        satellite.setCellValueFactory(new PropertyValueFactory<Result, String>("satellite"));
        station.setCellValueFactory(new PropertyValueFactory<Result, String>("station"));
    }
}
