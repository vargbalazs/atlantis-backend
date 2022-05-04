package api.atlantis.resource.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Language;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.general.LanguageDto;
import api.atlantis.mapstruct.mappers.app.masterdata.general.LanguageMapper;
import api.atlantis.service.interfaces.app.masterdata.general.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/masterdata/general/language")
public class LanguageResource extends ExceptionHandling {
    private LanguageService languageService;
    private LanguageMapper languageMapper;

    public LanguageResource(LanguageService languageService, LanguageMapper languageMapper) {
        this.languageService = languageService;
        this.languageMapper = languageMapper;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getLanguages() {
        return new ResponseEntity<>(languageMapper.toListDto(languageService.getAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewLanguage(@RequestBody LanguageDto langDto) {
        Long newId = languageService.addNew(languageMapper.toEntity(langDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateLanguage(@RequestBody LanguageDto langDto) {
        Language lang = languageMapper.toEntity(langDto);
        languageService.update(lang);
        return new ResponseEntity<>(lang.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteLanguage(@PathVariable("id") Long id) {
        languageService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/checkdefaultlang")
    public ResponseEntity<Map> checkDefaultLanguage(@RequestBody LanguageDto langDto) {
        Language language = languageMapper.toEntity(langDto);
        String resp = languageService.checkDefaultLanguage(language);
        return new ResponseEntity<>(Collections.singletonMap("message", resp), HttpStatus.OK);
    }
}
