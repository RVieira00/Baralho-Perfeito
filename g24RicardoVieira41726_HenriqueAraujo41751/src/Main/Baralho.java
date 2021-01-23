package Main;

import java.math.BigInteger;
import java.util.Iterator;
import mycollections.ArrayDeque;

public class Baralho {

    private ArrayDeque<Carta> conteudo = new ArrayDeque<>();
    private ArrayDeque<Carta> shuffledDeck = new ArrayDeque<>();

    public Baralho() { } // fim de construtor

    public Baralho(int numeroDeCartas) {

        for (int i = 1; i <= numeroDeCartas; i++) {

            Carta carta = new Carta(Naipe.ESPADAS, i);
            conteudo.addLast(carta);
        }

        shuffledDeck = conteudo;
    } // fim de construtor

    /**
     * Devolve o conteúdo do baralho.
     *
     * @return o conteúdo do baralho.
     */
    public ArrayDeque<Carta> getConteudo() {
        return conteudo;
    }

    public boolean nextBaralho() {

        boolean isEqual = true;

        Iterator<Carta> originalIterator = conteudo.iterator();
        Iterator<Carta> shuffledIterator = shuffledDeck.iterator();

        for (int i = 0; i < conteudo.size(); i++) {

            if (originalIterator.hasNext() && shuffledIterator.hasNext()) {
                if (!originalIterator.next().equals(shuffledIterator.next())) {
                    isEqual = false;
                }
            }
        }

        return !isEqual;
    }

    /**
     * Executa o baralho perfeito in-shuffle.
     */
    public void inShuffle() {

        int counter = 0;

        // Criar 2 baralhos auxiliares Top e Bottom
        ArrayDeque<Carta> topDeck = new ArrayDeque<>();
        ArrayDeque<Carta> bottomDeck = new ArrayDeque<>();

        // Iterar sobre o baralho inicial e corta-lo em dois
        for (Carta carta : shuffledDeck) {

            counter++;
            if (counter <= shuffledDeck.size() / 2) {
                topDeck.addFirst(carta);
            } else {
                bottomDeck.addFirst(carta);
            }
        }

        // Criar um baralho auxiliar baralhado para colocar as metades in-shuffle
        ArrayDeque<Carta> auxDeck = new ArrayDeque<>();
        Iterator<Carta> topDeckIterator = topDeck.iterator();
        Iterator<Carta> bottomDeckIterator = bottomDeck.iterator();

        // Vai colocando as cartas de forma in-shuffle
        for (int i = 0; i < shuffledDeck.size(); i++) {

            boolean isEven = (i % 2 == 0);
            if (isEven && topDeckIterator.hasNext()) {
                auxDeck.addFirst(topDeckIterator.next());
            } else if (bottomDeckIterator.hasNext()) {
                auxDeck.addFirst(bottomDeckIterator.next());
            }
        }

        System.out.println("Baralho Original: " + toString());
        shuffledDeck = auxDeck;
        System.out.println("Baralhado: " + toString());
    } // fim de inShuffle

    /**
     * Executa o baralho perfeito out-shuffle.
     */
    public void outShuffle() {

        int counter = 0;

        // Criar 2 baralhos auxiliares Top e Bottom
        ArrayDeque<Carta> topDeck = new ArrayDeque<>();
        ArrayDeque<Carta> bottomDeck = new ArrayDeque<>();

        // Iterar sobre o baralho inicial e corta-lo em dois
        for (Carta carta : shuffledDeck) {

            counter++;
            if (counter <= shuffledDeck.size() / 2) {
                topDeck.addFirst(carta);
            } else {
                bottomDeck.addFirst(carta);
            }
        }

        // Criar um baralho auxiliar baralhado para colocar as metades out-shuffle
        ArrayDeque<Carta> auxDeck = new ArrayDeque<>();
        Iterator<Carta> topDeckIterator = topDeck.iterator();
        Iterator<Carta> bottomDeckIterator = bottomDeck.iterator();

        // Vai colocando as cartas de forma out-shuffle
        for (int i = 0; i < shuffledDeck.size(); i++) {

            boolean isEven = (i % 2 == 0);
            if (isEven && bottomDeckIterator.hasNext()) {
                auxDeck.addFirst(bottomDeckIterator.next());
            } else if (topDeckIterator.hasNext()) {
                auxDeck.addFirst(topDeckIterator.next());
            }
        }

        System.out.println("Baralho Original: " + toString());
        shuffledDeck = auxDeck;
        System.out.println("Baralhado: " + toString());
    } // fim de outShuffle

    /**
     * Mover a carta de topo do baralho um determinado número de posições para
     * baixo do baralho.
     *
     * @param posicao o número de posições a mover.
     * @param messagens quando as mensagens devem ou não ser escritas.
     */
    public void moveTopo(int posicao, boolean messagens) {

        String binaryString = Integer.toBinaryString(posicao);

        System.out.println("Baralho Original: " + toString());
        System.out.println(posicao + " e equivalente a " + binaryString + " em binario.");
        
        for (char character: binaryString.toCharArray()) {
            
            if (character == '0') {             
                System.out.println("\nOut-Shuffle");
                outShuffle();
            } else if (character == '1') {
                System.out.println("\nIn-Shuffle");
                inShuffle();
            }
        }
        
        System.out.println("\nDepois de movido: " + toString());

    } // fim de moveTopo

    @Override
    public String toString() {
        String toString = "";

        for (Carta carta : shuffledDeck) {
            toString += carta.toString();
        }
        return toString;
    }

} // fim de Baralho 
