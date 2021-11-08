package com.olivtopa.paymybuddy.vue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Point d'entrée de l'application web.
 */
@Controller
public class HomeController {

  @RequestMapping("/")
  public String index() {
    // Cette string sera automatiquement mappée avec le fichier resources/templates/index.html
    return "index";
  }
}
