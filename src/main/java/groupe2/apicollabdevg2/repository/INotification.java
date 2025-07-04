package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface INotification extends JpaRepository<Notification, String> {
    Optional<Notification> findByType(Type type);

}
