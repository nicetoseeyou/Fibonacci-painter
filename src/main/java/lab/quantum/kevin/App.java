package lab.quantum.kevin;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import lab.quantum.kevin.fibonacci.Fibonacci;
import lab.quantum.kevin.fibonacci.ImageSettings;
import lab.quantum.kevin.fibonacci.Painter;
import lab.quantum.kevin.util.PropHandler;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        Properties settings = PropHandler.readResources("settings.properties");
        Fibonacci fibonacci = new Fibonacci(Integer.parseInt(settings.getProperty("fibonacci.length")));
        Painter painter = new Painter(settings);
        painter.drawSpiral(fibonacci.getFibonacciSequence());
        saveImage(painter.getImage(), settings.getProperty("image.name"));
    }

    public static void saveImage(BufferedImage image, String fullName) {
        try (OutputStream outputStream = new FileOutputStream(fullName)) {
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
            encoder.encode(image);
        } catch (FileNotFoundException e) {
            System.out.println(fullName);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(fullName);
            e.printStackTrace();
        }
    }
}
