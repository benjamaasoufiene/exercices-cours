package fr.orsys.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("INTER")
public class FromationInter extends Formation{
	private static final long serialVersionUID = 1L;
	private int nbEntreprises;

}
