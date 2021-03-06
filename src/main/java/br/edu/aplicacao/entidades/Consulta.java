package br.edu.aplicacao.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** 
 * 
 *
 */
@Entity
@Table(name="tb_consulta")
public class Consulta {
	
	@Id
	@Column(name = "id_consulta")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "anamnese", nullable = true)
	private String anamnese;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", nullable = false)
	private Usuario usuario;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_paciente", referencedColumnName = "pac_id", nullable = true)	
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_dentista", referencedColumnName = "dent_id", nullable = true)	
	private Dentista dentista;
	
	
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "fk_agenda", referencedColumnName = "id_agenda", nullable = true)
	private Agenda agenda;

	
	@Column(name = "dt_inclusao", nullable=true)
	private Date dtInclusao;
		
	public Consulta() {		
	}
	
	public Consulta(Agenda agenda,String anamnese, Paciente paciente,Dentista dentista, Usuario usuario) {
		this.agenda = agenda;
		this.anamnese = anamnese;
		this.paciente = paciente;
		this.dentista = dentista;
		this.usuario = usuario;
	}
	
	public Consulta(Agenda agenda,String anamnese,Paciente paciente,Dentista dentista) {
		this.agenda = agenda;
		this.anamnese = anamnese;
		this.paciente = paciente;
		this.dentista = dentista;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(String anamnese) {
		this.anamnese = anamnese;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	public Dentista getDentista() {
		return dentista;
	}

	public void setDentistas(Dentista dentista) {
		this.dentista = dentista;
	}
	
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}


	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
}
