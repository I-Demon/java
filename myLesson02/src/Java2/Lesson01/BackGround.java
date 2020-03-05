package Java2.Lesson01;

import java.awt.*;

public class BackGround  {
    private  Color color;

    BackGround(){
        color = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillRect(canvas.getLeft(), canvas.getTop(), canvas.getWidth(), canvas.getHeight());
    }
}
