/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.backing;

/**
 *
 * @author Darkness
 */
public class Student{
    private String name;
    private String surname;
    private String average;


    public Student(String name, String surname, String avg) {
        this.name = name;
        this.surname = surname;
        this.average = avg;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the average
     */
    public String getAverage() {
        return average;
    }

    /**
     * @param average the average to set
     */
    public void setAverage(String average) {
        this.average = average;
    }
   


}