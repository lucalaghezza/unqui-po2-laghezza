package ar.edu.unq.po2.tp6.composite.shapeshifter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;

public class ShapeShifterTest {

	@Test
	public void testShapeShifterCompositionAndFlattening() {
	    // a: [1]
	    IShapeShifter a = new ShapeShifterLeaf(1);
	    // b: [2]
	    IShapeShifter b = new ShapeShifterLeaf(2);
	    // c = a.compose(b): [1, 2]
	    IShapeShifter c = a.compose(b);
	    // d = (new Leaf(3)).compose(c): [3, [1, 2]]
	    IShapeShifter d = new ShapeShifterLeaf(3).compose(c);
	    // e = (new Leaf(5)).compose(new Leaf(6)): [5, 6]
	    IShapeShifter e = new ShapeShifterLeaf(5).compose(new ShapeShifterLeaf(6));
	    // f = d.compose(e): [ [3, [1, 2]], [5, 6] ]
	    IShapeShifter f = d.compose(e);
	    // g = f.flat(): [3, 1, 2, 5, 6]
	    IShapeShifter g = f.flat();

	    // --- Validaciones ---
	    assertEquals(0, a.deepest(), "Leaf should have depth 0");
	    assertEquals(1, c.deepest(), "Composite c = a.compose(b) should have depth 1");
	    assertEquals(3, f.deepest(), "Composite f should have depth 3");

	    List<Integer> expectedValues = List.of(3, 1, 2, 5, 6);
	    assertEquals(expectedValues.size(), f.values().size(), "f.values() should have correct size");
	    assertTrue(f.values().containsAll(expectedValues), "f.values() should contain all expected values");

	    assertEquals(1, g.deepest(), "Flattened composite g should have depth 1");
	    assertEquals(expectedValues.size(), g.values().size(), "g.values() should have correct size");
	    assertTrue(g.values().containsAll(expectedValues), "g.values() should contain all expected values");
	}
}
