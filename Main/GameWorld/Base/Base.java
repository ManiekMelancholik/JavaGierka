package Main.GameWorld.Base;

import Game.Textures.TexturesHolder;
import Main.GameWorld.GameObject;
import Main.GameWorld.IWorldComponent;
import Main.GameWorld.Unit.Unit;
import Main.TurnLogic;
import Rendering.Animation;

import java.awt.image.BufferedImage;

public class Base extends GameObject {

    //public BufferedImage idleTexture;

    //public Animation idle;
    String idleName;
    public final int idleMax;
    public int idleIterator = 0;

    public Base(String idleName){

        super(3,0,0,0);
        this.idleName = idleName;
        idleMax = Animation._ANIMATIONS.get(idleName).getLength();
        TurnLogic.getInstance().currentPlayer.ownedBases++;
        TurnLogic.getInstance().currentPlayer.updateUi();
    }
    public BufferedImage display(int number){
        idleIterator ++;
        if(idleIterator > idleMax) idleIterator = 1;

        return  Animation._ANIMATIONS.get(idleName).getFrame(idleIterator);
    }

    public static final String className = "BASE";

    @Override
    public String getClassName() {
        return className;
    }

    public void spawnUnit(IWorldComponent IWC){
        IWC.setGameObject(new Unit(
                TexturesHolder.get_instance().TEXTURE_meh_idle,
                TexturesHolder.NAME_meh_shoot,
                TexturesHolder.NAME_meh_walk));
    }


}
