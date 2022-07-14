package com.formacionspring.apirest.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.formacionspring.apirest.entity.Producto;
import com.formacionspring.apirest.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {
	
	@Autowired
	private ProductoService servicio;
	
	@GetMapping({"/producto","/"})
	public List<Producto> index(){
		return servicio.mostrarTodos();
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> show(@PathVariable long id) {
		
		Producto producto = null;
		Map<String,Object>  response = new HashMap<>();

		try {
			
			producto = servicio.mostrarPorId(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar en base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(producto == null) {
			response.put("mensaje", "El producto con ID: "+id+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	
	@PostMapping("/producto")
	public ResponseEntity<?> create(@RequestBody Producto cliente) {
		Producto clienteNew = null;
		Map<String,Object>  response = new HashMap<>();
		
		try {
			
			clienteNew =  servicio.guardar(cliente);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar en base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El producto ha sido creado con éxito");
		response.put("producto", clienteNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
				
	}
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> update(@RequestBody Producto producto
			,@PathVariable Long id) {
		
		Producto productoUpdate =  servicio.mostrarPorId(id);
		Map<String,Object>  response = new HashMap<>();
		
		
		if(productoUpdate == null) {
			response.put("mensaje","No existe el registro con id:"+id);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			
			productoUpdate.setNombre(producto.getNombre());
			productoUpdate.setCodProducto(producto.getCodProducto());
			productoUpdate.setTipo(producto.getTipo());
			productoUpdate.setCreateAt(producto.getCreateAt());
			productoUpdate.setCantidad(producto.getCantidad());
			
			if(producto.getImagen()!=null) {
				String nombreFotoAnterior = producto.getImagen();
				
				if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
				
					Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
					File archivoFotoAnterior = rutaFotoAnterior.toFile();
					
					if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					
						archivoFotoAnterior.delete();
					}
				}
				productoUpdate.setImagen(producto.getImagen());
			}
			
			servicio.guardar(productoUpdate);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar en base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El producto ha sido actualizado con éxito");
		response.put("producto", productoUpdate);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		

	}
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Producto productoBorrado = servicio.mostrarPorId(id);
		Map<String,Object>  response = new HashMap<>();
		
		if(productoBorrado == null) {
			response.put("mensaje","No existe el registro con id:"+id);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			
			if(productoBorrado.getImagen()!=null) {
				String nombreFotoAnterior = productoBorrado.getImagen();
				if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
					Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
					File archivoFotoAnterior = rutaFotoAnterior.toFile();
					if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
						archivoFotoAnterior.delete();
					}
				}
				
			}
			
			servicio.borrar(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar en base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El producto ha sido eliminado con éxito");
		response.put("producto", productoBorrado);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/producto/uploads")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo,
			@RequestParam("id") Long id){
		
		Map<String,Object>  response = new HashMap<>();
		
		Producto producto = servicio.mostrarPorId(id);
			
		if( !archivo.isEmpty() ) {
			
			String nombreArchivo =  UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			
			
			
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
		
			try {
			
				Files.copy(archivo.getInputStream(), rutaArchivo );
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del producto");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			String nombreFotoAnterior = producto.getImagen();
			
			if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
				
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				
				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					
					archivoFotoAnterior.delete();
				}
			}
			
		
			
			producto.setImagen(nombreArchivo);
			
			servicio.guardar(producto);
			
			response.put("producto", producto);
			response.put("mensaje","Imagen subida correctamente :"+nombreArchivo);
		
		}
		
	
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/uploads/img/{nombreImagen:.+}")
	public ResponseEntity<Resource> verImagen(@PathVariable String nombreImagen){
	
		Path rutaArchivo = Paths.get("uploads").resolve(nombreImagen).toAbsolutePath();
		
		Resource recurso = null;
		
		try {
			
			recurso = new UrlResource(rutaArchivo.toUri());
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("no se puede cargar a la imagen: "+nombreImagen);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+recurso.getFilename()+"\"");
		
		
		
		return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);
	}
	
	
	
}

