/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author student
 */
@Local
public interface NewsItemFacadeLocal {
    public List<NewsItem> getAllNewsItems();
}
