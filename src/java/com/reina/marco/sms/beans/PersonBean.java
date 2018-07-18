package com.reina.marco.sms.beans;

import com.reina.marco.sms.domain.Person;
import com.reina.marco.sms.service.PersonService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@RequestScoped
public class PersonBean {
    
    @EJB
    private PersonService personService;
    
    private Person selectedPerson;
    
    private List<Person> persons;
    
    public PersonBean(){}

    @PostConstruct
    public void initialize(){
        persons = personService.listPersons();
        selectedPerson = new Person();
    }
    
    public void addPerson(){
        personService.registerPerson(this.selectedPerson);
        persons = personService.listPersons();
        this.selectedPerson = null;
    }
    
    public void restartSelectedPerson(){
        this.selectedPerson = new Person();
    }
    
    public void editListener(RowEditEvent event){
        Person person = (Person)event.getObject();
        personService.modifyPerson(person);
    }
    
    public void deletePerson(){
        personService.deletePerson(this.selectedPerson);
        persons = personService.listPersons();
        this.selectedPerson = null;
    }
    
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
}
