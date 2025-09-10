package org.redbadger.app;

enum ORIENTATION {
    N(0,1),
    E(1,0),
    S(0,-1),
    W(-1,0);

    private final int x;
    private final int y;

    ORIENTATION(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public ORIENTATION turnLeft() {
        return values()[(ordinal() + 3) % 4];
    }
    public ORIENTATION turnRight() {
        return values()[(ordinal() + 1) % 4];
    }
}
