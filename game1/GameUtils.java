package game1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;

public class GameUtils {
	private static final String REGEX_ALPHABET = "^[A-Za-z]{4,12}$";

	private GameUtils() {

	}

	public static String getInputString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;

		while (true) {
			try {
				input = br.readLine();
				return input;
			} catch (IOException e) {
				System.out.println("Input error...Please retype!");
			}
		}
	}

	public static int getInputInt() {
		int num = 0;

		while (true) {
			String userInput = getInputString();

			try {
				num = Integer.parseInt(userInput);
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Please enter an integer!");
			}
		}
	}

	public static int getRandomInt(int maxValue) {
		Random random = new Random();
		return random.nextInt(maxValue);
	}

	public static boolean checkPattern(String targetStr) {
		if (targetStr == null || targetStr.isEmpty()) {
			return false;
		} else {
			boolean result = Pattern.matches(REGEX_ALPHABET, targetStr);
			return result;
		}
	}
}