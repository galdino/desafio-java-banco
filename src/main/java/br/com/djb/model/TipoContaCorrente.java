package br.com.djb.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoContaCorrente {
	
	C("PF"),E("PJ");
	
	private String tipoPessoa;
	
	TipoContaCorrente(String tipoPessoa) { 
		this.tipoPessoa = tipoPessoa; 
	}
    
	public String getTipoPessoa() { 
    	return tipoPessoa; 
    }
	
	public static Optional<TipoContaCorrente> filter(String t) {
		return Stream.of(values())
					 .filter(s -> t.equals(s.getTipoPessoa()))
					 .findAny();
	}

}
