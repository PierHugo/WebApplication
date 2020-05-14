package controller;

import DAO.AdminDAO;
import DAO.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Controller
{
    private static Controller controller = null;
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    private static UserDAO userDAO;
    private static AdminDAO adminDAO;

    private Controller()
    {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = null;

        userDAO = new UserDAO();
        adminDAO = new AdminDAO();
    }

    public static void beginTransaction()
    {
        if (transaction == null || !transaction.isActive())
            transaction = session.beginTransaction();
    }

    public static Controller getController()
    {
        if (controller == null)
            controller = new Controller();
        return controller;
    }

    public static void commitTransaction()
    {
        transaction.commit();
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static Session getSession()
    {
        return session;
    }

    public static Transaction getTransaction()
    {
        return transaction;
    }

    public static UserDAO getUserDAO()
    {
        return userDAO;
    }

    public static AdminDAO getAdminDAO()
    {
        return adminDAO;
    }

}

