package com.mv.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Util {

	public void bubbleSort(char[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				char tmp = 0;
				if (array[i] > array[j]) {
					tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
	}

	public static String loadFromFile(String fileName) {

		Path filePath = Path.of(fileName);
		String fileContent = null;
		try {
			fileContent = Files.readString(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileContent;
	}
}
