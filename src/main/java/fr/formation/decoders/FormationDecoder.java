package fr.formation.decoders;

import fr.formation.models.Formation;
import jakarta.websocket.DecodeException;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.Decoder.Text;

public class FormationDecoder implements Text<Formation> {

	@Override
	public void destroy() {
		
	}
	
	@Override
	public void init(EndpointConfig arg0) {
		
	}
	
	
	
	@Override
	public Formation decode(String message) throws DecodeException {
		String[] data = message.split(";"); 
        Formation formation = new Formation(); 
        formation.setNom(data[0]); 
        formation.setDescription(data[1]);
        
        return formation;
	}

	
	
	/*
	 * cette méthode permet de définir si le message pourra être décodé
	 */
	@Override
	public boolean willDecode(String message) {
		
		return true;
	}

}
