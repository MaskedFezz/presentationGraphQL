package ma.presentation.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import ma.presentation.demo.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}
