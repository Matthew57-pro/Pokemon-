package Game.CLI;

import Game.Player.Actions;

import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Struct;
import java.util.Scanner;

public class CLI implements Closeable {
    private Scanner sc;

    private static CLI instance;

    public static CLI getInstance() {
        if (instance == null)
            instance = new CLI();
        return instance;
    }

    private CLI() {
        sc = new Scanner(System.in);
    }

    public Actions nacitajAkciu() {
        //vypise mozne akcie
        //nacita od pouzivatela akciu

        System.out.println("Mozne akcie:");
        for (Actions a :
                Actions.values()) {
            System.out.println(a.ordinal() + "\t" + a.Desc);
        }
        return Actions.values()[_nacitajAkciu(0, Actions.values().length)];
    }

    public int nacitajPokemona(String text, int maxIndex) {
        System.out.println("Zadaj index noveho pokemona:");
        System.out.println(text);
        return _nacitajAkciu(0, maxIndex);
    }

    public int nacitajakciu(String hlavicka, String[] akcie){
        System.out.println(hlavicka);
        for(int i= 0; i< akcie.length; i++) {
            System.out.println("" + i + "\t"+ akcie[i]);
        }
        return _nacitajAkciu(0,akcie.length);
    }
    public String getString(String hlavicka) {
        System.out.println(hlavicka);
        return sc.next();
    }
    public int _nacitajAkciu(int min, int max) {
        while (true) {
            int vybratyIndex = sc.nextInt();
            if (vybratyIndex >= min && vybratyIndex < max) {
                return vybratyIndex;
            }
        else
                {
                System.out.println("Zadal si nespravny index");
            }
        }
    }


    @Override
    public void close() throws IOException {
        sc.close();
    }
}
