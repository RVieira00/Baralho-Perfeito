/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author paulo
 * @param <E> tipo de elemento colecionado
 */
public class SinglyLinkedList<E> implements Iterable<E>{
    //---------------- nested Node class ----------------
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement( ){ return element; }
        public Node<E> getNext( ) { return next; }
        public void setNext(Node<E> n) { next = n; }
    } //----------- end of nested Node class -----------
    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0; // number of nodes in the list
    public SinglyLinkedList(){} // constructs an initially empty list
    // access methods
    public int size( ) { return size; }
    public boolean isEmpty( ) { return size == 0; }
    public E first( ) { // returns (but does not remove) the first element
        if (isEmpty( )) return null;
        return head.getElement( );
    }
    public E last( ) { // returns (but does not remove) the last element
        if (isEmpty( )) return null;
        return tail.getElement( );
    }
    // update methods
    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0)
            tail = head; // special case: new node becomes tail also
        size++;
    }
    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty( ))
            head = newest; // special case: previously empty list
        else
            tail.setNext(newest); // new node after existing tail
        tail = newest; // new node becomes the tail
        size++;
    }
    public E removeFirst( ) { // removes and returns the first element
        if (isEmpty( )) return null; // nothing to remove
        E answer = head.getElement();
        head = head.getNext( ); // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; // special case as list is now empty
        return answer;
    } 

    
    //(aqui surge todo o código já implementado anteriormente)
    
    public Iterator<E> iterator(){return new SLLIterator();} //método da interf. Iterable
    
    //---------------- classe interna SLLIterator ----------------
    private class SLLIterator implements Iterator<E> {
        private Node<E> cursor=head;    // referência para o nodo com o próximo elemento
                                        // a devolver pelo next()
        // Testa se o iterador referencia um nodo válido, o qual conterá o elemento
        // a devolver pelo próximo next().
        public boolean hasNext( ) { return cursor != null; }
        // Devolve o elemento contido no nodo referenciado pelo iterador.
        public E next( ){
            if (cursor == null) throw new NoSuchElementException("Sem próximo elemento");
            Node<E> current=cursor;
            cursor=cursor.getNext();  // O cursor avança para o próximo nodo.
            return current.getElement(); // Devolve o elemento do nodo referenciado.
        }
        public void remove() { //Optamos por não implementá-lo, lançando apenas a exceção.
            throw new UnsupportedOperationException();
        }   
    } //------------ fim da classe interna SLLIterator ------------
} //------------ fim da classe externa SinglyLinkedList ------------
