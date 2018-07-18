package com.reina.marco.sms.beans;

import com.reina.marco.sms.domain.Person;
import com.reina.marco.sms.service.PersonService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named
@javax.enterprise.context.RequestScoped
public class PersonBean {
    
    @Inject
    private PersonService personService;
    
    List<Person> persons;
    
    public PersonBean(){}

    @PostConstruct
    public void initialize(){
        persons = personService.listPersons();
    }
    
    public void editListener(RowEditEvent event){
        Person person = (Person)event.getObject();
        personService.modifyPerson(person);
    }
    
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
