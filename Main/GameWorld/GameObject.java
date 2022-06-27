package Main.GameWorld;

import Main.Player.Player;
import Main.TurnLogic;
import Rendering.Animation;

import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected int health;

    protected int attack;
    protected int attackRange;

    protected int movementRange;

    protected int currentAction = 0;

    protected BufferedImage idle;
    protected String attackName;
    protected String movementName;

    protected double angle = 0;
    public static final int _IDLE = 0;
    public static final int _MOVE = 1;
    public static final int _ATTACK = 2;

    public boolean readyForAction = false;
    public final Player player;


    protected GameObject(int... values){
        health = values[0];
        attack = values[1];
        attackRange = values[2];
        movementRange = values[3];
        player = TurnLogic.getInstance().currentPlayer;
        TurnLogic.getInstance().currentPlayer.addUnits(this);
    }

    public abstract BufferedImage display(int number);
    public abstract String getClassName();
    public int getHealth(){return health;}
    public int getAttackRange(){return attackRange;}
    public int getMovementRange(){return movementRange;}
    public int getAttackDamage(){return attack;}
    public boolean takeDamage(int damage){
        this.health -= damage;
        if(health<=0) player.removeGO(this);
        return (health <= 0);
    }
    public double getAngle(){return angle;}
    public void setAngle(double newAngle){this.angle = newAngle;}
    public void changeAction(int actionCode){
        currentAction = actionCode;
    }

    public boolean isOwner(Player p2){
        return(p2.identificationNumber == this.player.identificationNumber);
    }


}
