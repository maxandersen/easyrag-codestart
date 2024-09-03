# code-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Easy RAG

This code is a simple example of how to use LangChain4j with Quarkus using Easy RAG.

This code is setup to use OpenAI as the LLM, thus you need to set the `QUARKUS_LANGCHAIN4J_OPENAI_API_KEY` environment variable to your OpenAI API key. 

In `easy-rag-catalog` you can find a set of documents that will be used to create the RAG index
which the bot (`src/main/java/org/acme/Bot.java`) will have automatically access to.

On first run, the bot will create the RAG index and store it in `easy-rag-catalog.json` file and reuse it on subsequent runs.
This can be disabled by setting the `quarkus.langchain4j.easy-rag.reuse-embeddings.enabled` property to `false`.

Then there is a simple startup listener (`src/main/java/org/acme/MyRag.java`) that will query the bot and print the results. 

In a more complete example, you would have a web interface that would allow you to query the RAG index, see https://github.com/quarkiverse/quarkus-langchain4j/tree/main/samples/chatbot-easy-rag for such an example.

## Related Guides

- LangChain4j OpenAI ([guide](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html)): Provides the basic integration with LangChain4j
- LangChain4j Easy RAG ([guide](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html)): Provides the Easy RAG functionality with LangChain4j
