package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.commons.clientmessages.ModeChoseClient;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WinController extends DefaultController {

    @FXML
    public Button Spectator;

    @FXML
    public Button NewGame;

    @FXML
    public AnchorPane anchorWin;

    @FXML
    @Override
    public void initialize() {
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        setBackground(new Image("/it.polimi.ingsw/view/gui/img/scene/win.png"));

        int x=125, y=71;

        Spectator.setMinSize(x,y);
        Spectator.setMaxSize(x,y);
        Spectator.setPrefSize(x,y);
        NewGame.setMinSize(x,y);
        NewGame.setMaxSize(x,y);
        NewGame.setPrefSize(x,y);
    }

    public void spectator(ActionEvent actionEvent) {
        this.gui.getWin().close();
    }

    public void newgame(ActionEvent actionEvent) {
        this.gui.getClient().resetMatch();
        this.gui.getWin().close();
        Platform.runLater(() -> {
            this.gui.getPrimaryStage().setScene(this.gui.load("/it.polimi.ingsw/view/gui/fxml/Mode.fxml"));
            this.gui.getPrimaryStage().show();
        });
        //this.gui.getClient().sendMessage(new ModeChoseClient(gui.getClient().getUsername(),Integer.parseInt(text)));
    }

    @Override
    public void setBackground(Image image){
        anchorWin.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, BackgroundSize.AUTO, true, false, true, true))));
    }
}