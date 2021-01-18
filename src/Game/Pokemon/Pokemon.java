package Game.Pokemon;

public class Pokemon {
    private String name = "";
    private int maxHP;
    private int actualHP;

    private int level;
    private int xp;

    public final PokemonType Type;

    private int attack;
    private int specialAttack;


    public Pokemon(int maxHP, int level, int xp, int attack, PokemonType type) {
        this.maxHP = maxHP;
        this.actualHP = maxHP;
        this.level = level;
        this.xp = xp;
        this.attack = attack;
        this.specialAttack = (int)(1.5 * attack);
        this.Type = type;
    }
    public void RecieveAttack(Pokemon target) {
        this.actualHP -= target.attack;
    }
    public void RecieveSpecialAttack(Pokemon target){
        this.actualHP -= target.specialAttack;
    }

    public void Attack(Pokemon target){
        target.RecieveAttack(this );
    }
    public void SpecialAttack(Pokemon target){
        target.RecieveSpecialAttack(this );
    }
    public void SetName(String name) {
        this.name = name;
    }
    public String GetName(){  return this.name;}

    @Override
    public String toString() {
        return "Pokemon" + name + "\nType:" + Type +  "\nLevel: " + level +"\tActual XP: " + xp + "\nMax HP:" + maxHP + "\tActual HP: " + actualHP;
    }
}
