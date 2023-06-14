package org.example;

import java.util.*;

public class Main {
	// Values that may be returned by nextNum() private
	static int[] randomNums = {1, 2, 3, 4, 5, 6};
	// Probability of the occurence of randomNums private
	static float[] probabilities = {0.1f, 0.2f, 0.3f, 0.2f, 0.1f, 0.1f};

	public static void main(String[] args) {
		getNextNumber(randomNums, probabilities);
	}

	public static Map<Integer, Integer> getNextNumber(int[] randomNums, float[] probabilities) {
		rangeProbabilities(probabilities);

		Map<Integer, Integer> result = new HashMap<>(); // number, count
		for (int i = 0; i < 100; i++) {
			int num = nextNum(randomNums, probabilities);
			result.put(num, result.getOrDefault(num, 0) + 1);
		}

		return result;
	}

	public static void rangeProbabilities(float[] probabilities) {
		for (int i = 1; i < probabilities.length; i++) {
			probabilities[i] = probabilities[i] + probabilities[i - 1];
		}
	}

	/**
	 Returns one of the randomNums. When this method is called
	 multiple times over a long period, it should return the
	 numbers roughly with the initialized probabilities.
	 */
	public static int nextNum(int[] randomNums, float[] probabilities) {
		Random rd = new Random();
		Float picked = rd.nextFloat();
		int index = getIndexOfProbability(picked, probabilities);
		return randomNums[index];
	}

	public static int getIndexOfProbability(float pickedProbability, float[] probabilities) {
		for (int i = 0; i < probabilities.length; i++) {
			if (probabilities[i] > pickedProbability) {
				return i;
			}
		}
		return 0;
	}
}