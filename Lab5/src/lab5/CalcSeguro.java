package lab5;

public enum CalcSeguro {
	FATOR_30(1.25),
	FATOR_30_60 (1.0),
	FATOR_60 (1.5),
	VALOR_BASE (10.0);
	
	private final double valor;
	
	CalcSeguro(double valor){
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
}
