package cl.thinkcloud.boxplanner.crud.controller;

import cl.thinkcloud.boxplanner.crud.entity.PrestamoEntity;
import cl.thinkcloud.boxplanner.crud.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller @RequestMapping("prestamo")
public class ControladorPrestamo {
	
	@Autowired
    private IPrestamoService servicio;
	
	@ResponseBody @PostMapping("REST") //CREATE-POST
    public PrestamoEntity agregarPersona(@Valid @NonNull @RequestBody PrestamoEntity prestamo) {
        return servicio.save(prestamo);
    }
	
	@ResponseBody @GetMapping("REST") //READ-GET
    public List<PrestamoEntity> getAllPrestamos() {
        return servicio.findAll();
    }
	
	@ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public PrestamoEntity getPrestamoById(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }
	
	@ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public PrestamoEntity updatePersonaById(@Valid @NonNull @RequestBody PrestamoEntity prestamo) {
        Optional<PrestamoEntity> p = servicio.findById(prestamo.getId());
        if (p.isPresent()==true) {
            return servicio.save(prestamo);
        } else return null;
    }
	
	/////////////////////////////////////////////////////////////////
	
	
    @GetMapping("listar")
    public String listar(Model model) {
        List<PrestamoEntity> prestamos=servicio.findAll();
        model.addAttribute("prestamos", prestamos);
        return "crud/indexPrestamo";
    }
	
    @GetMapping("nuevo")
    public String agregar(Model model) {
        model.addAttribute("prestamo", new PrestamoEntity());
        return "crud/formPrestamo";
    }
    
    @GetMapping("editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<PrestamoEntity> prestamo=servicio.findById(id);
        model.addAttribute("prestamo", prestamo);
        return "crud/formPrestamo";
    }
    
    @PostMapping("grabar")
    public String save(@Valid PrestamoEntity p, Model model) {
        servicio.save(p);
        return "redirect:/prestamo/listar";
    }
    
    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        servicio.delete(id);
        return "redirect:/prestamo/listar";
    }
    

}
