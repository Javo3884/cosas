package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Entity
@Table(name="libro")
public class LibroEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "titulo")
    private String titulo;
    
    @NotBlank
    @Column(name = "autor")
    private String autor;
    
    @NotBlank
    @Column(name = "editorial")
    private String editorial;
    
    @NotBlank
    @Column(name = "genero")
    private String genero;
    
    @NotNull
    @Column(name = "ejemplar")
    private int ejemplar;

	public LibroEntity(int id, @JsonProperty String titulo, @JsonProperty String autor, @JsonProperty String editorial,
			@JsonProperty String genero, @JsonProperty int ejemplar) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.genero = genero;
		this.ejemplar = ejemplar;
	}
    
    

}
