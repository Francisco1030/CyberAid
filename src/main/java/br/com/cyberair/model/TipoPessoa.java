package br.com.cyberair.model;

public enum TipoPessoa {
	CPF("999.999.999-99"), CNPJ("99.999.999/9999-99");

	TipoPessoa(String mascara) {
		this.mascara = mascara;
	}

	private String mascara;

	public String getMascara() {
		return mascara;
	}
}
