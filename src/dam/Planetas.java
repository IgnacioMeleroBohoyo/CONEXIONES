package dam;

import java.sql.*;

public class Planetas {

    public static void main(String[] args) {
        PlanetasDAO c = new PlanetasDAO();
        c.conectar();
        c.crearTabla();
        c.cerrarConexion();
    }
}
