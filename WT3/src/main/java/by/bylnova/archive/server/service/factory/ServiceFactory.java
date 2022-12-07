package by.lodnya.archive.server.service.factory;

import by.lodnya.archive.server.service.ArchiveService;
import by.lodnya.archive.server.service.UserService;
import by.lodnya.archive.server.service.impl.ArchiveServiceImpl;
import by.lodnya.archive.server.service.impl.UserServiceImpl;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final UserService userServiceImpl = new UserServiceImpl();
    private final ArchiveService archiveServiceImpl = new ArchiveServiceImpl();

    private ServiceFactory() {}

    public UserService getUserService() {
        return userServiceImpl;
    }

    public ArchiveService getArchiveService() {
        return archiveServiceImpl;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
