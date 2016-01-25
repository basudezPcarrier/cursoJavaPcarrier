package com.wpsnetwork.practica2;

import java.util.Date;

public class Alquiler {
	
	IInquilino inquilino ;
	Pisos piso ;
	java.util.Date fechaContrato ;
	double precioTotalAlquiler ;
	
	private double ivaPct = 0.21 ;
	
	public Alquiler(IInquilino inquilino, Pisos piso, Date fechaContrato) {
		super();
		this.inquilino = inquilino;
		this.piso = piso;
		this.fechaContrato = fechaContrato;
		this.precioTotalAlquiler = 
				this.piso.getPrecioBaseMensual()*
				(1+this.ivaPct ) * 
				( 1.00- this.inquilino.getDescuento()) ;
	}

	public IInquilino getInquilino() {
		return inquilino;
	}

	public Pisos getPiso() {
		return piso;
	}

	public java.util.Date getFechaContrato() {
		return fechaContrato;
	}

	public double getPrecioTotalAlquiler() {
		return precioTotalAlquiler;
	}

	public double getIvaPct() {
		return ivaPct;
	}

	public void setInquilino(IInquilino inquilino) {
		this.inquilino = inquilino;
	}

	public void setPiso(Pisos piso) {
		this.piso = piso;
	}

	public void setFechaContrato(java.util.Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public void setPrecioTotalAlquiler(double precioTotalAlquiler) {
		this.precioTotalAlquiler = precioTotalAlquiler;
	}

	public void setIvaPct(double ivaPct) {
		this.ivaPct = ivaPct;
	}
	
	
	

	
	
	
}
