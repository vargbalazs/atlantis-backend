package api.atlantis.service.impl.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Language;
import api.atlantis.repository.interfaces.app.masterdata.general.LanguageRepository;
import api.atlantis.service.interfaces.app.masterdata.general.LanguageService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {
    private LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Long addNew(Language lang) {
        languageRepository.save(lang);
        return lang.getId();
    }

    @Override
    public Long update(Language lang) {
        Language updatedLanguage = languageRepository.getById(lang.getId());
        updatedLanguage.setIsoCode(lang.getIsoCode());
        updatedLanguage.setName(lang.getName());
        updatedLanguage.setDefaultLang(lang.isDefaultLang());
        languageRepository.save(updatedLanguage);
        return updatedLanguage.getId();
    }

    @Override
    public Long delete(Long id) {
        languageRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    @Override
    public String checkDefaultLanguage(Language language) {
        long count = this.languageRepository.count();
        Language defaultLang = this.languageRepository.findLanguageByDefaultLang(true);
        if (count == 0 && !language.isDefaultLang()) return "firstLangShouldBeDefault";
        if (defaultLang != null && defaultLang.getId() == language.getId() && !language.isDefaultLang()) return "noDefaultLang";
        if (defaultLang != null && language.isDefaultLang() && defaultLang.getId() != language.getId()) return "multipleDefaultLang";
        return "checkOk";
    }
}
