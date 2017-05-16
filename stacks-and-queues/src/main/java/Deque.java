import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item>
  implements Iterable<Item>
{

  private class Node
  {
    private Node next;
    private Node previous;
    private Item item;
  }

  /**
   * unit testing (optional)
   */
  public static void main(final String[] args)
  {
  }

  private int n;
  private Node first;

  private Node last;

  /**
   * construct an empty deque
   */
  public Deque()
  {
    first = null;
    last = null;
    n = 0;
    check();
  }

  /**
   * add the item to the front
   */
  public void addFirst(final Item item)
  {
    if (item == null)
    {
      throw new NullPointerException();
    }

    final Node oldfirst = first;

    first = new Node();
    first.item = item;
    first.next = oldfirst;
    first.previous = null;

    oldfirst.previous = first;

    n++;

    if (n == 1)
    {
      last = first;
    }

    check();
  }

  /**
   * add the item to the end
   */
  public void addLast(final Item item)
  {
    if (item == null)
    {
      throw new NullPointerException();
    }

    final Node newLast = new Node();
    newLast.item = item;
    newLast.next = null;
    newLast.previous = last;

    last.next = newLast;
    last = newLast;

    n++;

    if (n == 1)
    {
      first = last;
    }

    check();
  }

  /**
   * is the deque empty?
   */
  public boolean isEmpty()
  {
    return first == null;
  }

  /**
   * return an iterator over items in order from front to end
   */
  @Override
  public Iterator<Item> iterator()
  {
    return null;
  }

  /**
   * remove and return the item from the front
   */
  public Item removeFirst()
  {
    if (isEmpty())
    {
      throw new NoSuchElementException();
    }

    final Item item = first.item; // save item to return

    first = first.next; // delete first node
    first.previous = null;

    n--;

    if (n == 0)
    {
      last = null;
    }

    check();

    return item; // return the saved item
  }

  /**
   * remove and return the item from the end
   */
  public Item removeLast()
  {
    if (isEmpty())
    {
      throw new NoSuchElementException();
    }

    final Item item = last.item; // save item to return

    last = last.previous; // delete last node

    n--;

    if (n == 0)
    {
      first = null;
    }

    check();

    return item; // return the saved item
  }

  /**
   * return the number of items on the deque
   */
  public int size()
  {
    return n;
  }

  private void check()
  {

    // check a few properties of instance variable 'first'
    if (n < 0)
    {
      throw new IllegalStateException("Bad deque size, " + n);
    }
    if (n == 0)
    {
      if (first != null)
      {
        throw new IllegalStateException("Inconsistent deque state");
      }
    }
    else if (n == 1)
    {
      if (first == null)
      {
        throw new IllegalStateException("Inconsistent deque state");
      }
      if (first.next != null)
      {
        throw new IllegalStateException("Inconsistent deque state");
      }
    }
    else
    {
      if (first == null)
      {
        throw new IllegalStateException("Inconsistent deque state");
      }
      if (first.next == null)
      {
        throw new IllegalStateException("Inconsistent deque state");
      }
    }

    // check internal consistency of instance variable n
    int numberOfNodes = 0;
    for (Node x = first; x != null && numberOfNodes <= n; x = x.next)
    {
      numberOfNodes++;
    }
    if (numberOfNodes != n)
    {
      throw new IllegalStateException("Inconsistent deque state");
    }

  }

}
