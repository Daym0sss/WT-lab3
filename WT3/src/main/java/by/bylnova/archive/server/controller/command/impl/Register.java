package by.lodnya.archive.server.controller.command.impl;

import by.lodnya.archive.server.bean.User;
import by.lodnya.archive.server.bean.UserRole;
import by.lodnya.archive.server.controller.command.Command;
import by.lodnya.archive.server.service.UserService;
import by.lodnya.archive.server.service.exception.ServiceException;
import by.lodnya.archive.server.service.factory.ServiceFactory;

public class Register implements Command {
    @Override
    public String execute(String request) {
        String[] splitString = request.split(" ");
        String login = splitString[1];
        String password = splitString[2];
        String role = splitString[3];
        String response;
        // get parameters from request and initialize the variables login and password
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService clientService = serviceFactory.getUserService();
        try {
            clientService.registration(new User(login, password, role));
            response = "registered user";
        } catch (ServiceException e) {
            // write log
            response = "Error during register procedure";
        }
        return response;
    }
}
