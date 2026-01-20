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

        System.out.println("\nLet the battle begin!\n");
        int turn = 1;
        
        while (player1.getHP() > 0 && player2.getHP() > 0){
            Card currentPlayer = (turn == 1) ? player1 : player2;
            Card opponent = (turn == 1) ? player2 : player1;
            
            System.out.println("----------------------------------------");
            System.out.println("Player " + turn + "'s turn (" + currentPlayer.getName() + ")");
            System.out.println(currentPlayer.getName() + " - HP: " + currentPlayer.getHP() + "/" + currentPlayer.getmaxHP() + " | " + currentPlayer.getSpecialName() + ": " + currentPlayer.getSpecial() + "/" + currentPlayer.getSpecialMax());
            System.out.println(opponent.getName() + " - HP: " + opponent.getHP() + "/" + opponent.getmaxHP());
            System.out.println("----------------------------------------");
            System.out.println("Choose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Special Attack");
            System.out.println("3. Support Self");
            System.out.println("4. Support Opponent");
            
            String action = input.nextLine();
            while (!(action.equals("1") || action.equals("2") || action.equals("3") || action.equals("4"))){
                System.out.println("Invalid choice! Please choose 1, 2, 3, or 4.");
                action = input.nextLine();
            }
            
            System.out.println();
            if (action.equals("1")){
                System.out.println(currentPlayer.attack(opponent));
            } else if (action.equals("2")){
                System.out.println(currentPlayer.specialAttack(opponent));
            } else if (action.equals("3")){
                System.out.println(currentPlayer.support());
            } else {
                System.out.println(currentPlayer.support(opponent));
            }
            System.out.println();
            

            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }

        }
        
        System.out.println("\n");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⡀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⠀⠀⠀⢀⣴⣿⡶⠀⣾⣿⣿⡿⠟⠛⠁");
        System.out.println("⠀⠀⠀⠀⠀⠀⣀⣀⣄⣀⠀⠀⠀⠀⣶⣶⣦⠀⠀⠀⠀⣼⣿⣿⡇⠀⣠⣿⣿⣿⠇⣸⣿⣿⣧⣤⠀⠀⠀");
        System.out.println("⠀⠀⢀⣴⣾⣿⡿⠿⠿⠿⠇⠀⠀⣸⣿⣿⣿⡆⠀⠀⢰⣿⣿⣿⣷⣼⣿⣿⣿⡿⢀⣿⣿⡿⠟⠛⠁⠀⠀");
        System.out.println("⠀⣴⣿⡿⠋⠁⠀⠀⠀⠀⠀⠀⢠⣿⣿⣹⣿⣿⣿⣿⣿⣿⡏⢻⣿⣿⢿⣿⣿⠃⣼⣿⣯⣤⣴⣶⣿⡤⠀");
        System.out.println("⣼⣿⠏⠀⣀⣠⣤⣶⣾⣷⠄⣰⣿⣿⡿⠿⠻⣿⣯⣸⣿⡿⠀⠀⠀⠁⣾⣿⡏⢠⣿⣿⠿⠛⠋⠉⠀⠀⠀");
        System.out.println("⣿⣿⠲⢿⣿⣿⣿⣿⡿⠋⢰⣿⣿⠋⠀⠀⠀⢻⣿⣿⣿⠇⠀⠀⠀⠀⠙⠛⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠹⢿⣷⣶⣿⣿⠿⠋⠀⠀⠈⠙⠃⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣴⣶⣦⣤⡀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⣠⡇⢰⣶⣶⣾⡿⠷⣿⣿⣿⡟⠛⣉⣿⣿⣿⠆");
        System.out.println("⠀⠀⠀⠀⠀⠀⢀⣤⣶⣿⣿⡎⣿⣿⣦⠀⠀⠀⢀⣤⣾⠟⢀⣿⣿⡟⣁⠀⠀⣸⣿⣿⣤⣾⣿⡿⠛⠁⠀");
        System.out.println("⠀⠀⠀⠀⣠⣾⣿⡿⠛⠉⢿⣦⠘⣿⣿⡆⠀⢠⣾⣿⠋⠀⣼⣿⣿⣿⠿⠷⢠⣿⣿⣿⠿⢻⣿⣧⠀⠀⠀");
        System.out.println("⠀⠀⠀⣴⣿⣿⠋⠀⠀⠀⢸⣿⣇⢹⣿⣷⣰⣿⣿⠃⠀⢠⣿⣿⢃⣀⣤⣤⣾⣿⡟⠀⠀⠀⢻⣿⣆⠀⠀");
        System.out.println("⠀⠀⠀⣿⣿⡇⠀⠀⢀⣴⣿⣿⡟⠀⣿⣿⣿⣿⠃⠀⠀⣾⣿⣿⡿⠿⠛⢛⣿⡟⠀⠀⠀⠀⠀⠻⠿⠀⠀");
        System.out.println("⠀⠀⠀⠹⣿⣿⣶⣾⣿⣿⣿⠟⠁⠀⠸⢿⣿⠇⠀⠀⠀⠛⠛⠁⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠈⠙⠛⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");

        if (player1.getHP() <= 0){
            System.out.println("Player 2 (" + player2.getName() + ") wins!");
        } else {
            System.out.println("Player 1 (" + player1.getName() + ") wins!");
        }
        System.out.println("\nFinal Stats:");
        System.out.println("Player 1 - HP: " + player1.getHP());
        System.out.println("Player 2 - HP: " + player2.getHP());
        
        input.close();
    }
}
