
package Bussines;

import DataAccess.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Farmacia {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idFarmacia, telefonoF;
    private String nombreF, direccionF;
    private int activo;

    public Farmacia(){}
    
    public Farmacia(int idFarmacia, int telefonoF, String nombreF, String direccionF, int activo) {
        this.idFarmacia = idFarmacia;
        this.telefonoF = telefonoF;
        this.nombreF = nombreF;
        this.direccionF = direccionF;
        this.activo = activo;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
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
     
     public DefaultTableModel Buscar(String entrada){
           String query = "SELECT idCategoria AS ID, nombre AS Nombre " +
                          "FROM Categorias " +
                          "LIKE '%" + entrada + "%'";
        return dataAccess.Query(query);
       }
     
     
    
     public void GetById(){
        String query =  "SELECT * FROM farmacias WHERE idFarmacia = " + idFarmacia;
        DefaultTableModel res = dataAccess.Query(query);
        idFarmacia = (int)res.getValueAt(0, 0);
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
        String query = "DELETE FROM farmacias WHERE idFarmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1; 
    }
    
    public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE farmacias SET " +
                "nombreF = '" + nombreF + "', " +
                "direccionF = '" + direccionF + "', " +
                "telefonoF = " + telefonoF + ", " +
                "activo = " + activo + " " + 
                "WHERE idFarmacia = " +idFarmacia;      
        return dataAccess.Execute(query) >= 1; 
    }
    
    
    
    
}
