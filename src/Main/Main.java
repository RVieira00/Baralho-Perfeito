package Main;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------TESTAR IN-SHUFFLE/OUT-SHUFFLE----------");
        a();

        System.out.println("\n---Testar Numero de In-Shuffles ate obter o Baralho Original---");
        b();

        System.out.println("\n---Testar Numero de Out-Shuffles ate obter o Baralho Original---");
        c();

        System.out.println("\n---Testar a Mover as 3 Cartas de Topo---\n");
        d();
    }

    static void a() {

        Baralho baralho = new Baralho(numberOfCards);
        System.out.println("IN-SHUFFLE");
        baralho.inShuffle();

        Baralho baralho2 = new Baralho(numberOfCards);
        System.out.println("\nOUT-SHUFFLE");
        baralho2.outShuffle();
    }

    static void b() {

        int numberOfCards = 6;
        int counter = 0;
        Baralho baralho = new Baralho(numberOfCards);

        do {
            counter++;
            System.out.println("\nEmbaralhar #" + counter);
            baralho.inShuffle();

        } while (baralho.nextBaralho());

        System.out.println("\nFoi necessario " + counter + " in-shuffles para voltar as " + numberOfCards + " cartas do baralho original!");
    }

    static void c() {

        int numberOfCards = 6;
        int counter = 0;
        Baralho baralho = new Baralho(numberOfCards);

        do {
            counter++;
            System.out.println("\nEmbaralhar #" + counter);
            baralho.outShuffle();
        } while (baralho.nextBaralho());

        System.out.println("\nFoi necessario " + counter + " out-shuffles para voltar as " + numberOfCards + " cartas do baralho original!");
    }

    static void d() {

        int numberOfCards = 6;
        int moveToTopo = 3;

        Baralho baralho = new Baralho(numberOfCards);
        baralho.moveTopo(moveToTopo, true);
    }
}
