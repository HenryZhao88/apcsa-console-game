import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Welcome to Battle Crown! Choose one of three cards: Paladin, Titan, or LP (Lil' P.L.E.K.K.A)!");
        String c1 = input.nextLine();
        while (!(c1.equals("LP") || c1.equals("Titan") || c1.equals("Paladin"))){
            System.out.println("Please select Paladin, Titan, or LP.");
            c1 = input.nextLine();
        }
        Card player;
        if (c1.equals("LP")){player = new LP();}
        else if (c1.equals("Titan")){player = new Titan();}
        else {player = new Paladin();}

        int random = (int)(Math.random() * 3);
        Card enemy;
        String enemyType;
        if (random == 0){
            enemy = new LP();
            enemyType = "LP";
        } else if (random == 1){
            enemy = new Titan();
            enemyType = "Titan";
        } else {
            enemy = new Paladin();
            enemyType = "Paladin";
        }

        System.out.println("\nYou have selected " + c1 + ". Your enemy has chosen " + enemyType + "!");
        System.out.println("\nLet the battle begin!\n");
        
        boolean quit = false;
        
        while (player.getHP() > 0 && enemy.getHP() > 0 && !quit){
            System.out.println("----------------------------------------");
            System.out.println("Your Turn (" + player.getName() + ")");
            System.out.println(player.getName() + " - HP: " + player.getHP() + "/" + player.getmaxHP() + " | " + player.getSpecialName() + ": " + player.getSpecial() + "/" + player.getSpecialMax());
            System.out.println(enemy.getName() + " - HP: " + enemy.getHP() + "/" + enemy.getmaxHP());
            System.out.println("----------------------------------------");
            System.out.println("Type: attack / special / support / quit");
            
            String action = input.nextLine().toLowerCase();
            while (!(action.equals("a") || action.equals("attack") || action.equals("sp") || action.equals("special") || action.equals("su") || action.equals("support") || action.equals("quit"))){
                System.out.println("Invalid choice! Type: attack / special / support / quit");
                action = input.nextLine().toLowerCase();
            }
            
            if (action.equals("quit")){
                quit = true;
                break;
            }
            
            System.out.println();
            if (action.equals("a") || action.equals("attack")){
                System.out.println(player.attack(enemy));
            } else if (action.equals("sp") || action.equals("special")){
                System.out.println(player.specialAttack(enemy));
            } else if (action.equals("su") || action.equals("support")){
                System.out.println(player.support());
            }
            System.out.println();
            
            if (enemy.getHP() > 0){
                int computerChoice = (int)(Math.random() * 3);
                System.out.println("----------------------------------------");
                System.out.println(enemy.getName() + "'s Turn");
                System.out.println("----------------------------------------");
                if (computerChoice == 0){
                    System.out.println(enemy.attack(player));
                } else if (computerChoice == 1){
                    System.out.println(enemy.specialAttack(player));
                } else {
                    System.out.println(enemy.support());
                }
                System.out.println();
            }
        }
        
        if (!quit){
            System.out.println("\n");
            System.out.println("╔═══╗─────────╔═══╗");
            System.out.println("║╔═╗║─────────║╔═╗║");
            System.out.println("║║─╚╬══╦╗╔╦══╗║║─║╠╗╔╦══╦═╗");
            System.out.println("║║╔═╣╔╗║╚╝║║═╣║║─║║╚╝║║═╣╔╝");
            System.out.println("║╚╩═║╔╗║║║║║═╣║╚═╝╠╗╔╣║═╣║");
            System.out.println("╚═══╩╝╚╩╩╩╩══╝╚═══╝╚╝╚══╩╝");
            System.out.println();

            if (player.getHP() <= 0){
                System.out.println("You have been defeated! " + enemy.getName() + " wins!");
            } else {
                System.out.println("You defeated " + enemy.getName() + "!");
            }
            System.out.println("\nFinal Stats:");
            System.out.println("You (" + player.getName() + ") - HP: " + player.getHP());
            System.out.println("Enemy (" + enemy.getName() + ") - HP: " + enemy.getHP());
        }
        
        input.close();
    }
}
