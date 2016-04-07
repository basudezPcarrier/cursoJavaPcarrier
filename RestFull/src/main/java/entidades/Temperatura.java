package entidades;

import java.io.Serializable;
import javax.xml.bind.annotation.*;


// debe implementar serializable (porque lo vamos a enviar por internet)
// debemos preparar esta clase para que se puede pasar a XML

@XmlRootElement
public class Temperatura implements Serializable {
	
	private double celsius ;
	private double farenheit ;
	private String miCadena ; 
	
	
	public Temperatura() {
		super();
	}


	public Temperatura(double celsius, double farenheit, String miCadena) {
		super();
		this.celsius = celsius;
		this.farenheit = farenheit;
		this.miCadena = miCadena;
	}


	/**
	 * @return the celsius
	 */
	public double getCelsius() {
		return celsius;
	}


	/**
	 * @param celsius the celsius to set
	 */
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}


	/**
	 * @return the farenheit
	 */
	public double getFarenheit() {
		return farenheit;
	}


	/**
	 * @param farenheit the farenheit to set
	 */
	public void setFarenheit(double farenheit) {
		this.farenheit = farenheit;
	}


	/**
	 * @return the miCadena
	 */
	public String getMiCadena() {
		return miCadena;
	}


	/**
	 * @param miCadena the miCadena to set
	 */
	public void setMiCadena(String miCadena) {
		this.miCadena = miCadena;
	}

//	public Temperatura(double celsius, double farenheit) {
//		super();
//		this.celsius = celsius;
//		this.farenheit = farenheit;
//	}
//
//	/**
//	 * @return the celsius
//	 */
//	public double getCelsius() {
//		return celsius;
//	}
//
//	/**
//	 * @param celsius the celsius to set
//	 */
//	public void setCelsius(double celsius) {
//		this.celsius = celsius;
//	}
//
//	/**
//	 * @return the farenheit
//	 */
//	public double getFarenheit() {
//		return farenheit;
//	}
//
//	/**
//	 * @param farenheit the farenheit to set
//	 */
//	public void setFarenheit(double farenheit) {
//		this.farenheit = farenheit;
//	}
//
//	
//	
	
	
	
	
}
