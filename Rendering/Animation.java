package Rendering;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;

public class Animation {

    public static Dictionary<String, Animation> _ANIMATIONS = new Hashtable<>();

    private String name;
    private int startsAt = 1;
    private int endsAt;
    private String path;
    private int speed = 1;
    private BufferedImage [] animationFrames;
    private int iterator = 0;

    public BufferedImage getFrame(int frame){


//        if(frame > endsAt)frame=1;


        return animationFrames[frame];
    }



    public static void registerAnimation(String name, String path, int endsAt,int speed,String convention){
       _ANIMATIONS.put(name,new Animation(name,path,speed,endsAt,1,convention,".png"));
    }

    public static void registerAnimation(String name, String path, int endsAt, int speed ){
        registerAnimation(name,path,endsAt,speed,"0000");
    }

    public static void registerAnimation(String name, String path, int endsAt, String convention){
        registerAnimation(name,path,endsAt,1,convention);
    }

    public static void registerAnimation(String name, String path, int endsAt){
        registerAnimation(name,path,endsAt,1,"0000");
    }



    private Animation(String name, String path, int speed, int endsAt, int startsAt,String textFormatCallConvention,String extension){
        this.name = name;
        this.path = path;
        this.speed = speed;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.animationFrames = new BufferedImage[endsAt +2- startsAt ];
        String temp;
        String num;
        try{
            for(int i = 1; i<animationFrames.length; i++) {
                num = i + "";

                temp = "/" + textFormatCallConvention.substring(
                        0,
                        textFormatCallConvention.length() - num.length()) + num;
                //System.out.println(temp);
                BufferedImage buff = ImageIO.read(new File(path + temp + extension));
                animationFrames[i] = buff;
               // System.out.println(animationFrames[i]);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public int getLength(){
        return endsAt;
    }

}
