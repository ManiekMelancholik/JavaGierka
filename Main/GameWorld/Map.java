package Main.GameWorld;

import Game.GameWorld.Scenes.SceneManager;
//import Game.GameWorld.Scenes.TestScene;
import PrimitiveRenderingObjects.Hexagon;
import Rendering.Point;
import Rendering.RenderingComponent;
import Rendering.Scene;

import java.util.ArrayList;

public class Map implements IConnectable{
    IWorldComponent[] map;
    int startShift = 0;
    int height;
    int width;
    public Map(int x, int y, Generator gen){
        height = y;
        width = x;
        map = new IWorldComponent[x*y];
        int temp = 1;
        int shift = startShift;
        for(int i =0; i<y;i++){

            if(shift==0)shift=1;
            else shift = 0;

            for(int j = 0; j<x; j++) {
                map[j + i * x] = gen.generateNext();
//                map[j + i * x].setPoint(Point.mult(new Point(j*2+shift,i), new Point(154,272)));
                map[j + i * x].setPoint(Point.mult(new Point(j*2+shift,i), new Point(180,320)));
            }
        }
        makeConnections(map);
    }

    public void genView(){
        Scene sc = new Scene();
        RenderingComponent rd = new RenderingComponent();
        for (IWorldComponent IWC: map) {
            rd.Add((Hexagon) IWC.updateToRender());
        }
        sc.Add(rd);
        SceneManager.setCurrentScene(sc);
    }

    @Override
    public void makeConnections(IWorldComponent[]collection) {
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.ensureCapacity(10);

        ArrayList<Integer> dirIndexes = new ArrayList<>();
        dirIndexes.ensureCapacity(10);



        int tabPositions[] = {-width-1,-width,width-1,width};
        int shift = startShift;

        for (int x = 0; x < width; x++) {

            for(int y = 0; y < height; y++) {

                if (shift == 0) shift = 1;
                else shift = 0;

                int ownH = map[x+y*width].getHeight();

                int amplitude;
                int hCurrent = map[x+y*width].getHeight();
                for (int i = 0; i < tabPositions.length; i++) {

                    int index = tabPositions[i] + shift + x + y * width;
                    if(index<width*height && index>=0) {


                        int h = map[index].getHeight();
                        if (
                                ((y)*width > index) &&
                                        ((y-1)*width < index+1)||
                                ((y+2)*width > index) &&
                                        ((y+1)*width < index+1)

                        ){
                            if(index>=0 && index<width*height) {
                                amplitude = map[index].getHeight() - hCurrent;

                                dirIndexes.add(index);

                                if(amplitude>-2 && amplitude<2)
                                    indexes.add(index);
                            }

                        }

                    }
                }
                if(x+y*width > y*width) {
                    amplitude = map[x + y * width - 1].getHeight() - hCurrent;

                    dirIndexes.add(x + y * width - 1);
                    if (amplitude > -2 && amplitude < 2)
                        indexes.add(x + y * width - 1);

                }
                if(x+y*width < (y+1)*width-1) {
                    amplitude = map[x + y * width + 1].getHeight() - hCurrent;

                    dirIndexes.add(x + y * width + 1);
                    if (amplitude > -2 && amplitude < 2)
                        indexes.add(x + y * width + 1);

                }
                IWorldComponent[] connections = new IWorldComponent[indexes.size()];

                for(int i = 0; i<connections.length;i++) {
                    connections[i] = map[indexes.get(i)];
                }

                IWorldComponent[] dirConnections = new IWorldComponent[dirIndexes.size()];

                for(int i = 0; i<dirConnections.length;i++) {
                    dirConnections[i] = map[dirIndexes.get(i)];
                }

                ((IConnectable)map[x+y*width]).makeConnections(connections);

                ((IConnectable)map[x+y*width]).makeDirectConnections(dirConnections);

                indexes.clear();
                dirIndexes.clear();
            }
        }

    }

    @Override
    public void makeDirectConnections(IWorldComponent[] direct) {

    }
}
