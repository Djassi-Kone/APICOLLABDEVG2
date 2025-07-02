package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
    Optional<Badge> findTopByPointLessThanEqualOrderByPointDesc(Integer point);
}
