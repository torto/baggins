package br.edu.utfpr.baggins.entidades;

import java.io.Serializable;


public abstract class AbstraticEnty implements Serializable
{
	public AbstraticEnty()
	{
		super();
	}
	public abstract Object getIdEntidade();
	public abstract Object getNome();
	public abstract void setIdEntidade(Long id);

}
