public class LP extends Card {
    int elixir, elixirMax;
    String sound;

    /*the other constructors ultimately call the constructor
      with all parameters.*/
    public LP(String name, int hp, String s) {
        super(name, hp);
        elixirMax = 400;
        elixir = elixirMax / 2;
        sound = s;
    }

    public LP(String name, int hp) {
        this(name, hp, "aÑA!");
    }

    public LP(String name) {
        this(name, 1433);
    }

    public LP() {
        this("Peter");
    }

    /*The next 8 methods are all required because they are abstract:*/
    public String getSpecialName() {
        return "elixir";
    }

    public int getSpecial() {
        return elixir;
    }

    public void setSpecial(int n) {
        elixir = n;
    }

    public int getSpecialMax() {
        return elixirMax;
    }

    /*Deal 300-400 damage to opponent, restores 80 elixir*/
    public String attack(Card other) {
        int damage = (int)(Math.random() * 100) + 301;
        other.applyDamage(damage);
        restoreSpecial(80);
        return this + " attacked " + other + " and dealt " + damage +
            " points of damage. They then regenerate their elixir.";
    }
    /*Deal 700-800 damage to opponent, only if elixir is high enough.
      Reduces elixir by 8.
    */
    public String specialAttack(Card other) {
        if (getSpecial() >= 200) {
            setSpecial(getSpecial() - 200);
            int damage = (int)(Math.random() * 100) + 701;
            other.applyDamage(damage);
            return sound + " " + this + " wound for a huge attack, dealing " + damage + " points of damage to " + other;
        } else {
            return "Not enough elixir. Instead " + attack(other);
        }
    }

    /*Restores 5 special to other*/
    public String support(Card other) {
        return "Gives to " + other + " and restores " +
            other.restoreSpecial(160) + " " + other.getSpecialName();
    }
    /*Restores 6 special and 1 hp to self.*/
    public String support() {
        int hp = 400;
        setHP(getHP() + hp);
        return this + " meditates to restores " + restoreSpecial(100) + " " +
            getSpecialName() + " and " + hp + " HP";
    }
}
