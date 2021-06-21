
package Bussines;

import DataAccess.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Farmacia {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idFar, telefonoF;
    private String nombreF, direccionF;
    private int activo;

    public Farmacia(){}
    
    public Farmacia(int idFar, int telefonoF, String nombreF, String direccionF, int activo) {
        this.idFar = idFar;
        this.telefonoF = telefonoF;
        this.nombreF = nombreF;
        this.direccionF = direccionF;
        this.activo = activo;
    }

    public int getIdFar() {
        return idFar;
    }

    public void setIdFar(int idFar) {
        this.idFar = idFar;
    }

    public int getTelefonoF() {
        return telefonoF;
    }

    public void setTelefonoF(int telefonoF) {
        this.telefonoF = telefonoF;
    }

    public String getNombreF() {
        return nombreF;
    }

    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }

    public String getDireccionF() {
        return direccionF;
    }

    public void setDireccionF(String direccionF) {
        this.direccionF = direccionF;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
    
    
    
     public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM farmacias";
        return dataAccess.Query(query);
    }
    
     public void GetById(){
        String query =  "SELECT * FROM farmacias WHERE idFarmacia = " + idFar;
        DefaultTableModel res = dataAccess.Query(query);
        idFar = (int)res.getValueAt(0, 0);
        nombreF = (String)res.getValueAt(0, 1);
        direccionF = (String)res.getValueAt(0, 2);
        telefonoF = (int)res.getValueAt(0, 3);
        activo = (int)res.getValueAt(0, 4);
        
    }
    //INSERT INTO TABLA(C1, C2) VALUES(V1, V2);
    public boolean add(){
        String query = "INSERT INTO farmacias(nombreF, direccionF, telefonoF, activo) " +
                "VALUES('" + nombreF + "','" + direccionF + "'," + telefonoF + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    public boolean Delete(){
        String query = "DELETE FROM farmacias WHERE idFarmacia = " + idFar;
        return dataAccess.Execute(query) >= 1; 
    }
    
    public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE farmacias SET " +
                "nombreF = '" + nombreF + "', " +
                "direccionF = '" + direccionF + "', " +
                "telefonoF = " + telefonoF + ", " +
                "activo = " + activo + " " + 
                "WHERE idFarmacia = " +idFar;      
        return dataAccess.Execute(query) >= 1; 
    }
    
    
    
    
}
