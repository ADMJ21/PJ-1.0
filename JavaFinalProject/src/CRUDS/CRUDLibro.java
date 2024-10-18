/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDS;

import Hibernate_Util.HibernateUtil;
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
    public static boolean insertar(String Nombre, String Genero, String Categoria){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Libros.class);
        criteria.add(Restrictions.eq("nombre", Nombre));
        Libros insrt = (Libros)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(insrt==null){
                 insrt = new Libros();
                 insrt.setNombre(Nombre);
                 insrt.setGenero(Genero);
                 insrt.setCategoria(Categoria);
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
   
   public static boolean Modificar(Integer Id_Libro, String Nombre, String Genero, String Categoria){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Libros.class);
        criteria.add(Restrictions.eq("idLibros", Id_Libro));
        Libros update = (Libros)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                 update.setNombre(Nombre);
                 update.setGenero(Genero);
                 update.setCategoria(Categoria);
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

   public static boolean Eliminar(Integer Id_Libro){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Libros.class);
        criteria.add(Restrictions.eq("idLibros", Id_Libro));
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
        criteria.add(Restrictions.eq("estado",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idLibros"))
            .add(Projections.property("nombre"))
            .add(Projections.property("genero"))
            .add(Projections.property("categoria"))
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
