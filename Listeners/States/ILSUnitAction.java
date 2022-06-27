package Listeners.States;

import Listeners.InGameInputListeners;
import Main.GameWorld.Base.Base;
import Main.GameWorld.Field;
import Main.GameWorld.GameObject;
import Main.GameWorld.IConnectable;
import Main.GameWorld.IWorldComponent;
import Main.GameWorld.Unit.Unit;
import Main.MainWindow.MainWindow;
import Main.MouseActions.FindIDrawable;
import Main.MouseActions.Highlight;
//import Rendering.Animator;
import Main.TurnLogic;
import Rendering.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ILSUnitAction extends ListenerState {

    private static final String name = "UA";

    GameObject selectedUnit;

    public ILSUnitAction(GameObject unit, IWorldComponent iwc) {
        selectedUnit = (Unit) unit;
        H.highlightBack();

        H = new Highlight(
                ((IConnectable ic) -> {
                    ic.highlightConnected(selectedUnit.getMovementRange(), Color.GREEN);
                    ic.HighlightForAttack(selectedUnit.getAttackRange(), Color.RED);
                }),
                ((IConnectable ic) -> {
                    ic.highlightBack(selectedUnit.getMovementRange());
                    ic.highlightDirectBack(selectedUnit.getAttackRange());
                }),
                (IConnectable) iwc);

        H.highlight();

    }

    public void click1(IWorldComponent iwc) {

    }

    public void click2(MouseEvent e) {
        Rendering.Point p1 = new Point(e.getX(), e.getY() - 130);
        IWorldComponent IWC = FindIDrawable.get_instance().action(p1);

        Rendering.Point pA = iwcSuper.getPoint();
        Rendering.Point pB = IWC.getPoint();
        selectedUnit.setAngle( Math.atan2((double)(pB.Y - pA.Y),(double)(pB.X - pA.X)));

        if(IWC.getState() == Field._ABLE_TO_MOVE_STATE){

            iwcSuper.setGameObject(null);
            IWC.setGameObject(selectedUnit);
            //TO BE CONTINUED
            //Animator.getInstance().AnimatorSet(iwcSuper.getView(),pSuper,p1);
            InGameInputListeners.getInstance().setState(new ILSDefault());
            H.highlightBack();

            //selectedUnit.setAngle();
            selectedUnit.changeAction(GameObject._MOVE);
            System.out.println("Moved");
            selectedUnit.readyForAction = false;
        }

        if(IWC.getState() == Field._ABLE_ATTACK_STATE) {
            System.out.println("Attack");

            if (IWC.getGameObject() != null) {

                GameObject go = (GameObject) IWC.getGameObject();

                if(selectedUnit.hashCode()!=go.hashCode()) {
                    selectedUnit.changeAction(GameObject._ATTACK);
//                    Rendering.Point pA = iwcSuper.getPoint();
//                    Rendering.Point pB = IWC.getPoint();

//                    selectedUnit.setAngle( Math.atan2((double)(pB.Y - pA.Y),(double)(pB.X - pA.X)));

                    if (go.takeDamage(selectedUnit.getAttackDamage())) {
                        if(go.getClassName().equals(Base.className)){
                            go.player.ownedBases--;
                            if(go.player.ownedBases<=0){
                                JOptionPane.showMessageDialog(MainWindow._instance, "PLAYER "+ TurnLogic.getInstance().currentPlayer.name +" HAD WON !!!");
                            }
                        }
                        if(go.getClassName().equals(Unit.className)) go.player.ownedUnits--;
                        IWC.getPoint();
                        IWC.setGameObject(null);
                    }

                    selectedUnit.readyForAction = false;
                }
                InGameInputListeners.getInstance().setState(new ILSDefault());
                H.highlightBack();
            }
        }

    }

    @Override
    public String getName() {
        return name;
    }
}
