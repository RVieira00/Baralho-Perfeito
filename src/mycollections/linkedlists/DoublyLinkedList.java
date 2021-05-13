/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections.linkedlists;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author paulo
 * @param <E> tipo de elemnto colecionado
 */
public class DoublyLinkedList<E> implements Iterable<E>{
    //---------------- nested Node class ----------------
    protected static class Node<E> {                            ////////////////////////////////////paqssou-se de privare para protected
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the subsequent node in the list
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement( ) { return element; }
        public Node<E> getPrev( ) { return prev; }
        public Node<E> getNext( ) { return next; }
        public void setElement(E e) { element = e; }     ////////////////////////////////////adicionou-se este método
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    } //----------- end of nested Node class -----------
    // instance variables of the DoublyLinkedList
    protected Node<E> header; // header sentinel  ////////////////////////////////////paqssou-se de privare para protected
    protected Node<E> trailer; // trailer sentinel    ////////////////////////////////////paqssou-se de privare para protected
    private int size = 0; // number of elements in the list
    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); // create header
        trailer = new Node<>(null, header, null); // trailer is preceded by header
        header.setNext(trailer); // header is followed by trailer
    }
    /** Returns the number of elements in the linked list. */
    public int size( ) { return size; }
    /** Tests whether the linked list is empty. */
    public boolean isEmpty( ) { return size == 0; }
    /** Returns (but does not remove) the first element of the list. */
    public E first( ) {
        //if (isEmpty( )) return null;
        return header.getNext( ).getElement( ); // first element is beyond header
    }
    /** Returns (but does not remove) the last element of the list. */
    public E last( ) {
        //if (isEmpty( )) return null;
        return trailer.getPrev( ).getElement( ); // last element is before trailer
    }  
    // public update methods
    /** Adds element e to the front of the list. */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext( )); // place just after the header
    }
    /** Adds element e to the end of the list. */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev( ), trailer); // place just before the trailer
    }
    /** Removes and returns the first element of the list. */
    public E removeFirst( ) {
        if (isEmpty( )) return null; // nothing to remove
        return remove(header.getNext( )); // first element is beyond header
    }
    /** Removes and returns the last element of the list. */
    public E removeLast( ) {
        if (isEmpty( )) return null; // nothing to remove
        return remove(trailer.getPrev( )); // last element is before trailer
    }
    // private update methods
    /** Adds element e to the linked list in between the given nodes. */
    protected void addBetween(E e, Node<E> predecessor, Node<E> successor) {          ////////////////////////////////////paqssou-se de privare para protected
    // create and link a new node
    Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    /** Removes the given node from the list and returns its element. */
    protected E remove(Node<E> node) {                                           ////////////////////////////////////paqssou-se de privare para protected
        Node<E> predecessor = node.getPrev( );
        Node<E> successor = node.getNext( );
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement( );
    }
    
    
     public Iterator<E> iterator(){return new DLLIterator();} //método da interf. Iterable
    
    //---------------- classe interna SLLIterator ----------------
    private class DLLIterator implements Iterator<E> {
        private Node<E> cursor=header.getNext();// referência para o nodo com o próximo elemento
                                                // a devolver pelo next()
        // Testa se o iterador referencia um nodo válido, o qual conterá o elemento
        // a devolver pelo próximo next().
        public boolean hasNext( ) { return cursor != trailer; }
        // Devolve o elemento contido no nodo referenciado pelo iterador.
        public E next( ){
            if (cursor == trailer) throw new NoSuchElementException("Sem próximo elemento");
            Node<E> current=cursor;
            cursor=cursor.getNext();  // O cursor avança para o próximo nodo.
            return current.getElement(); // Devolve o elemento do nodo referenciado.
        }
        public void remove() { //Optamos por não implementá-lo, lançando apenas a exceção.
            throw new UnsupportedOperationException();
        }   
    } //------------ fim da classe interna SLLIterator ------------  
} //----------- end of DoublyLinkedList class -----------
