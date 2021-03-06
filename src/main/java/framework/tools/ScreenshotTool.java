package framework.tools;

import framework.base.DriverContext;
import framework.config.Settings;
import lombok.extern.slf4j.Slf4j;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

@Slf4j
public class ScreenshotTool {

    public static String takeScreenshotEntirePage(String screenshotFileName) {
        String directoryPath = System.getProperty("user.dir") + "/" + Settings.LogsPath + "/screenshots/";

        makeDirectoryFolder(directoryPath);

        String destination = directoryPath + screenshotFileName;

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(DriverContext.driver);

        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(destination));
        } catch (Exception e) {
            log.error("", e);
        }

        return destination;
    }

    private static void makeDirectoryFolder(String directoryPath) {

        try {
            File dir = new File(directoryPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
        } catch (Exception e) {

        }
    }
}