package projeto.web.yourservice.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import net.bytebuddy.utility.nullability.NeverNull;


@Entity
@Table(name="service")
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column
    private Float price;
    @Column
    private String description; 
    
    @ManyToOne
    private Categoria category;
    
    @Column
    private User user_id;

    public void setId(Long id) {
        Id = id;
    }
    public Long getId() {
        return Id;
    }
    public void setCategory(Categoria category) {
        this.category = category;
    }
    public Categoria getCategory() {
        return category;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getPrice() {
        return price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setUser(User user) {
        this.user_id = user;
    }
    public User getUser() {
        return user_id;
    }
	@Override
	public int hashCode() {
		return Objects.hash(Id, category, description, price, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && Objects.equals(price, other.price)
				&& Objects.equals(user_id, other.user_id);
	}
	@Override
	public String toString() {
		return "UserServices [Id=" + Id + ", price=" + price + ", description=" + description + ", category=" + category
				+ ", user=" + user_id + "]";
	}
    
    
	
    
}
