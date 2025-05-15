package ar.edu.unq.po2.tp6.composite.shapeshifter;

import java.util.List;

public interface IShapeShifter {
	public IShapeShifter compose(IShapeShifter ss);
	public int deepest();
	public IShapeShifter flat();
	public List<Integer> values();
}
