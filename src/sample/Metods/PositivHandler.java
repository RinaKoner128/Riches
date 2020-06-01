package sample.Metods;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import static sample.Metods.ActionChain.SUCCESS;

public class PositivHandler extends Handler {

    public PositivHandler(Handler processor) {
        super(processor);
    }

    public boolean process(Integer request) {
        if (request != SUCCESS) {
            return super.process(request);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы победили!!!");
            alert.setHeaderText("Победа!!!");

            ButtonType replay = new ButtonType("Продолжить играть", ButtonBar.ButtonData.YES);
            ButtonType vacation = new ButtonType("Отдохнуть", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(replay, vacation);
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().getButtonData() == ButtonBar.ButtonData.YES)
                return true;
            else
                return false;
        }
    }
}