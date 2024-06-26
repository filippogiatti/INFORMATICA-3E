import java.util.Scanner;
import java.util.Random;

public class giatti_fiammiferiMod_3E {

    public static void main(String[] Args) {
        Scanner scanner = new Scanner(System.in);
        int giocatore1 = 0, giocatore2 = 0, fiammiferi = 21;
        String errore = "Errore!!! Il numero supera 3\n";

        System.out.println("-------------------------------------\n");
        System.out.println("Benvenuti al gioco dei fiammiferi!\n");
        System.out.println("-------------------------------------\n");

        while (true) {
            System.out.println("MODALITA' DI GIOCO");
            System.out.println("[1] 2 giocatori");
            System.out.println("[2] Giocatore vs Computer");
            System.out.println("[3] Computer vince sempre");
            System.out.println("[4] quit");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    giocatoreVsGiocatore(scanner, fiammiferi);
                    break;
                case 2:
                    giocatoreVsComputer(scanner, fiammiferi);
                    break;
                case 3:
                    computerVinceSempre(scanner, fiammiferi);
                    break;
                case 4:
                    System.out.println("Arrivederci!");
                    return;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }
    }

    private static void giocatoreVsGiocatore(Scanner scanner, int fiammiferi) {
        int giocatore1, giocatore2;

        while (fiammiferi > 0) {
            printFiammiferi(fiammiferi);
            System.out.println("\nGiocatore 1 inserisci il numero di fiammiferi che vuoi togliere (massimo 3):");
            giocatore1 = scanner.nextInt();
            if (giocatore1 > 3 || giocatore1 == 0) {
                System.out.println("Hai inserito un numero maggiore di 3 o minore di 1. Verrà preso automaticamente il valore 3.");
                giocatore1 = 3;
            }
            fiammiferi -= giocatore1;

            if (fiammiferi <= 0) {
                System.out.println("Ha vinto il giocatore 1");
                break;
            }
            System.out.println("Fiammiferi rimanenti: " + fiammiferi);

            System.out.println("\nGiocatore 2 inserisci il numero di fiammiferi che vuoi togliere (massimo 3):");
            giocatore2 = scanner.nextInt();
            if (giocatore2 > 3 || giocatore2 == 0) {
                System.out.println("Hai inserito un numero maggiore di 3 o minore di 1. Verrà preso automaticamente il valore 3.");
                giocatore2 = 3;
            }
            fiammiferi -= giocatore2;

            if (fiammiferi <= 0) {
                System.out.println("Ha vinto il giocatore 2");
                break;
            }
            System.out.println("Fiammiferi rimanenti: " + fiammiferi);
        }
    }

    private static void giocatoreVsComputer(Scanner scanner, int fiammiferi) {
        int giocatore1, mossaComputer;
        Random random = new Random();

        while (fiammiferi > 0) {
            printFiammiferi(fiammiferi);
            System.out.println("\nGiocatore inserisci il numero di fiammiferi che vuoi togliere (massimo 3):");
            giocatore1 = scanner.nextInt();
            if (giocatore1 > 3 || giocatore1 == 0) {
                System.out.println("Hai inserito un numero maggiore di 3 o minore di 1. Verrà preso automaticamente il valore 3.");
                giocatore1 = 3;
            }
            fiammiferi -= giocatore1;

            if (fiammiferi <= 0) {
                System.out.println("Ha vinto il giocatore");
                break;
            }
            System.out.println("Fiammiferi rimanenti: " + fiammiferi);

            mossaComputer = random.nextInt(3) + 1;
            System.out.println("Il computer ha rimosso " + mossaComputer + " fiammifero/i.");
            fiammiferi -= mossaComputer;

            if (fiammiferi <= 0) {
                System.out.println("Ha vinto il computer");
                break;
            }
            System.out.println("Fiammiferi rimanenti: " + fiammiferi);
        }
    }

    private static void computerVinceSempre(Scanner scanner, int fiammiferi) {
        Random random = new Random();

        while (fiammiferi > 0) {
            printFiammiferi(fiammiferi);
            int mossaComputer = (fiammiferi - 1) % 4 == 0 ? 1 : (fiammiferi - 2) % 4 == 0 ? 2 : 3;
            System.out.println("\nIl computer ha rimosso " + mossaComputer + " fiammifero/i.");
            fiammiferi -= mossaComputer;

            if (fiammiferi <= 0) {
                System.out.println("Ha vinto il computer");
                break;
            }

            System.out.println("Fiammiferi rimanenti: " + fiammiferi);
            System.out.println("\nIl giocatore deve ora fare la sua mossa. Inserisci il numero di fiammiferi che vuoi togliere (massimo 3): ");

            int giocatore = scanner.nextInt();
            if (giocatore > 3) {
                System.out.println("Hai inserito un numero maggiore di 3. Verrà preso automaticamente il valore 3.");
                giocatore = 3;
            }
            fiammiferi -= giocatore;

            if (fiammiferi <= 0) {
                System.out.println("Ha vinto il giocatore");
                break;
            }
            System.out.println("Fiammiferi rimanenti: " + fiammiferi);
        }
    }

    private static void printFiammiferi(int fiammiferi) {
        /* creo un ciclo dove stampare più fiammiferi */
        for(int i=0;i<fiammiferi;i++)
            System.out.print("\t*");
        System.out.println("\n");
        for(int i=0;i<fiammiferi;i++)
            System.out.print("\t|");
        System.out.print("\n");
        for(int i=0;i<fiammiferi;i++)
            System.out.print("\t|");
        System.out.print("\n");
        for(int i=0;i<fiammiferi;i++)
            System.out.print("\t|");
    }
}
