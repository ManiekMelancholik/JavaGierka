//package Rendering;
//
//import Game.Textures.TexturesHolder;
//import Main.GameWorld.Field;
//import Main.GameWorld.GameObject;
//import Main.GameWorld.Unit.Unit;
//import Main.MainWindow.MainWindow;
//import PrimitiveRenderingObjects.Hexagon;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class Movement {
//    GameObject go;
//
//    BufferedImage text;
//    Field f = new Field(20);
//    IDrawable h;
//
//    //Rendering.Point endPos;
//
//    int x = 0;
//    int y = 0;
//
//    int xShift;
//    int yShift;
//    public Movement(IDrawable h,Rendering.Point start, Rendering.Point end){
//        //hex = new Hexagon(Point.P_ZERO,10, Color.BLACK,null);
//        f.setGameObject(new Unit(TexturesHolder._instance.TEXTURE_meh_idle,TexturesHolder.NAME_meh_shoot,TexturesHolder.NAME_meh_walk));
//
//        xShift = (start.X - end.X)/30;
//        yShift = (start.Y - end.Y)/30;
//        this.h= h;
//
//    }
//    public Movement display(Graphics g) {
//
//        h=h.copy();
//        IDrawable h1 = h.copy();
//        x += xShift;
//        y += yShift;
//        h1.UpdateScreenPosition(x, y);
//
//        h1.Draw(g);
////        g.drawImage(text,x,10,null);
//        if (x != 30 * xShift)
//            return this;
//
//        return null;
//    }
//
//}
