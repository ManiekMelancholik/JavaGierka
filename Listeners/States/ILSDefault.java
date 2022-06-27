package Listeners.States;

import Main.GameWorld.IWorldComponent;

import java.awt.event.MouseEvent;

public class ILSDefault extends ListenerState {
    private static final String name = "DEF";
//    @Override
//    public void click(MouseEvent e) {
//
//    }


    @Override
    public void click1(IWorldComponent iwc) {

    }

    @Override
    public void click2(MouseEvent e) {

    }

    @Override
    public String getName() {
        return name;
    }
}
