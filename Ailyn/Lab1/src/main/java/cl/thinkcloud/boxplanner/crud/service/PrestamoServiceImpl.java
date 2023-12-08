package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.entity.PrestamoEntity;
import cl.thinkcloud.boxplanner.crud.repository.IPrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
@Service
public class PrestamoServiceImpl implements IPrestamoService{
	
	@Autowired
    private IPrestamoRepository data;

	@Override
	public List<PrestamoEntity> findAll() {
		return (List<PrestamoEntity>)data.findAll();
	}

	@Override
	public Optional<PrestamoEntity> findById(int id) {
		return data.findById(id);
	}

	@Override
	public PrestamoEntity save(PrestamoEntity p) {
		PrestamoEntity prestamo = data.save(p);
        return prestamo;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}



}
