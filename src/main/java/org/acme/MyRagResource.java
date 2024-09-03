package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/rag")
public class MyRagResource {

    @Inject
    Bot bot;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String chat(String q) {
        return bot.chat(q);
    }
}
