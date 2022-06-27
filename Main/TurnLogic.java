package Main;

import Main.MainWindow.MainWindow;
import Main.Player.Player;

import javax.swing.*;
import java.awt.*;

public class TurnLogic {

    private static TurnLogic _instance;

    public static TurnLogic getInstance(){
        if(_instance == null) _instance = new TurnLogic();
        return _instance;
    }

    public Player p1;
    public Player p2;
    public Player currentPlayer;

    JLabel turnCounterDisplay;
    int turnCounter;
    String turnCounterInitial;

    private TurnLogic(){
        p1 = new Player(Color.YELLOW, MainWindow.UNITS,MainWindow.BASES,100,"YELLOW");
        p2 = new Player(Color.CYAN, MainWindow.UNITS,MainWindow.BASES,111,"CYAN");
        turnCounter = 1;
        turnCounterDisplay = MainWindow.turnCount;
        turnCounterInitial = turnCounterDisplay.getText();
        currentPlayer = p1;
        updateUi();
    }

    public void endTurn(){
        if(currentPlayer.hashCode() == p2.hashCode()){
            turnCounter++;
            currentPlayer = p1;
            updateUi();
            return;
        }
        currentPlayer = p2;
        updateUi();
        p1.newTurn();
        p2.newTurn();
    }

    public void updateUi(){
        currentPlayer.updateUi();
        turnCounterDisplay.setForeground(currentPlayer.c);
        turnCounterDisplay.setText(turnCounterInitial + turnCounter);
        if(!currentPlayer.checkBases())
            MainWindow._instance.setBase.setEnabled(false);
        else
            MainWindow._instance.setBase.setEnabled(true);
    }


}
