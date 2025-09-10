package org.redbadger.app;

import java.util.Set;

class Robot {
    private ORIENTATION orientation;
    private int x, y;
    private boolean isLost;

    public Robot(int x, int y, ORIENTATION orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.isLost = false;
    }

    public void turnLeft() {
        orientation = orientation.turnLeft();
    }

    public void turnRight() {
        orientation = orientation.turnRight();
    }

    public Integer getX(){return x;}
    public Integer getY(){return y;}
    public ORIENTATION getOrientation(){return orientation;}
    public boolean isLost(){return isLost;}

    public void moveForward(int maxX, int maxY, Set<String> scents) {
        int newX = x + orientation.getX();
        int newY = y + orientation.getY();

        if(newX < 0 || newY < 0 || newX > maxX || newY > maxY){
            String scent = String.format("%d,%d", x, y);
            if(!scents.contains(scent)){
                scents.add(scent);
                isLost = true;
            }
        }else{
            x = newX;
            y = newY;
        }
    }

    public String getStatus() {
        return String.format("%d %d %s%s", x, y, orientation.name(), isLost ? " LOST" : "");
    }
}
