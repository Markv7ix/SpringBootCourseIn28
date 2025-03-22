package com.mv.javacert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LeaderBoard {

	/*
	 * Complete the 'climbingLeaderboard' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY ranked 2. INTEGER_ARRAY player
	 */

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here
		List<Integer> optRanked = ranked.stream().distinct().collect(Collectors.toList());
		List<Integer> result = new ArrayList<>();
		for (Integer score : player) {
			result.add(searchPosition(optRanked, score));
		}

		return result;
	}

	// { 100, 50, 20, 10}
	// 80
	public static int searchPosition(List<Integer> ranked, int score) {

		if (score > ranked.get(0)) {
			return 1;
		}

		if (score < ranked.get(ranked.size() - 1)) {
			return ranked.size() + 1;
		}

		int start = 0;
		int end = ranked.size() - 1;
		int half = 0;
		while (start <= end) {
			half = (start + end) / 2;
			if (ranked.get(half).equals(score)) {
				return half + 1;
			} else if (score > ranked.get(half)) {
				end = half - 1;
			} else {
				if (start == end) {
					return start + 2;
				}
				start = half + 1;
			}
		}

		return half + 1;
	}

	public static void main(String[] args) {
		List<Integer> list = List.of(100, 100, 50, 40, 40, 20, 10);
		List<Integer> scores = List.of(5, 25, 50, 120);

		var results = climbingLeaderboard(list, scores);
		System.out.println(results);

		List<Integer> list2 = List.of(100, 90, 90, 80, 75, 60);
		List<Integer> scores2 = List.of(50, 65, 77, 90, 102);

		System.out.println(climbingLeaderboard(list2, scores2));

		System.out.println(climbingLeaderboard(getRankedBoard(), getScores()));
	}

	private static List<Integer> getRankedBoard() {
		String sboard = "295 294 291 287 287 285 285 284 283 279 277 274 274 271 270 268 268 268 264 260 259 258 257 255 252 250 244 241 240 237 236 236 231 227 227 227 226 225 224 223 216 212 200 197 196 194 193 189 188 187 183 182 178 177 173 171 169 165 143 140 137 135 133 130 130 130 128 127 122 120 116 114 113 109 106 103 99 92 85 81 69 68 63 63 63 61 57 51 47 46 38 30 28 25 22 15 14 12 6 4";
		return Arrays.stream(sboard.split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
	}

	private static List<Integer> getScores() {
		String sboard = "5 5 6 14 19 20 23 25 29 29 30 30 32 37 38 38 38 41 41 44 45 45 47 59 59 62 63 65 67 69 70 72 72 76 79 82 83 90 91 92 93 98 98 100 100 102 103 105 106 107 109 112 115 118 118 121 122 122 123 125 125 125 127 128 131 131 133 134 139 140 141 143 144 144 144 144 147 150 152 155 156 160 164 164 165 165 166 168 169 170 171 172 173 174 174 180 184 187 187 188 194 197 197 197 198 201 202 202 207 208 211 212 212 214 217 219 219 220 220 223 225 227 228 229 229 233 235 235 236 242 242 245 246 252 253 253 257 257 260 261 266 266 268 269 271 271 275 276 281 282 283 284 285 287 289 289 295 296 298 300 300 301 304 306 308 309 310 316 318 318 324 326 329 329 329 330 330 332 337 337 341 341 349 351 351 354 356 357 366 369 377 379 380 382 391 391 394 396 396 400";
		return Arrays.stream(sboard.split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
	}
}