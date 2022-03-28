/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author student
 */
@Named(value = "managedBean")
@RequestScoped
public class ManagedBean {
    
    private List<Student> students;
    private Integer first = 0;
    private Integer second = 0;
    private Integer result = 0;
    private LineChartModel lineModel ;

    
    /**
     * Creates a new instance of ManagedBean
     */
    public ManagedBean() {
        Faker faker = new Faker();
        students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String firstName = faker.name().firstName(); 
            String lastName = faker.name().lastName(); 
            double random = new Random().nextDouble(); 
            double SP = 4.0 + (random * (5.0 - 4.0)); 
            students.add(new Student(firstName, lastName, String.format("%.2f", SP)));
        }
    }

    public void calculate(){
        setResult(first + second);
        String message= String.format("%d + %d = %d", first, second, result); 
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));	
    }
    
     /**
     * @return the lineModel
     */
    public LineChartModel getLineModel() {        
        lineModel = new LineChartModel();
        lineModel.setTitle("Sin/cos");
        lineModel.setLegendPosition("be");
        lineModel.setZoom(true);
        
        LineChartSeries sine = new LineChartSeries();
        sine.setLabel("sin(x)");
        LineChartSeries cosine = new LineChartSeries();
        cosine.setLabel("cos(x)");

        for (int x = 0; x <= 360; x+=10) {
            sine.set(x , Math.sin((x*Math.PI/180)));
            cosine.set(x ,  Math.cos((x / 180.0) * Math.PI));
        }
        
        lineModel.addSeries(sine);
        lineModel.addSeries(cosine);
        
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setLabel("y");
        yAxis.setMin(-1.5);
        yAxis.setMax(1.5);
        
        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setLabel("x (deg)");
        xAxis.setMin(0);
        xAxis.setMax(360);
        
        return lineModel;
    }
    
    /**
     * @return the curr_date
     */
    public Date getDate() {
        return new Date();
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

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}
