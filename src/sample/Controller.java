package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.Metods.ActionChain;
import sample.Metods.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ActionChain action = null;
    @FXML
    ImageView view;
    Player player1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        view.setImage(new Image("монетка.png"));
        view.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (action == null) return;
            if (action.process()) {
                init();
            }
            else action = null;
        });
    }
    public void onPay(ActionEvent actionEvent) {
        player1.addNumber(1);
    }


    public void onStart(ActionEvent actionEvent) {
        if(!init()) return;
        view.setImage(new Image("мешочки.png"));
        action=new ActionChain();
    }

    public boolean init(){
        if(! player1.pay(1)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Средств на счете недостаточно, еще монетку плисс!");
            alert.show();
            action=null;
            view.setImage(new Image("монетка.jpg"));
            return false;
        }
        else return true;
    }
}
