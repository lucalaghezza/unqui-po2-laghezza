package ar.edu.unq.po2.tp6.composite.shapeshifter;

import java.util.Collections;
import java.util.List;

public class ShapeShifterLeaf implements IShapeShifter{
	private final int value;

    public ShapeShifterLeaf(int value) {
        this.value = value;
    }

	@Override
	public IShapeShifter compose(IShapeShifter ss) {
		return new ShapeShifterComposite(List.of(this,ss));
	}

	@Override
	public int deepest() {
		return 0;
	}

	@Override
	public IShapeShifter flat() {
		return this;
	}

	@Override
	public List<Integer> values() {
		return Collections.singletonList(this.value);
	}

}
