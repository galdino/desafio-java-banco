package br.com.djb.model;

public enum TipoPessoa {
	
	PF(11),PJ(14);
	
	private final int tamanho;
	
	TipoPessoa(int tamanho) { 
		this.tamanho = tamanho; 
	}
    
	public int getValue() { 
    	return tamanho; 
    }
	
	public static TipoPessoa contains(String s){
	      for(TipoPessoa tipoPessoa:values())
	           if (tipoPessoa.name().equals(s)) 
	              return tipoPessoa;
	      return null;
	}

}
