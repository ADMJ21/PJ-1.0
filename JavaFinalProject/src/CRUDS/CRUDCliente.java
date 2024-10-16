/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDS;

import Hibernate_Util.HibernateUtil;
import POJOS.Cliente;
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
public class CRUDCliente {
   public static boolean insertar(String Nombre, String Telefono, String Email, Integer Edad){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("emailCliente", Email));
        Cliente insrt = (Cliente)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(insrt==null){
                 insrt = new Cliente();
                 insrt.setNombreCliente(Nombre);
                 insrt.setTelefonoCliente(Telefono);
                 insrt.setEmailCliente(Email);
                 insrt.setEdad(Edad);
                 insrt.setEstados(true);
                 
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
   
   public static boolean Modificar(Integer Id_Cliente, String Nombre, String Telefono, String Email, Integer Edad){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("idCliente", Id_Cliente));
        Cliente update = (Cliente)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                 update.setNombreCliente(Nombre);
                 update.setTelefonoCliente(Telefono);
                 update.setEmailCliente(Email);
                 update.setEdad(Edad);
                 session.save(update);
                                  
                 flag=true;
                 
             }
             transactions.commit();
             
         }
         
         catch(Exception e){
             System.out.println("error "+e);
             transactions.rollback();
             
         }finally{
             //el finally ejecuta el codigo que está en el bloque, si o si
             session.close();
         }
        return flag;
    }

   public static boolean Eliminar(Integer Id_Cliente){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("idCliente", Id_Cliente));
        Cliente update = (Cliente)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                 update.setEstados(false);
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

   public static List<Cliente> universo(){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    List<Cliente> lst = null;
    try{
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("estados",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idCliente"))
            .add(Projections.property("nombreCliente"))
            .add(Projections.property("telefonoCliente"))
            .add(Projections.property("emailCliente"))
            .add(Projections.property("edad"))            
                    );
            criteria.addOrder(Order.desc("idCliente"));
            lst = criteria.list();
           }catch(HibernateException e){
               System.out.println("error" + e);
           }finally{
                session.getTransaction().commit();
    }
    return lst;
    
    }
}
