package home.questionnaire.db.data.repository;

import home.questionnaire.db.data.domain.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
}
