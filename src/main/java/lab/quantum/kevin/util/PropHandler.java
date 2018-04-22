package lab.quantum.kevin.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropHandler {
    private static Properties read(Path path) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = Files.newInputStream(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static Properties readResources(String file) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Path path = Paths.get(loader.getResource(file).toURI());
            boolean exists = Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            if (!exists) {
                throw new RuntimeException("Properties not found");
            }
            return read(path);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
