public class Paladin extends Card {
    private int faith;
    private int faithMax;

    public Paladin(String name, int hp) {
        super(name, hp);
        this.faithMax = 100;
        this.faith = 50;
    }

    public Paladin(String name) {
        this(name, 1766);
    }

    public Paladin() {
        this("Sir");
    }

    @Override
    public String getSpecialName() {
        return "Faith";
    }

    @Override
    public int getSpecial() {
        return faith;
    }

    @Override
    public void setSpecial(int n) {
        this.faith = n;
    }

    @Override
    public int getSpecialMax() {
        return faithMax;
    }

    @Override
    public String attack(Card other) {
        int damage = 202;
        other.applyDamage(damage);
        restoreSpecial(20);
        return "\u001b[31m" + this.getName() + " uses Slash on " + other.getName() + " dealing " + damage + " damage!\u001b[0m";
    }

    @Override
    public String specialAttack(Card other) {
        int heal = 500;
        int max = getmaxHP();
        if(getHP() + heal > max) {
            setHP(max);
        } else {
            setHP(getHP() + heal);
        }
        return "\u001b[32m" + this.getName() + " uses Heal, restoring " + heal + " HP!\u001b[0m";
    }

    @Override
    public String support(Card other) {
        int heal = 200;
        int max = other.getmaxHP();
        if(other.getHP() + heal > max) {
            other.setHP(max);
        } else {
            other.setHP(other.getHP() + heal);
        }
        return "\u001b[32m" + this.getName() + " blesses " + other.getName() + ", healing them for " + heal + " HP!\u001b[0m";
    }

    @Override
    public String support() {
        restoreSpecial(40);
        return "\u001b[32m" + this.getName() + " prays, recovering Faith.\u001b[0m";
    }
}
