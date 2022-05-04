package api.atlantis.service.impl.sp;

import api.atlantis.domain.sp.TaskForHome;
import api.atlantis.repository.impl.sp.TaskForHomeImpl;
import api.atlantis.service.interfaces.sp.TaskForHomeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskForHomeServiceImpl implements TaskForHomeService {
    private TaskForHomeImpl rep;

    public TaskForHomeServiceImpl(TaskForHomeImpl rep) {
        this.rep = rep;
    }

    @Override
    public List<TaskForHome> getTasks() {
        return rep.getTasks();
    }
}
