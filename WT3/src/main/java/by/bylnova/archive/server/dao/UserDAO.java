package by.lodnya.archive.server.dao;

import by.lodnya.archive.server.bean.User;
import by.lodnya.archive.server.dao.exception.DAOException;

public interface UserDAO {
    boolean signIn(User user) throws DAOException;
    void registration(User user) throws DAOException;
}
