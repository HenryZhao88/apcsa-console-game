// Collaborators: Henry Zhao, Carter Kuo

import java.util.Random;

public abstract class Card {
    private String name;
    private int HP, maxHP;

    /*There is no no-arg constructor. Be careful with your subclass constructors.*/

    public Card(String name) {
        this(name, 10);
    }

    public Card(String name, int hp) {
        this.name = name;
        this.HP = hp;
        this.maxHP = hp;
    }

    //concrete method written using abstract methods.
    //refill special resource by amount, but only up to at most getSpecialMax()
    public int restoreSpecial(int n) {
        if (n > getSpecialMax() - getSpecial()) {
            n = getSpecialMax() - getSpecial();
        }
        setSpecial(getSpecial() + n);
        return n;
    }

    //Abstract methods are meant to be implemented in child classes.

    /*
      all cards must have a custom special
      consumable resource (mana/rage/money/witts etc)
    */
    //give it a short name (fewer than 13 characters)
    public abstract String getSpecialName();
    //accessor methods
    public abstract int getSpecial();
    public abstract void setSpecial(int n);
    public abstract int getSpecialMax();

    /*
      all cards must have a way to attack enemies and
      support their allys
    */
    //hurt or hinder the target card
    public abstract String attack(Card other);

    //heall or buff the target card
    public abstract String support(Card other);

    //heall or buff self
    public abstract String support();

    //hurt or hinder the target card, consume some special resource
    public abstract String specialAttack(Card other);

    /*
      standard methods
    */
    public void applyDamage(int amount) {
        this.HP -= amount;
    }

    //toString method
    public String toString() {
        return this.getName();
    }

    //Get Methods
    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getmaxHP() {
        return maxHP;
    }
    public void setmaxHP(int newMax) {
        maxHP = newMax;
    }

    //Set Methods
    public void setHP(int health) {
        this.HP = health;
    }

    public void setName(String s) {
        this.name = s;
    }
}
