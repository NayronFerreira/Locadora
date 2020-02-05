package servico.modelo;

import entidade.modelo.ContratoCarro;
import entidade.modelo.NotaPagamento;

public class ServicoContrato {
	
	private Double precoPorHora;
	private Double precoPorDia;
	
	private TaxaServico taxaServico;
	
	public ServicoContrato () {
		
	}

	public ServicoContrato(Double precoPorHora, Double precoPorDia, TaxaServico taxaServico ) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxaServico = taxaServico;
	}
	
	public void processarNota (ContratoCarro contratoCarro) {
		 long ini = contratoCarro.getInicio().getTime();
		 long fim = contratoCarro.getFim().getTime();
		 double horas = ((double)fim-ini) / 1000 / 60 / 60;
		 
		 double pagamentoBasico;
		 
		 if (horas <= 12.0) {
			 pagamentoBasico = Math.ceil(horas)* precoPorHora;
		 }
		 else {pagamentoBasico = Math.ceil(horas/24)* precoPorDia;
		 }
		 
		 double taxa = taxaServico.taxa(pagamentoBasico);
		 
		 contratoCarro.setNotaPagamento(new NotaPagamento(pagamentoBasico, taxa));
				 
	}
	
	public TaxaServico getTaxaServico () {
		return taxaServico;
	}

	public Double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}
	
	
	

}
