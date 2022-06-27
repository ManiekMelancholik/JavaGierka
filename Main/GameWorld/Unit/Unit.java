package Main.GameWorld.Unit;

import Game.Textures.TexturesHolder;
import Main.GameWorld.GameObject;
import Main.GameWorld.IGOState;
import Main.MainWindow.Zoom;
import Main.TurnLogic;
import Rendering.Animation;
import Rendering.IDrawable;
import Rendering.Point;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Unit extends GameObject {

    public BufferedImage idleTexture;

    private int movementCount;
    private int attackCount;

    private int movementIterator;
    private int attackIterator;

    private IGOState currentState;


    public Unit(BufferedImage texture,String attackName, String movementName){
        super(1,1,4,3);
        this.attackName = attackName;
        this.movementName = movementName;
        readyForAction = true;
        idleTexture = texture;
        movementCount = Animation._ANIMATIONS.get(movementName).getLength();
        System.out.println(movementCount);
        attackCount = Animation._ANIMATIONS.get(attackName).getLength();
        System.out.println(attackCount);
        attackIterator = 0;
        movementIterator = 0;
        TurnLogic.getInstance().currentPlayer.ownedUnits++;


        TurnLogic.getInstance().currentPlayer.updateUi();
    }

    public BufferedImage display(int number){

        if(number == 0){

        }

        if(currentAction == _IDLE) {
            return idleTexture;
        }

        if(currentAction == _MOVE){

            movementIterator ++;
            if(movementIterator >movementCount){
                movementIterator = 1;
                currentAction = _IDLE;
            }

            return  Animation._ANIMATIONS.get(movementName).getFrame(movementIterator);


        }
        attackIterator ++;
        if(attackIterator > attackCount){
            attackIterator = 1;
            currentAction = _IDLE;
        }

        return  Animation._ANIMATIONS.get(attackName).getFrame(attackIterator);
    }


    public static final String className = "UNIT";
    @Override
    public String getClassName() {
        return className;
    }
}
