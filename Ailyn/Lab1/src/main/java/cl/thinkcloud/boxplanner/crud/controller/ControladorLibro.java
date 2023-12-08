package cl.thinkcloud.boxplanner.crud.controller;

import cl.thinkcloud.boxplanner.crud.entity.LibroEntity;
import cl.thinkcloud.boxplanner.crud.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller @RequestMapping("libro")
public class ControladorLibro {
	
	@Autowired
    private ILibroService servicio;
	
	@ResponseBody @PostMapping("REST") //CREATE-POST
    public LibroEntity agregarLibro(@Valid @NonNull @RequestBody LibroEntity libro) {
        return servicio.save(libro);
    }
	
	@ResponseBody @GetMapping("REST") //READ-GET
    public List<LibroEntity> getAllLibros() {
        return servicio.findAll();
    }
	
	@ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public LibroEntity getLibroById(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }
	
	@ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public LibroEntity updateLibroById(@Valid @NonNull @RequestBody LibroEntity libro) {
        Optional<LibroEntity> p = servicio.findById(libro.getId());
        if (p.isPresent()==true) {
            return servicio.save(libro);
        } else return null;
    }
	
	@ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public LibroEntity updateLibroById(@Valid @NonNull @RequestBody LibroEntity libro, @PathVariable("id") int id) {
        Optional<LibroEntity> p = servicio.findById(id);
        if (p.isPresent()==true) {
        	libro.setId(id);
            return servicio.save(libro);
        } else return null;
    }
	
	@ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public LibroEntity deletePersonaById(@Valid @NonNull @RequestBody LibroEntity libro) {
        Optional<LibroEntity> p =  servicio.findById(libro.getId());
        if (p.isPresent()==true) {
            servicio.delete(libro.getId());
            return libro;
        } else return null;
    }
	
	@ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteLibroById(@PathVariable("id") int id) {
        Optional<LibroEntity> p =  servicio.findById(id);
        if (p.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@GetMapping("listar")
    public String listar(Model model) {
        List<LibroEntity> libros=servicio.findAll();
        model.addAttribute("libros", libros);
        return "crud/indexLibro";
    }
	
	//http://localhost:8080/persona/nuevo
    @GetMapping("nuevo")
    public String agregar(Model model) {
        model.addAttribute("libro", new LibroEntity());
        return "crud/formLibro";
    }

    //http://localhost:8080/persona/editar/id
    @GetMapping("editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<LibroEntity> libro=servicio.findById(id);
        model.addAttribute("libro", libro);
        return "crud/formLibro";
    }

    //http://localhost:8080/persona/grabar
    @PostMapping("grabar")
    public String save(@Valid LibroEntity p, Model model) {
        servicio.save(p);
        return "redirect:/libro/listar";
    }

    //http://localhost:8080/persona/eliminar/id
    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        servicio.delete(id);
        return "redirect:/libro/listar";
    }
	
	

}
