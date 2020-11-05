package home.hq.chief.data.repository;

import home.hq.chief.data.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Owner, Long> {
}
