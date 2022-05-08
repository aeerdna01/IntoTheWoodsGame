package PaooGame.Entities.Movable;

import PaooGame.Entities.Entity;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

public abstract class Creature extends Entity {

    protected float speed;
    protected  float xMove, yMove;

    public static int DEFAULT_LIFE = 30;
    public static final float DEFAULT_SPEED=2.0f;
    public static  final int DEFAULT_CREATURE_WIDTH=64;
    public static final int DEFAULT_CREATURE_HEIGHT=64;

    protected int life;
    protected int actual_life;


    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler,x, y, width, height);
        speed=DEFAULT_SPEED;
    xMove=0;
        yMove=0;
        life = DEFAULT_LIFE;
}
    public Creature(Handler handler, float x, float y, int width, int height, float speed, int life){
        super(handler,x, y, width, height);
        this.life = life;
        actual_life= life;
        this.speed = speed;
        xMove   = 0;
        yMove   = 0;
    }
    public void move(){
        if(!checkEntityCollision(xMove,0f))
            moveX();
        if(!checkEntityCollision(0f,yMove))
            moveY();
    }

    public void moveX(){
        if(xMove>0){ //moving right
            int tx=(int)(x+xMove+ bounds.x+ bounds.width)/ Tile.TILE_WIDTH;

            if(!collisionWithTile(tx,(int)(y+ bounds.y)/Tile.TILE_HEIGHT) && !collisionWithTile(tx,(int)(y+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT)){
                x+=xMove;
            }else{
                x = tx*Tile.TILE_WIDTH - bounds.x- bounds.width-1;
            }

        }else if(xMove<0){ //moving left
            int tx=(int)(x+xMove+ bounds.x)/ Tile.TILE_WIDTH;

            if(!collisionWithTile(tx,(int)(y+ bounds.y)/Tile.TILE_HEIGHT) && !collisionWithTile(tx,(int)(y+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT)){
                x+=xMove;
            }else
            {
                x=tx*Tile.TILE_WIDTH+Tile.TILE_WIDTH- bounds.x;
            }
        }
    }
    public void moveY(){
        if(yMove<0){ //up
            int ty=(int)(y+yMove+ bounds.y)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+ bounds.x)/Tile.TILE_WIDTH,ty)&&!collisionWithTile((int)(x+ bounds.x+ bounds.width)/Tile.TILE_WIDTH,ty)){
                y+=yMove;
            }else
            {
                y=ty*Tile.TILE_HEIGHT +Tile.TILE_HEIGHT - bounds.y;
            }
        }else if (yMove>0){ //down
            int ty=(int)(y+yMove+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+ bounds.x)/Tile.TILE_WIDTH,ty)&&!collisionWithTile((int)(x+ bounds.x+ bounds.width)/Tile.TILE_WIDTH,ty)){
                y+=yMove;
            }else
            {
                y=ty*Tile.TILE_HEIGHT- bounds.y- bounds.height-1;
            }
        }
    }

    protected  boolean collisionWithTile(int x, int y)
    {
        return handler.getWorld().getTile(x,y).IsSolid();
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getActual_life() {
        return actual_life;
    }

    public void setActual_life(int actual_life) {
        this.actual_life = actual_life;
    }
}
