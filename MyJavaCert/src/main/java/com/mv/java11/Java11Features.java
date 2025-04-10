package com.mv.java11;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java11Features {

	public static void multiLineString() {
		String multilineString = "Baeldung helps \n| \n developers \n explore Java.";
		List<String> lines = multilineString.lines().filter(line -> !line.isBlank()).map(String::strip)
				.collect(Collectors.toList());
		assertTrue(lines.containsAll(List.of("Baeldung helps", "developers", "explore Java.")));
	}

	public static void newFileMethods() throws IOException {
		Path demoFilePath = Path.of("src/main/resources/demo.txt");
		Path filePath = Files.writeString(demoFilePath, "Sample text");

		// Using temp files
//		Path tempDir = Path.of("src/main/resources");
//		Path filePath = Files.writeString(Files.createTempFile(tempDir, "demo", ".txt"), "Sample text");

		String fileContent = Files.readString(filePath);
		assertTrue(fileContent.equals("Sample text"));
	}

	public static void collectionToArray() {
		List<String> sampleList = Arrays.asList("Java", "Kotlin");
		String[] sampleArray = sampleList.toArray(String[]::new);
		assertTrue(sampleList.containsAll(Arrays.asList(sampleArray)));
	}

	public static void notPredicate() {
		List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
		List<String> withoutBlanks = sampleList.stream().
				filter(Predicate.not(String::isBlank)).
				collect(Collectors.toList());
		assertTrue(withoutBlanks.containsAll(List.of("Java", "Kotlin")));
	}

	public static void main(String[] args) throws IOException {
//		multiLineString();
//		newFileMethods();
//		collectionToArray();
		notPredicate();
	}
}
