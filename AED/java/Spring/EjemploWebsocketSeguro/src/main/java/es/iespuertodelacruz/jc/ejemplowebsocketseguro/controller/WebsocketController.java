package es.iespuertodelacruz.jc.ejemplowebsocketseguro.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.iespuertodelacruz.jc.ejemplowebsocketseguro.document.PartidaDocument;
import es.iespuertodelacruz.jc.ejemplowebsocketseguro.document.service.PartidaDocumentService;


class MessageTo{
	
	String author;
	String receiver;
	String peticion; //Solicitar Partida, apostar
	PartidaDocument pd;
	String apuesta;
	String response;
	public MessageTo() {}
	
	
	public String getApuesta() {
		return apuesta;
	}


	public void setApuesta(String apuesta) {
		this.apuesta = apuesta;
	}


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	public String getAuthor() {
		return author;
	}
	public PartidaDocument getPd() {
		return pd;
	}
	public String getPeticion() {
		return peticion;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPd(PartidaDocument pd) {
		this.pd = pd;
	}
	public void setPeticion(String content) {
		this.peticion = content;
	}
	public void setReceiver(String destiny) {
		this.receiver = destiny;
	}
}



@Controller
@CrossOrigin
public class WebsocketController { //el controlador es para una conexión establecida en: ws://ip_de_la_api:8080/websocket
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private PartidaDocumentService partidaService;

	
	//se manejan los mensajes enviados a la ruta (recibida por el websocket ) de:  /app/publicmessage
	//y lo que corresponde hacer se envía a la ruta: /topic/chatroom y lo recibirán los que estén suscritos 
    @MessageMapping("/mensajegeneral")
    @SendTo("/salas/general")
    public MessageTo sendMessage(@Payload MessageTo chatMessage) {

        return chatMessage;
    }
    
    
    @MessageMapping("/privado") 
     public void sendSpecific(    		
      @Payload MessageTo msg, 
      Principal user, 
      @Header("simpSessionId") String sessionId) throws Exception { 
  
    	if(msg.getPeticion().equals("solicitar partida")) {
    		List<PartidaDocument> findAll = partidaService.findAll();
    		PartidaDocument p = null;
    		for (PartidaDocument pd : findAll) {
				if(pd.getNombreJ2() == null) {
					p = pd;
					p.setNombreJ2(msg.getAuthor());
					break;
				}
			}
    		
    		if(p == null) {
    			p = new PartidaDocument();
    			p.setNombreJ1(msg.getAuthor());
    		}
    		
    		PartidaDocument save = partidaService.save(p);
    		msg.setPd(p);
    		
    		simpMessagingTemplate.convertAndSendToUser(p.getNombreJ1(), "/cola/mensajes", save);
    		if(save.getNombreJ2() != null) {
    			simpMessagingTemplate.convertAndSendToUser(p.getNombreJ2(), "/cola/mensajes", save);
    		}
    		/*findAll.stream()
    			.filter(p -> p.getNombreJ2() == null);*/
    	}else if(msg.equals("apostar")) {
    		PartidaDocument findById = partidaService.findById(msg.getPd().getId());
    		if(findById != null) {
    			boolean apostar = findById.apostar(msg.getApuesta(), msg.getAuthor());
    			if(apostar) {
    				PartidaDocument save = partidaService.save(findById);
    				
    				simpMessagingTemplate.convertAndSendToUser(findById.getNombreJ1(), "/cola/mensajes", save);
    	    		simpMessagingTemplate.convertAndSendToUser(findById.getNombreJ2(), "/cola/mensajes", save);
    			}else {
    				msg.setResponse("ERROR");
    				simpMessagingTemplate.convertAndSendToUser(msg.getAuthor(), "/cola/mensajes", msg);
    			}
    		}
    	}
    	
    	simpMessagingTemplate.convertAndSendToUser(msg.getReceiver(), "/cola/mensajes", msg);
    	//si queremos una copia al autor, como cuando es una partida entre dos:
    	//simpMessagingTemplate.convertAndSendToUser(msg.getAuthor(), "/cola/mensajes", msg);
    }
}