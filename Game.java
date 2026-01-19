public class Game {
    public static void main(String[] args) {
        Card player1 = new Titan("Jynxi", 4090);
        Card enemy = new Titan("Leo", 4090); // Using Titan as enemy for testing

        System.out.println("Beginning Battle!");
        System.out.println(player1.getName() + " HP: " + player1.getHP() + " Special: " + player1.getSpecial());
        System.out.println(enemy.getName() + " HP: " + enemy.getHP());
        System.out.println();

        // toss
        System.out.println(player1.attack(enemy));
        System.out.println(enemy.getName() + " HP: " + enemy.getHP());
        System.out.println(player1.getName() + " Special: " + player1.getSpecial()); // Should increase
        System.out.println();

        // special (punch)
        System.out.println(player1.specialAttack(enemy));
        System.out.println(enemy.getName() + " HP: " + enemy.getHP());
        System.out.println(player1.getName() + " Special: " + player1.getSpecial()); // Should decrease
        System.out.println();

        // support self
        System.out.println(player1.support());
        System.out.println(player1.getName() + " HP: " + player1.getHP());
        System.out.println();

        // support others
        System.out.println(player1.support(enemy));
        System.out.println(enemy.getName() + " HP: " + enemy.getHP());
    }
}