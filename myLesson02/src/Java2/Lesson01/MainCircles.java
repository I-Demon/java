package Java2.Lesson01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private long startTime;
    private final long timeToSwitch = 5;        // кол-во секунд, через которое меняется фон приложения

    private Sprite[] sprites = new Sprite[10];
    private BackGround back = new BackGround();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        initApplication();
        startTime = System.nanoTime();

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 )  addBall(1);
                else  addBall(-1);
            }
        });

        setVisible(true);
    }

    private void initApplication() {

        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
        long curTime = System.nanoTime();
        float deltaT = (curTime - startTime) * 0.000000001f;
        back.render(canvas, g);
        update(canvas, deltaTime);
        render(canvas, g);
        if (deltaT >= timeToSwitch) {
            back.setColor(new Color(
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255)
            ));
            startTime = curTime;

        }

    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    private void addBall(int count){
        int newLength = sprites.length + count;
        if (newLength < 1) newLength = 1;
        if (newLength > 30) newLength = 30;
        Sprite[] newSprites = new Sprite[newLength];

        for (int i = 0; i < newLength; i++) {
            if (i < sprites.length) newSprites[i] = sprites[i];
            else newSprites[i] = new Ball();
        }
        sprites = newSprites;
    }
}

