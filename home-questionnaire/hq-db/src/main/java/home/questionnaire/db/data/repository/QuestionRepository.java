package home.questionnaire.db.data.repository;

import home.questionnaire.db.data.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
