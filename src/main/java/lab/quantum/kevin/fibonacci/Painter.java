package lab.quantum.kevin.fibonacci;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Properties;

public class Painter {
    private BufferedImage image;
    private Graphics2D graphics2D;
    private ImageSettings imageSettings;
    private Integer scale;

    public Painter(Properties settings) {
        this.imageSettings = new ImageSettings(settings);
        this.image = new BufferedImage(imageSettings.getWidth(), imageSettings.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.graphics2D = (Graphics2D) image.getGraphics();
        this.graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //image background setup start
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, imageSettings.getAlpha()));// 1.0f为透明度 ，值从0-1.0，依次变得不透明
        graphics2D.setColor(imageSettings.getBackgroundColor());
        graphics2D.fillRect(0, 0, imageSettings.getWidth(), imageSettings.getHeight());
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

        //graphics2D.setBackground(imageSettings.getBackgroundColor());//设置背景色
        //graphics2D.clearRect(0, 0, imageSettings.getWidth(), imageSettings.getHeight());//通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
        //image background setup end
        this.scale = Integer.parseInt(settings.getProperty("fibonacci.scale"));
    }

    public void drawSpiral(Integer[] fibonacciSequence) {
        int xPos = imageSettings.getWidth() / 2 - 200;
        int yPos = imageSettings.getHeight() / 2 + 150;
        for (int i = 0; i < fibonacciSequence.length - 1; i++) {
            int seqNum = (i + 1) % 4;

            drawFromCorner(xPos, yPos, fibonacciSequence[i], seqNum);

            if (i != fibonacciSequence.length - 1) {
                if (seqNum == 1)
                    xPos -= fibonacciSequence[i] * scale + fibonacciSequence[i + 1] * scale;
                else if (seqNum == 2)
                    yPos -= fibonacciSequence[i] * scale + fibonacciSequence[i + 1] * scale;
                else if (seqNum == 3)
                    xPos += fibonacciSequence[i] * scale + fibonacciSequence[i + 1] * scale;
                else if (seqNum == 0)
                    yPos += fibonacciSequence[i] * scale + fibonacciSequence[i + 1] * scale;
            }
        }
    }

    private void drawFromCorner(int xPos, int yPos, int size, int corner) {
        Color spiralColor = imageSettings.getSpiralColor();
        Color squireLineColor = imageSettings.getSquareLineColor();
        if (corner == 3) {
            graphics2D.setPaint(squireLineColor);
            graphics2D.drawRect(xPos, yPos, size * scale, size * scale);
            graphics2D.setPaint(spiralColor);
            graphics2D.drawArc(xPos, yPos, size * scale * 2, size * scale * 2, -180, -90);
        } else if (corner == 0) {
            xPos -= size * scale;
            graphics2D.setPaint(squireLineColor);
            graphics2D.drawRect(xPos, yPos, size * scale, size * scale);
            graphics2D.setPaint(spiralColor);
            graphics2D.drawArc(xPos - size * scale, yPos, size * scale * 2, size * scale * 2, -270, -90);
        } else if (corner == 1) {
            xPos -= size * scale;
            yPos -= size * scale;
            graphics2D.setPaint(squireLineColor);
            graphics2D.drawRect(xPos, yPos, size * scale, size * scale);
            graphics2D.setPaint(spiralColor);
            graphics2D.drawArc(xPos - size * scale, yPos - size * scale, size * scale * 2, size * scale * 2, 0, -90);

        } else if (corner == 2) {
            yPos -= size * scale;
            graphics2D.setPaint(squireLineColor);
            graphics2D.drawRect(xPos, yPos, size * scale, size * scale);
            graphics2D.setPaint(spiralColor);
            graphics2D.drawArc(xPos, yPos - size * scale, size * scale * 2, size * scale * 2, -90, -90);
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}
