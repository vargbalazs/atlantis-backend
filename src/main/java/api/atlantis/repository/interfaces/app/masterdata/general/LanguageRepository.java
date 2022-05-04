package api.atlantis.repository.interfaces.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findLanguageByDefaultLang(boolean isDefault);
}
