import java.awt.*;
import javax.swing.*;

public class MidpointCircle extends JPanel {

    void drawCircle(Graphics g, int xc, int yc, int r) {

        int x = 0;
        int y = r;
        int p = 1 - r;

        while (x <= y) {

            // Print 8 symmetric points
            System.out.println("(" + (xc + x) + ", " + (yc + y) + ")");
            System.out.println("(" + (xc - x) + ", " + (yc + y) + ")");
            System.out.println("(" + (xc + x) + ", " + (yc - y) + ")");
            System.out.println("(" + (xc - x) + ", " + (yc - y) + ")");

            System.out.println("(" + (xc + y) + ", " + (yc + x) + ")");
            System.out.println("(" + (xc - y) + ", " + (yc + x) + ")");
            System.out.println("(" + (xc + y) + ", " + (yc - x) + ")");
            System.out.println("(" + (xc - y) + ", " + (yc - x) + ")");

            // Draw 8 symmetric points
            g.drawLine(xc + x, yc + y, xc + x, yc + y);
            g.drawLine(xc - x, yc + y, xc - x, yc + y);
            g.drawLine(xc + x, yc - y, xc + x, yc - y);
            g.drawLine(xc - x, yc - y, xc - x, yc - y);

            g.drawLine(xc + y, yc + x, xc + y, yc + x);
            g.drawLine(xc - y, yc + x, xc - y, yc + x);
            g.drawLine(xc + y, yc - x, xc + y, yc - x);
            g.drawLine(xc - y, yc - x, xc - y, yc - x);

            // Update decision parameter
            if (p < 0) {
                x++;
                p = p + 2 * x + 1;
            } else {
                x++;
                y--;
                p = p + 2 * (x - y) + 1;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        // Center = (250, 250), Radius = 100
        drawCircle(g, 250, 250, 100);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Midpoint Circle Drawing");

        MidpointCircle panel = new MidpointCircle();

        frame.add(panel);

        frame.setSize(600, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}