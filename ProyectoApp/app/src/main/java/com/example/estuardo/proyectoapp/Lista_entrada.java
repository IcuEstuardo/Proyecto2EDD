package com.example.estuardo.proyectoapp;

/** Handler para listado.
 * @author Ramon Invarato Men�ndez
 * www.jarroba.es
 */
public class Lista_entrada {
	private String textoEncima; 
	private String textoDebajo;
	private int identificador;
	private String usuario;
	  
	public Lista_entrada (String textoEncima, String textoDebajo, String usuario, int identificador) {
	    this.textoEncima = textoEncima; 
	    this.textoDebajo = textoDebajo;
		this.identificador = identificador;
		this.usuario = usuario;
	}
	
	public String get_textoEncima() { 
	    return textoEncima; 
	}
	
	public String get_textoDebajo() { 
	    return textoDebajo; 
	}

	public int get_Identificador() { return identificador;}

	public String get_Usuario() { return  usuario; }
}
