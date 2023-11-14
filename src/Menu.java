import java.util.Scanner;

public class Menu {

    public static void main() {
        int choix;

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");


        System.out.println("\n" +
                "┏━━━┓                                     ┏┓ ┏┓\n" +
                "┃┏━┓┃                                     ┃┃ ┃┃\n" +
                "┃┗━┛┃┏┓┏┓ ┏━┓ ┏━━┓ ┏━━┓ ┏━━┓┏━━┓ ┏━━┓ ┏━━┓┃┗━┛┃\n" +
                "┃┏━━┛┃┃┃┃ ┃ ┃ ┃━━┫ ┃━━┫ ┃┏┓┃┃┏┓┃ ┃┏━┫ ┃┃━┫┗━━┓┃\n" +
                "┃┃   ┃┗┛┃ ┃ ┃ ┣━━┃ ┣━━┃ ┃┏┓┃┃┃┃┃ ┃┗━┫ ┃┃━┫   ┃┃\n" +
                "┗┛   ┗━━┛ ┗━┛ ┗━━┛ ┗━━┛ ┗┛┗┛┗┛┗┛ ┗━━┛ ┗━━┛   ┗┛");

        do {

            System.out.println("------------------------------------------\n" +
                    "Bienvenue dans le menu du jeu :\n\n" +
                    "1. Pour jouer, Tapez 1.\n" +
                    "2. Pour voir les règles, Tapez 2.\n" +
                    "3. Pour quitter le programme, Tapez 3.\n" +
                    "------------------------------------------");
            choix = scanner.nextInt();

            switch(choix){
                case 1:
                    Puissance4.main();
                    break;
                case 2:
                    Puissance4.regle();
                    break;
                case 3:
                    System.out.println("Merci et a bientôt !");
                    break;
                default:
                    System.out.println("Erreur.");
                    break;
            }

        }while(choix != 3);


    }

}
