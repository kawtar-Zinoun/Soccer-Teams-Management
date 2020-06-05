import java.sql.*; // on importe le package sql qui nous permet de manipuler les données de la BD
import java.sql.DriverManager; // le driver manager charge le driver du JDBC
public class Connexion {
	Connection con; // On initialize une connection
	public void conection(){
		try {
			
Class.forName("com.mysql.cj.jdbc.Driver") ;  // nous permet d’appeler la classe Driver et initialiser 
                                             // ses valeurs 

		con=DriverManager.getConnection( // pour tenter une connexion avec la bd
				"jdbc:mysql://localhost/bdjava2?useUnicode=true&useJDBCCompliantTimezoneShift=true"
				+ "&useLegacyDatetimeCode=false&serverTimezone=UTC"
	,"root","root");  // On inclut dans le URL le nom du host, le nom de la bd, le user le password 
		              // de la BD, on gère aussi le problème du time zone.
		}
		catch (Exception ex) { 
			System.out.println(ex.getMessage()); // au cas où une exception est generée, on affiche
			                                     // le message d'erreur 
			}
		}
}
