/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ultis {
    private static final SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public static List<Account> getAccount() {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Account.class);        
        List<Account> account = cr.list();  
        session.close();        
        return account;
    }
}
