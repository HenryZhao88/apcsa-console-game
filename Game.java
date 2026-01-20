import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Welcome to Battle Crown! Each player will choose one of three cards: Paladin, Titan, and LP (Lil' P.L.E.K.K.A)! Player 1, choose your card!");
        String c1 = input.nextLine();
        while (!(c1.equals("LP") || c1.equals("Titan") || c1.equals("Paladin"))){
            System.out.println("Please select Paladin, Titan, or LP.");
            c1 = input.nextLine();
        }
        Card player1;
        if (c1.equals("LP")){player1 = new LP();}
        else if (c1.equals("Titan")){player1 = new Titan();}
        else {player1 = new Paladin();}

        System.out.println("Alright! Player 1 has selected " + c1 + ". Player 2, choose your card!");
        String c2 = input.nextLine();
        while (!(c2.equals("LP") || c2.equals("Titan") || c2.equals("Paladin"))){
            System.out.println("Please select Paladin, Titan, or LP.");
            c2 = input.nextLine();
        }
        Card player2;
        if (c2.equals("LP")){player2 = new LP();}
        else if (c2.equals("Titan")){player2 = new Titan();}
        else {player2 = new Paladin();}

        System.out.println("Let the battle begin!");
        int turn = 1;
        while (player1.getHP() > 0 && player2.getHP() > 0){
            if (turn == 1){
                System.out.println("It is player 1's turn. Choose from the following actions: attack, special attack HENRY I STOPPED HERE")
            }
        }

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
