package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.entity.PrestamoEntity;

public interface IPrestamoService {
    public List<PrestamoEntity> findAll();
    public Optional<PrestamoEntity> findById(int id);
    public PrestamoEntity save(PrestamoEntity prestamo);
    public void delete(int id);

}
