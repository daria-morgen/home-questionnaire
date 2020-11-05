package home.hq.chief.controller;

import home.hq.chief.data.repository.QuestionnaireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeadController {
    private static final Logger log = LoggerFactory.getLogger(HeadController.class);

    QuestionnaireRepository questionnaireRepository;

    public HeadController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @PostMapping("/payment")
    String makePayment(String paymentInfo) {
        log.debug(paymentInfo);
        return "success";
    }

}
