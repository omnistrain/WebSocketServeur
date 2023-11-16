package fr.formation.websocket;

import java.io.IOException;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;



//Acces via ws://localhost:8080/WebSocketServeur/pojo
@ServerEndpoint("/pojo")
public class ExemplePojo {
	
	/*
	 * L'objet Session est l'objet inévitable dans le cadre d'une connexion en WS entre les deux parties.
	 * 
	 * .getOpenSessions() : ensemble des sessions actives.
	 * .getRequestUri() : URL qui a permis d'établir la connexion
	 * .getUserPrincipal() : information sur l'utilisateur authentifié
	 * .isOpen() : la connexion est elle ouverte ?
	 * .isSecure : la communication est elle chiffrée ?
	 * .getRequestParameterMap() : Map des parametres
	 * .getBasicRemote() : retourne un objet RemoteEndPoint.Basic, référence vers l'autre acteur de la communication.
	 * .sendBinary(....) : permet d'envoyer du binaire
	 * .sendObject(....) : permet d'envoyer un objet
	 * .sendText(....) : permet d'envoyer du texte.
	 * 
	 */
	
	/*
	 * Ecodeurs et décodeurs : Ces éléments sont importants pour encoder et décoder des messages reçus et les rendre compatibles.
	 * 
	 * Ex : si on envoi un objet.
	 * 
	 * Les interfaces : 
	 * Encoder.Text<T>
	 * Encoder.Binary<T>
	 * Encoder.TextStream<T>
	 * Encoder.BinaryStream<T>
	 * 
	 * et équivalent en Decoder.XXXX
	 * 
	 * 
	 */
	
	
	
	/*
	 * Cette méthode réceptionne le message client
	 * L'Objet Session décrit la communication établie entre la WS et le client.
	 */
	@OnMessage
	public void receptionMessage(String message, Session session) {
		/*
		 * On a la possibilité de rajouter des paramètres en Path avec l'annotation @PathPram
		 * 
		 * Dans ce cas là le @ServeurEndPoint(value="/pojo/{param}")
		 * et dans les arguments de la méthode : @PathParam(value="param") String page
		 */

		
		
	}
	
	/*
	 * 
	 * Methode appellée à l'ouverture de la communication
	 */
	@OnOpen
	public void ouvertureCommunication(Session session) {
		
		/*
		 * Exemple d'envoie un message textuel
		 */
		
		try {
			session.getBasicRemote().sendText("Welcome sur ma websocket de formation");
			
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
