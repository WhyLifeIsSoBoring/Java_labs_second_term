package bsu.rfe.java.group7.lab6.Stankevich.varA5;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BouncingBall implements Runnable {

    private static final int MAX_RADIUS = 40;
    private static final int MIN_RADIUS = 3;
    private static final int MAX_SPEED = 15;

    private Field field;
    private int radius;
    private Color color;

    private double x;
    private double y;

    private int speed;
    private double speedX;
    private double speedY;

    public BouncingBall(Field field) {

        this.field = field;
        radius = new Double(Math.random() * (MAX_RADIUS - MIN_RADIUS)).intValue() + MIN_RADIUS;

        speed = new Double(Math.round(5 * MAX_SPEED / radius)).intValue();
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        double angle = Math.random() * 2 * Math.PI;

        speedX = 3 * Math.cos(angle);
        speedY = 3 * Math.sin(angle);

        color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());

        x = Math.random() * (field.getSize().getWidth() - 2 * radius) + radius;
        y = Math.random() * (field.getSize().getHeight() - 2 * radius) + radius;

        Thread thisThread = new Thread(this);
        thisThread.start();
    }
    public void run() {

    }

    public void paint(Graphics2D canvas) {
        canvas.setColor(color);
        canvas.setPaint(color);
        Ellipse2D.Double ball = new Ellipse2D.Double(x-radius, y-radius,
                2*radius, 2*radius);

        canvas.draw(ball);
        canvas.fill(ball);
    }
}
