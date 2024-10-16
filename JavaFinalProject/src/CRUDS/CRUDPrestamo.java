/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDS;

import Hibernate_Util.HibernateUtil;
import POJOS.Cliente;
import POJOS.Libros;
import POJOS.Prestamos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Angel
 */
public class CRUDPrestamo {
    public static boolean insertar(String Fecha, String Clave, Integer Id_Cliente, Integer Id_Libros){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Prestamos.class);
        criteria.add(Restrictions.eq("clave", Clave));
        Prestamos insrt = (Prestamos)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(insrt==null){
                 insrt = new Prestamos();
                    Cliente cliente = new Cliente ();
                    cliente.setIdCliente(Id_Cliente);
                 insrt.setCliente(cliente);
                    Libros libros = new Libros ();
                    libros.setIdLibros(Id_Libros);
                 insrt.setLibros(libros);
                 insrt.setFecha(Fecha);
                 insrt.setClave(Clave);
                 insrt.setEstado(true);
                 
                 session.save(insrt);
                 flag=true;
                 
             }
             transactions.commit();
             
         }
         
         catch(Exception e){
             System.out.println("error "+e);
             transactions.rollback();
             
         }finally{
             session.close();
         }
        return flag;
    }
   
   public static boolean Modificar(Integer Id_Prestamos, String Fecha, String Clave, Integer Id_Cliente, Integer Id_Libros){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Prestamos.class);
        criteria.add(Restrictions.eq("idPrestamos", Id_Prestamos));
        Prestamos update = (Prestamos)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(Id_Cliente);
                 update.setCliente(cliente);
                    Libros libros = new Libros();
                    libros.setIdLibros(Id_Libros);
                 update.setLibros(libros);
                 update.setFecha(Fecha);
                 update.setClave(Clave);
                 
                session.save(update);
                                  
                 flag=true;
                 
             }
             transactions.commit();
             
         }
         
         catch(Exception e){
             System.out.println("error "+e);
             transactions.rollback();
             
         }finally{
             session.close();
         }
        return flag;
    }

   public static boolean Eliminar(Integer Id_Prestamos){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Prestamos.class);
        criteria.add(Restrictions.eq("idPrestamos", Id_Prestamos));
        Prestamos update = (Prestamos)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                 update.setEstado(false);
                 session.save(update);
                                  
                 flag=true;
                 
             }
             transactions.commit();
             
         }
         
         catch(Exception e){
             System.out.println("error "+e);
             transactions.rollback();
             
         }finally{
             session.close();
         }
        return flag;
    }

   public static List<Prestamos> universo(){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    List<Prestamos> lst = null;
    try{
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Prestamos.class);
        criteria.add(Restrictions.eq("estados",true));
        criteria.createAlias("cliente", "c");
        criteria.createAlias("libros", "l");
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idPrestamos"))
            .add(Projections.property("c.nombreCliente"))
            .add(Projections.property("l.nombre"))
            .add(Projections.property("fecha"))      
            .add(Projections.property("clave"))
                    );
            criteria.addOrder(Order.desc("idPrestamos"));
            lst = criteria.list();
           }catch(HibernateException e){
               System.out.println("error" + e);
           }finally{
                session.getTransaction().commit();
    }
    return lst;
    
    }
}
