package org.example.ViewNote;

import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.navigator.View;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.*;
import org.example.entity.NoteCurs;
import org.example.repository.InitSpring;

import java.util.List;

public class ViewNoteStudent extends Composite implements ViewNoteInterface, View {
    public VerticalLayout verticalLayout = new VerticalLayout();
    InitSpring initSpring;
    Grid<NoteCurs> noteCursGrid = new Grid<>();
    List<NoteCurs> curs;
    public ViewNoteStudent(){

        initSpring = InitSpring.getInstance();
       curs = initSpring.getNoteCursRepository().findAll();
        Label title = new Label();
        title.setValue("Note of students");
      title.setStyleName("h1");
      noteCursGrid.setSelectionMode(Grid.SelectionMode.NONE);

        noteCursGrid.addColumn(NoteCurs::getIdNoteCurs).setCaption("idCurs");
        Binder<NoteCurs> binder = noteCursGrid.getEditor().getBinder();
        noteCursGrid.addColumn(notes -> notes.getCursDenumirea().getDenumirea()).setCaption("curs");
        TextField nota1Field= new TextField();

        StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter("enter a number");
        Binder.Binding<NoteCurs, Integer> binding = binder.forField(nota1Field).withConverter(stringToIntegerConverter)
                .withValidator(validator -> (validator>0 && validator<=10),"The grade must be between 0 and 10")
                .bind(NoteCurs::getNota1, NoteCurs::setNota1);
        noteCursGrid.addColumn(NoteCurs::getNota1).setEditorBinding(binding).setCaption("Nota1");

        TextField nota2Field= new TextField();
        Binder.Binding<NoteCurs, Integer> binding2 = binder.forField(nota2Field).withConverter(stringToIntegerConverter)
                .withValidator(validator -> (validator>0 && validator<=10),"The grade must be between 0 and 10")
                .bind(NoteCurs::getNota2, NoteCurs::setNota2);
        noteCursGrid.addColumn(NoteCurs::getNota2).setEditorBinding(binding2).setCaption("Nota2");

        TextField nota3Field= new TextField();
        Binder.Binding<NoteCurs, Integer> binding3 = binder.forField(nota3Field).withConverter(stringToIntegerConverter)
                .withValidator(validator -> (validator>0 && validator<=10),"The grade must be between 0 and 10")
                .bind(NoteCurs::getNota3, NoteCurs::setNota3);
        noteCursGrid.addColumn(NoteCurs::getNota3).setEditorBinding(binding3).setCaption("Nota3");

       noteCursGrid.setItems(curs);
       noteCursGrid.getEditor().setEnabled(true);
       noteCursGrid.getEditor().addSaveListener(listener ->{
           NoteCurs noteCurs = listener.getBean();
           initSpring.getNoteCursRepository().save(noteCurs);
               }
               );
        noteCursGrid.setWidth(100,Unit.PERCENTAGE);
        noteCursGrid.setHeightMode(HeightMode.ROW);
        noteCursGrid.setHeightByRows(10);
        verticalLayout.setWidth(100,Unit.PERCENTAGE);
        verticalLayout.addComponent(title);
        verticalLayout.setComponentAlignment(title,  Alignment.TOP_CENTER);
        verticalLayout.addComponent(noteCursGrid);
        setCompositionRoot(verticalLayout);
    }
}
