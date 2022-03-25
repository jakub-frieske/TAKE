/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author student
 */
@Named(value = "managedBean")
@RequestScoped
public class ManagedBean {
    public class Student{
        public String name;
        public String surname;
        public String average;
        public Student(String n,String s,String a){
            name = n;
            surname = s;
            average = a;
            
        }
    }
    
    private List<Student> students;
    private Integer first = 0;
    private Integer second = 0;
    private Integer result = 0;
    private Date curr_date = new Date();

    
    /**
     * Creates a new instance of ManagedBean
     */
    public ManagedBean() {
        Random rand = new Random();
        students = new ArrayList<>();
        for ( int i =0 ; i <10; i++){
            Integer avg = rand.nextInt((5 - 4) + 1) + 4;
            Student student = new Student("Name" + i.toString(), "Surname"+i.toString() , "5.0");
        }
    }

    public void calculate(){
        setResult(first + second);
        String message= first.toString() + '+' + second.toString() + '=' + result.toString();
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));		
	
	
    }
    
    /**
     * @return the curr_date
     */
    public Date getCurr_date() {
        return curr_date;
    }

    /**
     * @param curr_date the curr_date to set
     */
    public void setCurr_date(Date curr_date) {
        this.curr_date = new Date();
    }
    
    /**
     * @return the first
     */
    public Integer getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Integer first) {
        this.first = first;
    }

    /**
     * @return the second
     */
    public Integer getSecond() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(Integer second) {
        this.second = second;
    }

    /**
     * @return the result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Integer result) {
        this.result = result;
    }
    
}


