package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Tank extends GameObject
{
    protected int width = 64, height = 32;
    Handler h;
    Gun gun;
    private int health = 3;
    Tank enemyTankData;
    Camera cam;
    Game game;
    boolean rightCrashed = false;



    float gravity = -.3f;
    public Tank(float x, float y, ObjectId id, Handler handler, Camera cam, Game game) {
        super(x, y, id);
        h = handler;
        //gun = new Gun(400,180,ObjectId.Gun);
        //x=120, y=468        // move this to render.
        h.addObject(this);
        gun = new Gun(x+30,y,ObjectId.Gun, 45, this, h);
        h.addObject(gun);
        this.cam = cam;
        this.game = game;

    }
    public Tank(ObjectId id){
        super(id);
    }
    @Override
    public void tick(LinkedList<GameObject> object) {

        gun.setX(x+30);
        x+=velX;
        collision();
        if(getHealth() == 0)
            h.removeObject(this);

    }

    @Override
    public String toString() {
        return "Tank";
    }

    @Override
    public void render(Graphics g) {

            g.setColor(Color.BLUE);
            g.fillRect((int) x, (int) y, width, height);
            gun.render(g);
            Graphics2D g2D = (Graphics2D)g;
            g2D.setStroke(new BasicStroke(0));
            g2D.setColor(Color.MAGENTA);
            g2D.draw(getBoundsLeft());
            g2D.draw(getBoundsRight());
    }
    public boolean isPlayer(){
        return this.getID() == ObjectId.PlayerTank;
    }
    public Gun getGun(){
        return gun;
    }
    public Rectangle getBounds(){
        return new Rectangle((int) (x+5), (int) (y-10), width - 10, 5);
    }
    public Rectangle getBoundsLeft(){
        return new Rectangle((int)x, (int)y, width/32, height);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle((int)(x + width), (int)y, width/32, height);
    }
    public Tank getEnemyTankData(){
        return enemyTankData;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void collision(){
        for(GameObject a : h.object){
            if(a.getID() == ObjectId.Platform){
                Platform block = (Platform)a;
                if(getBoundsLeft().intersects(block.getBounds())){
                    x = block.getX() + 40;
                    //gun.setX(gun.getX() - 24.1f);

                }
                else if (getBoundsRight().intersects(block.getBounds())){
                    x = block.getX() - width;
                    //gun.setX(gun.getX() + width);
                }

            }
            else if(this.getID() == ObjectId.PlayerTank && a.getID() == ObjectId.Flag){
                Flag f = (Flag)a;
                if(getBoundsRight().intersects(f.getBounds())) {
                    h.clearLevel();
                    cam.setX(0);
                    game.setCurrentLevel(2);
                    game.init();
                }
            }
            else if(this.getID() == ObjectId.PlayerTank && a.getID() == ObjectId.PowerUp){
                PowerUp p = (PowerUp)a;
                if(getBoundsRight().intersects(p.getBounds())){
                    p.setRemove(true);
                    for(int i = 0; i < 10; i++)
                        getGun().getBullets().push(new Bullet(ObjectId.Bullet));

                }

            }
            else if(this.getID() == ObjectId.PlayerTank && a.getID() == ObjectId.EnemyTank){
                EnemyTank enemy = (EnemyTank)a;
                if(getBoundsRight().intersects(enemy.getBoundsLeft())){
                   System.out.println("kjkl;;jkl");
//                    rightCrashed = true;
//                    enemy.setX(x + width);
//                    enemy.setVelX(0);
                    x = enemy.getX() - 70;

                }
            }
//            else if (this.getID() == ObjectId.EnemyTank && a.getID() == ObjectId.PlayerTank){
//                PlayerTank playerTank = (PlayerTank)a;
//                System.out.println("hhhhhhhhhhhhhh");
//                if(getBoundsLeft().intersects(playerTank.getBoundsRight())){
//                    x = x + 10;
//                }
//            }
        }


    }
    public boolean isRightCrashed() {
        return rightCrashed;
    }
}

