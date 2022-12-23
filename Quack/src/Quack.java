package src;

import java.util.Iterator;
import java.util.LinkedList;


public class Quack<T> {

    private int itemCount;
    private LinkedList<T> values;


    /**
     * Constructor for an empty quack.
     */
    public Quack() {
        this.itemCount = 0;
        this.values = new LinkedList<>();
    }


    /**
     * Adds an item to the quack.
     * @param item the item to be added
     */
    public void push(T item) {
        values.addLast(item);
        ++itemCount;
    }


    /**
     * Pops from the quack with queue behaviour.
     * @return the item at the front of the queue
     */
    public T qpop() {
        T value = values.getFirst();
        values.removeFirst();
        --itemCount;
        return value;
    }


    /**
     * Pops from the quack with stack behaviour.
     * @return the item at the top of the stack
     */
    public T spop() {
        T value = values.getLast();
        values.removeLast();
        --itemCount;
        return value;
    }


    /**
     * Retirieve item at front of queue without removing it.
     * @return the next item to be popped with queue behaviour
     */
    public T qpeek() {
        return values.getFirst();
    }


    /**
     * Retrieve item at top of stack witihout removing it.
     * @return the next item to be popped with stack behaviour
     */
    public T speek() {
        return values.getLast();
    }



    // Overrides.

    @Override
    public boolean equals(Object o) {
        // False if comparing with null object.
        if (o == null) {
            return false;
        }

        // True if comparing with itself.
        if (o == this) {
            return true;
        }

        // False if not comparing with another quack.
        if (o.getClass() != getClass()) {
            return false;
        }

        // Typecast o to a quack before checking equality.
        Quack<?> other = (Quack<?>) o;

        return other.getItemCount() == itemCount
        && other.getValues().equals(values);
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "\nEmpty quack\n\n";
        } else if (itemCount == 1) {
            return "\nQuack with 1 item:\n"
            + "  Top --> " + getItemCount() + " <-- Front\n\n";
        } else {
            // Print capacity.
            String firstLine = "\nQuack with " + getItemCount() + " items:\n";

            // Traverse the list, printing each element.
            String quackRep = "";
            Iterator<T> it = values.descendingIterator();

            while (it.hasNext()) {
                T value = it.next();
                if (value == values.getFirst()) {
                    quackRep += "Front --> " + value + "\n";
                } else if (value == values.getLast()) {
                    quackRep += "  Top --> " + value + "\n";
                } else {
                    quackRep += "          " + value + "\n";
                }
            }

            return firstLine + quackRep + "\n";
        }
    }



    // Getters and setters.

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void incItemCount() {
        ++this.itemCount;
    }

    public void decItemCount() {
        --this.itemCount;
    }

    public LinkedList<T> getValues() {
        return values;
    }

}
