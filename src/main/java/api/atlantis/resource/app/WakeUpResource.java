package api.atlantis.resource.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WakeUpResource {
    @GetMapping("/wakeup")
    public ResponseEntity wakeUp() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
