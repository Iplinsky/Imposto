package entities;

public class PessoaJuridica extends Contribuinte {

	private Integer numeroDeEmpregados;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendimentoAnual, Integer numeroDeEmpregados) {
		super(nome, rendimentoAnual);
		this.numeroDeEmpregados = numeroDeEmpregados;
	}

	public Integer getNumeroDeEmpregados() {
		return numeroDeEmpregados;
	}

	public void setNumeroDeEmpregados(Integer numeroDeEmpregados) {
		this.numeroDeEmpregados = numeroDeEmpregados;
	}

	@Override
	public Double tax() {
		
		if (getNumeroDeEmpregados() > 10 ) {
			return getRendimentoAnual() * 0.14;			
		} else {
			return getRendimentoAnual() * 0.16;		
		}
		
	}
}
