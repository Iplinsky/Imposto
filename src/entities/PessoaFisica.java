package entities;

public class PessoaFisica extends Contribuinte {
	
	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendimentoAnual, Double gastosSaude) {
		super(nome, rendimentoAnual);
		this.gastosSaude = gastosSaude;
	}
	
	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double tax() {
		
		if (getRendimentoAnual() < 20000.0) {
			return getRendimentoAnual() * 0.15 - gastosSaude * 0.5;	
		} else {
			return getRendimentoAnual() * 0.25 - gastosSaude * 0.5;
		}
		
	}
	
}
