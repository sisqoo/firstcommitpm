// default package
// Generated 11 nov. 2018 20:55:22 by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tproduct generated by hbm2java
 */
@Entity
@Table(name="tproduct"
    ,catalog="projectmanagement"
)
public class Tproduct  implements java.io.Serializable {


     private int idproduct;
     private String nameproduct;
     private Integer enabledproduct;
     private Set ttickets = new HashSet(0);

    public Tproduct() {
    }

	
    public Tproduct(int idproduct) {
        this.idproduct = idproduct;
    }
    public Tproduct(int idproduct, String nameproduct, Integer enabledproduct, Set ttickets) {
       this.idproduct = idproduct;
       this.nameproduct = nameproduct;
       this.enabledproduct = enabledproduct;
       this.ttickets = ttickets;
    }
   
     @Id 

    
    @Column(name="idproduct", unique=true, nullable=false)
    public int getIdproduct() {
        return this.idproduct;
    }
    
    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    
    @Column(name="nameproduct", length=30)
    public String getNameproduct() {
        return this.nameproduct;
    }
    
    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    
    @Column(name="enabledproduct")
    public Integer getEnabledproduct() {
        return this.enabledproduct;
    }
    
    public void setEnabledproduct(Integer enabledproduct) {
        this.enabledproduct = enabledproduct;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tproduct")
    public Set getTtickets() {
        return this.ttickets;
    }
    
    public void setTtickets(Set ttickets) {
        this.ttickets = ttickets;
    }




}


