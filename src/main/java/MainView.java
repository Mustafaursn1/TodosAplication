import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route()
public class MainView extends TodosAppLayout {
    
    public MainView() {
        setContent(new H1("Hello,Vaadin"));


    }
}