package DAOinterface;

import java.io.Serializable;

public interface UserDAOInterface<T, Id extends Serializable> extends DAOInterface<T>
{
    T findByUsernameAndPassword(String username, String password);
}
