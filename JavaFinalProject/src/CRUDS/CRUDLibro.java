/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDS;

import HIBERNATEUtil.HibernateUtil;
import POJOS.Libros;
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
public class CRUDLibro {
    public static boolean insertar(String Genero, Integer Cantidad){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Libros.class);
        //Aqui cambian por el nombre que se tiene en pojos, pero la que dice java
        criteria.add(Restrictions.eq("genero", Genero));
        //Aqui lo deje que el No. de habitación sea la condicion
        Libros insrt = (Libros)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(insrt==null){
                 insrt = new Libros();
                 insrt.setGenero(Genero);
                 insrt.setCantidad(Cantidad);
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
             //el finally ejecuta el codigo que está en el bloque, si o si
             session.close();
         }
        return flag;
    }
   
   public static boolean Modificar(Integer Id_Libro, String Genero, Integer Cantidad){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Libros.class);
        //Aqui cambian por el nombre que se tiene en pojos, pero la que dice java
        criteria.add(Restrictions.eq("idLibros", Id_Libro));
        //Aqui lo deje que el No. de habitación sea la condicion
        Libros update = (Libros)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                 update.setGenero(Genero);
                 update.setCantidad(Cantidad);
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

   public static boolean Eliminar(Integer Id_Libro){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Libros.class);
        //Aqui cambian por el nombre que se tiene en pojos, pero la que dice java
        criteria.add(Restrictions.eq("idLibros", Id_Libro));
        //Aqui lo deje que el No. de habitación sea la condicion
        Libros update = (Libros)criteria.uniqueResult();
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
             //el finally ejecuta el codigo que está en el bloque, si o si
             session.close();
         }
        return flag;
    }

   public static List<Libros> universo(){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    List<Libros> lst = null;
    try{
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Libros.class);
        criteria.add(Restrictions.eq("estados",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idLibros"))
            .add(Projections.property("genero"))
            .add(Projections.property("cantidad"))
            );
            criteria.addOrder(Order.desc("idLibros"));
            lst = criteria.list();
           }catch(HibernateException e){
               System.out.println("error" + e);
           }finally{
                session.getTransaction().commit();
    }
    return lst;
    
    }
}
