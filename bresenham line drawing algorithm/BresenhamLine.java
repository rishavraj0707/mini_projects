import java.awt.*;
import javax.swing.*;

public class BresenhamLine extends JPanel {

    void drawLine(Graphics g, int x1, int y1, int x2, int y2) {

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        int err = dx - dy;

        while (true) {

            // Draw pixel
            g.drawLine(x1, y1, x1, y1);

            // Print point
            System.out.println("(" + x1 + ", " + y1 + ")");

            // Stop when destination is reached
            if (x1 == x2 && y1 == y2) {
                break;
            }

            int e2 = 2 * err;

            if (e2 > -dy) {
                err = err - dy;
                x1 = x1 + sx;
            }

            if (e2 < dx) {
                err = err + dx;
                y1 = y1 + sy;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);

        // Start point = (100, 100)
        // End point = (500, 400)
        drawLine(g, 100, 100, 500, 400);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bresenham Line Drawing");

        BresenhamLine panel = new BresenhamLine();

        frame.add(panel);

        frame.setSize(700, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}