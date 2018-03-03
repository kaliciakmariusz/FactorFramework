package framework.tools;

import framework.base.DriverContext;
import framework.config.Settings;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotTool {

    public static String takeScreenshotCurrentView(String fileName) throws IOException {
        fileName = fileName + " " + TimeTool.getTime() + ".png";
        String directory = Settings.LogsPath + "/" + Settings.ScreenshootFolderName + "/";
        String destination = directory + fileName;

        File sourceFile = ((TakesScreenshot) DriverContext.driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(sourceFile, new File(directory + fileName));

        return destination;
    }

    public static String takeScreenshotEntirePage(String fileName) throws IOException {
        fileName = fileName + " " + TimeTool.getTime() + ".png";
        String directory = Settings.LogsPath + "/" + Settings.ScreenshootFolderName + "/";
        String destination = directory + fileName;

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(DriverContext.driver);

        ImageIO.write(screenshot.getImage(), "PNG", new File(destination));

        return destination;
    }

}
