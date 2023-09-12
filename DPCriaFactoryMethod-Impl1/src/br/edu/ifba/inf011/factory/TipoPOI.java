package br.edu.ifba.inf011.factory;

public enum TipoPOI {
	
	ATRACAO {
		@Override
		public CreatorPOI factory() {
			return new CreatorAtracao();
		}
	}, 
	
	HOTEL {
		@Override
		public CreatorPOI factory() {
			return new CreatorHotel();
		}
	}, 
	
	RESTAURANTE {
		public CreatorPOI factory() {
			return new CreatorRestaurante();
		}
	};
	
	public abstract CreatorPOI factory();

}
