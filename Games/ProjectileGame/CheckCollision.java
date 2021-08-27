package ProjectileGame;

import java.awt.geom.Rectangle2D;

public class CheckCollision {

    public static boolean collisionWithTiles(Rectangle2D p, Terrain.Tiles tile) {
        Rectangle2D.Double tRect = tile.getBounds();
        if(p.intersects(tRect)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean collisionWithLava(Rectangle2D p, Terrain.Lava lava) {
        Rectangle2D.Double lRect = lava.getBounds();
        return p.intersects(lRect);
    }

    public static boolean collisionWithCoin(Player p, Terrain.Coins coin) {
        Rectangle2D.Double cRect = coin.getBounds();
        Rectangle2D.Double pRect = p.getBounds();
        if(pRect.intersects(cRect)) {
            return true;
        }
        return false;
    }
}
