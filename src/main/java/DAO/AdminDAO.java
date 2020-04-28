package DAO;

import DAOinterface.UserDAOInterface;
import controller.Controller;
import model.Admin;

import javax.persistence.TypedQuery;
import java.util.List;

public class AdminDAO implements UserDAOInterface<Admin, Integer>
{
    public Admin findByUsernameAndPassword(String username, String password)
    {
        Controller.beginTransaction();
        TypedQuery<Admin> query = Controller.getSession().createQuery("FROM Admin WHERE username = :username AND password = :password", Admin.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Admin> admins = query.getResultList();
        Controller.commitTransaction();
        if (admins.size() == 0)
            return null;
        else
            return admins.get(0);
    }

    public boolean delete(Admin entity)
    {
        try
        {
            Controller.beginTransaction();
            if (!Controller.getSession().contains(entity))
                Controller.getSession().merge(entity);
            Controller.getSession().delete(entity);
            Controller.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Admin> findAll()
    {
        Controller.beginTransaction();
        List<Admin> admins = (List<Admin>) Controller.getSession().createQuery("from Admin").list();
        Controller.commitTransaction();
        return admins;
    }

    public boolean saveOrUpdate(Admin entity)
    {
        try
        {
            Controller.beginTransaction();
            Controller.getSession().saveOrUpdate(entity);
            Controller.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}