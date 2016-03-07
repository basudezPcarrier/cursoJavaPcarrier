package com.wpsnetwork.consola;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.wpsnetwork.entidades.Cliente;
import com.wpsnetwork.entidades.Dato;
import com.wpsnetwork.entidades.Pedido;
import com.wpsnetwork.jpa.EntityManagerUtil;

public class App 
{
    public static void main( String[] args )
    {
        EntityManager em = EntityManagerUtil.getEntityManager() ;
        
        // el JPA permite hacer consultas a la bbdd usando el lenguaje especial de eclipseLink (o de
        // hibernate, o del framework que sea), en este caso se llama JSQL
        
        
//        tal que aí devuelve un array
//        
//        List<Dato> lista = em.createQuery("select c.nombre , c.info from Cliente c join Pedido p"
//        		                         , Dato.class )
//        		             .getResultList() ;
        
//        // para que devuelva objetos
//        List<Dato> lista = em.createQuery("select new com.wpsnetwork.entidades.Dato(c.nombre , c.nombre) from Cliente c join Pedido p"
//                						, Dato.class )
//        				     .getResultList() ;
//
//        System.out.println(lista);

        
        //tambien se puede hacer con una query ya definida
        List<Cliente> listaCliente = em.createNamedQuery("Cliente.findAll" // la consulta
                						                , Cliente.class )  // la clase que devuelve
        				               .getResultList() ;
        
        System.out.println(listaCliente);

        //tambien se puede hacer con una query ya definida
        Cliente cliente = em.createNamedQuery("Cliente.findById" // la consulta
                						     , Cliente.class )  // la clase que devuelve
        				    .setParameter("id", 2)
        				    .getSingleResult() // solo quiero un resultado, no una lista 
        				    ;
        
        System.out.println(cliente);
        
//        // hacer transacciones
//        System.out.println("******** Hacer transaciones");
//        
//        em.getTransaction().begin();
//        
//        // insertar 
//        
//        Cliente c1 = new Cliente(100, "Cliente 100", null) ;						// creo cliente
//        Pedido p1 = new Pedido( 150 , new Date() , "Info pedido 150" , c1 ) ; 		// creo 2 pedidos
//        Pedido p2 = new Pedido( 151 , new Date() , "Info pedido 151" , c1 ) ;
//        
//        List<Pedido> pedidos = new ArrayList<Pedido>() ;
//        pedidos.add(p1);
//        pedidos.add(p2);
//        
//        c1.setPedidos(pedidos) ;
//        
//        em.persist(c1); // para insertar
//        
//        em.getTransaction().commit();

    }
}
