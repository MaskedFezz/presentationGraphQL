package ma.presentation.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ma.presentation.demo.entities.Employe;
import ma.presentation.demo.services.EmployeService;
import ma.presentation.demo.services.ServiceService;

@Controller
public class EmployeController {

	@Autowired
	private EmployeService employeService;

	@Autowired
	private ServiceService serviceService;

	@QueryMapping
	List<Employe> employes() {
		return employeService.findAll();
	}

	@QueryMapping
	Employe employeById(@Argument Long id) {
		return employeService.findById(id);
	}

	@QueryMapping
	public List<Employe> findByService(@Argument ServiceIdentifier serviceId) {
		return employeService.findByService(serviceService.findById(serviceId.id()));
	}

	@MutationMapping
	Employe addEmploye(@Argument EmployeInput employeInput) {
		Employe employe = null;
		try {
			employe = new Employe(employeInput.name(), employeInput.phone(),
					serviceService.findById(employeInput.serviceId()));
			employeService.create(employe);

		} catch (Exception err) {
			System.out.println("The Employe input name is : " + employe.getName());
		}
		return employe;
	}

	@MutationMapping
	public Boolean deleteEmploye(@Argument Long id) {
		try {
			employeService.deleteById(id);
			return true;
		} catch (Exception err) {
			System.out.println("The id to delete is " + id);
			return false;
		}
	}

	@MutationMapping
	public Boolean updateEmploye(@Argument Long id, @Argument EmployeInput employeInput) {
		try {
			employeService.update(new Employe(employeInput.name(), employeInput.phone(),
					serviceService.findById(employeInput.serviceId())), id);
			return true;
		} catch (Exception err) {
			err.printStackTrace();
			return false;
		}
	}

	record EmployeInput(String name, String phone, Long serviceId) {
	}

	record ServiceIdentifier(Long id) {
	}

}