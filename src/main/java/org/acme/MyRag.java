package org.acme;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class MyRag {

    @Inject
    Bot bot;

    void onStart(@Observes StartupEvent ev) {
        String question = "What financial products are available?";
        System.out.println("Question: " + question);
        String response = bot.chat(question);
        System.out.println("Response: " + response);
    }
}
