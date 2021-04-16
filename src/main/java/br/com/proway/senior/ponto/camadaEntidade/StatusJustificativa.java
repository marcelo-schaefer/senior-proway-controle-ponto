package br.com.proway.senior.ponto.camadaEntidade;

public enum StatusJustificativa {

		APROVADO("Aprovado"),
		REPROVADO("Reprovado"),
		PENDENTE("Pendente");
	
		private String descricao;
		
		StatusJustificativa(String descricao){
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
}
