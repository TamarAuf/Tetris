package tetris.shapes;

import tetris.Square;

import java.awt.*;

public class ZShape extends AbstractShape {

    public ZShape(int x, int y) {
        super(x, y);
        createZShape();
    }

    /**
     *   Individual Coordinates
     *    (-1,1) O O   (0,1)
     *     (0,0)   O O (1,0)
     */
    private void createZShape() {
        getSquares().add(new Square(getShapeX() - 1, getShapeY() + 1, Color.LIGHT_GRAY));
        getSquares().add(new Square(getShapeX(), getShapeY() + 1, Color.LIGHT_GRAY));
        getSquares().add(new Square(getShapeX(), getShapeY(), Color.LIGHT_GRAY));
        getSquares().add(new Square(getShapeX() + 1, getShapeY(), Color.LIGHT_GRAY));
    }
}