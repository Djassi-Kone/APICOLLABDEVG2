package groupe2.apicollabdevg2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Gestionnaire")
public class Gestionnaire extends Contributeur{

    @OneToMany(mappedBy = "gestionnaire")
    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getNom(){
        return this.getNom();
    }
    public void setNom(String nom){
        this.setNom(nom);
    }
}
