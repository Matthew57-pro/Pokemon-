package Game.Player;
import Game.Battle;
import Game.CLI.CLI;
import Game.Pokemon.Pokemon;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.util.ArrayList;

public class Player {
    private Battle battle;
    private String name;
    private int selectedPokemonIndex;
    private ArrayList<Pokemon> pokemons;

    public Player(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        selectedPokemonIndex = 0;

    }
    public String GetName() {return name;}

    public void CatchPokemon(Pokemon p) {
        pokemons.add(p);
    }

    public Pokemon GetPokemon(int index) {
        return pokemons.get(index);
    }

    public void RemovePokemon(int index) {
        pokemons.remove(index);
    }

    public void SelectPokemon(int index) {
        selectedPokemonIndex = index;
    }

    private Pokemon getSelectedPokemon() {
        return pokemons.get(selectedPokemonIndex);
    }
    public int GetPokemonCount (){

        return pokemons.size();

    }
    public String PrintSelectedPokemon() {
        return pokemons.get(selectedPokemonIndex).toString();
    }

    public String PrintPokemons() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pokemons.size(); i++) {
            sb.append(i);
            sb.append(".\t");
            sb.append(pokemons.get(i));
            sb.append(".\n");
        }
        return sb.toString();
    }

    public void StartBattle(Battle battle) {
        this.battle = battle;
    }

    public void PerformTurn() {
        System.out.println("Na tahu je hrac:\t" + this.GetName());
        System.out.println("Aktualne vybraty pokemon je:");
        this.StavPokemona();
        //vykonam jednu z nasledujucich akcii
        //1. vyber pokemona
        //2. utok
        //3. specialny utok
        //4. obrana
        //6. vzdat sa

        //okrem toho su akcie ktore ma nestoa tah
        //7. zistenie aktualneho stavu mojho pokemona
        //8. vypis vsetkych mojich pokemonov
        //9. zistenie stavu protivnikovho pokemona

        //potrebujem si zistit, co chce hrac sravit
        Actions selectedAction = Actions.Default;
        int actionsCount = 1;
        while (actionsCount > 0) {


            //nacitanie akcie
            selectedAction = CLI.getInstance().nacitajAkciu();
            if (selectedAction.COST_ACTION) {
                actionsCount--;
            }
            //vykonanie akcie
            switch (selectedAction) {
                case VyberPokemona:
                    this.VyberPokemona();
                    break;
                //1. vyber pokemona
                case Utok:
                    this.utok();
                    break;
                //2. utok
                case SpecialnyUtok:
                    this.specialnyUtok();
                    break;
                //3. specialny utok
                case Obrana:
                    this.obrana();
                    break;
                //4. obrana

                case Vzdajsa:
                    this.vzdajSa();
                    break;
                //6. vzdat sa
                case ZistenieAktualnehoStavuMojhoPokemona:
                    this.StavPokemona();
                    break;
                //7. zistenie aktualneho stavu mojho pokemona
                case VypisVsetkychMojichPokemonov:
                    this.VypisPokemona();
                    break;
                //8. vypis vsetkych mojich pokemonov
                case ZistenieStavuProtivnikovhoPokemona:
                    this.StavProtivnikovhoPokemona();
                    break;
                //9. zistenie stavu protivnikovho pokemona

            }

        }
    }

    private void StavProtivnikovhoPokemona() {
this.battle.getOtherPlyer(this).StavPokemona();
    }

    private void VypisPokemona() {

        System.out.println(this.PrintPokemons());

    }

    private void StavPokemona() {
        System.out.println(this.PrintSelectedPokemon());

    }

    private void vzdajSa() {
        this.battle.vzdajSa(this);
    }


    private void obrana() {

    }

    private void specialnyUtok() {
this.getSelectedPokemon().SpecialAttack(this.battle.getOtherPlyer(this).getSelectedPokemon());
this.StavProtivnikovhoPokemona();
    }

    private void utok() {
        this.getSelectedPokemon().Attack(this.battle.getOtherPlyer(this).getSelectedPokemon());
        this.StavProtivnikovhoPokemona();
    }

    private void VyberPokemona() {
        this.selectedPokemonIndex = CLI.getInstance().nacitajPokemona(this.PrintPokemons(), this.pokemons.size());
System.out.println("Novy vybratý pokémon je:");
this.StavPokemona();
    }

    public void VypisVysledokBitky(boolean vyhralSom) {
        System.out.println("********** Bitka Skoncila *********");
        if (vyhralSom)
            System.out.println("Vyhral som");
        else
            System.out.println("Prehral som");
    }
}






