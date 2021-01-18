package Game.Player;

public enum Actions {
    //1. vyber pokemona
    //2. utok
    //3. specialny utok
    //4. obrana
    //5. pouzit predmet
    //6. vzdat sa

    //okrem toho su akcie ktore ma nestoa tah
    //7. zistenie aktualneho stavu mojho pokemona
    //8. vypis vsetkych mojich pokemonov
    //9. zistenie stavu protivnikovho pokemona

    Default(false, ""),
    VyberPokemona(true, "Vyber Pokemona do biky"),
    Utok(true, "Zautoc" ),
    SpecialnyUtok(true, "Pouzi specialny utok"),
    Obrana(true, "Obrana "),
    Vzdajsa(true, "Vzdaj sa"),
    ZistenieAktualnehoStavuMojhoPokemona(false, "Zisti aktualny stav pokemona"),
    VypisVsetkychMojichPokemonov(false, "Zisti vsetkych mojich pokemonov"),
    ZistenieStavuProtivnikovhoPokemona(false, "Zisti stav protovnikovho pokemona");

    public final boolean COST_ACTION;
    public final String Desc;

    Actions(boolean cost_action, String desc) {
        COST_ACTION = cost_action;
        Desc = desc;
    }
}
