package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonUtils {
	public static String getTimestampEmail() {
		return "rehankhan" + System.currentTimeMillis() + "@gmail.com";
	}

	public static boolean CompareTwoScreenshots(String actualImagePath, String expectedImagePath) throws IOException {
		BufferedImage actualbufferedImag = ImageIO.read(new File(actualImagePath));
		BufferedImage expectedbufferedImag = ImageIO.read(new File(expectedImagePath));
		ImageDiffer imgdiffer = new ImageDiffer();
		ImageDiff ImageDifferences = imgdiffer.makeDiff(expectedbufferedImag, actualbufferedImag);
		// If image has no difference it return true
		// boolean b = ImageDifferences.hasDiff();
		// System.out.println(b);
		return ImageDifferences.hasDiff();
	}

	public static Properties loadProperties() throws IOException {
		Properties prop = new Properties();
		FileReader filereader;
		try {
			filereader = new FileReader(
					"C:\\FullAutomationLiveProject\\FullAutomationProject\\src\\test\\resources\\projectdata.properties");
			prop.load(filereader);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return prop;

	}

}
