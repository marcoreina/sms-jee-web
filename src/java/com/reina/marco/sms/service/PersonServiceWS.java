package com.reina.marco.sms.service;

import com.reina.marco.sms.domain.Person;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PersonServiceWS {
    
    @WebMethod
    public List<Person> listPersons();
}
