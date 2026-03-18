package bitcoinscript.engine;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implementacion de la pila utilizada durante la ejecucion de los scripts.
 * La pila sigue LIFO (Last In, First Out) y almacena elementos en forma de cadenas de texto.
 */
public class BitcoinStack {
    private Deque<String> elements;

    /**
     * Constructor de la pila.
     * Inicializa la estructura interna.
     */
    public BitcoinStack() {
        this.elements = new ArrayDeque<>();
    }

    /**
     * Inserta un elemento en la parte superior de la pila.
     * @param data valor a insertar
     */
    public void push(String data) {
        elements.addFirst(data);
    }

    /**
     * Extrae el elemento superior de la pila.
     * @return elemento extraido
     * @throws RuntimeException si la pila esta vacia
     */
    public String pop(){
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        return elements.removeFirst();
    }

    /**
     * Duplica el elemento superior de la pila.
     * @throws RuntimeException si la pila esta vacia
     */
    public void dup() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        String top = elements.peekFirst();
        elements.addFirst(top);
    }

    /**
     * Elimina el elemento superior de la pila.
     * @throws RuntimeException si la pila esta vacia
     */
    public void drop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        elements.removeFirst();
    }

    /**
     * Verifica si la pila esta vacia.
     * @return true si no contiene elementos
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Obtiene el elemento superior sin removerlo.
     * @return elemento superior
     * @throws RuntimeException si la pila esta vacia
     */
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        return elements.peekFirst();
    }

    /**
     * Devuelve una representacion textual de la pila.
     * @return contenido de la pila
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        for (String element : elements) {
            if (!first) sb.append(", ");
            sb.append(element);
            first = false;
        }
        sb.append("]");
        return sb.toString();
    }

}
