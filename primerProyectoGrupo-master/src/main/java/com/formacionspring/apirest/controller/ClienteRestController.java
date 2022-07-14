package com.formacionspring.apirest.controller;

import com.formacionspring.apirest.entity.Cliente;
import com.formacionspring.apirest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping({"/cliente","/"})
	public List<Cliente> index(){
		return clienteService.mostrarTodos();
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<?> show(@PathVariable long id) {
		
		Cliente cliente = null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			
			cliente = clienteService.mostrarPorId(id);
		
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (cliente == null) {
			response.put("mensaje", "El cliente con ID: "+id+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}

	@PostMapping("/cliente")
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.guardar(cliente);
	}

	//Buscar los datos de clienteUpdate por el modelo recibido
	@PutMapping("/cliente/{id}")
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		//Buscar en el registro por id y guardar el objeto en clienteUpdate
		Cliente clienteUpdate = clienteService.mostrarPorId(id);
		//Reemplazo los datos de clienteUpdate por el modelo recibido
		//en @RequestBody
		clienteUpdate.setNombre(cliente.getNombre());
		clienteUpdate.setApellido(cliente.getApellido());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefono(cliente.getTelefono());
		clienteUpdate.setNif(cliente.getNif());
		//Guardo y retorno los datos actualizados
		return clienteService.guardar(clienteUpdate);
	}

	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity<>("test", HttpStatus.OK);
	}

//	@DeleteMapping("/clientes/{id}")
//	public ResponseEntity<?> delete(@PathVariable Long id) {
//		Cliente clienteBorrado = servicio.mostrarPorId(id);
//		Map<String,Object>  response = new HashMap<>();
//
//		if(clienteBorrado == null) {
//			response.put("mensaje","No existe el registro con id:"+id);
//			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
//		}
//
//		try {
//
//			if(clienteBorrado.getImagen()!=null) {
//				String nombreFotoAnterior = clienteBorrado.getImagen();
//				//verificamos que el cliente tenga registrado una imagen
//				if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
//					//preparamos la ruta a la imagen guardada
//					Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
//					File archivoFotoAnterior = rutaFotoAnterior.toFile();
//					//verificamos que el archivo existe y se pueda leer
//					if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
//						//borramos la imagen
//						archivoFotoAnterior.delete();
//					}
//				}
//
//			}
//
//			servicio.borrar(id);
//
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al realizar en base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		response.put("mensaje","El cliente ha sido eliminado con éxito");
//		response.put("cliente", clienteBorrado);
//		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
//
//
//	}
//
//	@PostMapping("/clientes/uploads")
//	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo,
//			@RequestParam("id") Long id){
//
//		Map<String,Object>  response = new HashMap<>();
//		//buscar el cliente por el id recibido
//		Cliente cliente = servicio.mostrarPorId(id);
//
//		//preguntamos si el archivo es distinto de vacio
//		if( !archivo.isEmpty() ) {
//			//guardamos el nombre del archivo en esta variable
//			String nombreArchivo =  UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
//
//			//guardamos la ruta completa uploads/nombredelaimagen lo guardamos en
//			//una variable de tipo path que es de java.io
//
//			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
//
//			try {
//				//copiamos el archivo fisico a la ruta que definimos en Path
//				Files.copy(archivo.getInputStream(), rutaArchivo );
//			} catch (IOException e) {
//				response.put("mensaje", "Error al subir la imagen del cliente");
//				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
//				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//
//
//			String nombreFotoAnterior = cliente.getImagen();
//			//verificamos que el cliente tenga registrado una imagen
//			if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
//				//preparamos la ruta a la imagen guardada
//				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
//				File archivoFotoAnterior = rutaFotoAnterior.toFile();
//				//verificamos que el archivo existe y se pueda leer
//				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
//					//borramos la imagen
//					archivoFotoAnterior.delete();
//				}
//			}
//
//
//			//guardamos el nombre de la imagen
//			cliente.setImagen(nombreArchivo);
//			//registramos en base de datos
//			servicio.guardar(cliente);
//
//			response.put("cliente", cliente);
//			response.put("mensaje","Imagen subida correctamente :"+nombreArchivo);
//
//		}
//
//
//		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
//	}
//
//
//
//	@GetMapping("/uploads/img/{nombreImagen:.+}")
//	public ResponseEntity<Resource> verImagen(@PathVariable String nombreImagen){
//
//		Path rutaArchivo = Paths.get("uploads").resolve(nombreImagen).toAbsolutePath();
//
//		Resource recurso = null;
//
//		try {
//			//codigo para acceder al archivo por url
//			recurso = new UrlResource(rutaArchivo.toUri());
//
//		} catch (MalformedURLException e) {
//
//			e.printStackTrace();
//		}
//
//		if(!recurso.exists() && !recurso.isReadable()) {
//			throw new RuntimeException("no se puede cargar a la imagen: "+nombreImagen);
//		}
//
//		HttpHeaders cabecera = new HttpHeaders();
//		cabecera.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+recurso.getFilename()+"\"");
//
//
//
//		return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);
//	}
//
//
//		//metodo paraf mostrar todas la regiones
//		@GetMapping("/regiones")
//		public List<region> showRegions(){
//			return servicio.mostrarRegiones();
//
//	}
}