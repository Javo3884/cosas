package cl.thinkcloud.boxplanner.crud.service;
import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.entity.LibroEntity;

public interface ILibroService {
	
    public List<LibroEntity> findAll();
    public Optional<LibroEntity> findById(int id);
    public LibroEntity save(LibroEntity libro);
    public void delete(int id);

}
