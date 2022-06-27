package Main.GameWorld;

import java.util.Random;



public class Generator {
    private int x = -1;
    //private int y = 0;

    Random rng;
    public Generator(){
        rng = new Random();
    }
    public IWorldComponent generateNext(){
        x++;
        return new Field(rng.nextInt(1,4));

    }

}
//    RenderingComponent rd = new RenderingComponent();
    //rd.Add(new PrimitiveGameObjects.Triangle(new Point(400,100),new Point(100,100), new Point(20,60), Color.BLUE));
    //rd.Add(new Line(new Point(100,100), new Point(200,200),Color.RED));
    //rd.Add(new PrimitiveGameObjects.Hexagon(new Point(100,100),10,Color.GREEN));
    //rd.Add(new PrimitiveGameObjects.Triangle(new Point(100,200),new Point(1,20),new Point(300,400),Color.black));
//    int size = 9;
//    int temp = 1;
//    for(int i = 0; i<20;i++){
//
//        if(temp == 1) temp = 0;
//        else temp = 1;
//
//        for(int j =0; j<20;j++) {
//
//        rd.Add(new PrimitiveGameObjects.Hexagon(new Point(100 + j * size * 19 + j*3 + temp*86, 100 +i * size * 17), 10, Color.getHSBColor(6*(1+i)*(1+j),20*(1+j),6*(1+i))));
//
//        }
//        }
//        scene = new Scene();
//        scene.Add(rd);
