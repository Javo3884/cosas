package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.PrestamoEntity;

@Repository
public interface IPrestamoRepository extends CrudRepository <PrestamoEntity, Integer>{

}
