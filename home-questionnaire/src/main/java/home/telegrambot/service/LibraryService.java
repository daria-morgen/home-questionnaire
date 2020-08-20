package home.telegrambot.service;

import reactor.core.publisher.Mono;

public interface LibraryService {

    Mono<String> getRandomRussianWord();

    Mono<String> getRandomEnglishWord();

    Mono<String> getWordTranslation(String translationWord);

}
