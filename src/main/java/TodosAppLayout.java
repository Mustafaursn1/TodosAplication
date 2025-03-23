import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.sidenav.SideNav;



abstract class TodosAppLayout extends AppLayout {
    TodosAppLayout() {
        var touchOptimized = true;
        addToNavbar(touchOptimized,new  DrawerToggle(), new H2("Todos Application"));

        var sideNav = new SideNav();
        sideNav.addItem(new SideNav("Home", "/"));
        sideNav.addItem(new SideNav("Todos", "tod"));
        addToDrawer(sideNav);


    }
    @Override
    public void setContent(Component content){
        content.getStyle().setPadding("1.5em");
        super.setContent(content);
    }
}
