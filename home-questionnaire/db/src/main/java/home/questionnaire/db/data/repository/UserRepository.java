package home.questionnaire.db.data.repository;

import home.questionnaire.db.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
