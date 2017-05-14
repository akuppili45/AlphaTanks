package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by akupp_000 on 5/5/2017.
 */
public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = -6261436164361361187L;
    private boolean running = false;
    private Thread thread;
    public static int WIDTH,HEIGHT;
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
        WIDTH = getWidth();//Canvas width
        HEIGHT = getHeight();//Canvas height
        handler = new Handler();


        handler.addObject(new Platform(0, 500, ObjectId.Platform, this));
        handler.addObject(new PlayerTank(120, 468, ObjectId.PlayerTank, handler));
       // handler.addObject(new PlayerTank(400, 468-288, ObjectId.PlayerTank, handler));
        //for(GameObject a : handler.object)
              //  System.out.println(a);
        //handler.addObject(new Gun(40,50,ObjectId.Gun));
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
        g.fillRect(0,0,getWidth(),getHeight());//This NEEDS to be here. DON'T TAKE IT OUT OR THE PLAYER WON'T MOVE
        handler.render(g);
        /////////////////////
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Window(800,600,"Alpha Tanks", new Game());
    }
}
