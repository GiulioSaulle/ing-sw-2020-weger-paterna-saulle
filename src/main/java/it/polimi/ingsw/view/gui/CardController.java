package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.commons.clientmessages.PlayerChoseClient;
import it.polimi.ingsw.model.cards.CardName;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.util.List;

public class CardController extends DefaultController {

    public Button button1;
    public Button button2;
    public Button button3;
    public Button buttonSend;

    @FXML
    public Button buttonSelected1;

    @FXML
    public Button buttonSelected2;

    @FXML
    public Button buttonSelected3;

    @FXML
    public Button buttonGod1;

    @FXML
    public Button buttonGod2;

    @FXML
    public Button buttonGod3;

    public TextArea textAreaDescription;
    public TextField textFieldName1;
    public TextField textFieldName2;
    public TextField textFieldName3;

    public CardName cardName;

    public List<CardName> cards;

    @FXML
    @Override
    public void initialize(){
        super.initialize();
        super.setBackground(new Image("/it.polimi.ingsw/view/gui/img/scene/bg_card.png"));

        buttonSend.setDisable(true);
        buttonSend.setVisible(false);

        double w = 170;
        double h = 180;
        buttonSelected1.setPrefSize(w,88);
        buttonSelected2.setPrefSize(w,88);
        buttonSelected3.setPrefSize(w,88);

        buttonSend.setPrefSize(150,42);

        w = 185;
        buttonGod1.setMinSize(w,h);
        buttonGod1.setMaxSize(w,h);
        buttonGod1.setPrefSize(w,h);
        buttonGod2.setMinSize(w,h);
        buttonGod2.setMaxSize(w,h);
        buttonGod2.setPrefSize(w,h);
        buttonGod3.setMinSize(w,h);
        buttonGod3.setMaxSize(w,h);
        buttonGod3.setPrefSize(w,h);

        buttonSend.setMinSize(154,88);
        buttonSend.setMaxSize(154,88);
        buttonSend.setPrefSize(154,88);

        buttonGod1.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            setPodium(buttonSelected1,newValue,0);
        });
        buttonSelected1.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            setPodium(buttonSelected1,newValue,0);
        });
        buttonGod2.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            setPodium(buttonSelected2,newValue,1);
        });
        buttonSelected2.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            setPodium(buttonSelected2,newValue,1);
        });
        buttonGod3.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            setPodium(buttonSelected3,newValue,2);
        });
        buttonSelected3.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            setPodium(buttonSelected3,newValue,2);
        });

        textAreaDescription.setFont(f);
        textAreaDescription.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                textAreaDescription.setFont(f);
            }
        });

        textFieldName1.setMinSize(180,48);
        textFieldName1.setMaxSize(180,48);
        textFieldName1.setPrefSize(180,48);
        textFieldName1.setEditable(false);
        textFieldName2.setMinSize(180,48);
        textFieldName2.setMaxSize(180,48);
        textFieldName2.setPrefSize(180,48);
        textFieldName2.setEditable(false);
        textFieldName3.setMinSize(180,48);
        textFieldName3.setMaxSize(180,48);
        textFieldName3.setPrefSize(180,48);
        textFieldName3.setEditable(false);

        setUpTextField(textFieldName1);
        setUpTextField(textFieldName2);
        setUpTextField(textFieldName3);

        buttonSend.setMinSize(154,88);
        buttonSend.setMaxSize(154,88);
        buttonSend.setPrefSize(154,88);
    }

    @Override
    public void setup(){
        super.setup();
        int y = 25;

        textFieldName1.setLayoutY(10);
        textFieldName2.setLayoutY(10);
        textFieldName3.setLayoutY(10);

        if(gui.getClient().getPlayers().size() == 3){
            int offset = 0;
            buttonSelected1.setLayoutX(gui.sceneWidth/4 - buttonSelected1.getPrefWidth()/2+offset);
            buttonSelected2.setLayoutX(gui.sceneWidth/2 - buttonSelected2.getPrefWidth()/2);
            buttonSelected3.setLayoutX(3*gui.sceneWidth/4 - buttonSelected3.getPrefWidth()/2-offset);

            buttonGod1.setLayoutX(gui.sceneWidth/4 - buttonGod1.getPrefWidth()/2+offset);
            buttonGod2.setLayoutX(gui.sceneWidth/2 - buttonGod2.getPrefWidth()/2);
            buttonGod3.setLayoutX(3*gui.sceneWidth/4 - buttonGod3.getPrefWidth()/2-offset);

            textFieldName1.setLayoutX(gui.sceneWidth/4 - textFieldName1.getPrefWidth()/2+offset);
            textFieldName2.setLayoutX(gui.sceneWidth/2 - textFieldName2.getPrefWidth()/2);
            textFieldName3.setLayoutX(3*gui.sceneWidth/4 - textFieldName3.getPrefWidth()/2-offset);
        } else if(gui.getClient().getPlayers().size() == 2){
            int offset = 0;
            buttonSelected1.setLayoutX(gui.sceneWidth/3 - buttonSelected1.getPrefWidth()/2+offset);
            buttonSelected2.setLayoutX(2*gui.sceneWidth/3 - buttonSelected2.getPrefWidth()/2-offset);
            buttonSelected3.setVisible(false);

            buttonGod1.setLayoutX(gui.sceneWidth/3 - buttonGod1.getPrefWidth()/2+offset);
            buttonGod2.setLayoutX(2*gui.sceneWidth/3 - buttonGod2.getPrefWidth()/2-offset);
            buttonGod3.setVisible(false);

            textFieldName1.setLayoutX(gui.sceneWidth/3 - textFieldName1.getPrefWidth()/2+offset);
            textFieldName2.setLayoutX(2*gui.sceneWidth/3 - textFieldName2.getPrefWidth()/2-offset);
            textFieldName3.setVisible(false);
        }
        buttonSelected1.setLayoutY(425-225);
        buttonSelected2.setLayoutY(425-225);
        buttonSelected3.setLayoutY(425-225);
        buttonGod1.setLayoutY(282-225);
        buttonGod2.setLayoutY(282-225);
        buttonGod3.setLayoutY(282-225);

        buttonSend.setLayoutY(425);
        buttonSend.setLayoutX(gui.sceneWidth/2-buttonSend.getPrefWidth()/2);

        textAreaDescription.setMinSize(gui.sceneWidth-200,130);
        textAreaDescription.setMaxSize(gui.sceneWidth-200,130);
        textAreaDescription.setPrefSize(gui.sceneWidth-200,130);
        textAreaDescription.setLayoutY(285);
        textAreaDescription.setLayoutX(100);

        buttonSend.setVisible(false);
        buttonSend.setDisable(true);

        buttonSend.setLayoutY(425);
        buttonSend.setLayoutX(gui.sceneWidth/2-buttonSend.getPrefWidth()/2);
    }

    public void setGods(){
        buttonGod1.getStyleClass().clear();
        buttonGod2.getStyleClass().clear();
        buttonGod3.getStyleClass().clear();
        for(int i = 0; i < cards.size(); i++){
            switch (i){
                case  0:
                    buttonGod1.getStyleClass().addAll("button",cards.get(i).toString().toLowerCase());
                    textFieldName1.setText(cards.get(0).toString());
                    break;
                case  1:
                    buttonGod2.getStyleClass().addAll("button",cards.get(i).toString().toLowerCase());
                    textFieldName2.setText(cards.get(1).toString());
                    break;
                case  2:
                    buttonGod3.getStyleClass().addAll("button",cards.get(i).toString().toLowerCase());
                    textFieldName3.setText(cards.get(2).toString());
                    break;
                default:
                    break;
            }
        }
    }

    public void setPodium(Button b, boolean newValue, int j){
        String[] splitted;
        if (newValue) {
            b.getStyleClass().clear();
            b.getStyleClass().addAll("button","podiumGold");

            splitted = (cards.get(j).getDescription()).split(" ");
        } else if (cardName == null) {
            b.getStyleClass().clear();
            b.getStyleClass().addAll("button","podium");

            splitted = "".split(" ");
        }else if(!cards.get(j).toString().equals(cardName.toString())) {
            b.getStyleClass().clear();
            b.getStyleClass().addAll("button","podium");

            splitted = (cardName.getDescription()).split(" ");
        }
        else splitted = (cardName.getDescription()).split(" ");

        String desc = "";
        int cc = 0;
        for(int i=0; i<splitted.length; i++){
            cc += splitted[i].length();
            desc += splitted[i];
            if(cc > 60){
                cc = 0;
                desc += (i+1 == splitted.length ? "" : "\n");
            } else desc += " ";
        }
        textAreaDescription.setText(desc);
    }

    public void setGod1(ActionEvent actionEvent) {
        cardName = cards.get(0);
        buttonSend.setVisible(true);
        buttonSend.setDisable(false);
        buttonSelected2.getStyleClass().clear();
        buttonSelected2.getStyleClass().addAll("button","podium");
        buttonSelected3.getStyleClass().clear();
        buttonSelected3.getStyleClass().addAll("button","podium");
    }

    public void setGod2(ActionEvent actionEvent) {
        cardName = cards.get(1);
        buttonSend.setVisible(true);
        buttonSend.setDisable(false);
        buttonSelected3.getStyleClass().clear();
        buttonSelected3.getStyleClass().addAll("button","podium");
        buttonSelected1.getStyleClass().clear();
        buttonSelected1.getStyleClass().addAll("button","podium");
    }

    public void setGod3(ActionEvent actionEvent) {
        cardName = cards.get(2);
        buttonSend.setVisible(true);
        buttonSend.setDisable(false);
        buttonSelected2.getStyleClass().clear();
        buttonSelected2.getStyleClass().addAll("button","podium");
        buttonSelected1.getStyleClass().clear();
        buttonSelected1.getStyleClass().addAll("button","podium");

    }

    public void sendOnAction(ActionEvent actionEvent) {
        if(cardName != null)
            gui.getClient().sendMessage(new PlayerChoseClient(gui.getClient().getUsername(), cardName));
    }
}