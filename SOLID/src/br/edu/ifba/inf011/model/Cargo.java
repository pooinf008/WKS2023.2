package br.edu.ifba.inf011.model;

public enum Cargo {
	TRAINEE {
		@Override
		public Cargo next() {
			return Cargo.JUNIOR;
		}
	}, 
	JUNIOR {
		@Override
		public Cargo next() {
			return Cargo.SENIOR;
		}
	}, 
	SENIOR {
		public Cargo next() {
			return Cargo.MENTOR;
		}
	}, 
	MENTOR {
		@Override
		public Cargo next() {
			return Cargo.MENTOR;
		}
	};
	
	public abstract Cargo next();
}
