package api.atlantis.repository.impl.sp;

import api.atlantis.domain.sp.TaskForHome;
import api.atlantis.repository.interfaces.sp.TaskForHomeRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class TaskForHomeImpl implements TaskForHomeRepository {
    private final EntityManager em;

    public TaskForHomeImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TaskForHome> getTasks() {
        Session session = em.unwrap(Session.class);
        NativeQuery<TaskForHome> query = session.createNativeQuery(
                "SELECT * FROM get_tasks()", "TaskForHomeMapping");

        return query.getResultList();
    }
}
