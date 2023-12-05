package br.edu.ifba.inf011.model.memento.impl2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import br.edu.ifba.inf011.model.impl.VooImpl;

public class VooCaretakerMap {
	
	
	protected Map<String, VooImpl.VooSnapshot > snapshots;
	private VooOriginator voo;
	
	public VooCaretakerMap(VooOriginator voo) {
		this.voo = voo;
		this.snapshots = new HashMap<String, VooImpl.VooSnapshot>();
	}
	
	public void checkpoint() {
		LocalDateTime localDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedString = localDate.format(formatter);		
		VooImpl.VooSnapshot  snapshot = this.voo.save();
		this.snapshots.put(formattedString, snapshot);
	}
	
	public Set<String> saved(){
		return this.snapshots.keySet();
	}
	
	public void undo(String chave) {
		VooImpl.VooSnapshot snapshot = this.snapshots.get(chave);
		this.voo.restore(snapshot);
	}		

}
