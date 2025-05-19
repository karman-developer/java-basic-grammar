package game1;

import java.util.List;
import java.util.ArrayList;

public class CardPickGame {
	private int maxBetCoin = 100;
	private int deckSetCount = 2;
	private int possessionCoin;

	public CardPickGame(int possessionCoin) {
		this.possessionCoin = possessionCoin;
	}

	public int execute() {
		if (possessionCoin == 0) {
			return possessionCoin;
		}

		while (true) {
			System.out.println("You have " + possessionCoin + " Coin, Start the game? y / n");
			String userInput = GameUtils.getInputString();

			if (userInput.equalsIgnoreCase("y")) {
				while (true) {
					int betMax = Math.min(maxBetCoin, possessionCoin);
					System.out.println("Please bet Coin 1 ~ " + betMax);
					int userBetCoin = GameUtils.getInputInt();

					if (userBetCoin > 0 && userBetCoin <= betMax) {
						possessionCoin -= userBetCoin;

						int total = getCard();
						boolean isWin = judgeCard(total);
						int winCoin = 0;

						if (isWin) {
							winCoin = userBetCoin * 2;
							possessionCoin += winCoin;
							System.out.println("You Win! Get " + winCoin + "Coin!");
							// high row games
						} else {
							System.out.println("You lose");
						}

						if (possessionCoin == 0) {
							System.out.println("No more coin.");
							return possessionCoin;
						}
						break;
					}
				}
			} else if (userInput.equalsIgnoreCase("n")) {
				System.out.println(possessionCoin);
				return possessionCoin;
			} else {
				System.out.println("Please enter y or n.");
			}
		}
	}

	private int getCard() {
		List<Integer> deck = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			deck.add(i);
			deck.add(i);
		}

		int indexA = GameUtils.getRandomInt(deck.size());
		int cardA = deck.get(indexA);

		deck.remove(indexA);

		int indexB = GameUtils.getRandomInt(deck.size());
		int cardB = deck.get(indexB);

		int total = cardA + cardB;

		System.out.println("Cards drawn are " + cardA + " and " + cardB + ", total is " + total + ".");

		return total;
	}

	private boolean judgeCard(int getCardResult) {
		return getCardResult >= 11;
	}
}