package by.lodnya.archive.server.service.impl;

import by.lodnya.archive.server.bean.Document;
import by.lodnya.archive.server.dao.DocumentDAO;
import by.lodnya.archive.server.dao.exception.DAOException;
import by.lodnya.archive.server.dao.factory.DAOFactory;
import by.lodnya.archive.server.service.ArchiveService;
import by.lodnya.archive.server.service.UserSession;
import by.lodnya.archive.server.service.exception.ServiceException;

import java.util.List;

public class ArchiveServiceImpl implements ArchiveService {
    private final DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private final DocumentDAO documentDAO = daoObjectFactory.getDocumentDAO();
    private final UserSession userSession = UserSession.getInstance();
    @Override
    public void addNewDocument(Document document) throws ServiceException {
        if (document == null) {
            throw new ServiceException("Empty document");
        }
        try {
            if (userSession.isUserActive()) {
                if (userSession.getActiveUser().getUserRole().equals("user")) {
                    documentDAO.addDocument(document);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteDocument(long id) throws ServiceException {
        try {
            if (userSession.isUserActive()) {
                if (userSession.getActiveUser().getUserRole().equals("admin")) {
                    documentDAO.deleteDocument(id);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEditedDocument(Document document) throws ServiceException {

    }

    @Override
    public List<Document> listAllDocuments() throws ServiceException {
        try {
            if (userSession.isUserActive()) {
                return documentDAO.listDocuments();
            }
            return List.of();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
