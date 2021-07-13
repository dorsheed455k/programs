class Circle {
    int x, y;
    int r;
    Color cl;

    public Circle(int x, int y, Color cl) {
        this.x = x;
        this.y = y;
        this.cl = cl;
        r = 40;
    }

    public int getRadius() {
        return r;
    }

    public void render(Graphics2D g) {
        g.setColor(cl);
        g.fillOval(x, y, r, r);
    }
