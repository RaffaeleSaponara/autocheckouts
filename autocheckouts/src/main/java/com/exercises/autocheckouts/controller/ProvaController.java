package com.exercises.autocheckouts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvaController {

    @GetMapping(value="/")
    public String getPage(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"it\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Chiamate GET e POST</title>\n" +
                "    <script>\n" +
                "        // Funzione per eseguire la chiamata GET\n" +
                "        function makeGetRequest() {\n" +
                "            const url = 'http://localhost:8080/get-example?name=Marco';\n" +
                "\n" +
                "            fetch(url)\n" +
                "                .then(response => response.text())\n" +
                "                .then(data => {\n" +
                "                    alert(data);\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Errore durante la chiamata GET:', error);\n" +
                "                });\n" +
                "        }\n" +
                "\n" +
                "        // Funzione per eseguire la chiamata POST\n" +
                "        function makePostRequest() {\n" +
                "            const url = 'http://localhost:8080/post-example';\n" +
                "            const message = 'Questo è un messaggio POST';\n" +
                "\n" +
                "            fetch(url, {\n" +
                "                method: 'POST',\n" +
                "                headers: {\n" +
                "                    'Content-Type': 'application/json',\n" +
                "                },\n" +
                "                body: JSON.stringify({ message: message })  // Invia il messaggio nel corpo della richiesta\n" +
                "            })\n" +
                "            .then(response => response.text())\n" +
                "            .then(data => {\n" +
                "                alert(data);\n" +
                "            })\n" +
                "            .catch(error => {\n" +
                "                console.error('Errore durante la chiamata POST:', error);\n" +
                "            });\n" +
                "        }\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Premi i bottoni per fare una chiamata GET o POST</h1>\n" +
                "\n" +
                "    <!-- Bottone per fare la richiesta GET -->\n" +
                "    <button onclick=\"makeGetRequest()\">Fai una richiesta GET</button>\n" +
                "\n" +
                "    <br><br>\n" +
                "\n" +
                "    <!-- Bottone per fare la richiesta POST -->\n" +
                "    <button onclick=\"makePostRequest()\">Fai una richiesta POST</button>\n" +
                "</body>\n" +
                "</html>";
    }
    // Metodo per gestire una richiesta GET
    @GetMapping("/get-example")
    public String getExample(@RequestParam String name) {
        return "Ciao, " + name + "!";
    }

    // Metodo per gestire una richiesta POST
    @PostMapping("/post-example")
    public String postExample(@RequestBody String message) {
        return "Messaggio ricevuto: " + message;
    }
}
