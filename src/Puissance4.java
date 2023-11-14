import java.util.Scanner;

public class Puissance4 {

    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static void main (){

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");


        int tours = 0, c = 0, ligneColonne = 0;
        int joueur = 0;

        do{
            System.out.println("Nombre de ligne et de colonne (entre 4 et 10) :");
            ligneColonne = scanner.nextInt();
        }while(ligneColonne < 4 || ligneColonne > 10);

        char[][][] tab = new char[ligneColonne][ligneColonne][2];

        int[] tabPoint = new int[]{0, 0};

        remplissage(tab);
        affichage(tab);


        do {
            if(testPlace(tab) == false)
            {
                break;
            }
            if (tours%2 == 0)
                joueur = 1;
            else
                joueur = 2;
            placement(tab, joueur);

            affichage(tab);


            tours++;
        }while(verification(tab, joueur, tabPoint));

        System.out.println("joueur 1 = "+tabPoint[0]+" point(s)");
        System.out.println("joueur 2 = "+tabPoint[1]+" point(s)");

        if (tabPoint[0] > tabPoint[1])
            System.out.println("Victoire du joueur 1!!");
        else if(tabPoint[0] < tabPoint[1])
            System.out.println("Victoire du joueur 2!!");
        else
            System.out.println("Egalité !!");

        Menu.main();


    }

    public static boolean testPlace (char[][][] tableau){
        boolean emptyTab = false;

        for(int i = 0;i<tableau.length;i++)
        {
            for(int j = 0;j<tableau[0].length;j++)
            {
                if(tableau[i][j][0] == ' ')
                {
                    emptyTab = true;
                }
            }
        }

        return emptyTab;
    }

    public static void remplissage (char[][][] tableau){

        for(int i = 0;i<tableau.length;i++)
        {
            for(int j = 0;j<tableau[0].length;j++)
            {
                tableau[i][j][0] = ' ';
                tableau[i][j][1] = '0';
            }
        }
    }

    public static void affichage (char[][][] tableau){

        for(int i = 0;i<tableau.length;i++)
        {
            System.out.print("|");
            for(int j = 0;j<tableau[0].length;j++)
            {
                if (tableau[i][j][0] == 'X')
                    System.out.print(YELLOW+tableau[i][j][0]+RESET+"|");
                else if (tableau[i][j][0] == 'O')
                    System.out.print(RED+tableau[i][j][0]+RESET+"|");
                else
                    System.out.print(tableau[i][j][0]+"|");
            }
            System.out.println();
        }
        System.out.println();

        /*for(int i = 0;i<tableau.length;i++)
        {
            System.out.print("|");
            for(int j = 0;j<tableau[0].length;j++)
            {
                System.out.print(tableau[i][j][1]+"|");
            }
            System.out.println();
        }*/


        System.out.println();
    }

    public static boolean verification (char[][][] tableau, int joueur, int[] tabPoint){


        for(int i = (tableau.length)-1;i> 2;i--)/* TEST DIAG ASC*/
        {
            for(int j = 0;j< (tableau[0].length)-3;j++)
            {
                if(tableau[i][j][0] == 'X' || tableau[i][j][0] == 'O')
                {
                    if(tableau[i][j][0] == tableau[i-1][j+1][0] && tableau[i][j][0] == tableau[i-2][j+2][0] && tableau[i][j][0] == tableau[i-3][j+3][0] &&
                            !(tableau[i][j][1] == '1' && tableau[i-1][j+1][1] == '1' || tableau[i][j][1] == '1' && tableau[i-2][j+2][1] == '1' ||
                                    tableau[i][j][1] == '1' && tableau[i-3][j+3][1] == '1' || tableau[i-1][j+1][1] == '1' && tableau[i-2][j+2][1] == '1' ||
                                    tableau[i-1][j+1][1] == '1' && tableau[i-3][j+3][1] == '1' || tableau[i-2][j+2][1] == '1' && tableau[i-3][j+3][1] == '1'))
                    {

                            tableau[i][j][1] = '1';
                            tableau[i-1][j+1][1] = '1';
                            tableau[i-2][j+2][1] = '1';
                            tableau[i-3][j+3][1] = '1';

                            if(tableau[i][j][0] == 'X')
                            {
                                tabPoint[0]++;
                                System.out.println(tabPoint[0]+" point pour le joueur "+joueur+", félicitation !!\n");
                            }
                            else
                            {
                                tabPoint[1]++;
                                System.out.println(tabPoint[1]+" point pour le joueur "+joueur+", félicitation !!\n");
                            }


                        return true;
                    }
                }
            }
        }

        for(int i = (tableau.length)-1;i> 2;i--)/* TEST DIAGONALE DESC*/
        {
            for(int j = tableau.length-1;j> 2;j--)
            {



                if(tableau[i][j][0] == 'X' || tableau[i][j][0] == 'O')
                {
                    if(tableau[i][j][0] == tableau[i-1][j-1][0] && tableau[i][j][0] == tableau[i-2][j-2][0] && tableau[i][j][0] == tableau[i-3][j-3][0] &&
                            !(tableau[i][j][1] == '1' && tableau[i-1][j-1][1] == '1' || tableau[i][j][1] == '1' && tableau[i-2][j-2][1] == '1' ||
                                    tableau[i][j][1] == '1' && tableau[i-3][j-3][1] == '1' || tableau[i-1][j-1][1] == '1' && tableau[i-2][j-2][1] == '1' ||
                                    tableau[i-1][j-1][1] == '1' && tableau[i-3][j-3][1] == '1' || tableau[i-2][j-2][1] == '1' && tableau[i-3][j-3][1] == '1'))
                    {

                            tableau[i][j][1] = '1';
                            tableau[i-1][j-1][1] = '1';
                            tableau[i-2][j-2][1] = '1';
                            tableau[i-3][j-3][1] = '1';

                            if(tableau[i][j][0] == 'X')
                            {
                                tabPoint[0]++;
                                System.out.println(tabPoint[0]+" point pour le joueur "+joueur+", félicitation !!\n");
                            }
                            else
                            {
                                tabPoint[1]++;
                                System.out.println(tabPoint[1]+" point pour le joueur "+joueur+", félicitation !!\n");
                            }

                        return true;
                    }
                }
            }
        }

        for(int i = (tableau.length)-1;i>= 0;i--)/* TEST LIGNE HORIZONTALE*/
        {
            for(int j = 0;j< (tableau[0].length)-3;j++)
            {
                if(tableau[i][j][0] == 'X' || tableau[i][j][0] == 'O')
                {
                    if(tableau[i][j][0] == tableau[i][j+1][0] && tableau[i][j][0] == tableau[i][j+2][0] && tableau[i][j][0] == tableau[i][j+3][0] &&
                            !(tableau[i][j][1] == '1' && tableau[i][j+1][1] == '1' || tableau[i][j][1] == '1' && tableau[i][j+2][1] == '1' ||
                                    tableau[i][j][1] == '1' && tableau[i][j+3][1] == '1' || tableau[i][j+1][1] == '1' && tableau[i][j+2][1] == '1' ||
                                    tableau[i][j+1][1] == '1' && tableau[i][j+3][1] == '1' || tableau[i][j+2][1] == '1' && tableau[i][j+3][1] == '1'))
                    {
                            tableau[i][j][1] = '1';
                            tableau[i][j+1][1] = '1';
                            tableau[i][j+2][1] = '1';
                            tableau[i][j+3][1] = '1';

                            if(tableau[i][j][0] == 'X')
                            {
                                tabPoint[0]++;
                                System.out.println(tabPoint[0]+" point pour le joueur "+joueur+", félicitation !!\n");
                            }
                            else
                            {
                                tabPoint[1]++;
                                System.out.println(tabPoint[1]+" point pour le joueur "+joueur+", félicitation !!\n");
                            }

                        return true;
                    }
                }
            }
        }


        for(int i = (tableau.length)-1;i> 2;i--)/* TEST LIGNE VERTICALE*/
        {
            for(int j = 0;j< (tableau[0].length);j++)
            {
                if(tableau[i][j][0] == 'X' || tableau[i][j][0] == 'O')
                {
                    if(tableau[i][j][0] == tableau[i-1][j][0] && tableau[i][j][0] == tableau[i-2][j][0]&& tableau[i][j][0] == tableau[i-3][j][0] &&
                            !(tableau[i][j][1] == '1' && tableau[i-1][j][1] == '1' || tableau[i][j][1] == '1' && tableau[i-2][j][1] == '1' ||
                                    tableau[i][j][1] == '1' && tableau[i-3][j][1] == '1' || tableau[i-1][j][1] == '1' && tableau[i-2][j][1] == '1' ||
                                    tableau[i-1][j][1] == '1' && tableau[i-3][j][1] == '1' || tableau[i-2][j][1] == '1' && tableau[i-3][j][1] == '1'))
                    {
                            tableau[i][j][1] = '1';
                            tableau[i-1][j][1] = '1';
                            tableau[i-2][j][1] = '1';
                            tableau[i-3][j][1] = '1';

                            if(tableau[i][j][0] == 'X')
                            {
                                tabPoint[0]++;
                                System.out.println(tabPoint[0]+" point pour le joueur "+joueur+", félicitation !!\n");
                            }
                            else
                            {
                                tabPoint[1]++;
                                System.out.println(tabPoint[1]+" point pour le joueur "+joueur+", félicitation !!\n");
                            }

                        return true;
                    }
                }
            }
        }


        return true;
    }


    public static void placement(char[][][] tableau, int joueur){
        char symb;
        int pos = 0;
        int loc;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        if (joueur == 1)
            symb = 'X';
        else
            symb = 'O';

        do {
            do {
                System.out.println("Joueur "+joueur+", entrez un nombre entre 1 et 7 :");
                loc = scanner.nextInt();
            }while(loc<1 || loc> tableau.length);

            for(int i = 0;i<tableau[0].length;i++)
            {
                if (tableau[(tableau[0].length-1)-i][loc-1][0] == ' '){
                    tableau[(tableau[0].length-1)-i][loc-1][0] = symb;
                    pos = 1;
                    break;
                }
            }

            if(pos == 0)
            {
                System.out.println("Plus de place sur la colonne !");
            }
        }while(pos == 0);

    }

    public static void regle (){

        System.out.println("Cette évolution du puissance 4 est un jeu inédit qui demande une certaine concentration. \n" +
                "La première particularité du jeu est qu'il ne se joue pas sur un tableau de 7 par 7. En  effet, \n" +
                "les joueurs peuvent choisir un nombre en 4 et 10 qui définira la taille du plateau.\n" +
                "La seconde particularité est qu'il ne suffit pas d'aligner 4 pions pour gagner. Désormais, aligner 4 pions vous permet " +
                "de gagner 1 point et celui qui a le plus de point lorsque le plateau est rempli gagne !\n\n" +
                "PS : La seule façon de finir la partie est donc de remplir toutes les cases.\n");

    }

}