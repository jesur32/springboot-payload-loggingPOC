package cl.jesu.api.web.rest;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jesu")
public class MyController {

    @CrossOrigin
    @PostMapping(path = "/log", produces = MediaType.APPLICATION_JSON_VALUE)
    public String actualizarReasignacion(@RequestBody String log) {
        return "le";
    }


}
