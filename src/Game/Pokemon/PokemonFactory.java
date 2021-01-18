package Game.Pokemon;

public class PokemonFactory {
    private static PokemonFactory instance;

    public static PokemonFactory getInstance() {
        if (instance == null)
            instance = new PokemonFactory();
        return instance;

    }
    private PokemonFactory() {}
    public Pokemon VytvorPikachua() {
        return new Pokemon( 30, 1,  0, 10, PokemonType.Electric);
    }
    public Pokemon VytvorCharizarda() {
        return new Pokemon( 60, 1,  0, 10, PokemonType.Dragon);
    }
}
