package Game;
import Game.Player.Player;
import Game.Pokemon.Pokemon;

public class Battle {
    private Player player1;
    private Player player2;
    private boolean battleEnds = false;
    private boolean plWin = false;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void StartBattle() {
        player1.StartBattle(this);
        player2.StartBattle(this);
        battleEnds = false;
        int i = 0;
        while (!battleEnds) {
            if (i % 2 == 0) {

                player1.PerformTurn();

            } else
                player2.PerformTurn();
            {

            }
            //skontrolovat,  ci skoncila bitka
            i++;
            i %= 2;
        }
        //player1.VypisVysledokBitky(plWin);
        //player2.VypisVysledokBitky(plWin);
        System.out.println("********** Bitka Skoncila *********");
        System.out.println("Vyhral hrac" + (plWin ? player1.GetName() : player2.GetName()));
    }

    public Player getOtherPlyer(Player player) {
        return player == player1 ? player2 : player1;
    }

    public void vzdajSa(Player player) {
        this.battleEnds = true;
        plWin = (player == player2);
    }
}