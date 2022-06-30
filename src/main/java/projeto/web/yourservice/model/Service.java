package projeto.web.yourservice.model;

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
public class Service {
    
    @Id
    private String Id;
    
    @Column
    private Float price;
    @Column
    private String description; 
    
    @ManyToOne
    private Categoria category;
    
    @Column
    private User user;

    public void setId(String id) {
        Id = id;
    }
    public String getId() {
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
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    
}
