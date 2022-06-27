package Rendering;

import Main.MainWindow.MainWindow;

import javax.swing.*;
import java.awt.*;

public interface IDrawable {
    void Draw(Graphics g);
    void UpdateScreenPosition(float x, float y);
    public default void Reg(){
        MainWindow.mainContainerBackground.add((JButton)this);
    }

    default void Scale(float newSize) {

    }

    default IDrawable copy(){return null;}


}
