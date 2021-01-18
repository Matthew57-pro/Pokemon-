package Game;
import Game.Player.Player;
import Game.Pokemon.Pokemon;
import Game.Pokemon.PokemonFactory;
import Game.Pokemon.PokemonType;

public class Main {

    public static void main(String[] args) {

        /*var pikachu = PokemonFactory.getInstance().VytvorPikachua();
        pikachu.SetName("Uzasny Pikachu");
        var charizard = PokemonFactory.getInstance().VytvorCharizarda();
        charizard.SetName("Nejaky dalsi pokemon");
        var nejakyDalsi = PokemonFactory.getInstance().VytvorPikachua();
                nejakyDalsi.SetName("Pikachu 2.0");
        var nejakyChar = PokemonFactory.getInstance().VytvorCharizarda();
        charizard.SetName("Char Char Char");

        Player p1 = new Player ( "Johny ");
        p1.CatchPokemon(pikachu);
        p1.CatchPokemon(nejakyDalsi);


        String s = p1.PrintPokemons();
        System.out.println(s);

        Player p2 = new Player("Fero");
        p2.CatchPokemon(charizard);
        p2.CatchPokemon(nejakyDalsi);

        Battle battle = new Battle (p1, p2);
        battle.StartBattle();*/
        Game g = new Game();
        g.Start();

        //pikachu.Attack(charizard);
    }
}
