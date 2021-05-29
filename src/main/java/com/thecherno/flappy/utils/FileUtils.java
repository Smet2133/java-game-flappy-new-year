package com.thecherno.flappy.utils;

import com.thecherno.flappy.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileUtils {

	private FileUtils() {
	}
	
	public static String loadAsString(String file) {
		StringBuilder result = new StringBuilder();
		try {
			InputStream cpResource = Main.class.getClassLoader().getResourceAsStream(file);
			File tmpFile = File.createTempFile("file", "temp");
			org.apache.commons.io.FileUtils.copyInputStreamToFile(cpResource, tmpFile); // FileUtils from apache-io

			System.out.println(tmpFile.getAbsolutePath());
			BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
			//BufferedReader reader = new BufferedReader(new FileReader(file));
			String buffer = "";
			while ((buffer = reader.readLine()) != null) {
				result.append(buffer + '\n');
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

}
