package home.telegrambot.datamanagement.repository;


import home.telegrambot.datamanagement.model.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
}

