package ma.presentation.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Service {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany
	private List<Employe>employes;
	public Service() {
super();
}
	
	public Service(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + "]";
	}

}
