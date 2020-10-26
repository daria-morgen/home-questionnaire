package home.questionnaire.db.impl;

import home.questionnaire.db.QuestionnaireDataRepository;
import home.questionnaire.db.data.domain.Questionnaire;
import home.questionnaire.db.data.repository.QuestionnaireRepository;

import java.util.Optional;

public class QuestionnaireDataRepositoryImpl implements QuestionnaireDataRepository {

    QuestionnaireRepository questionnaireRepository;

    public QuestionnaireDataRepositoryImpl(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @Override
    public Optional<Questionnaire> getQuestionnaireById(Long id) {
        return questionnaireRepository.findById(id);
    }
}
