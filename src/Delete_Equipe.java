import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Delete_Equipe{
	
	
	 public void delete(String itemd) { // une m�thode qu'on va appeller dans la classe equipe1
		 // et qui prend en parametres l'item selectionn� dans le combobox
		 Connexion cr = new Connexion();
			cr.conection(); // on etablit la connexion
	 try {
		 String sql = "select * from equipe where Nom LIKE ?"; // on selectionne l'equipe qui a 
		 // le nom pass� en parametres

			
			 PreparedStatement ps = cr.con.prepareStatement(sql); 
			 ps.setString(1, itemd);
			 ResultSet rs = ps.executeQuery(); // on met le resultat dans un resultset
			 int result = 0; 
			 while (rs.next()) {
				 result = rs.getInt(1); // on stocke l'id de l'equipe dans la variable result
				 
			 }
				 String jouersDl = "Delete from joueur where ID_EQUIPE LIKE ?"; // puisque joueur a une
				 // cl� etrang�re qui reference l'id de l'equipe, on doit d'abord supprimer les joueurs 
				 // associ�s avec l'equipe avant de supprimer cette derni�re, sinon on va violer 
				 // une contrainte sql 
				 PreparedStatement ps2 = cr.con.prepareStatement(jouersDl); // on prepare le statement
				 ps2.setInt(1, result); // on met l'id de l'equipe dans le premier parametre de la req
			 
			      ps2.executeUpdate(); // on execute la requete sans rien retourner
			      
			      String dlEq = "Delete from equipe where ID_Equipe LIKE ?"; // finalement, apr�s avoir
			      // supprim� les joueurs associ�s � l'�quipe on peut supprimer l'equipe
			      PreparedStatement ps3 = cr.con.prepareStatement(dlEq); // on prepare le statement
		 ps3.setInt(1, result); // on met l'id de l'equipe dans le premier parametre de la req
					 ps3.executeUpdate();
				 
	 }
	 catch (Exception ex) {
	 System.out.println(ex.getMessage()); // en cas d'exception gener�e on affiche un message d'erreur
	 }
}
}
