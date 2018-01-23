/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

/**
 *
 * @author Ricky
 */
import java.sql.*;
import java.util.ArrayList;
public class Conexion {
    
   private static Connection cnx = null;
   public static boolean actualizado = false;
   public static Connection obtener() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
      if (cnx == null) {
         try {
                final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
                Class.forName(driver).newInstance();
                final String protocol = "jdbc:derby:";
                final String dbName = "derbyDB";
                Connection connection = DriverManager.getConnection(
                protocol + dbName + ";create=true");
                cnx = connection;
                CrearTablas();
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
   
  
   public static ArrayList<String> getRequerimiento(String nroReq) throws SQLException{
       ArrayList<String> Array = new ArrayList<String>();
       Statement statement = cnx.createStatement();
        final String selectSql = "select * from requerimientos";
        ResultSet rs = statement.executeQuery(selectSql);
        while(rs.next()){
            String id = rs.getString("numeroreq");
            if(id.equals(nroReq)){
                for(int i=1;i<60;i++)
                    Array.add(rs.getString(i));            
            }
      
        }
       
       return Array;
       
        
   
   }
   
   public static void CrearTablas() throws SQLException{
       if(cnx != null){
        
        Statement statement = cnx.createStatement();
        DatabaseMetaData dbmd = cnx.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "users".toUpperCase(),null);
        /*String dropSql = "drop table users";
        statement.execute(dropSql);
        String dropSql1 = "drop table requerimientos";
        statement.execute(dropSql1);*/
        if(rs.next()){        
        
        }else{
            final String createSql = "create table users ( name varchar(32), tipo varchar(32) )";
            statement.execute(createSql);
             //Tabla usuario creada
            final String createSqlReq = "create table requerimientos (requestid varchar(32), numeroreq varchar(32),fechasolicitud varchar(32),situacion varchar(32), ejestelefonica varchar(32),iniciativas varchar(32),certificacionreq varchar(32),nombrereq varchar(32), descripcion varchar(32), dsaa varchar(32), aplicacion varchar(32), prioridadsolic varchar(32),impactonegocio varchar(32), justificacion varchar(32), fechaesperada varchar(32), fechacertificacion varchar(32), nombresolic varchar(32), codempleado varchar(32), vpsolicitante varchar(32), ggsolicitante varchar(32), gsolicitante varchar(32), nombrecontacto varchar(32), vpcontacto varchar(32), ggcontacto varchar(32), gcontacto varchar(32), extensioncontacto varchar(32), statuscomite varchar(32), observacionescomite varchar(32), fechacancelado varchar(32), fechapendiente varchar(32), grciademanda varchar(32), prioridadti varchar(32), fechacomite varchar(32), fechafacibilidad varchar(32), fecharequiereintv varchar(32), tiporeq varchar(32), subtipo varchar(32), fechaestimadainicio varchar(32), complejidad varchar(32), solicitud varchar(32), nombrerespfunc varchar(32), codigorespfunc varchar(32), ggrespfunc varchar(32), grespfunc varchar(32), fechainicioreal varchar(32), fechaestimadaculminacion varchar(32), fechaculminacion varchar(32), nombrerespimpl varchar(32), codrespimpl varchar(32), ggrespimpl varchar(32), grespimpl varchar(32), costoreq varchar(32), impactotecnico varchar(32), observaciones varchar(32), nombreejecutor varchar(32), codejecutor varchar(32), ggejecutor varchar(32), gejecutor varchar(32), extensionejecutor varchar(32))";
            statement.execute(createSqlReq);
        }
        


        statement.close();
    }   
   }
   
   public static void ActualizarCarteleraPrimeraVez() throws SQLException{
        if(actualizado){
            return;
        }else{
            actualizado = true;
        }
        Statement statement = cnx.createStatement();
        final String selectSql = "select * from requerimientos";
        ResultSet rs = statement.executeQuery(selectSql);
        CarteleraDeRequerimientos cartelera = CarteleraDeRequerimientos.Instance();
        while(rs.next()){
            ArrayList<String> Array = new ArrayList<String>();
            Array.add(rs.getString("numeroreq"));
            Array.add(rs.getString("aplicacion"));
            Array.add(rs.getString("nombrereq"));
            Array.add(rs.getString("statuscomite"));
            Array.add(rs.getString("vpsolicitante"));
            Array.add(rs.getString("nombresolic")); 
            Array.add(rs.getString("ggrespfunc"));
            Array.add(rs.getString("nombrerespfunc")); 
            Array.add(rs.getString("fechasolicitud")); //            
            cartelera.addRequerimiento(new Requerimiento(Array));        
        }
   }
   
      public static void ActualizarCartelera2() throws SQLException{
        Statement statement = cnx.createStatement();
        final String selectSql = "select * from requerimientos";
        ResultSet rs = statement.executeQuery(selectSql);
        CarteleraDeRequerimientos cartelera = CarteleraDeRequerimientos.Instance();
        cartelera.RemoveArray();
        while(rs.next()){
            ArrayList<String> Array = new ArrayList<String>();
            Array.add(rs.getString("numeroreq"));
            Array.add(rs.getString("aplicacion"));
            Array.add(rs.getString("nombrereq"));
            Array.add(rs.getString("statuscomite"));
            Array.add(rs.getString("vpsolicitante"));
            Array.add(rs.getString("nombresolic")); 
            Array.add(rs.getString("ggrespfunc"));
            Array.add(rs.getString("nombrerespfunc")); 
            Array.add(rs.getString("fechasolicitud")); //            
            cartelera.addRequerimiento(new Requerimiento(Array));        
        }
   }
      
   public static void EliminarReq(String nroReq) throws SQLException{
       Statement statement = cnx.createStatement();
       statement.executeUpdate("DELETE FROM requerimientos WHERE numeroreq='"+nroReq+"'");  
       statement.close();
   }
   
   public static void CulminarReq(String nroReq) throws SQLException{
        Statement statement = cnx.createStatement();
        PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM requerimientos", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            String id = rs.getString("numeroreq"); 
            if(id.equals(nroReq)){
                rs.updateString("statuscomite", "Concluido");
                rs.updateRow(); 
            }
        }
        statement.close();
        stmt.close();    
   }
   
    public static void EjecucionReq(String nroReq, boolean Activar) throws SQLException{
        Statement statement = cnx.createStatement();
        PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM requerimientos", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            String id = rs.getString("numeroreq"); 
            if(id.equals(nroReq)){
                if(Activar)
                    rs.updateString("statuscomite", "En Uso");
                else
                    rs.updateString("statuscomite", "Aprobado");
                rs.updateRow(); 
            }
        }
        statement.close();
        stmt.close();    
   }
      
    public static void InsertarTodo(ArrayList<String> Array) throws SQLException{
        Statement statement = cnx.createStatement();
            String IDReq = Array.get(0);            
            PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM requerimientos", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            //final String selectSql = "select requestid from requerimientos";
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("requestid");
                if(id.equals(IDReq)){
                    int count = 1;
                    for(int i=0;i<Array.size();i++){
                        rs.updateString(count, Array.get(i));
                        count++;
                    }      
                    //rs.updateString("statuscomite","En Ejecución");
                    rs.updateRow(); 
                    statement.close();
                    stmt.close();
                    return;
                }
            }
    }
   
    public static boolean InsertarRequerimiento(ArrayList<String> Array, int Tab) throws SQLException{
        
        Statement statement = cnx.createStatement();
        if(Tab==0){
            String IDReq = Array.get(0);            
            final String selectSql = "select requestid from requerimientos";
            ResultSet rs = statement.executeQuery(selectSql);
            while(rs.next()){
                String id = rs.getString("requestid");
                if(id.equals(IDReq)){
                    statement.close();
                    return false;
                }
            }
            String Insert = "insert into requerimientos values ( ";
            for(int i=0; i < Array.size();i++){
                String Auxiliar = Array.get(i);
                Auxiliar = "'"+Auxiliar+"'";
                if(i+1 == Array.size()){
                    Auxiliar = Auxiliar +")";
                }else{
                    Auxiliar = Auxiliar + ",";
                }
                Insert = Insert+Auxiliar;
            }
            statement.execute(Insert);
            
        }else if(Tab==1){
            String IDReq = Array.get(0);            
            PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM requerimientos", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            //final String selectSql = "select requestid from requerimientos";
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("requestid");
                if(id.equals(IDReq)){
                    int count = 27;
                    for(int i=1;i<Array.size();i++){
                        rs.updateString(count, Array.get(i));
                        count++;
                    }      
                    //rs.updateString("statuscomite","En Ejecución");
                    rs.updateRow(); 
                    statement.close();
                    stmt.close();
                    return true;
                }
            }            
        }
        
        statement.close();
        return true;
    }
    
    public static boolean InsertarUsuario(String name, String tipo) throws SQLException{
        if(cnx != null){            
            Statement statement = cnx.createStatement();
            final String selectSql = "select name from users";
            ResultSet rs = statement.executeQuery(selectSql);
            name = name.toUpperCase();
            while(rs.next()){
                String nombre = rs.getString("name");
                if(nombre.equals(name)){
                    statement.close();
                    return false;
                }
            }    
            name = "'"+name+"'";
            tipo = "'"+tipo+"'";
            String insertSql = "insert into users values ( ";
            insertSql = insertSql + name +", "+tipo+" )";            
            statement.execute(insertSql);
            statement.close();
            return true;
        }
        return false;
    }
}