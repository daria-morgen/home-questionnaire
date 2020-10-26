package home.questionnaire.db.data.repository;

import home.questionnaire.db.data.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
