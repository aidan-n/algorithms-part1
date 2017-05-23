import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item>
  implements Iterable<Item>
{

  private class RandomizedIterator
    implements Iterator<Item>
  {
    private int currentIndex;
    private final Item[] b;
    private final int size;

    public RandomizedIterator()
    {
      size = n;
      b = (Item[]) new Object[size];
      for (int i = 0; i < size; i++)
      {
        b[i] = a[i];
      }
      StdRandom.shuffle(b);
    }

    @Override
    public boolean hasNext()
    {
      return currentIndex < size;
    }

    @Override
    public Item next()
    {
      if (!hasNext())
      {
        throw new NoSuchElementException();
      }
      return b[currentIndex++];
    }

    @Override
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }

  private Item[] a; // array of items
  private int n; // number of elements in queue

  /**
   * construct an empty randomized queue
   */
  public RandomizedQueue()
  {
    a = (Item[]) new Object[2];
    n = 0;
  }

  /**
   * remove and return a random item
   */
  public Item dequeue()
  {
    if (n == 0)
    {
      throw new NoSuchElementException();
    }

    StdRandom.shuffle(a, 0, n);
    final Item item = a[--n];
    a[n] = null;

    if (n > 0 && n <= a.length / 4)
    {
      resize(a.length / 3);
    }

    return item;
  }

  /**
   * add the item
   */
  public void enqueue(final Item item)
  {
    if (item == null)
    {
      throw new NullPointerException();
    }

    if (n == a.length)
    {
      resize(2 * n);
    }

    a[n] = item;
    n++;
  }

  /**
   * is the queue empty?
   */
  public boolean isEmpty()
  {
    return n == 0;
  }

  /**
   * return an independent iterator over items in random order
   */
  @Override
  public Iterator<Item> iterator()
  {
    return new RandomizedIterator();
  }

  /**
   * return (but do not remove) a random item
   */
  public Item sample()
  {
    if (n == 0)
    {
      throw new NoSuchElementException();
    }
    return a[StdRandom.uniform(n)];
  }

  /**
   * return the number of items on the queue
   */
  public int size()
  {
    return n;
  }

  private void resize(final int capacity)
  {
    if (capacity <= a.length)
    {
      return;
    }

    // textbook implementation
    final Item[] temp = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++)
    {
      temp[i] = a[i];
    }
    a = temp;

    // alternative implementation
    // a = java.util.Arrays.copyOf(a, capacity);
  }

}
