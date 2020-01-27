package org.example;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.example.repository.InitSpring;

public class ViewNoteCursStudent extends Composite implements View {
    InitSpring initSpring;
    public ViewNoteCursStudent(){
        initSpring = InitSpring.getInstance();
        VerticalLayout layout = new VerticalLayout();
        Grid<Object[]> grid = new Grid<>();
        grid.addColumn(objects -> objects[0]).setCaption("firstName");
        grid.addColumn(objects -> objects[1]).setCaption("lasttName");
        grid.addColumn(objects -> objects[2]).setCaption("curs");
        grid.addColumn(objects -> objects[3]).setCaption("nota1");
        grid.addColumn(objects -> objects[4]).setCaption("nota2");
        grid.addColumn(objects -> objects[5]).setCaption("nota3");
        grid.setItems(initSpring.getStudentRepository().studentCursNote());
        grid.setSelectionMode(Grid.SelectionMode.NONE);
        grid.setSizeFull();
        layout.addComponent(grid);
        setCompositionRoot(layout);

    }
}
