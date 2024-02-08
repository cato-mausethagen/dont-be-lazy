package no.playground.spring.dontbelazy.ai.services

import org.slf4j.LoggerFactory
import org.springframework.ai.openai.OpenAiChatClient
import org.springframework.stereotype.Service

@Service
class ExperimentalAiService(val aiClient: OpenAiChatClient) {

   private val log = LoggerFactory.getLogger(javaClass)

   fun getCatHaiku(): String {
      return aiClient.call("Write me Haiku about cat, haiku should start with the word cat obligatory")
   }

}
