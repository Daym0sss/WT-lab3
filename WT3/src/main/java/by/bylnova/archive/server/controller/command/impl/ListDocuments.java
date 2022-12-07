package by.lodnya.archive.server.controller.command.impl;

import by.lodnya.archive.server.bean.Document;
import by.lodnya.archive.server.controller.command.Command;
import by.lodnya.archive.server.service.ArchiveService;
import by.lodnya.archive.server.service.exception.ServiceException;
import by.lodnya.archive.server.service.factory.ServiceFactory;

public class ListDocuments implements Command {
    @Override
    public String execute(String request) {
        final String[] response = {""};

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ArchiveService archiveService = serviceFactory.getArchiveService();
        try {
            var documentList = archiveService.listAllDocuments();
            documentList
                    .forEach(document -> response[0] += document.toString() + " ");
            return response[0];
        } catch (ServiceException e) {
            // write log
            response[0] = "Error during list document procedure";
        }
        return "";
    }
}
