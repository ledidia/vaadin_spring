package org.example.ViewStudent;

import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

import com.vaadin.navigator.View;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import org.example.entity.Student;
import org.example.repository.InitSpring;

import java.io.OutputStream;


public class StudentView extends Composite implements  ViewStudent, View{
  public  VerticalLayout verticalLayout = new VerticalLayout();
   InitSpring initSpring;
    Grid<Student> studentGrid  = new Grid<>();

    public  StudentView() {
         initSpring = InitSpring.getInstance();
        if (verticalLayout.getComponentCount() == 0) {
            Label label = new Label();
            label.setValue("List of students");
            label.setStyleName("h1");
            studentGrid.setItems(initSpring.getStudentRepository().findAll());
            studentGrid.addColumn(Student::getStudentId).setCaption("StudentId");
           // studentGrid.addColumn(Student::getPhoto).setCaption("Photo");
            studentGrid.addColumn(Student::getFirstName).setCaption("Firstname");
            studentGrid.addColumn(Student::getLastName).setCaption("LastName");
            studentGrid.addColumn(Student::getDateOfBirthDay).setCaption("Date of birthday");
            studentGrid.addComponentColumn(student -> {
                Button button = new Button("delete");
                button.addClickListener(clickEvent -> {
                    delete(student);
                });
                return button;
            });
            studentGrid.addComponentColumn(student -> {
                Button update = new Button("update");
                update.addClickListener(clickEvent -> {
                    update(student);
                });
                return update;
            });
            verticalLayout.addComponent(label);
            verticalLayout.setComponentAlignment(label, Alignment.TOP_CENTER);
            verticalLayout.addComponent(studentGrid);

            Button add = new Button("add student");
            add.addClickListener(clickEvent -> {
                add();
            });
            studentGrid.setWidth(100, Sizeable.Unit.PERCENTAGE);
            verticalLayout.setWidth(100, Sizeable.Unit.PERCENTAGE);
            verticalLayout.addComponent(add);
            verticalLayout.setComponentAlignment(add,Alignment.TOP_LEFT);


        }
setCompositionRoot(verticalLayout);

    }



    @Override
    public void add() {
        FormLayout formLayout = new FormLayout();
        TextField firstName = new TextField("FisrtName");
        TextField lastName = new TextField("Last Name");

        Upload upload = new Upload();
        upload.setImmediateMode(true);
        TextField tttx = new TextField();
        tttx.setValue(String.valueOf(upload.getBytesRead()));
        formLayout.addComponent(tttx);

        upload.setButtonCaption("upload");
        upload.setImmediateMode(false);
        DateField date = new  DateField("date");
        date.setDateFormat("yyyy-MM-dd");
        formLayout.addComponent(firstName);
        formLayout.addComponent(lastName);
        formLayout.addComponent(date);
        formLayout.addComponent(upload);
        Button cancel = new Button("cancel");
        Button ok = new Button("save");
        formLayout.addComponent(ok);
        formLayout.addComponent(cancel);
        cancel.addClickListener(clickEvent1 -> {
            verticalLayout.removeComponent(formLayout);
        });
        ok.addClickListener(clickEvent -> {
            Student student = new Student();
            student.setFirstName(firstName.getValue());
            student.setLastName(lastName.getValue());
            student.setDateOfBirthDay(date.getValue());
            initSpring.getStudentRepository().save(student);
            verticalLayout.removeComponent(formLayout);
            studentGrid.setItems(initSpring.getStudentRepository().findAll());
        });
       verticalLayout.addComponent(formLayout);
    }

    @Override
    public void update(Student student) {
        FormLayout formLayout = new FormLayout();
        TextField firstName = new TextField("FisrtName");
        firstName.setValue(student.getFirstName());
        TextField lastName = new TextField("Last Name");
        lastName.setValue(student.getLastName());
        DateField date = new  DateField("date");
        date.setValue(student.getDateOfBirthDay());
        date.setDateFormat("yyyy-MM-dd");
        Button ok = new Button("ok");
        formLayout.addComponent(firstName);
        formLayout.addComponent(lastName);
        formLayout.addComponent(date);
        Button cancel = new Button("Cancel");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(ok);
        horizontalLayout.addComponent(cancel);
        formLayout.addComponent(horizontalLayout);
        ok.addClickListener(clickEvent1 -> {
            student.setFirstName(firstName.getValue());
            student.setLastName(lastName.getValue());
            student.setDateOfBirthDay(date.getValue());
            initSpring.getStudentRepository().save(student);
            studentGrid.setItems(initSpring.getStudentRepository().findAll());
            verticalLayout.removeComponent(formLayout);
        });
        cancel.addClickListener(clickEvent1 -> {
            verticalLayout.removeComponent(formLayout);
        });
        verticalLayout.addComponent(formLayout);
    }
    @Override
    public void delete(Student student) {
        initSpring.getStudentRepository().deleteById(student.getStudentId());
        Notification.show("Deleted student "+student.toString());
        studentGrid.setItems(initSpring.getStudentRepository().findAll());
        verticalLayout.addComponent(studentGrid);
    }


}

