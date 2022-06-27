package Main.GameWorld;

import java.awt.*;

public interface IConnectable {

    void makeConnections(IWorldComponent[] componentConnections);

    void makeDirectConnections(IWorldComponent[] direct);

    default int highlightConnected(int range, Color color){return 0;}

    default int highlightDirect(int range, Color color){return 0;}

    default int highlightBack(int range){return 0;}

    default int highlightDirectBack(int range){return 0;}

    default int HighlightForAttack(int range, Color color){return 0;}



}
