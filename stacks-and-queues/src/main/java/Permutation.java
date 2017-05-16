import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation
{

  public static void main(String[] args)
  {
    RandomizedQueue<String> queue = new RandomizedQueue<>();

    final int k = Integer.parseInt(args[0]);
    for (int i = 0; i < k; i++)
    {
      String string = StdIn.readString();
      queue.enqueue(string);
    }

    for (String string: queue)
    {
      StdOut.println(string);
    }
  }

}
