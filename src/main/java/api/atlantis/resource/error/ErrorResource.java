package api.atlantis.resource.error;

import api.atlantis.domain.http.HttpResponse;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.utility.Translator;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class ErrorResource extends ExceptionHandling implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<HttpResponse> notFound404() {
        return createHttpResponse(NOT_FOUND, Translator.toLocale("NO_MAPPING"));
    }
}
