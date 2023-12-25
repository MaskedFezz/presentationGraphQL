package ma.presentation.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import ma.presentation.demo.entities.Employe;
import ma.presentation.demo.entities.Service;

import java.util.List;


@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
List<Employe> findByService(Service service);
}
