package br.edu.ifba.inf011.observer;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSubject {
	private List<Observer> observers;
	
	public AbstractSubject() {
		this.observers = new LinkedList<Observer>();
	}
	
	public void attachObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	public void dettachObserver(Observer observer) {
		this.observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer observer : observers)
			observer.update();
	}
	
	
}
