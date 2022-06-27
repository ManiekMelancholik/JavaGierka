package Main.GameWorld;

import Rendering.IDrawable;
import Rendering.Point;

public interface IWorldComponent {
    IDrawable updateToRender();
    void setPoint(Point point);
    void setGameObject(GameObject gameObject);
    void removeUnit();
    GameObject getGameObject();
    int getHeight();
    default void changeConnected(){}

    int getState();
    Point getPoint();
    default IDrawable getView(){return null;}

}


