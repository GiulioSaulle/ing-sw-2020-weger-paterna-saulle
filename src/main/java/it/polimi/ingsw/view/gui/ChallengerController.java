package it.polimi.ingsw.view.gui;

import it.polimi.ingsw.commons.clientmessages.ChallengerChoseClient;
import it.polimi.ingsw.model.cards.Card;
import it.polimi.ingsw.model.cards.CardName;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChallengerController extends DefaultController {

    @FXML
    public ImageView imageViewCard;

    @FXML
    public Button buttonRight;

    @FXML
    public Button buttonLeft;

    @FXML
    public ImageView imageViewFrame;

    @FXML
    public TextArea textAreaDescription;

    @FXML
    public Button buttonAccept;

    @FXML
    public TextField textFieldName;

    @FXML
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

    @FXML
    public Button buttonClear;

    public List<CardName> cards;

    int count = 0;

    List<CardName> selected;

    @FXML
    @Override
    public void initialize(){
        super.initialize();
        super.setBackground(new Image("/it.polimi.ingsw/view/gui/img/scene/bg_card.png"));
        cards = Arrays.asList(CardName.values());
        imageViewFrame.setImage(new Image("/it.polimi.ingsw/view/gui/img/other/frame.png"));
        setCard();
        selected = new ArrayList<>();

        imageViewCard.setFitWidth(163);
        imageViewCard.setFitHeight(220);
        imageViewCard.setPreserveRatio(true);

        imageViewFrame.setFitWidth(169);
        imageViewFrame.setFitHeight(228);
        imageViewFrame.setPreserveRatio(true);

        buttonRight.setMinSize(50,50);
        buttonRight.setMaxSize(50,50);
        buttonRight.setPrefSize(50,50);
        buttonLeft.setMinSize(50,50);
        buttonLeft.setMaxSize(50,50);
        buttonLeft.setPrefSize(50,50);

        textAreaDescription.setMinSize(525,190);
        textAreaDescription.setMaxSize(525,190);
        textAreaDescription.setPrefSize(525,190);

        buttonAccept.setMinSize(197,48);
        buttonAccept.setMaxSize(197,48);
        buttonAccept.setPrefSize(197,48);

        textFieldName.setMinSize(220,48);
        textFieldName.setMaxSize(220,48);
        textFieldName.setPrefSize(220,48);
        textFieldName.setEditable(false);

        buttonSend.setDisable(true);
        buttonSend.setVisible(false);

        double w = 170;
        double h = 180;
        buttonSelected1.setPrefSize(w,88);
        buttonSelected2.setPrefSize(w,88);
        buttonSelected3.setPrefSize(w,88);

        buttonSend.setPrefSize(150,42);
        buttonClear.setPrefSize(150,42);
        buttonClear.setPrefSize(150,42);

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
        buttonClear.setMinSize(154,88);
        buttonClear.setMaxSize(154,88);
        buttonClear.setPrefSize(154,88);
    }

    @Override
    public void setup(){
        super.setup();
        int y = 25;

        if(gui.getClient().getPlayers().size() == 3){
            int offset = 45;
            buttonSelected1.setLayoutX(gui.sceneWidth/4 - buttonSelected1.getPrefWidth()/2+offset);
            buttonSelected2.setLayoutX(gui.sceneWidth/2 - buttonSelected2.getPrefWidth()/2);
            buttonSelected3.setLayoutX(3*gui.sceneWidth/4 - buttonSelected3.getPrefWidth()/2-offset);

            buttonGod1.setLayoutX(gui.sceneWidth/4 - buttonGod1.getPrefWidth()/2+offset);
            buttonGod2.setLayoutX(gui.sceneWidth/2 - buttonGod2.getPrefWidth()/2);
            buttonGod3.setLayoutX(3*gui.sceneWidth/4 - buttonGod3.getPrefWidth()/2-offset);
        } else if(gui.getClient().getPlayers().size() == 2){
            int offset = 45;
            buttonSelected1.setLayoutX(gui.sceneWidth/3 - buttonSelected1.getPrefWidth()/2+offset);
            buttonSelected2.setLayoutX(2*gui.sceneWidth/3 - buttonSelected2.getPrefWidth()/2-offset);
            buttonSelected3.setVisible(false);

            buttonGod1.setLayoutX(gui.sceneWidth/3 - buttonGod1.getPrefWidth()/2+offset);
            buttonGod2.setLayoutX(2*gui.sceneWidth/3 - buttonGod2.getPrefWidth()/2-offset);
            buttonGod3.setVisible(false);
        }

        buttonSelected1.setLayoutY(425);
        buttonSelected2.setLayoutY(425);
        buttonSelected3.setLayoutY(425);

        buttonClear.setLayoutY(425);
        buttonSend.setLayoutY(425);
        int offset = 30;
        buttonClear.setLayoutX(offset);
        buttonSend.setLayoutX(gui.sceneWidth-offset-150);

        buttonGod1.setLayoutY(282);
        buttonGod2.setLayoutY(282);
        buttonGod3.setLayoutY(282);

        imageViewFrame.setLayoutX(gui.sceneWidth/5-imageViewFrame.getFitWidth()/2);
        imageViewFrame.setLayoutY(y-1);
        imageViewCard.setLayoutX(120);
        imageViewCard.setLayoutY(y);

        buttonLeft.setLayoutX(gui.sceneWidth/5-imageViewFrame.getFitWidth()/2-60);
        buttonLeft.setLayoutY(y+imageViewFrame.getFitHeight()/2-25);
        buttonRight.setLayoutX(gui.sceneWidth/5-imageViewFrame.getFitWidth()/2+10+169);
        buttonRight.setLayoutY(y+imageViewFrame.getFitHeight()/2-25);

        textAreaDescription.setLayoutY(y+38);
        textAreaDescription.setLayoutX(400);

        buttonAccept.setLayoutY(y);
        buttonAccept.setLayoutX(400+525-197);

        textFieldName.setLayoutY(y);
        textFieldName.setLayoutX(400);
        setUpTextField(textFieldName);
        textAreaDescription.setFont(f);
        textAreaDescription.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                textAreaDescription.setFont(f);
            }
        });
    }

    public void rightCard(ActionEvent actionEvent) {
        if(++count == cards.size()) count = 0;
        setCard();
    }

    public void leftCard(ActionEvent actionEvent) {
        if(--count == -1) count = cards.size()-1;
        setCard();
    }

    public void setCard(){
        try{
            imageViewCard.setImage(new Image("/it.polimi.ingsw/view/gui/img/card/"+cards.get(count).toString().toLowerCase()+".png"));
            textFieldName.setText(cards.get(count).toString());
            String[] splitted = cards.get(count).getDescription().split(" ");
            String desc = "";
            int cc = 0;
            for(int i=0; i<splitted.length; i++){
                cc += splitted[i].length();
                desc += splitted[i];
                if(cc > 38){
                    cc = 0;
                    desc += (i+1 == splitted.length ? "" : "\n");
                } else desc += " ";
            }
            textAreaDescription.setText(desc);
        } catch (Exception ex){
            imageViewCard.setImage(new Image("/it.polimi.ingsw/view/gui/img/card/random.png"));
            textFieldName.setText(cards.get(count).toString());
            textAreaDescription.setText("");
        }
    }

    public void acceptOnAction(ActionEvent actionEvent) {
        if(!selected.contains(cards.get(count))){
            selected.add(cards.get(count));
            showSelected();
            if(selected.size() == gui.getClient().getPlayers().size()){
                buttonSend.setDisable(false);
                buttonSend.setVisible(true);
            }
        }
    }

    public void sendOnAction(ActionEvent actionEvent){
        if(selected.size() == gui.getClient().getPlayers().size()){
            gui.getClient().sendMessage(new ChallengerChoseClient(gui.getClient().getUsername(), selected));
        }
    }

    public void clearOnAction(ActionEvent actionEvent) {
        selected.clear();
        buttonSend.setDisable(true);
        buttonSend.setVisible(false);
        showSelected();
    }

    public void showSelected(){
        buttonGod1.getStyleClass().clear();
        buttonGod2.getStyleClass().clear();
        buttonGod3.getStyleClass().clear();
        for(int i = 0; i < selected.size(); i++){
            switch (i){
                case  0:
                    buttonGod1.getStyleClass().addAll("button",selected.get(i).toString().toLowerCase());
                    break;
                case  1:
                    buttonGod2.getStyleClass().addAll("button",selected.get(i).toString().toLowerCase());
                    break;
                case  2:
                    buttonGod3.getStyleClass().addAll("button",selected.get(i).toString().toLowerCase());
                    break;
                default:
                    break;
            }
        }
    }
}