public class Titan extends Card {
    private int protein;
    private int proteinMax;

    public Titan(String name, int hp) {
        super(name, hp);
        this.proteinMax = 100;
        this.protein = 50;
    }

    public Titan(String name) {
        this(name, 4090);
    }

    public Titan() {
        this("Big Man");
    }

    @Override
    public String getSpecialName() {
        return "Protein";
    }

    @Override
    public int getSpecial() {
        return protein;
    }

    @Override
    public void setSpecial(int n) {
        this.protein = n;
    }

    @Override
    public int getSpecialMax() {
        return proteinMax;
    }

    @Override
    public String attack(Card other) {
        int damage = 135;
        other.applyDamage(damage);
        restoreSpecial(5); // Regain protein on basic hit
        return this.getName() + " uses Toss on " + other.getName() + " dealing " + damage + " damage!";
    }

    @Override
    public String specialAttack(Card other) {
        if (getSpecial() >= 25) {
            setSpecial(getSpecial() - 25);
            int damage = 253;
            other.applyDamage(damage);
            return this.getName() + " uses Punch on " + other.getName() + " dealing " + damage + " damage!";
        } else {
            return "Not enough protein to Punch! Instead " + attack(other);
        }
    }

    @Override
    public String support(Card other) {
        int heal = 50;
        int max = other.getmaxHP();
        if(other.getHP() + heal > max){
            other.setHP(max);
        }else{
            other.setHP(other.getHP() + heal);
        }
        return this.getName() + " encourages " + other.getName() + ", healing them for " + heal + " HP!";
    }

    @Override
    public String support() {
        int heal = 100;
        int max = getmaxHP();
        if(getHP() + heal > max){
            setHP(max);
        }else{
            setHP(getHP() + heal);
        }
        restoreSpecial(10);
        return this.getName() + " heals self for " + heal + " HP and recovers Protein.";
    }
}
