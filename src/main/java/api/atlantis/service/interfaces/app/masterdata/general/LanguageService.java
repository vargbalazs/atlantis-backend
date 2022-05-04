package api.atlantis.service.interfaces.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Language;
import api.atlantis.service.interfaces.BaseCrudService;

public interface LanguageService extends BaseCrudService<Language> {
    String checkDefaultLanguage(Language language);
}
