package no.playground.spring.dontbelazy.apis.springai

import no.playground.spring.dontbelazy.services.ExperimentalAiService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ai")
class ExperimentalAiApi(val aiService: ExperimentalAiService) {

   private val log = LoggerFactory.getLogger(javaClass)

   @GetMapping("/haiku")
   fun generateHaiku(): String {
      return aiService.getCatHaiku()
   }

}