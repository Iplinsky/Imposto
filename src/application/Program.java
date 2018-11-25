package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Contribuinte> list = new ArrayList<>();
		
		System.out.print("Entre com a quantidade de contribuintes: ");
		int qnt = sc.nextInt();
		
		for(int i=1; i<=qnt; i++) {			
		
			System.out.println("Contribuinte #" + i + ": ");
			System.out.println();
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			char pp = sc.next().charAt(0);		
			if(pp == 'f') {			
				System.out.print("Nome: ");
				sc.next();
				String nome = sc.nextLine();
				System.out.print("Rendimento anual: ");
				double rendimentoAnual = sc.nextDouble();
				System.out.print("Gastos com saúde: ");
				double gastosSaude = sc.nextDouble();
				System.out.println();
				list.add(new PessoaFisica(nome, rendimentoAnual, gastosSaude));			
			} else {
				System.out.print("Nome: ");
				sc.next();
				String nome = sc.nextLine();
				System.out.print("Rendimento anual: ");
				double rendimentoAnual = sc.nextDouble();
				System.out.print("Numero de empregados: ");
				int numeroDeEmpregados = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendimentoAnual, numeroDeEmpregados));
				
			}		
		}
		
		System.out.println();
		System.out.println("Impostos pagos: ");		
		double soma = 0.0;
		
		for(Contribuinte ct: list) {
			
			double tax = ct.tax();
			System.out.println(ct.getNome() + ": R$ " + String.format("%.3f",tax));
			soma += tax;
		}
		
		System.out.println();
		System.out.println("Total de impostos: R$ " + String.format("%.3f",soma));
		
		sc.close();

	}

}
