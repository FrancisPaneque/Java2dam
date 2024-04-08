package unoN;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Profesor")
public class Profesor implements Serializable  {
 
    @Id
    @Column(name="Id")
    private int id;
 
    @Column(name="nombre")
    private String nombre;
 
    @Column(name="ape1")
    private String ape1;
 
    @Column(name="ape2")    
    private String ape2;
 
    @OneToMany(mappedBy="profesor",cascade= CascadeType.ALL)
    private Set<CorreoElectronico> correosElectronicos;
 
 
    public Profesor(){ 
    }
 
    public Profesor(int id, String nombre, String ape1, String ape2) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }
}