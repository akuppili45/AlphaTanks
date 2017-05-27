package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by akupp_000 on 5/5/2017.
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = -6261436164361361187L;
    private boolean running = false;
    public static int WIDTH, HEIGHT;
    private int currentLevel = 1;

    //Objects
    Handler handler;
    Camera cam;

    public synchronized void start() {
        if (running)
            return;
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void init() {

        BufferedImageLoader loader = new BufferedImageLoader();

        BufferedImage level = null;
        handler = new Handler();
        cam = new Camera(0, 0);
        switch (currentLevel) {
            case 1:
                level = loader.loadImage("/level2.png");
                break;
            case 2:
                level = loader.loadImage("/secondlevel.png");
        }
        //handler.decideLevel();//decide which level
        loadImageLevel(level);//actually loads level

        WIDTH = getWidth();//Canvas width
        HEIGHT = getHeight();//Canvas height

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
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        handler.tick();
        PlayerTank p = new PlayerTank(ObjectId.PlayerTank);
        EnemyTank e ;
        for (GameObject a : handler.object) {
            if (a.getID() == ObjectId.PlayerTank){
                p = (PlayerTank)a;
                cam.tick(a);
            }
            else if(a.getID() == ObjectId.EnemyTank){
                e = (EnemyTank)a;
                if(e.getY() == p.getY()) {
                    e.moveToPlayer(p);
                }

            }

        }
    }

    //Called in the game loop in this class.
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2D = (Graphics2D) g;
        /////////////////////////////////
        //Draw Everything in here
        //g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());//This NEEDS to be here. DON'T TAKE IT OUT OR THE PLAYER WON'T MOVE
        g2D.translate(cam.getX(), cam.getY());
        handler.render(g);
        g2D.translate(-cam.getX(), -cam.getY());
        /////////////////////
        g.dispose();
        bs.show();
    }

    private void loadImageLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        int xx;
        int yy;
        PlayerTank pT;
        System.out.println("width, height" + w + "," + h);
        for (xx = 0; xx < h; xx++) {
            for (yy = 0; yy < w; yy++) {

                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (red == 255 && green == 255 && blue == 255)
                    handler.addObject(new Platform(xx * 32, yy * 32, ObjectId.Platform, this));
                if (red == 0 && green == 0 && blue == 255) {
                    pT = new PlayerTank(xx * 32, yy * 32, ObjectId.PlayerTank, handler, cam, this);
                    handler.addObject(pT);
                }
                if (red == 255 && green == 0 && blue == 0) {
                    handler.addObject(new EnemyTank(xx * 32, yy * 32, ObjectId.EnemyTank, handler, cam, this));
                }
                if (red == 255 && green == 216 && blue == 0) {
                    handler.addObject(new Flag(xx * 32, yy * 32, ObjectId.Flag));
                }
                if (red == 0 && green == 255 && blue == 33)
                    handler.addObject(new PowerUp(xx * 32, yy * 32, ObjectId.PowerUp, handler));
            }
        }
    }

    public void setCurrentLevel(int level) {
        currentLevel = level;
    }

    public static void main(String[] args) {
        //new Window(800,600,"Alpha Tanks", new Game());
        new Window(1800, 900, "Alpha Tanks", new Game());
    }
}