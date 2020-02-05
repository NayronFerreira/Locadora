package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidade.modelo.ContratoCarro;
import entidade.modelo.Veiculo;
import servico.modelo.BrasilTaxa;
import servico.modelo.ServicoContrato;

public class Programa {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		SimpleDateFormat y = new SimpleDateFormat("dd/MM/yyyy HH:ss");

		try {
			System.out.println("Informe os dados do contrato");
			System.out.print("Modelo do Carro: ");
			String modelo = leia.nextLine();
			System.out.print("Data inicio (dd/mm/aaaa):");
			Date inicio = y.parse(leia.nextLine());
			System.out.print("Data inicio (dd/mm/aaaa):");
			Date fim = y.parse(leia.nextLine());
			System.out.print("Informe preço por hora: ");
			double precoPH = leia.nextDouble();
			System.out.print("Informe preço por dia: ");
			double precoPD = leia.nextDouble();

			ContratoCarro contrato = new ContratoCarro(inicio, fim, new Veiculo(modelo));
			ServicoContrato servico = new ServicoContrato(precoPH, precoPD, new BrasilTaxa());
			servico.processarNota(contrato);

			System.out.println("Nota de pagamento: ");
			System.out.println("Pagamento básico: "+ contrato.getNotaPagamento().getPagamentoBasico());
			System.out.println("Taxa: "+contrato.getNotaPagamento().getTaxa());
			System.out.println("Pagamento total: "+contrato.getNotaPagamento().getPagamentoTotal());
			

		} catch (ParseException x) {
			System.out.println("Error: " + x.getMessage());
		}

		leia.close();
	}

}
