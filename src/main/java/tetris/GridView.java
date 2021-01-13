package tetris;

import tetris.shapes.AbstractShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridView extends JComponent {
    private Grid grid;
    private static final int CELL_SIZE = 15;
    
    public GridView(Grid grid) {
        this.grid = grid;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
        paintFixedSquares(g);
        paintCurrShape(g);
    }

    private void paintGrid(Graphics g) {
        g.setColor(new Color(0,0,100));
        g.fillRect(0,0,Grid.WIDTH, Grid.HEIGHT);

        g.setColor(Color.BLACK);
        for (int i = 0; i < Grid.ROWS; i++) {
            g.drawLine(0, i * Grid.CELL_SIZE, Grid.WIDTH, i * Grid.CELL_SIZE);
        }

        for (int i = 0; i < Grid.COLS; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * Grid.CELL_SIZE, Grid.HEIGHT);
        }
    }

    private void paintFixedSquares(Graphics g){
        Square[][] fixedSquares = grid.getFixedSquares();
        for (int row = 1; row < Grid.ROWS; row++) {
            for (int col = 0; col < Grid.COLS; col++) {
                if (fixedSquares[row][col] != null) {
                    g.setColor(fixedSquares[row][col].getColor());
                    g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    private void paintCurrShape(Graphics g) {
        AbstractShape shape = grid.getCurrentShape();
        int gridX = shape.getX();
        int gridY = shape.getY();
        ArrayList<Square> squares = shape.getSquares();
        for(Square square : squares)
        {
            g.setColor(square.getColor());
            g.fillRect(gridX + square.getX() * CELL_SIZE,  gridY + square.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }
}