package ma.presentation.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.presentation.demo.dao.IDao;
import ma.presentation.demo.entities.Service;
import ma.presentation.demo.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service> {
	@Autowired
	ServiceRepository serviceRepository;

	@Override
	public Service create(Service o) {
		return serviceRepository.save(o);
	}

	@Override
	public List<Service> findAll() {
		return serviceRepository.findAll();
	}

	public void update(Service newFiliere, Long id) {
		Service oldService = serviceRepository.findById(id).get();

		if (oldService != null) {

			String newName = newFiliere.getName();

			if (newName != null && !newName.isEmpty()) {
				oldService.setName(newName);
			}
			serviceRepository.save(oldService);
		}
	}

	@Override
	public boolean delete(Service o) {
		try {
			serviceRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Service findById(Long id) {
		return serviceRepository.findById(id).orElse(null);
	}

	public void deleteById(Long id) {
		serviceRepository.deleteById(id);
	}
}
