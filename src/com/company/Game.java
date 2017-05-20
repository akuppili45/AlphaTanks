package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
/**
 * Created by akupp_000 on 5/5/2017.
 */
public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = -6261436164361361187L;
    private boolean running = false;
    private Thread thread;
    public static int WIDTH,HEIGHT;
    private BufferedImage level = null;
    //Objects
    Handler handler;
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread= new Thread(this);
        thread.start();
    }
    private void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/level2.png");//loading the level
        handler = new Handler();
        loadImageLevel(level );
        WIDTH = getWidth();//Canvas width
        HEIGHT = getHeight();//Canvas height


//        PlayerTank pT = new PlayerTank(120, 700-32, ObjectId.PlayerTank, handler);
//        EnemyTank eT = new EnemyTank(1100,700-32,ObjectId.EnemyTank, handler, pT);
//        handler.addObject(new Platform(0, 700, ObjectId.Platform, this));
//        handler.addObject(pT);
//        handler.addObject(eT);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput());

    }
    @Override
    public void run() {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
    private void tick(){
        handler.tick();
    }
    //Called in the game loop in this class.
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        /////////////////////////////////
        //Draw Everything in here
        //g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());//This NEEDS to be here. DON'T TAKE IT OUT OR THE PLAYER WON'T MOVE
        handler.render(g);
        /////////////////////
        g.dispose();
        bs.show();
    }
    private void loadImageLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        int xx;
        int yy ;
        PlayerTank pT;
        //EnemyTank eT = new EnemyTank(xx*32, yy*32,ObjectId.EnemyTank, handler);
        System.out.println("width, height" + w + "," + h);
        for( xx = 0; xx < h; xx++){
            for( yy = 0; yy < w; yy++){

                int pixel = image.getRGB(xx,yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if(red == 255 && green == 255 && blue == 255)
                    handler.addObject(new Platform(xx * 32, yy * 32, ObjectId.Platform, this));
                if(red == 0 && green == 0 && blue == 255) {
                    pT = new PlayerTank(xx*32, yy*32, ObjectId.PlayerTank, handler);
                    handler.addObject(pT);
                }
                if(red == 228 && green == 51 && blue == 51){
                    handler.addObject(new EnemyTank(xx*32, yy*32,ObjectId.EnemyTank, handler));
                }
            }
        }
    }

    public static void main(String[] args) {
        //new Window(800,600,"Alpha Tanks", new Game());
        new Window(1800,900,"Alpha Tanks", new Game());
    }
}