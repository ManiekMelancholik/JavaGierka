package Game.Textures;

import Rendering.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TexturesHolder {

    public static TexturesHolder _instance = new TexturesHolder();
    public static final String PATH_gras = "JavaGierkaTextures/TERRAIN/GRASS.png";
    public static final String PATH_sand = "JavaGierkaTextures/TERRAIN/SAND.png";
    public static final String PATH_moss_marble = "JavaGierkaTextures/TERRAIN/MOSS_MARBLE.png";

    public static final String PATH_meh_idle = "JavaGierkaTextures/MEH/MEH_IDLE.png";
    public static final String PATH_meh_walking = "JavaGierkaTextures/MEH/MEH_WALKING";
    public static final String PATH_meh_shooting = "JavaGierkaTextures/MEH/MEH_SHOOTING";

    public static final String PATH_base_idle = "JavaGierkaTextures/BASE/BASE_IDLE";

    public static final String NAME_base_idle = "base_idle";
    public static final String NAME_meh_walk = "walk";
    public static final String NAME_meh_shoot = "shoot";


    public BufferedImage TEXTURE_gras;
    public BufferedImage TEXTURE_sand;
    public BufferedImage TEXTURE_moss_marble;
    public BufferedImage TEXTURE_meh_idle;

    public static TexturesHolder get_instance() {
        if(_instance == null) _instance = new TexturesHolder();
        return _instance;
    }

    private TexturesHolder(){
        Animation.registerAnimation(NAME_meh_walk,PATH_meh_walking,60);
        Animation.registerAnimation(NAME_meh_shoot,PATH_meh_shooting,60);
        Animation.registerAnimation(NAME_base_idle,PATH_base_idle,60);
        try {
            TEXTURE_gras = ImageIO.read(new File(PATH_gras));
            TEXTURE_sand = ImageIO.read(new File(PATH_sand));
            TEXTURE_moss_marble = ImageIO.read(new File(PATH_moss_marble));
            TEXTURE_meh_idle = ImageIO.read(new File(PATH_meh_idle));
        }
        catch (Exception e){

        }
    }




    public final BufferedImage getImage(){
//        BufferedImage grassTexture = null;
//        try {
//            grassTexture = ImageIO.read(new File(idle));
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//        System.out.println(grassTexture);
//        return grassTexture;

        //60 - persec - > jump = 0
        //30 - persec -> jump = 1;
        //
        return Animation._ANIMATIONS.get("shoot").getFrame(0);
    }
}
