package by.lodnya.archive.server.service;

import by.lodnya.archive.server.bean.User;
import by.lodnya.archive.server.service.exception.ServiceException;

public interface UserService {
    boolean signIn(User user) throws ServiceException;

    void signOut(User user) throws ServiceException;

    void registration(User user) throws ServiceException;
}
