package Listeners;

import Listeners.States.ILSSetBase;
import Main.MainWindow.MainWindow;
import Main.TurnLogic;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class UserInterfaceInputListeners {

    private static UserInterfaceInputListeners _instance;

    public static UserInterfaceInputListeners getInstance() {
        if (_instance == null) _instance = new UserInterfaceInputListeners();
        return _instance;
    }

    MouseInputListener setBase;
    MouseInputListener endTurn;
    MouseInputListener nextUnit;

    private UserInterfaceInputListeners() {
        setBase = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(TurnLogic.getInstance().currentPlayer.checkBases()) {
                    InGameInputListeners.getInstance().setState(new ILSSetBase());
                }
            }
        };
        endTurn = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //InGameInputListeners.getInstance().setState(new ILSSetBase());
                TurnLogic.getInstance().endTurn();
            }
        };

    }
    public static void SetObject(MainWindow window){
        window.setBase.addMouseListener(getInstance().setBase);
        window.endTurn.addMouseListener(getInstance().endTurn);
//        window.endTurn;
//        window.nextUnit;
    }


}
