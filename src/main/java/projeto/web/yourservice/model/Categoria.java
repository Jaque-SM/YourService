package projeto.web.yourservice.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    private String Id;
    
    @Column
    private String name;

    public String getId() {
        return Id;
    }
    
    public void setId(String id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    
    

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Category [Id=" + Id + ", name=" + name + "]";
	}
    
    
    
}
