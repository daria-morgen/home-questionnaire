package home.questionnaire.utils;


import home.questionnaire.bot.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/*
@Component
@EnableScheduling
*/
public class Scheduler {

    private final Logger LOGGER = LoggerFactory.getLogger(Bot.class);

    public static int i;
    /**
     * Шедулер для отправки инфо.
     */
    @Scheduled(fixedRate = 5000)
    public void sendScheduleMsg() {
        LOGGER.info("scheduler: "+  i);

    }
}
