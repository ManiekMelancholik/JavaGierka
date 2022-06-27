package Main.Player;

import Main.GameWorld.GameObject;
import Main.MainWindow.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {




    public Color c;

    public int ownedBases;
    public int ownedUnits;

    int unitsCap;
    int basesCap;

    String unitsInitial;
    String basesInitial;

    JLabel unitsDisplay;
    JLabel basesDisplay;

    public final int identificationNumber;

    public final String name;

    ArrayList<GameObject> gameObjects = new ArrayList<>();

    public Player(Color color, JLabel units, JLabel bases,int id, String name){
        c= color;
        unitsCap = 9;
        basesCap = 2;
        ownedBases = 0;
        ownedUnits = 0;
        unitsDisplay = units;
        basesDisplay = bases;
        unitsInitial = units.getText();
        basesInitial = bases.getText();
        identificationNumber = id;
        this.name = name;

    }

    public void updateUi() {
        unitsDisplay.setText(unitsInitial + ": " + ownedUnits + " | " + unitsCap);
        basesDisplay.setText(basesInitial + " : " + ownedBases + " | " + basesCap);


    }
    public boolean checkBases(){
        return (ownedBases<basesCap);
    }

    public boolean checkUnits(){
        return (ownedUnits<unitsCap);
    }

    public void addBases(GameObject go){
       // basesCap++;
        gameObjects.add(go);
    }

    public void addUnits(GameObject go){
        //unitsCap++;
        gameObjects.add(go);
    }

    public void newTurn(){
        for (GameObject GO : gameObjects) {
            GO.readyForAction = true;
        }
    }

    public void removeGO(GameObject go){
        gameObjects.remove(go);
    }






}
