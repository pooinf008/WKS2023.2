package br.edu.ifba.inf011.model.memento.impl2;

import java.util.Stack;

import br.edu.ifba.inf011.model.impl.VooImpl;

public class VooCaretakerStack implements  VooCaretaker{
	
	
	protected Stack<VooImpl.VooSnapshot > snapshots;
	private VooOriginator voo;
	
	public VooCaretakerStack(VooOriginator voo) {
		this.voo = voo;
		this.snapshots = new Stack<VooImpl.VooSnapshot>();
	}
	
	public void checkpoint() {
		VooImpl.VooSnapshot  snapshot = this.voo.save();
		this.snapshots.push(snapshot);
	}
	
	public void undo() {
		VooImpl.VooSnapshot snapshot = this.snapshots.pop();
		this.voo.restore(snapshot);
	}	

}
