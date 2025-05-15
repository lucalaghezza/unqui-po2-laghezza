package ar.edu.unq.po2.tp6.composite.shapeshifter;

import java.util.ArrayList;
import java.util.List;

public class ShapeShifterComposite implements IShapeShifter {
	private List<IShapeShifter> children;

	public ShapeShifterComposite(List<IShapeShifter> children) {
		this.children = new ArrayList<>(children);
	}

	private ShapeShifterComposite() {
		this.children = new ArrayList<>();
	}

	private ShapeShifterComposite add(IShapeShifter s) {
		children.add(s);
		return this;
	}

	@Override
	public IShapeShifter compose(IShapeShifter s) {
		return new ShapeShifterComposite(List.of(this, s));
	}

	@Override
	public int deepest() {
		return 1 + children.stream().mapToInt(IShapeShifter::deepest).max().orElse(0);
	}

	@Override
	public IShapeShifter flat() {
		// nobody knows the implementation inside, we know that values are the leaf values, then make shapeshifters
		ShapeShifterComposite flatComposite = new ShapeShifterComposite();
	    for (Integer val : this.values()) {
	        flatComposite.add(new ShapeShifterLeaf(val));
	    }
	    return flatComposite;
	}

	@Override
	public List<Integer> values() {
		List<Integer> result = new ArrayList<>();
		for (IShapeShifter child : children) {
			result.addAll(child.values());
		}
		return result;
	}

}
