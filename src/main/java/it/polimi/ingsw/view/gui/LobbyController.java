package it.polimi.ingsw.view.gui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;

public class LobbyController extends DefaultController {



    @FXML
    @Override
    public void initialize(){
        super.initialize();
        super.setBackground(new Image("/it.polimi.ingsw/view/gui/img/scene/bg_lobby.png"));

        buttonHelper.setVisible(false);
    }
}