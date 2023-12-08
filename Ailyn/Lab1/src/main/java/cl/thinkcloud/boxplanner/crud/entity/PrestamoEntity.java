package cl.thinkcloud.boxplanner.crud.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="prestamo")
public class PrestamoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "fecha_prestamo")
    private String fecha_prestamo;
    
    @NotBlank
    @Column(name = "fecha_vencimiento")
    private String fecha_vencimiento;

	public PrestamoEntity(@JsonProperty("id")int id, @JsonProperty("fecha_prestamo") String fecha_prestamo, @JsonProperty("fecha_vencimiento") String fecha_vencimiento) {
		super();
		this.id = id;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_vencimiento = fecha_vencimiento;
	}
    
    

}
