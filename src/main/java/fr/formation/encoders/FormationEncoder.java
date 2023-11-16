package fr.formation.encoders;

import fr.formation.models.Formation;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder.Text;
import jakarta.websocket.EndpointConfig;

public class FormationEncoder implements Text<Formation> {

	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void init(EndpointConfig arg0) {
		
	}
	
	
	@Override
	public String encode(Formation formation) throws EncodeException {
		String csv = "";
		if(formation !=null)
			csv = formation.getNom() + ";" + formation.getDescription();
		
		
		
		
		return csv;
	}

}
