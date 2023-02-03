package org.dam2.empledepart.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity

public class Emple {
	

	/*
	 nDIEmp VARCHAR( 12 ) NOT NULL PRIMARY KEY,
	
	nomEmp VARCHAR( 30 ) NOT NULL ,
	sexEmp CHAR( 1 ) NOT NULL CHECK (sexEmp IN ('F', 'M') ),
	fecNac DATE NOT NULL ,
	fecIncorporacion DATE NOT NULL,
	salEmp FLOAT NOT NULL,
	comisionE FLOAT NOT NULL,
	cargoE VARCHAR( 15 ) NOT NULL,
	jefeID VARCHAR( 12 ),
	codDepto VARCHAR( 4 ) NOT NULL,
	*/
	
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column (length=12,nullable=false)
	private String nidemp;
	
	@Column (length=30,nullable=false)
	private String nomemp;
	
	@Enumerated(value=EnumType.STRING)
	@Column (length=2,nullable=false)
	private Sexo sexemp;
	
	@NonNull
	@Column (name="fecnac", nullable=false)
	private LocalDate fecNac;
	
	@NonNull
	@Column (name="fecincorporacion", nullable=false)
	private LocalDate fecIncorporacion;
	
	@Column (name="salemp",nullable=false)
	private float salEmp;
	
	@Column (name="comisione",nullable=false)
	private float comisionE;
	
	@NonNull	
	@Column (name="cargoe",length=15,nullable=false)
	private String cargoE;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "jefeID", nullable = true)
	private Emple jefe;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "coddepto", nullable = false)
	private Depart depto;

	@Override
	public String toString() {
		return "Emple [nIDEmp=" + nidemp + ", nomemp=" + nomemp + ", sexEmp=" + sexemp + ", fecNac=" + fecNac
				+ ", fecIncorporacion=" + fecIncorporacion + ", salEmp=" + salEmp + ", comisionE=" + comisionE
				+ ", cargoE=" + cargoE 
				+ ", jefe=" + (jefe != null?jefe.getNidemp():"sin jefe") 
				+ ", depto=" + depto.getCodDepto() + "]";
	}
	
	
}
