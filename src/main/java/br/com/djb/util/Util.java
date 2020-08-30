package br.com.djb.util;

import java.util.concurrent.ThreadLocalRandom;

public class Util {
	
	public static int random0a9(){
		return (int) (Math.random()*9);
	}
	
	public static Integer random6digitos(){
	    return ThreadLocalRandom.current().nextInt(100000, 1000000);
	}
	
}