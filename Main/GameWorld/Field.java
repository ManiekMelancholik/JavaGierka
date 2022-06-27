package Main.GameWorld;

import Game.Textures.TexturesHolder;
import PrimitiveRenderingObjects.Hexagon;
import Rendering.IDrawable;
import Rendering.Point;

import java.awt.*;

public class Field implements  IWorldComponent, IConnectable{
    //Hexagon view;
    Image fieldSprite;
    Color color;
    Point point;
    int height;
    public Hexagon hex;
    public IWorldComponent [] connections;
    public IWorldComponent [] directConnections;
    GameObject gameObject;

    public static final int _DEF_STATE = 0;
    public static final int _SPAWN_POINT_STATE = 1;
    public static final int _ABLE_TO_MOVE_STATE = 2;
    public static final int _ABLE_ATTACK_STATE = 3;


    private int state = 0;

    @Override
    public int getState() {
        return state;
    }

    public Field(Point position, int height){
        point = position;
        this.height = height;
        color = Color.getHSBColor(0.1F*height,0.5F,1);
    }

    public Field(int height){
        point = Point.P_ZERO;
        this.height = height;
        color = Color.getHSBColor(0.1F,0.1F*height,0.1F*height);
    }

    public void setPoint(Point point){
            this.point = point;
           // System.out.println(point.X + "::"+ point.Y);
    }

    @Override
    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }


    @Override
    public IDrawable updateToRender() {
        this.hex= new Hexagon(point, 18, color, this);
        switch (height){
            case 1:
                hex.setTexture(TexturesHolder.get_instance().TEXTURE_gras,height);
                break;
            case 3:
                hex.setTexture(TexturesHolder.get_instance().TEXTURE_sand,height);
                break;
            case 2:
                hex.setTexture(TexturesHolder.get_instance().TEXTURE_moss_marble,height);
                break;
//            default:
//                return null;
        }
//        hex.setTexture(TexturesHolder.get_instance().TEXTURE_sand,height);
        //hex.setTexture(TexturesHolder.get_instance().TEXTURE_sand);
        return this.hex;
    }
   // public void setGameObject(Unit gameObject){
//        this.gameObject = gameObject;
//    }
    public void removeUnit(){
        this.gameObject = null;
    }

    public GameObject getGameObject() {

        return gameObject;
    }


    @Override
    public void makeConnections(IWorldComponent[] componentConnections) {
        connections = componentConnections;
    }

    @Override
    public void makeDirectConnections(IWorldComponent[] direct) {
        this.directConnections = direct;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void changeConnected() {
        for (IWorldComponent IWC: connections) {
            IWC.setGameObject(gameObject);
        }
    }

    @Override
    public int highlightConnected(int range, Color color) {

        state = _ABLE_TO_MOVE_STATE;
        this.hex.color = color;
        if(range > 0){
            range -- ;
            for (IWorldComponent IWC: connections) {
                ((IConnectable)IWC).highlightConnected(range, color);
            }
        }
        return range;
    }

    @Override
    public int highlightDirect(int range, Color color) {
        state = _SPAWN_POINT_STATE;
        this.hex.color = color;
        if(range > 0){
            range -- ;
            for (IWorldComponent IWC: directConnections) {
                ((IConnectable)IWC).highlightDirect(range,color);
            }
        }
        return range;
    }

    @Override
    public int highlightBack(int range) {
        state = _DEF_STATE;
        this.hex.color = this.color;
        if(range > 0){
            range -- ;
            for (IWorldComponent IWC: directConnections) {
                ((IConnectable)IWC).highlightBack(range);
            }
        }
        return range;
    }

    @Override
    public int highlightDirectBack(int range) {
        state = _DEF_STATE;
        this.hex.color = this.color;
        if(range > 0){
            range -- ;
            for (IWorldComponent IWC: directConnections) {
                ((IConnectable)IWC).highlightDirectBack(range);
            }
        }
        return range;
    }

    @Override
    public int HighlightForAttack(int range, Color color) {

        if(this.gameObject != null){

            this.hex.color = color;
            state = _ABLE_ATTACK_STATE;
        }
        if(range > 0){
            range -- ;
            for (IWorldComponent IWC: directConnections) {
                ((IConnectable)IWC).HighlightForAttack(range,color);
            }
        }
        return range;
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public IDrawable getView() {
        return hex;
    }
}



