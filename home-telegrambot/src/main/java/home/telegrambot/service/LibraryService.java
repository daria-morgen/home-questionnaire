package home.telegrambot.service;

import reactor.core.publisher.Mono;

public interface LibraryService {

    Mono<String> getRandomWord();

    Mono<String> getWordTranslation(String translationWord);

}
