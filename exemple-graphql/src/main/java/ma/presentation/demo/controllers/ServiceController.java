package ma.presentation.demo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import ma.presentation.demo.entities.Service;
import ma.presentation.demo.services.ServiceService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @QueryMapping
    List<Service> services() {
        return serviceService.findAll();
    }

    @QueryMapping
    Service serviceById(@Argument Long id) {
        return serviceService.findById(id);
    }

    @MutationMapping
    Service addService(@Argument ServiceInput serviceInput) {

        Service service = null;
        try {
            service = new Service(serviceInput.name);
            serviceService.create(service);

        } catch (Exception err) {
            System.out.println("The service input name is : " + serviceInput.name);
        }
        return service;
    }

    // Deleting Service
    @MutationMapping
    public Boolean deleteService(@Argument Long id) {
        try {
            serviceService.deleteById(id);
            return true;
        } catch (Exception err) {
            System.out.println("The id to delete is " + id);
            return false;
        }
    }

    // Updating Service
    @MutationMapping
    public Boolean updateService(@Argument Long id, @Argument ServiceInput serviceInput) {

        try {
            serviceService.update(new Service(serviceInput.name), id);
            return true;
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        }
    }

    record ServiceInput(String name) {
    }

}