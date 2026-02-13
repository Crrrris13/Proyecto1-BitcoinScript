import java.util.ArrayDeque;

public class BitcoinStack {
    private ArrayDeque<String> elements;

    public BitcoinStack() {
        this.elements = new ArrayDeque<>();
    }

    public void push(String data) {
        elements.addFirst(data);
    }

    public String pop(){
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        return elements.removeFirst();
    }

    public void dup() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        String top = elements.peekFirst();
        elements.addFirst(top);
    }

    public void drop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        return elements.peekFirst();
    }

    public String toString() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
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
