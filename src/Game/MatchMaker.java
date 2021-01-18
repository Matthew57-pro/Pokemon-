package Game;

import Game.Player.Player;
import Game.Pokemon.Pokemon;
import Game.Pokemon.PokemonFactory;

import java.util.Random;


public class MatchMaker {
    private Random rnd;

    public void dalsiaBitka(Player p) {
        System.out.println("So the battle begins");
        //Vytvor dalsieho hraa (idealne - rovnaky pocet pokemonov ako m,a hrac p, rovnaky level)
        Player p2 = vytvorHraca(p);
        //Vytvor bitku
        Battle b = new Battle(p, p2);
        //spusti bitku
        b.StartBattle();
    }

    private Player vytvorHraca(Player p) {
        Player p2 = new Player("Jozko");
        int pocetPokemonov = Math.max(p.GetPokemonCount() + rnd.nextInt(3) - 1, 1);
        for (int i = 0; i < pocetPokemonov; i++) {
            Pokemon pok;
            if (rnd.nextBoolean()) {
                pok = PokemonFactory.getInstance().VytvorPikachua();
            } else
                pok = PokemonFactory.getInstance().VytvorCharizarda();

            pok.SetName("Pokemon" + i);
            p2.CatchPokemon(pok);

        }
        return p2;
    }

    public MatchMaker() {
        rnd = new Random();
    }
}


