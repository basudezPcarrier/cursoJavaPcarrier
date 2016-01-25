package com.wpsnetwork.consola;

import java.util.Iterator;

import com.wpsnetwork.patrones.abstractfactory.FactoryProducer;
import com.wpsnetwork.patrones.abstractfactory.Forma;
import com.wpsnetwork.patrones.abstractfactory.FormaFactory;
import com.wpsnetwork.patrones.abstractfactory.colorFactory;
import com.wpsnetwork.patrones.builder.Comensal;
import com.wpsnetwork.patrones.builder.ComensalBuilder;
import com.wpsnetwork.patrones.dao.ClienteHibernateDao;
import com.wpsnetwork.patrones.dao.ClienteOracleDao;
import com.wpsnetwork.patrones.dao.interfaces.IClienteDao;
import com.wpsnetwork.patrones.factory.Paciente;
import com.wpsnetwork.patrones.factory.PacienteFactory;
import com.wpsnetwork.patrones.iterator.ColeccionArray;
import com.wpsnetwork.patrones.observer.EmisorEvento;
import com.wpsnetwork.patrones.observer.ReceptorEvento;
import com.wpsnetwork.patrones.singleton.ClienteSingleton;
import com.wpsnetwork.patrones.wrapper.CaseWrapper;

public class main {

	public static void main(String[] args) {
		
		// ejemplo patron abstractFactory
		
		Paciente p1 = PacienteFactory.getPaciente("HOMBRE") ;
		Paciente p2 = PacienteFactory.getPaciente("MUJER") ;
		
		// cargar los objetos factory
		
		// como los getFactory son abstract, hay que hacer el cast al tipo deseado
		FormaFactory f1 = (FormaFactory)FactoryProducer.getFactory("FORMA") ;
		colorFactory c1 = (colorFactory)FactoryProducer.getFactory("COLOR") ;
		
		// ya puedo crear los objetos que necesite usando la factoria adecuada
		
		Forma fig1 = f1.getForma("TRIANGULO") ;
		
		// ejemplo patron builder
		
		ClienteSingleton cs1 = ClienteSingleton.getInstance();
		ClienteSingleton cs2 = ClienteSingleton.getInstance(); // va a devolver el mismo objeto
		
		
		// ejemplo patron builder
		
		ComensalBuilder cb = new ComensalBuilder();
		Comensal comensal1 = cb.prepareMenu1() ;
		Comensal comensal2 = cb.prepareMenu2() ;
		
		// ejemplo iterator
		
		/*
		 * 
		 * 		ColeccionArray col = new ColeccionArray(1 , 2, 3 , 4) ;
		Iterator it = col.getIterator();
		
		while (it.hasNext()){
			System.out.println(it.next());
		}

		 * */
		
		ReceptorEvento oyente = new ReceptorEvento() ;
		EmisorEvento emisor = new EmisorEvento() ;
		
		emisor.addObserver(oyente); 
		emisor.doSomething();
		emisor.eliminar();
		
		// ejemplo patron WRAPPER
		
		IClienteDao daoCliente1 = new ClienteHibernateDao();
		IClienteDao daoCliente2 = new ClienteOracleDao();
		
		CaseWrapper m = new CaseWrapper();
		System.out.println(m.getValor());
		
		m.setValor(8);
		System.out.println(m.getValor());
		
	}

}
