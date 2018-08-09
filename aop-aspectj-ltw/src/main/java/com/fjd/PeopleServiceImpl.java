package com.fjd;

import java.util.List;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.factory.annotation.Qualifier;  
import org.springframework.transaction.annotation.Propagation;  
import org.springframework.transaction.annotation.Transactional;  
  
import quickstart.dao.PersonDao;  
import quickstart.model.Person;  
import quickstart.service.PeopleService;  
  
public class PeopleServiceImpl implements PeopleService{  
      
    //通过类型(byType为默认)的自动连接可能会有多个候选,  
    //通过使用@Qualifier注解，使用名称(byName)来限定  
    @Autowired  
    @Qualifier("personDao")  
    private PersonDao personDao;  
      
    @Transactional(propagation = Propagation.REQUIRED)  
    public void savePerson(Person person) {  
        personDao.save(person);  
    }  
  
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)  
    public Person findPersonById(Integer id) {  
        return personDao.findById(id);  
    }  
  
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)  
    public List findPersonByJPQL(String jpql){  
        return personDao.findByJPQL(jpql);  
    }  