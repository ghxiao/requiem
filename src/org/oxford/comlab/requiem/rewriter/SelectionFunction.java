package org.oxford.comlab.requiem.rewriter;

public abstract class SelectionFunction {
	public abstract void selectAtoms(Clause c);
	public abstract boolean isToBePruned(Clause c);
}