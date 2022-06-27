package Listeners;


import Listeners.States.*;
import Main.GameWorld.Base.Base;
import Main.GameWorld.GameObject;
import Main.GameWorld.IWorldComponent;
import Main.GameWorld.Unit.Unit;
import Main.MouseActions.FindIDrawable;
import Main.TurnLogic;
import Rendering.Point;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;




public class InGameInputListeners{
    private static InGameInputListeners _instance;



    public static InGameInputListeners getInstance(){
        if(_instance == null) _instance = new InGameInputListeners();
        return  _instance;

    }
    private MouseWheelListener mwl;

    static Rendering.Point p1;
    static Rendering.Point p2;
    private MouseInputListener mil;
    public static ListenerState LS;

//
//    private void c1Check(MouseEvent e) {
//
//        //IWorldComponent IWC = FindIDrawable.get_instance().action(new Point(e.getX(), e.getY()));
////        IListenerState ILS;
//        IWorldComponent IWC = LS.click(e);
//        if (IWC == null) {
//            //System.out.println("IWC NULL");
//            LS = new ILSDefault();
//            //return;
//
//        }
//        GameObject GO = IWC.getGameObject();
//
//        if (GO == null) {
//            System.out.println("GO NULL");
//            //if (!this.LS.getName().equals(ILSSetBase.name))
//            LS = new ILSDefault();
//            //return;
//        }
//
//        if(GO.getClassName().equals(Base.className)) {
//            System.out.println("GO BASE");
//            InGameInputListeners.getInstance().setState(new ILSSetUnit((Base) GO));
//        }
//        if(GO.getClassName().equals(Unit.className)) {
//            System.out.println("GO UNIT");
//            InGameInputListeners.getInstance().setState(new ILSUnitAction());
//        }
//        System.out.println(LS.getName());
//    }
//


    private InGameInputListeners(){
        this.LS = new ILSDefault();

        mwl = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
//                Zoom.UpdateZoom(e.getWheelRotation());
                ListenerState.zoom(e);
                //JOptionPane.showMessageDialog(Main.MainWindow.MainWindow._instance, "AAAAAA");
            }


        };

        mil = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showMessageDialog(


                if(e.getButton()==MouseEvent.BUTTON1) {
//                    c1Check(e);

                    IWorldComponent IWC = ListenerState.click(e);
                    LS.click1(IWC);
                            //FindIDrawable.get_instance().action(new Point(e.getX(), e.getY()));
//        IListenerState ILS;
                    if (IWC == null) {
                        System.out.println("IWC NULL");
                       // return;

                    }
                    else {
                        GameObject GO = IWC.getGameObject();


                        if (GO == null) {
//                            System.out.println("GO NULL");
//                            if (!LS.getName().equals(ILSSetBase.name))
                            setState(new ILSDefault());
                            // return;
                        } else {

                            if (GO.isOwner(TurnLogic.getInstance().currentPlayer)) {

                                if (GO.readyForAction) {
                                    if (GO.getClassName().equals(Base.className)) {

                                        System.out.println("GO BASE");
                                        setState(new ILSSetUnit((Base) GO));
                                    }


                                    if (GO.getClassName().equals(Unit.className)) {
                                        System.out.println("GO UNIT");
                                        setState(new ILSUnitAction(GO, IWC));
                                    }
                                }
                            }
                        }
                    }



                }
                if(e.getButton()==MouseEvent.BUTTON3){
                    LS.click2(e);
                }
//                        Main.MainWindow.MainWindow._instance,
//                        e.getPoint());
//                p1 = new Point(e.getX(),e.getY()-130);
//                FindIDrawable.get_instance().action(p1);
//                Hexagon hex = new Hexagon(new Rendering.Point(e.getX(),e.getY()) ,20, Color.red,null);
//                hex.Draw(MainWindow._instance.getGraphics());

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //p1 = new Point(e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                p2 = new Point(e.getX(),e.getY()-20);
//                PrimitiveGameObjects.Line l = new Line(p1,p2,Color.red);
//                l.Draw(MainWindow.mainContainer.getGraphics());
            }

        };
//        Main.MainWindow.MainWindow._instance.addMouseWheelListener(mwl);
//        Main.MainWindow.MainWindow._instance.addMouseListener(mil);
    }
    public static void SetObject(JFrame window){
        window.addMouseWheelListener(getInstance().mwl);
        window.addMouseListener(getInstance().mil);
    }
    public void setState(ListenerState s){
        this.LS = s;

    }

}
