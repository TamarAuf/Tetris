package tetris.shapes;

import tetris.Square;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractShape {
    private ArrayList<Square> squaresList;
    private int x, y;
    private Square center;
    private boolean canRotate;
    private boolean fixed;
    private boolean inBounds;

    public AbstractShape(ArrayList<Square> squaresList, int x, int y) {
        this.squaresList = squaresList;
        this.x = x;
        this.y = y;
    }

    public ArrayList<Square> getSquares() {
        return squaresList;
    }

    public void move(int xChange, int yChange) {
        x += xChange;
        y += yChange;
    }

    public void rotate()
    {

    }
}
