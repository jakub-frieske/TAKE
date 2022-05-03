/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import entities.Complaint;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
    import javax.ws.rs.core.MediaType;
/**
 *
 * @author Darkness
 */
public class Main {
    
    public static void main(String[] args) {
        String URL = "http://localhost:8080/Complaints/resources/complaints";
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider(); 
        provider.setMapper(mapper); 
        Client client = ClientBuilder.newClient().register(provider);
        WebTarget base = client.target(URL);

        /* COUNT */
        String count = base.path("count")
            .request(MediaType.TEXT_PLAIN)
            .get(String.class);
        System.out.println("Count: " + count);
        System.out.println("----------------------------");
        
        /* List of complaints */
        List<Complaint> allComplaints = base
            .request()
            .get(new GenericType<List<Complaint>>(){});
        System.out.println("\t\t All Complaints: " );
        allComplaints.forEach(System.out::println);
        System.out.println("----------------------------");
        
         /* Open complaint  */
        Complaint openComplaint = base.path("54")
            .request()
            .get(Complaint.class);
        openComplaint.setStatus("open");
        System.out.println("\t\t Open Complaints: \n" + openComplaint );
        
        /* Edit complaint from OPEN -> CLOSED */
        openComplaint.setStatus("closed");
        base.path("54")
            .request()
            .put(Entity.json(openComplaint));
        System.out.println("----------------------------");
        
        /* List of open complaints */
        List<Complaint> openComplaints = base.queryParam("status", "open")
            .request()
            .get(new GenericType<List<Complaint>>(){});
        System.out.println("\t\t All Open Complaints: " );
        openComplaints.forEach(System.out::println);
        System.out.println("----------------------------");

        
        client.close(); 
    }
}
