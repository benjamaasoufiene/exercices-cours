package fr.orsys.entities;

import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor 
public class Formation_UNIDERECT implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	@GeneratedValue
	private Long id;
	private String code;
	private String theme;
	private double prix;
	@ManyToOne
	private Formateur formateur;
}
