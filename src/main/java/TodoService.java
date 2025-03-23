import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class TodoService {
    private final List<Todo> todos =new LinkedList<>();

    public void save(Todo todo) {
        log.info("Title:{}, Due Date: {}",todo.getTitle(),todo.getDueDate());
        todos.add(todo);

    }

    public List<Todo> findAll(){

        return todos;
    }

}
