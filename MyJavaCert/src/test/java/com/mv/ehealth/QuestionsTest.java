package com.mv.ehealth;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionsTest {

	@Test
	void testGetUnUsedKeys() {
		int[] allKeys = { 1, 2, 3, 4, 5 };
		int[] usedKeys = { 1, 3 };
		int[] unUsedKeys = Questions.getUnUsedKeysStream(allKeys, usedKeys);
		int[] expectedUnUsedKeys = { 2, 4, 5 };
		assertArrayEquals(expectedUnUsedKeys, unUsedKeys);
	}

}
