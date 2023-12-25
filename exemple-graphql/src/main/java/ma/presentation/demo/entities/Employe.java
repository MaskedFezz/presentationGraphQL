	package ma.presentation.demo.entities;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.ManyToOne;
	
	@Entity
	public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phone;
	@ManyToOne
	private Service service;
		public Employe() {
	super();	}
		
		public Employe(String name, String phone, Service service) {
			super();
			this.name = name;
			this.phone = phone;
			this.service = service;
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
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Service getService() {
			return service;
		}
		public void setService(Service service) {
			this.service = service;
		}
		
		@Override
		public String toString() {
			return "Employe [id=" + id + ", name=" + name + ", phone=" + phone + ", service=" + service + "]";
		}
	
	}
