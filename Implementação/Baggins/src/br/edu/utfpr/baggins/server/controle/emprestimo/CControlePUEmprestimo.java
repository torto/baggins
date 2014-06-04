package br.edu.utfpr.baggins.server.controle.emprestimo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.baggins.entidades.EMaterial;
import br.edu.utfpr.baggins.entidades.ETipoMaterial;
import br.edu.utfpr.baggins.entidades.EUsuario;
import br.edu.utfpr.baggins.server.controle.CControlePU;
import br.edu.utfpr.baggins.util.CSessao;

public class CControlePUEmprestimo
{

	private ArrayList<EMaterial> materialList;

	public static List<EMaterial> buscarListaMaterial(String filtro)
	{

		StringBuilder where = new StringBuilder();

		if (!filtro.isEmpty())
		{
			where.append("obj.nome LIKE '%");
			where.append(filtro);
			where.append("%'");
			where.append(" OR ");
			where.append("obj.descricao LIKE '%");
			where.append(filtro);
			where.append("%'");
			where.append(" OR ");
			where.append("obj.categoria.nome LIKE '%");
			where.append(filtro);
			where.append("%'");
			where.append(" OR ");
			where.append("obj.tipoMaterial.nome LIKE '%");
			where.append(filtro);
			where.append("%'");
			where.append(" OR ");
			where.append("obj.materialConsumo.nome LIKE '%");
			where.append(filtro);
			where.append("%'");
			where.append(" OR ");
			where.append("obj.modelo.nome LIKE '%");
			where.append(filtro);
			where.append("%'");
			where.append(" OR ");
			where.append("obj.marca.nome LIKE '%");
			where.append(filtro);
			where.append("%'");
			where.append(" OR ");
			where.append("obj.equipamento.nome LIKE '%");
			where.append(filtro);
			where.append("%'");
			where.append(" OR ");

		}

		return (List<EMaterial>) CControlePU.buscaList(EMaterial.class, where.toString());
	}

	public static List<ETipoMaterial> buscarListaTipoMaterial(String filtro)
	{

		StringBuilder where = new StringBuilder();

		if (!filtro.isEmpty())
		{
			where.append("obj.nome");
			where.append(" LIKE ");
			where.append("'");
			where.append(filtro);
			where.append("'");
		}

		return (List<ETipoMaterial>) CControlePU.buscaList(ETipoMaterial.class, where.toString());

	}
	
	public static EUsuario buscarUsuario(String filtro)
	{
		
		StringBuilder where = new StringBuilder();
		
		if (!filtro.isEmpty())
		{
			where.append("obj.numeroRa");
			where.append(" = ");
			where.append(filtro);
		}
		
		return (EUsuario) CControlePU.buscaUnique(EUsuario.class, where.toString());
		
	}

	public static EMaterial buscarMaterial(String filtro)
	{
		
		StringBuilder where = new StringBuilder();
		
		if (!filtro.isEmpty())
		{
			where.append("obj.codigoBarras");
			where.append(" = ");
			where.append(filtro);
		}
		
		return (EMaterial) CControlePU.buscaUnique(EMaterial.class, where.toString());
		
	}

}
