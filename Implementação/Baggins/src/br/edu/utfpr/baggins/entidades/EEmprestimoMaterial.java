package br.edu.utfpr.baggins.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="emprestimo_material")
public class EEmprestimoMaterial extends AbstraticEnty
{
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="material_id")
	private EMaterial material;
	
	@Column(name="ambiente_id")
	private EAmbiente ambiente;
	
	@Column(name="emprestimo_id")
	private EEmprestimo emprestimo;

	@Column(name="quantidade")
	private Double quantidade;
	
	public EEmprestimoMaterial()
	{
		// TODO Auto-generated constructor stub
	}

	public Double getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(Double quantidade)
	{
		this.quantidade = quantidade;
	}


	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public EMaterial getMaterial()
	{
		return material;
	}

	public void setMaterial(EMaterial material)
	{
		this.material = material;
	}

	public EAmbiente getAmbiente()
	{
		return ambiente;
	}

	public void setAmbiente(EAmbiente ambiente)
	{
		this.ambiente = ambiente;
	}

	public EEmprestimo getEmprestimo()
	{
		return emprestimo;
	}

	public void setEmprestimo(EEmprestimo emprestimo)
	{
		this.emprestimo = emprestimo;
	}

	@Override
	public Object getIdEntidade()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getNome()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdEntidade(Long id)
	{
		// TODO Auto-generated method stub
		
	}

}
