package lab.quantum.kevin.fibonacci;

import java.awt.*;
import java.util.Properties;

public class ImageSettings {
    private Integer width;
    private Integer height;
    private Float alpha;
    private Color backgroundColor;
    private Color squareLineColor;
    private Color spiralColor;

    public ImageSettings(Properties properties) {
        this.width = Integer.parseInt(properties.getProperty("image.width"));
        this.height = Integer.parseInt(properties.getProperty("image.height"));
        this.alpha = Float.parseFloat(properties.getProperty("image.background.alpha"));
        this.backgroundColor = new Color(
                Integer.parseInt(properties.getProperty("image.background.RGB.red")),
                Integer.parseInt(properties.getProperty("image.background.RGB.green")),
                Integer.parseInt(properties.getProperty("image.background.RGB.blue"))
        );
        this.squareLineColor = new Color(
                Integer.parseInt(properties.getProperty("image.square.line.RGB.red")),
                Integer.parseInt(properties.getProperty("image.square.line.RGB.green")),
                Integer.parseInt(properties.getProperty("image.square.line.RGB.blue"))
        );

        this.spiralColor = new Color(
                Integer.parseInt(properties.getProperty("image.spiral.RGB.red")),
                Integer.parseInt(properties.getProperty("image.spiral.RGB.green")),
                Integer.parseInt(properties.getProperty("image.spiral.RGB.blue"))
        );
    }

    public Integer getWidth() {
        return width;
    }


    public Integer getHeight() {
        return height;
    }

    public Float getAlpha() {
        return alpha;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }


    public Color getSquareLineColor() {
        return squareLineColor;
    }

    public Color getSpiralColor() {
        return spiralColor;
    }

}
