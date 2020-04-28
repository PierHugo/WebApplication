package DAOinterface;

import java.util.List;

public interface DAOInterface<T>
{
    boolean delete(T entity);

    List<T> findAll();

    boolean saveOrUpdate(T entity);
}
