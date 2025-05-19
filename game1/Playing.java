package game1;

public class Playing {
  public static void main(String[] args) {
    String username = "";
    int possessionCoin = 1000;

    System.out.println("Welcome !");
    System.out.println("Enter your username");

    while (true) {
      String userInput = GameUtils.getInputString();
      username = userInput;
      if (GameUtils.checkPattern(username)) {
        System.out.println("Hello " + username);
        break;
      } else {
        System.out.println("Does not match condition of the username");
      }
    }

    CardPickGame cardPickGame = new CardPickGame(possessionCoin);
    possessionCoin = cardPickGame.execute();

    HighAndLowGame highAndLowGame = new HighAndLowGame(possessionCoin, 3);
    possessionCoin = highAndLowGame.execute();

    System.out.println(username + " Possession : " + possessionCoin + " Coin");
  }
}