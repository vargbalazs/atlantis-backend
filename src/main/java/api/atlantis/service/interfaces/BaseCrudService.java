package api.atlantis.service.interfaces;


import java.util.List;

public interface BaseCrudService<T> {
    Long addNew(T entity);
    Long update(T entity);
    Long delete(Long id);
    List<T> getAll();
}
