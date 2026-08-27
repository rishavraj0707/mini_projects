import java.awt.*;
import javax.swing.*;

public class MidpointEllipse extends JPanel {

    void drawEllipse(Graphics g, int xc, int yc, int rx, int ry) {

        int x = 0;
        int y = ry;

        double rx2 = rx * rx;
        double ry2 = ry * ry;

        double dx = 2 * ry2 * x;
        double dy = 2 * rx2 * y;

        // Region 1 decision parameter
        double p1 = ry2 - (rx2 * ry) + (0.25 * rx2);

        // Region 1
        while (dx < dy) {

            // Print 4 symmetric points
            printPoints(xc, yc, x, y);

            // Draw 4 symmetric points
            plotPoints(g, xc, yc, x, y);

            if (p1 < 0) {
                x++;
                dx = 2 * ry2 * x;
                p1 = p1 + dx + ry2;
            } else {
                x++;
                y--;
                dx = 2 * ry2 * x;
                dy = 2 * rx2 * y;
                p1 = p1 + dx - dy + ry2;
            }
        }

        // Region 2 decision parameter
        double p2 = ry2 * Math.pow(x + 0.5, 2)
                + rx2 * Math.pow(y - 1, 2)
                - rx2 * ry2;

        // Region 2
        while (y >= 0) {

            // Print 4 symmetric points
            printPoints(xc, yc, x, y);

            // Draw 4 symmetric points
            plotPoints(g, xc, yc, x, y);

            if (p2 > 0) {
                y--;
                dy = 2 * rx2 * y;
                p2 = p2 - dy + rx2;
            } else {
                x++;
                y--;
                dx = 2 * ry2 * x;
                dy = 2 * rx2 * y;
                p2 = p2 + dx - dy + rx2;
            }
        }
    }

    // Plot 4 symmetric points
    void plotPoints(Graphics g, int xc, int yc, int x, int y) {

        g.drawLine(xc + x, yc + y, xc + x, yc + y);
        g.drawLine(xc - x, yc + y, xc - x, yc + y);
        g.drawLine(xc + x, yc - y, xc + x, yc - y);
        g.drawLine(xc - x, yc - y, xc - x, yc - y);
    }

    // Print 4 symmetric points
    void printPoints(int xc, int yc, int x, int y) {

        System.out.println(
                "(" + (xc + x) + ", " + (yc + y) + ")"
        );

        System.out.println(
                "(" + (xc - x) + ", " + (yc + y) + ")"
        );

        System.out.println(
                "(" + (xc + x) + ", " + (yc - y) + ")"
        );

        System.out.println(
                "(" + (xc - x) + ", " + (yc - y) + ")"
        );
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);

        // Center = (300, 300)
        // X-radius = 150
        // Y-radius = 100
        drawEllipse(g, 0, 0, 8, 6);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Midpoint Ellipse Drawing");

        MidpointEllipse panel = new MidpointEllipse();

        frame.add(panel);

        frame.setSize(700, 700);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}