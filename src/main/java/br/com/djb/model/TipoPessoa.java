package br.com.djb.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoPessoa {
	
	PF(11),PJ(14);
	
	private int tamanho;
	
	TipoPessoa(int tamanho) { 
		this.tamanho = tamanho; 
	}
	
	public int getTamanho() {
    	return tamanho; 
    }
	
	public static Optional<TipoPessoa> filter(String t) {
		return Stream.of(values())
					 .filter(s -> t.equals(s.name()))
					 .findAny();
	}

}
