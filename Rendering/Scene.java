package Rendering;

import Main.MouseActions.IMouseDelegate;
import Main.MouseActions.ISearchable;

import java.awt.*;
import java.util.ArrayList;

public class Scene implements IDrawable, ISearchable {

    public ArrayList<RenderingComponent> sceneObjects;

    public Scene(){
        sceneObjects = new ArrayList<>();
    }

    @Override
    public void Draw(Graphics g) {
        if(!sceneObjects.isEmpty())
            for(IDrawable sceneObject : sceneObjects) sceneObject.Draw(g);
    }
    public void UpdateScreenPosition(float x, float y){
        if(!sceneObjects.isEmpty())
            for(IDrawable IDO : sceneObjects) IDO.UpdateScreenPosition(x,y);
    }
    public void Add(RenderingComponent object){

            sceneObjects.add(object);
    }
    public void Reg(){
        for (IDrawable IDO : sceneObjects) IDO.Reg();
        //System.out.println("Registered");
    }
    public void search(Point p, IMouseDelegate action){
        for (ISearchable IS: sceneObjects) {
            IS.search(p, action);
        };
    }

    @Override
    public void Scale(float newSize) {
        for (IDrawable IDO : sceneObjects) IDO.Scale(newSize);
    }
}
