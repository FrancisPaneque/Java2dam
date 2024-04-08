package unoN;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CorreoElectronico")
public class CorreoElectronico implements Serializable {
 
    @Id
    @Column(name="IdCorreo")    
    private int idCorreo;
 
    @Column(name="DireccionCorreo")
    private String direccionCorreo;
 
    @ManyToOne
    @JoinColumn(name="IdProfesor")
    private Profesor profesor;
 
    public CorreoElectronico() {
 
    }
 
    public CorreoElectronico(int idCorreo,String direccionCorreo,Profesor profesor) {
        this.idCorreo=idCorreo;
        this.direccionCorreo=direccionCorreo;
        this.profesor=profesor;
    }
}
