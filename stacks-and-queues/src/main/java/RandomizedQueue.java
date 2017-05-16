import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item>
  implements Iterable<Item>
{

  private class RandomizedIterator
    implements Iterator<Item>
  {
    private int i;
    private final Item[] b;

    @SuppressWarnings("unchecked")
    public RandomizedIterator()
    {
      b = (Item[]) new Object[n];
      for (int i = 0; i < a.length; i++)
      {
        b[i] = a[i];
      }
      StdRandom.shuffle(b);
    }

    @Override
    public boolean hasNext()
    {
      return i < b.length - 1;
    }

    @Override
    public Item next()
    {
      if (!hasNext())
      {
        throw new NoSuchElementException();
      }
      return b[i--];
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
  @SuppressWarnings("unchecked")
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
    final Item item = a[n - 1];
    a[n - 1] = null;
    n--;
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
    return a[randomInSize() - 1];
  }

  /**
   * return the number of items on the queue
   */
  public int size()
  {
    return n;
  }

  private int randomInSize()
  {
    final int min = 1;
    final int max = n;
    return min + (int) (StdRandom.uniform() * (max - min + 1));
  }

  @SuppressWarnings("unchecked")
  private void resize(final int capacity)
  {
    if (capacity <= n)
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
