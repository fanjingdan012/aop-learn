//package com.fjd;
//
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import quickstart.model.Address;
//import quickstart.model.Person;
//import quickstart.service.PeopleService;
//
//
//public class JpaServiceTest {
//
//    private static ApplicationContext appContext;
//    private static PeopleService peopleService;
//
//    @BeforeClass
//    public static void Init(){
//        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        peopleService = (PeopleService)appContext.getBean("peopleService");
//    }
//
//    @Test
//    public void findById(){
//        Person person = peopleService.findPersonById(new Integer(2));
//        System.out.println(person.getFirstName()+person.getLastName());
//        //System.out.println(person.getAddress().getStreetName());
//    }
//
//    @Test
//    public void findByJPQL(){
//        StringBuilder jpql = new StringBuilder();
//        jpql.append(" FROM Person p JOIN FETCH p.address");
//        List list = peopleService.findPersonByJPQL(jpql.toString());
//        for(Object obj : list){
//            Person person = (Person)obj;
//            System.out.println(person.getFirstName() + person.getLastName());
//            System.out.println(person.getAddress().getStreetName());
//        }
//    }
//}
