package Game;

import Game.CLI.CLI;
import Game.Player.Player;
import Game.Pokemon.Pokemon;
import Game.Pokemon.PokemonFactory;

public class Game {
    private MatchMaker matchMaker;
    public Game() {
        matchMaker = new MatchMaker();
    }
    public void Start() {
        String hlavicka ="Vitaj v hre PokemonBattle.";
        String[] moznosti = {"Start", "Exit"};
        while(true) {
            int akcia = CLI.getInstance().nacitajakciu(hlavicka, moznosti);
            switch (akcia) {
                case 0:
                    this.startGame();
                    break;
                case 1:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private void startGame() {
    String meno = CLI.getInstance().getString("Zadaj meno hraca:");
    Player p = new Player(meno);
    Pokemon pokemon = PokemonFactory.getInstance().VytvorPikachua();
    pokemon.SetName("Pikachu 1");
    p.CatchPokemon(pokemon);
    System.out.println("Vitaj, " + meno + " vhra, ktora ta absolutne rozbije :)");
    String hlavicka = "Zadaj akciu, ktoru chces vykonat";
    String[] moznosti = {"Dalsia Bitka", "Koniec hry"};

    while (true){
        int akcia = CLI.getInstance().nacitajakciu(hlavicka, moznosti);
        switch (akcia) {
            case 0:
                matchMaker.dalsiaBitka(p);
                break;
            case 1:
                return;
            default:
                break;
        }
    }
}
}
