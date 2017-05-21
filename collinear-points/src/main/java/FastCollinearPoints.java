import java.util.Arrays;

import edu.princeton.cs.algs4.LinkedStack;

public class FastCollinearPoints
{

  private final LinkedStack<LineSegment> segments;

  /**
   * finds all line segments containing 4 points
   */
  public FastCollinearPoints(final Point[] points)
  {
    if (points == null)
    {
      throw new NullPointerException();
    }

    segments = new LinkedStack<>();

    if (points.length < 4)
    {
      return;
    }

    for (int i = 0; i < points.length; i++)
    {
      final Point point = points[i];
      if (point == null)
      {
        throw new NullPointerException();
      }

      final Point[] pointsOther = new Point[points.length - 1];
      int index = 0;
      for (int j = 0; j < points.length; j++)
      {
        final Point otherPoint = points[j];
        if (otherPoint == null)
        {
          throw new NullPointerException();
        }
        if (i != j)
        {
          pointsOther[index++] = otherPoint;
        }
      }
      Arrays.sort(pointsOther, point.slopeOrder());

      for (int j = 0; j < pointsOther.length - 2; j++)
      {
        final Point[] points4 = new Point[] {
                                              point,
                                              pointsOther[j],
                                              pointsOther[j + 1],
                                              pointsOther[j + 2] };
        final boolean areCollinear = areCollinear(points4);
        if (areCollinear)
        {
          addLineSegments(points4);
        }
      }

    }

  }

  /**
   * the number of line segments
   */
  public int numberOfSegments()
  {
    return segments.size();
  }

  /**
   * the line segments
   */
  public LineSegment[] segments()
  {
    final LineSegment[] segmentsArray = new LineSegment[segments.size()];
    int index = 0;
    for (final LineSegment lineSegment: segments)
    {
      segmentsArray[index++] = lineSegment;
    }
    return segmentsArray;
  }

  private void addLineSegments(final Point[] points)
  {
    Arrays.sort(points);
    final LineSegment lineSegment = new LineSegment(points[0], points[3]);
    // DEBUG
    // System.out
    // .println(String.format("%s slope %.3f points: %s",
    // lineSegment,
    // points[0].slopeTo(points[3]),
    // Arrays.toString(points)));
    // end DEBUG
    segments.push(lineSegment);
  }

  private boolean areCollinear(final Point[] points)
  {
    final double slope1 = points[0].slopeTo(points[1]);
    final double slope2 = points[1].slopeTo(points[2]);
    if (!doubleEquals(slope1, slope2))
    {
      return false;
    }
    final double slope3 = points[2].slopeTo(points[3]);
    return doubleEquals(slope1, slope3);
  }

  private boolean doubleEquals(final double slope1, final double slope2)
  {
    if (slope1 == Double.POSITIVE_INFINITY
        && slope2 == Double.POSITIVE_INFINITY)
    {
      return true;
    }
    if (slope1 == Double.NEGATIVE_INFINITY
        && slope2 == Double.NEGATIVE_INFINITY)
    {
      return true;
    }
    return Math.abs(slope1 - slope2) < 1e-10;
  }

}
