/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDS;

import HIBERNATEUtil.HibernateUtil;
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
    public static boolean insertar(Integer idPrestamos, Cliente cliente, Libros libros, String fecha){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Prestamos.class);
        //Aqui cambian por el nombre que se tiene en pojos, pero la que dice java
        criteria.add(Restrictions.eq("emailPrestamos", Email));
        //Aqui lo deje que el No. de habitación sea la condicion
        Prestamos insrt = (Prestamos)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(insrt==null){
                 insrt = new Prestamos();
                 insrt.setNombrePrestamos(Nombre);
                 insrt.setTelefonoPrestamos(Telefono);
                 insrt.setEmailPrestamos(Email);
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
             //el finally ejecuta el codigo que está en el bloque, si o si
             session.close();
         }
        return flag;
    }
   
   public static boolean Modificar(Integer Id_Prestamos, String Nombre, String Telefono, String Email, Integer Edad){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Prestamos.class);
        //Aqui cambian por el nombre que se tiene en pojos, pero la que dice java
        criteria.add(Restrictions.eq("idPrestamos", Id_Prestamos));
        //Aqui lo deje que el No. de habitación sea la condicion
        Prestamos update = (Prestamos)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                 update.setNombrePrestamos(Nombre);
                 update.setTelefonoPrestamos(Telefono);
                 update.setEmailPrestamos(Email);
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

   public static boolean Eliminar(Integer Id_Prestamos){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Prestamos.class);
        //Aqui cambian por el nombre que se tiene en pojos, pero la que dice java
        criteria.add(Restrictions.eq("idPrestamos", Id_Prestamos));
        //Aqui lo deje que el No. de habitación sea la condicion
        Prestamos update = (Prestamos)criteria.uniqueResult();
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
             //el finally ejecuta el codigo que está en el bloque, si o si
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
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idPrestamos"))
            
            .add(Projections.property("fecha"))            
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
