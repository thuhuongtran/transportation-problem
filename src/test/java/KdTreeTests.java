import com.vimensa.fashivi.service.KdTree;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.vimensa.fashivi.service.KdTree.*;

import org.junit.Test;


public class KdTreeTests {
    @Test
    public void testKdTree() {
        List<XYZPoint> points = new ArrayList<XYZPoint>();
        XYZPoint p1 = new XYZPoint(2, 3, "p1");
        points.add(p1);
        XYZPoint p2 = new XYZPoint(5, 4,"p2");
        points.add(p2);
        XYZPoint p3 = new XYZPoint(9, 6,"p3");
        points.add(p3);
        XYZPoint p4 = new XYZPoint(4, 7,"p4");
        points.add(p4);
        XYZPoint p5 = new XYZPoint(8, 1,"p5");
        points.add(p5);
        XYZPoint p6 = new XYZPoint(7, 2,"p6");
        points.add(p6);
        KdTree<XYZPoint> kdTree = new KdTree<XYZPoint>(points);

        Collection<XYZPoint> result = kdTree.nearestNeighbourSearch(1, p3);
        assertTrue("K-D Tree query error. query=(k=1, p=(9, 6)) returned="+result, result.contains(p3));

        XYZPoint search = new XYZPoint(1, 4,"search");
        result = kdTree.nearestNeighbourSearch(4, search);
        assertTrue("K-D Tree query error. query=(k=4, p=(1, 4)) returned="+result, (result.contains(p1) &&
                result.contains(p2) &&
                result.contains(p4) &&
                result.contains(p6))
        );

        kdTree.remove(p6);
        kdTree.remove(p4);
        kdTree.remove(p3);
        kdTree.remove(p5);
        kdTree.remove(p1);
        kdTree.remove(p2);
    }

    @Test
    public void testKdTree_as_iterable() {
        List<XYZPoint> points = new ArrayList<XYZPoint>();
        XYZPoint p1 = new XYZPoint(2, 3, "p1");
        points.add(p1);
        XYZPoint p2 = new XYZPoint(5, 4,"p2");
        points.add(p2);
        XYZPoint p3 = new XYZPoint(9, 6,"p3");
        points.add(p3);
        XYZPoint p4 = new XYZPoint(4, 7,"p4");
        points.add(p4);
        XYZPoint p5 = new XYZPoint(8, 1,"p5");
        points.add(p5);
        XYZPoint p6 = new XYZPoint(7, 2,"p6");
        points.add(p6);
        KdTree<XYZPoint> kdTree = new KdTree<XYZPoint>(points);

        for (final KdTree.XYZPoint p : kdTree)
            assertTrue(kdTree.contains(p));
    }
}
