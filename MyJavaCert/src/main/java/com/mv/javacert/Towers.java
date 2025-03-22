package com.mv.javacert;

public class Towers {

	/*
	 * Complete the 'towerBreakers' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. INTEGER m
	 */

	public static int towerBreakers(int n, int m) {
		// Write your code here
		int[] towers = new int[n];
		// Initializing towers
		for (int i = 0; i < towers.length; i++) {
			towers[i] = m;
		}

		System.out.println("Initializing " + n + " towers of " + m);
		for (int t : towers) {
			System.out.print("(" + t + ")");
		}
		System.out.println();
		// Player 1
		int winner = 0;
		while (winner == 0) {
			// Player 1
			if (makeAmove(towers) == -1) {
				winner = 2;
				break;
			}

			// Player 2
			if (makeAmove(towers) == -1) {
				winner = 1;
				break;
			}

		}
		System.out.println("Towers end:");
		for (int t : towers) {
			System.out.print("[" + t + "]");
		}
		System.out.println();
		return winner;
	}

	public static int makeAmove(int[] towers) {
		for (int i = 0; i < towers.length; i++) {
			int move = towers[i] - 1;
			if (move == 0) {
				continue;
			}
			if (towers[i] % (towers[i] - move) == 0) {
				towers[i] -= move;
				return 1;
			}
		}
		// No moves left
		return -1;
	}
	
	public static void main(String[] args) {
		int n = 2, m = 2;
		System.out.println("n:" + n + " m: " + 2 + " Winner:" + towerBreakers(n, m));
		n = 1;
		m = 4;
		System.out.println("n:" + n + " m: " + 2 + " Winner:" + towerBreakers(n, m));
	}
}
