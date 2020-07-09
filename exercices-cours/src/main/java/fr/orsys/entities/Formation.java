package fr.orsys.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("MERE")
@Data @AllArgsConstructor @NoArgsConstructor 
public class Formation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	@GeneratedValue
	private Long id;
	private String code;
	private String theme;
	private double prix;
	@ManyToOne
	private Formateur formateur;
	@ManyToOne
    private Centre centre;
	@ManyToMany(mappedBy = "formation", fetch = FetchType.LAZY)
	Collection<Participant> participant;
}
