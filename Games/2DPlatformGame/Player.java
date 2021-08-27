package ProjectileGame;

import ProjectileGame.Img.SpriteSheet;
import ProjectileGame.KeyInput.*;
import ProjectileGame.Sound.Audio;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends GameObject  {
    private double xVel = 5, yVel = 5;
    private int playerHeight, playerWidth;
    private boolean falling, jumping;
    private BufferedImage img;
    private Terrain terrain;
    private SpriteSheet sprite;
    private int forw = 0;
    private boolean flip = false;
    public final int maxDistX;

    Player(double x, double y, Terrain terrain) throws IOException {
        super(x, y);
        this.terrain = terrain;
        playerHeight = 60;
        playerWidth = 48;
        maxDistX = (terrain.mapX - 1) * terrain.mapS;
        sprite = new SpriteSheet();
        img = sprite.trimImage(ImageIO.read(new File("C:\\Users\\Administrator.WIN-5GBSLTHUIQC\\RayCaster\\src\\ProjectileGame\\Img\\player.png")));
        falling = true;
        jumping = true;
    }


    public double getX() {
         return x;
    }

    public double getY() {
         return y;
    }


    @Override
    public void setVelX(double xVel) {
        this.xVel = xVel;
    }

    @Override
    public void setVelY(double yVel) {
        this.yVel = yVel;
    }

    @Override
    public double getVelX() {
        return xVel;
    }

    @Override
    public double getVelY() {
        return yVel;
    }

    @Override
    public void tick() {
        y += yVel;
        if(falling || jumping) {
            float gravity = 0.5f;
            yVel += gravity;
            float MAX_SPEED = 12;
            if(yVel > MAX_SPEED) {
                yVel = MAX_SPEED;
            }
        }
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    void updateImage() {
        forw++;
        if(forw == 9) {
            forw = 0;
        }

        if(jumping) {
            forw = 2;
        }
    }

    public boolean isJumping() {
         return jumping;
    }

    public boolean isFalling() {
        return falling;
    }

    public void move(ArrayList<Terrain.Tiles> tiles, ArrayList<Terrain.Lava> lava, KeyHandler key, Audio audio)  {
        if(x <= 0) x = 0;
        if(x >= maxDistX) x = maxDistX;
        keyType(key, audio);
        tileCollision(tiles);
        lavaCollision(lava, audio);
    }

    public void keyType(KeyHandler key, Audio audio) {
        if(key.getKey() == KeyType.LeftArrow) {
            x -= xVel;
            updateImage();
            flip = true;
        }
        if(key.getKey() == KeyType.RightArrow) {
            x += xVel;
            updateImage();
            flip = false;
        }

        if(key.getKey() == KeyType.TopArrow && !jumping) {
            jumping = true;
            audio.jumpSound();
            yVel = -12;
            updateImage();
        }

        if(key.getKey() == KeyType.Unknown) {
            forw = 8;
        }
    }


    public void tileCollision(ArrayList<Terrain.Tiles> tiles) {
        for(Terrain.Tiles tile : tiles) {
            Terrain.Tiles next = tile;
            // Top
            if(CheckCollision.collisionWithTiles(getBoundsTop(), next)) {
                y = next.getBounds().y + playerHeight;
                yVel = 0;
            }
            // Bottom
            if(CheckCollision.collisionWithTiles(getBounds(), next)) {
                y = next.getBounds().y - playerHeight;
                yVel = 0;
                falling = false;
                jumping = false;
            } else {
                falling = true;
            }
            // Right
            if(CheckCollision.collisionWithTiles(getBoundsRight(), next)) {
                x = next.getBounds().x - next.getBounds().width;
            }
            // Left
            if(CheckCollision.collisionWithTiles(getBoundsLeft(), next)) {
                x = next.getBounds().x + next.getBounds().width;
            }
        }
    }

    public void lavaCollision(ArrayList<Terrain.Lava> lavas, Audio audio) {
        for (Terrain.Lava lava : lavas) {
            Terrain.Lava next = lava;
            if (CheckCollision.collisionWithLava(getBoundsTop(), next)) {
                audio.burningSound();
                x = terrain.getPx();
                y = terrain.getPx();
            }
        }
    }


    public void drawPlayer(Graphics g) {
         if (flip) {
             g.drawImage(img.getSubimage(24 * forw, 0, 20, 30), (int) x + playerWidth, (int) y, -playerWidth, playerHeight, null);
         } else {
             g.drawImage(img.getSubimage(24 * forw, 0, 20, 30), (int) x, (int) y, playerWidth, playerHeight, null);
         }
    }

    @Override
     public void render(Graphics g) {
        drawPlayer(g);

      /*  g.setColor(Color.RED);
        g.draw(getBounds());
        g.draw(getBoundsTop());
        g.draw(getBoundsRight());
        g.draw(getBoundsLeft()); */

    }

    public Rectangle2D.Double getBounds() {
        return new Rectangle2D.Double((x+((double) playerWidth/2) - ((double) (playerWidth/2)/2))-5, (double)(y+playerHeight/2), (double) (playerWidth/2)+10, (double) playerHeight/2);
    }

    public Rectangle2D.Double getBoundsTop() {
        return new Rectangle2D.Double((x+((double) playerWidth/2) - ((double) (playerWidth/2)/2))-5, y, (double) (playerWidth/2)+10, (double) playerHeight/2);
    }


    public Rectangle2D.Double getBoundsRight() {
        return new Rectangle2D.Double(x+playerWidth, y+2, (double) ((playerWidth/4)/2), playerHeight-4);
    }

    public Rectangle2D.Double getBoundsLeft() {
        return new Rectangle2D.Double(x, y+2, (double) ((playerWidth/4)/2), playerHeight-4);
    }

}
