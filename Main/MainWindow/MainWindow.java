package Main.MainWindow;

import Listeners.InGameInputListeners;
import Listeners.UserInterfaceInputListeners;
import Main.Core;
//import Rendering.Animator;
import Rendering.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainWindow extends JFrame {
    public static MainWindow _instance = new MainWindow();
    public static JLabel frameCount;
    public static JLabel zoomLevel;
    public static JLabel turnCount;

    public static JLabel mainContainerBackground;

    public static JPanel topUiContainer;
    public static JPanel sideUiContainer;

    public static JPanel mapContainer;


    public static JLabel UNITS;
    public static JLabel BASES;

    public JButton setBase;
    public JButton endTurn;
    public JButton nextUnit;

    public Rendering.IDrawable scene;

    //public static JPanel layerPanel;
    //public static final Font font = new Font("Arial",1,100);

    private float scale;

    //private static final Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();

    private MainWindow(){
        scale = 1;

        Font font = new Font("Courier New", Font.BOLD,40);
        this.setSize(1400,1000);
        this.setTitle("GRA RADOSLAW BOCZON");
        this.setResizable(false);

        //this.setMaximizedBounds(1400,1000);
        frameCount = new JLabel();
        frameCount.setBounds(50,25,300,50);
        frameCount.setFont(font);
        frameCount.setForeground(Color.white);

        zoomLevel = new JLabel();
        zoomLevel.setBounds(350,25,400,50);
        zoomLevel.setFont(font);
        zoomLevel.setForeground(Color.white);

        turnCount = new JLabel();
        turnCount.setBounds(1025,25,400,50);
        turnCount.setFont(font);
        turnCount.setForeground(Color.white);
        turnCount.setText("TURN: ");

        topUiContainer = new JPanel();

        topUiContainer.add(frameCount);
        topUiContainer.add(zoomLevel);
        topUiContainer.add(turnCount);
        topUiContainer.setLayout(new BorderLayout());

        topUiContainer.setBackground(Color.darkGray);
        topUiContainer.setBounds(0,0,1400,100);


        UNITS = new JLabel("UNITS");
        UNITS.setBounds(25,25,300,50);
        UNITS.setFont(font);
        UNITS.setForeground(Color.white);

        BASES = new JLabel("BASES");
        BASES.setBounds(25,125,400,50);
        BASES.setFont(font);
        BASES.setForeground(Color.white);

        setBase = new JButton("SET BASE");
        setBase.setBounds(25,300,350,150);
        setBase.setFont(font);
        setBase.setBackground(Color.black);
        setBase.setForeground(Color.gray);

        endTurn = new JButton("END TURN");
        endTurn.setBounds(25,500,350,150);
        endTurn.setFont(font);
        endTurn.setBackground(Color.gray);
        endTurn.setForeground(Color.black);

        nextUnit = new JButton("NEXT UNIT");
        nextUnit.setBounds(25,700,350,150);
        nextUnit.setFont(font);
        nextUnit.setBackground(Color.black);
        nextUnit.setForeground(Color.gray);





        sideUiContainer = new JPanel();

        sideUiContainer.setBackground(Color.black);
        sideUiContainer.setBounds(1000,100,400,1000);

        sideUiContainer.add(UNITS);
        sideUiContainer.add(BASES);
        sideUiContainer.add(setBase);
        //sideUiContainer.add(nextUnit);
        sideUiContainer.add(endTurn);
        sideUiContainer.setLayout(new BorderLayout());


        mapContainer = new JPanel();
        mapContainer.setBackground(Color.BLACK);
        mapContainer.setBounds(0,100,1000,1000);

        mainContainerBackground = new JLabel();
        mainContainerBackground.setBackground(Color.black);
        mainContainerBackground.setBounds(0,0,1000,1000);


        mainContainerBackground.add(topUiContainer);
        mainContainerBackground.add(sideUiContainer);

        mainContainerBackground.add(mapContainer);


        this.add(mainContainerBackground);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.scene = new Scene();
        InGameInputListeners.SetObject(this);
        UserInterfaceInputListeners.SetObject(this);

    }
    public boolean updateSuper=false;
    @Override
    public void setVisible(boolean b) {

        super.setVisible(b);
    }

    BufferedImage img;
    public void _update() {

        frameCount.setText("\tFPS: " + Core.FPS+"\t");
        zoomLevel.setText("\tZOOM: "+Zoom.ZOOM_LEVELS[Zoom.zoomIndexer]+"\t");

        img = new BufferedImage(mapContainer.getWidth(),mapContainer.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);

        Graphics imgGraphics = img.getGraphics();

        imgGraphics.setColor(Color.black);
        imgGraphics.fillRect(0,0,1000,1000);
        scene.Draw(imgGraphics);
        //Animator.getInstance()._update(imgGraphics);

        mapContainer.getGraphics().drawImage(img,0,0,null);
    }
    public static void UpdateScale(float scale){
        _instance.updateSuper = true;
        _instance.scale = scale;
    }
    public static void UpdateScene(Scene newScene){
        _instance.scene = newScene;
        System.out.println(_instance.scene);
        //_instance.scene.Reg();
    }

}
