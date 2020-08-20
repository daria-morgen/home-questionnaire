package home.questionnaire.controller;

import home.questionnaire.service.LibraryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private LibraryService libraryService;

    public DictionaryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/getRandomWord")
    public Mono<String> handle() {
        return libraryService.getRandomEnglishWord();
    }

}

