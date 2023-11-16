package fr.formation.websocket;

import java.io.IOException;

import fr.formation.decoders.FormationDecoder;
import fr.formation.encoders.FormationEncoder;
import fr.formation.models.Formation;
import jakarta.websocket.EncodeException;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;


/*
 * 
 * Exemple d'encodage et de décodage
 * Il faut préciser les encoders et decodeurs dans l'annotation @ServeurEndPoint
 * 
 */


//Acces via ws://localhost:8080/WebSocketServeur/formation
@ServerEndpoint(value="/formation", encoders = FormationEncoder.class, decoders = FormationDecoder.class)
public class FormationWS {
	
	
	
	/*
	 * Pour le décodage il suffit simplement de typer l'argument de réception
	 */
	@OnMessage
	public void receptionMessage(Formation formation, Session session) {
		System.out.println(formation.getNom() + " => " + formation.getDescription());
	}
	

	@OnOpen
	public void ouvertureCommunication(Session session) {
		
		/*
		 * Envoie de message avec l'encodeur
		 */
		
		
		Formation formation = new Formation();
		formation.setNom("WebSocket Formation");
		formation.setDescription("Exemple de description");
		try {
			session.getBasicRemote().sendObject(formation);
			
		}catch(EncodeException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Methode appellée dans le cas d'une erreur
	 */
	@OnError
	public void error(Throwable error, Session session) {
		
	}
	
	/*
	 * Methode appellée à la fermeture de la connexion
	 */
	@OnClose
	public void fermeture(Session session) {
		
		System.out.println("Fermeture de la connexion");
		
	}

}
