import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import oshi.software.os.unix.solaris.SolarisOSFileStore;

import java.awt.*;
import java.time.LocalDate;

@Route("/todos")
@Slf4j
public class TodosView extends TodosAppLayout {
    TodosView(TodoService todoService) {
        var binder = new Binder<>(Todo.class);

//Title
        var titleField = new TextField("Title");

        binder.forField(titleField).
                asRequired("Title is required").
                withValidator(title -> title.length() >= 3, "Title must be at least 3 Characters long").
                bind(Todo::getTitle, Todo::setTitle);
        //DueDAte
        var dueDateField = new TextField("Due Date");
        binder.forField(dueDateField).withConverter(
                        text -> text.isEmpty() ? null : LocalDate.parse(text),
                        LocalDate::toString
                ).
                bind(Todo::getDueDate, Todo::setDueDate);
        //Formlayout

        var formLayout = new FormLayout(titleField, dueDateField);

        Grid<Todo> grid = new Grid<>();
        grid.addColumn(Todo::getTitle).setHeader("Title");
        grid.addColumn(Todo::getDueDate).setHeader("Due Date");
        grid.setItems(new ListDataProvider<>(todoService.findAll()));
        grid.addSelectionListener(event -> {
            var todo = event.getFirstSelectedItem().orElse(null);
            binder.readBean(todo);
        });

        var addButton = new Button("Add");
        addButton.addClickListener(event -> {
            var todo = new Todo();
            if (binder.writeBeanIfValid(todo)) {
                todoService.save(todo);
                grid.getDataProvider().refreshAll();
                //binder.removeBean(null); 36->6.50´
            }


        });


        var verticalLayout = new VerticalLayout();
        verticalLayout.add((Component) formLayout, addButton, grid);

        setContent(formLayout);


    }

}
