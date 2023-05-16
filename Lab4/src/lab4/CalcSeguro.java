package lab4;

public enum CalcSeguro {
	FATOR_18_30(1.2),
	FATOR_30_60 (1.0),
	FATOR_60_90 (1.5),
	VALOR_BASE (100.0);
	
	private final double valor;
	
	CalcSeguro(double valor){
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
}
