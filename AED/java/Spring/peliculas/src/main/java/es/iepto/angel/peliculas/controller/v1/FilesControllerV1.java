package es.iepto.angel.peliculas.controller.v1;

import java.io.IOException;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iepto.angel.peliculas.service.IFileStorageService;

//@RestController
@CrossOrigin
//@RequestMapping("/api/v1/files")
public class FilesControllerV1 {
	@Autowired
	private IFileStorageService storageService;
	
	@GetMapping("/{filename}")
	 public ResponseEntity<?> getFiles(@PathVariable String filename) {
		 Resource resource = storageService.get(filename);
	
		 // Try to determine file's content type
		 String contentType = null;
		 try {
			 contentType = URLConnection.guessContentTypeFromStream(resource.getInputStream());
	
		 } catch (IOException ex) {
			 System.out.println("Could not determine file type.");
		 }
		 // Fallback to the default content type if type could not be determined
		 if (contentType == null) {
		 contentType = "application/octet-stream";
		 }
	
		 String headerValue = "attachment; filename=\"" +
		 resource.getFilename() + "\"";
		 return ResponseEntity.ok()
			 .contentType(MediaType.parseMediaType(contentType))
			 .header(
				org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
				 headerValue
			 )
			 .body(resource);
	 }
}
