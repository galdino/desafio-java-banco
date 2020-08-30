package br.com.djb.model;

public enum TipoContaCorrente {
	
	C("PF"),E("PJ");
	
	private final String tipoPessoa;
	
	TipoContaCorrente(String tipoPessoa) { 
		this.tipoPessoa = tipoPessoa; 
	}
    
	public String getValue() { 
    	return tipoPessoa; 
    }
	
	public static TipoContaCorrente contains(String s){
	      for(TipoContaCorrente tipoContaCorrente:values())
	           if (tipoContaCorrente.getValue().equals(s)) 
	              return tipoContaCorrente;
	      return null;
	}

}
