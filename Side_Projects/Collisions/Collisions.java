import java.util.ArrayList;

public class Collisions {

    double xDist, yDist;
    Audio audio;

    public Collisions() {
        audio = new Audio();
    }

    public void collide(ArrayList<Particle> particles) {
        for (int i = 0; i < particles.size()-1; i++) {
            Particle p1 = particles.get(i);
            for (int j = i+1; j < particles.size(); j++) {
                Particle p2 = particles.get(j);

                float distSqrt = getDistance(p1.getCx(), p1.getCy(), p2.getCx(), p2.getCy());

                if (distSqrt < p1.getRadius() + p2.getRadius()) {
                    audio.pongSound();
                    float theta1 = p1.angle();
                    float theta2 = p2.angle();
                    double phi = Math.atan2(p2.cy - p1.cy, p2.cx - p1.cx);
                    float m1 = p1.getMass();
                    float m2 = p2.getMass();
                    float v1 = p1.speed();
                    float v2 = p2.speed();

                    float dx1F = (float) ((v1 * Math.cos(theta1 - phi) * (m1 - m2) + 2 * m2 * v2 * Math.cos(theta2 - phi)) / (m1 + m2) * Math.cos(phi) + v1 * Math.sin(theta1 - phi) * Math.cos(phi + Math.PI / 2));
                    float dy1F = (float) ((v1 * Math.cos(theta1 - phi) * (m1 - m2) + 2 * m2 * v2 * Math.cos(theta2 - phi)) / (m1 + m2) * Math.sin(phi) + v1 * Math.sin(theta1 - phi) * Math.sin(phi + Math.PI / 2));
                    float dx2F = (float) ((v2 * Math.cos(theta2 - phi) * (m2 - m1) + 2 * m1 * v1 * Math.cos(theta1 - phi)) / (m1 + m2) * Math.cos(phi) + v2 * Math.sin(theta2 - phi) * Math.cos(phi + Math.PI / 2));
                    float dy2F = (float) ((v2 * Math.cos(theta2 - phi) * (m2 - m1) + 2 * m1 * v1 * Math.cos(theta1 - phi)) / (m1 + m2) * Math.sin(phi) + v2 * Math.sin(theta2 - phi) * Math.sin(phi + Math.PI / 2));

                    p1.velX = dx1F;
                    p1.velY = dy1F;
                    p2.velX = dx2F;
                    p2.velY = dy2F;

                 //   staticCollision(p1, p2, false);
                }
            }
            wallCollision(p1);
        }
        if (particles.size() > 0) {
            wallCollision(particles.get(particles.size()-1));
        }
    }

    public void wallCollision(Particle p) {
        if (p.getCx() - p.getRadius() + p.getVx() < 0 ||
                p.getCx() + p.getRadius() + p.getVx() > 735) {
            p.velX *= -1;
        }
        if (p.getCy() - p.getRadius() + p.getVy() < 0 ||
                p.getCy() + p.getRadius() + p.getVy() > 500) {
            p.velY *= -1;
        }
        if (p.getCy() + p.getRadius() > 500) {
            p.cy = 500 - p.getRadius();
        }
        if (p.getCy() - p.getRadius() < 0) {
            p.cy = p.getRadius();
        }
        if (p.getCx() + p.getRadius() > 735) {
            p.cx = 735 - p.getRadius();
        }
        if (p.getCx() - p.getRadius() < 0) {
            p.cx = p.getRadius();
        }
    }

    public void staticCollision(Particle p1, Particle p2, Boolean emergency) {
        float overLap = p1.getRadius() + p2.getRadius() - getDistance(p1.getCx(), p1.getCy(), p2.getCx(), p2.getCy());
        Particle smallerObject = p1.getRadius() < p2.getRadius() ? p1 : p2;
        Particle biggerObject = p1.getRadius() > p2.getRadius() ? p1 : p2;

        if (emergency) {
            Particle tmp = smallerObject;
            smallerObject = biggerObject;
            biggerObject = tmp;
        }

        float theta = (float) Math.atan2((biggerObject.getCy() - smallerObject.getCy()), (biggerObject.getCx() - smallerObject.getCx()));
        smallerObject.cx -= overLap * Math.cos(theta);
        smallerObject.cy -= overLap *  Math.sin(theta);

        if (getDistance(p1.getCx(), p1.getCy(), p2.getCx(), p2.getCy()) < p1.getRadius() + p2.getRadius()) {
            if (!emergency) staticCollision(p1, p2, true);
        }
    }

    public float getDistance (float x1, float y1, float x2, float y2){
         xDist = x2 - x1;
         yDist = y2 - y1;

        return (float) Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
    }
}
