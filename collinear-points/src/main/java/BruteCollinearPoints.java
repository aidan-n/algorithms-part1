import java.util.Arrays;

import edu.princeton.cs.algs4.LinkedStack;

public class BruteCollinearPoints
{

  private final LinkedStack<LineSegment> segments;

  /**
   * finds all line segments containing 4 points
   */
  public BruteCollinearPoints(final Point[] points)
  {
    if (points == null)
    {
      throw new NullPointerException();
    }
    for (final Point point: points)
    {
      if (point == null)
      {
        throw new NullPointerException();
      }
    }

    segments = new LinkedStack<>();

    for (int i1 = 0; i1 < points.length; i1++)
    {
      for (int i2 = i1 + 1; i2 < points.length; i2++)
      {
        for (int i3 = i2 + 1; i3 < points.length; i3++)
        {
          for (int i4 = i3 + 1; i4 < points.length; i4++)
          {
            final Point[] pointsArray = new Point[] {
                                                      points[i1],
                                                      points[i2],
                                                      points[i3],
                                                      points[i4] };

            final boolean areCollinear = areCollinear(pointsArray);
            if (areCollinear)
            {
              Arrays.sort(pointsArray);
              addLineSegments(pointsArray);
            }
          }
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
    segments.push(new LineSegment(points[0], points[1]));
    segments.push(new LineSegment(points[1], points[2]));
    segments.push(new LineSegment(points[3], points[3]));
  }

  private boolean areCollinear(final Point[] points)
  {
    final double slope1 = points[0].slopeTo(points[1]);
    final double slope2 = points[1].slopeTo(points[2]);
    if (slope1 != slope2)
    {
      return false;
    }
    final double slope3 = points[2].slopeTo(points[3]);
    return slope1 == slope3;
  }

}
