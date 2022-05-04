package api.atlantis.service.interfaces.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.Provk;
import api.atlantis.domain.app.forecast.provk.ProvkVersion;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface ProvkVersionService extends BaseCrudService<ProvkVersion> {
    List<ProvkVersion> getProvkVersions(Long provkId);
    boolean hasVersions(Long provkId);
    int getNextVersionNumber(Long provkId);
    ProvkVersion getByProvkIdAndVersion(Long provkId, int version);
}
