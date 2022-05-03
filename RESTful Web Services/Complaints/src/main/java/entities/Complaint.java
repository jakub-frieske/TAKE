/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Darkness
 */
@Entity
@NamedQuery(
        name = "Complaint.findByStatus", 
        query = "SELECT c FROM Complaint c WHERE c.status = :status"
)
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private LocalDate complaintDate;
    
    @NotNull
    @Size(min = 1, max = 60)
    private String complaintText;
    
    @NotNull
    @Size(min = 1, max = 60)
    private String author;
    
    @NotNull
    @Size(min = 1, max = 6)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaint)) {
            return false;
        }
        Complaint other = (Complaint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Complaint[ id=" + id + " ]";
    }

    /**
     * @return the complaintDate
     */
    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    /**
     * @param complaintDate the complaintDate to set
     */
    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    /**
     * @return the complaintText
     */
    public String getComplaintText() {
        return complaintText;
    }

    /**
     * @param complaintText the complaintText to set
     */
    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
