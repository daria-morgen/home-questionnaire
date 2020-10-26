package home.questionnaire.db;

import home.questionnaire.db.data.domain.Questionnaire;

import java.util.Optional;

public interface QuestionnaireDataRepository {

    Optional<Questionnaire> getQuestionnaireById(Long id);
}
