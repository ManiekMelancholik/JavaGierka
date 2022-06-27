//package Game.GameWorld.Scenes;
//
//import PrimitiveGameObjects.Line;
//import Rendering.Point;
//import Rendering.RenderingComponent;
//import Rendering.Scene;
//
//import java.awt.*;
//
//public class TestScene {
//
//    public static Scene scene;
//
//public static void INIT(){
//    RenderingComponent rd = new RenderingComponent();
//    //rd.Add(new PrimitiveGameObjects.Triangle(new Point(400,100),new Point(100,100), new Point(20,60), Color.BLUE));
//    //rd.Add(new Line(new Point(100,100), new Point(200,200),Color.RED));
//    //rd.Add(new PrimitiveGameObjects.Hexagon(new Point(100,100),10,Color.GREEN));
//    //rd.Add(new PrimitiveGameObjects.Triangle(new Point(100,200),new Point(1,20),new Point(300,400),Color.black));
//    int size = 9;
//    int temp = 1;
//    for(int i = 0; i<20;i++){
//
//        if(temp == 1) temp = 0;
//        else temp = 1;
//
//        for(int j =0; j<20;j++) {
//
//            rd.Add(new PrimitiveGameObjects.Hexagon(new Point(100 + j * size * 19 + j*3 + temp*86, 100 +i * size * 17), 10, Color.getHSBColor(.2F,1,1f)));
//
//        }
//    }
//    scene = new Scene();
//    scene.Add(rd);
//
//
//}
//
//}
