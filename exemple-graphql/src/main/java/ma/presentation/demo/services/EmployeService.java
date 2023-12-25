package ma.presentation.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.presentation.demo.dao.IDao;
import ma.presentation.demo.entities.Employe;
import ma.presentation.demo.repository.EmployeRepository;


@Service
public class EmployeService implements IDao<Employe> {
	@Autowired
	EmployeRepository employeRepository;

	@Override
	public Employe create(Employe o) {
		return employeRepository.save(o);
	}

	@Override
	public List<Employe> findAll() {
		return employeRepository.findAll();
	}

	public void update(Employe newEmploye, Long id) {
		Employe oldEmploye = employeRepository.findById(id).get();

		if (oldEmploye != null) {

			String newName = newEmploye.getName();
			String newPhone = newEmploye.getPhone();
			ma.presentation.demo.entities.Service newService =  newEmploye.getService();
			if (newName != null && !newName.isEmpty()) {
				oldEmploye.setName(newName);
			}
			if (newPhone != null && !newPhone.isEmpty()) {
				oldEmploye.setPhone(newPhone);
			}
			if (newService != null) {
				oldEmploye.setService(newService);
			}
			employeRepository.save(oldEmploye);
		}
	}

	@Override
	public boolean delete(Employe o) {
		try {
			employeRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Employe findById(Long id) {
		return employeRepository.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		employeRepository.deleteById(id);
	}
public List<Employe> findByService(ma.presentation.demo.entities.Service service){
	return employeRepository.findByService(service);
}
}
