package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.entity.LibroEntity;
import cl.thinkcloud.boxplanner.crud.repository.ILibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
@Service
public class LibroServiceImpl implements ILibroService{
	
	@Autowired
    private ILibroRepository data;
	
	@Override
	public List<LibroEntity> findAll() {
		return (List<LibroEntity>)data.findAll();
	}

	@Override
	public Optional<LibroEntity> findById(int id) {
		return data.findById(id);
	}

	@Override
	public LibroEntity save(LibroEntity l) {
		LibroEntity libro = data.save(l);
        return libro;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
