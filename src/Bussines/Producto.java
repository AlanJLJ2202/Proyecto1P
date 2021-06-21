
package Bussines;

import DataAccess.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Producto {
    
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idProducto;
    private String nombreP;
    private String caducidadP;
    private int stock;
    private int idFarmacia;
    private String nombreF;
    private int activo;

    public Producto() {}

    public Producto(int idProducto, String nombre, String caducidad, int stock, int idFarmacia, String nombreF, int activo) {
        this.idProducto = idProducto;
        this.nombreP = nombre;
        this.caducidadP = caducidad;
        this.stock = stock;
        this.idFarmacia = idFarmacia;
        this.nombreF = nombreF;
        this.activo = activo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombreP;
    }

    public void setNombre(String nombre) {
        this.nombreP = nombre;
    }

    public String getCaducidad() {
        return caducidadP;
    }

    public void setCaducidad(String caducidad) {
        this.caducidadP = caducidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombreF() {
        return nombreF;
    }

    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }
    
    
    

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

  
    
    public DefaultTableModel mostrarTodo(){
        String query = "SELECT * FROM productos";
        return dataAccess.Query(query);
    }
    
     public DefaultTableModel Prueba(){
        String query = "SELECT idProducto AS ID, " +
                               "nombreP AS Producto, " +
                               "caducidadP AS Caducidad, " +
                               "stock," +
                               "nombreF " + 
                               "FROM productos";
        return dataAccess.Query(query);
    }
    
     public void GetById(){
        String query =  "SELECT * FROM productos WHERE idProducto = " + idProducto;
        DefaultTableModel res = dataAccess.Query(query);
        idProducto = (int)res.getValueAt(0, 0);
        nombreP = (String)res.getValueAt(0, 1);
        caducidadP = (String)res.getValueAt(0, 2);
        stock = (int)res.getValueAt(0, 3);
        activo = (int)res.getValueAt(0, 4);
        idFarmacia = (int)res.getValueAt(0, 5);
        nombreF = (String)res.getValueAt(0, 6);
    }
     
     
    //INSERT INTO TABLA(C1, C2) VALUES(V1, V2);
    public boolean add(){
        String query = "INSERT INTO productos(nombreP, caducidadP, stock, idFarmacia, nombreF, activo) " +
                "VALUES('" + nombreP + "','" + caducidadP + "'," + stock + "," + idFarmacia + ",'" + nombreF + "'," + activo + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    public boolean Delete(){
        String query = "DELETE FROM productos WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1; 
    }
    
    public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE productos SET " +
                "nombreP = '" + nombreP + "', " +
                "caducidadP = '" + caducidadP + "', " +
                "stock = " + stock + ", " +
                "idFarmacia = " + idFarmacia + ", " +
                "nombreF = '" + nombreF + "', " +
                "activo = " + activo + " " + 
                "WHERE idProducto = " +idProducto;      
        return dataAccess.Execute(query) >= 1; 
    }
}
