import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation
{

  public static void main(final String[] args)
  {

    int k = Integer.parseInt(args[0]);
    if (k <= 0)
    {
      throw new IllegalArgumentException();
    }

    final RandomizedQueue<String> queue = new RandomizedQueue<>();
    while (!StdIn.isEmpty())
    {
      final String string = StdIn.readString();
      queue.enqueue(string);
    }

    for (final String string: queue)
    {
      StdOut.println(string);
      k--;
      if (k == 0)
      {
        break;
      }
    }

  }

}
