package br.edu.utfpr.baggins.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlPanelGroup;

import org.hibernate.Query;

import br.edu.utfpr.baggins.client.componentes.ctabeladinamica.CTabelaDinamica;
import br.edu.utfpr.baggins.entidades.ECategoria;
import br.edu.utfpr.baggins.util.CSessao;


@ManagedBean
@RequestScoped
public class CTelaEmprestimo implements Serializable
{

	private HtmlPanelGroup topo;
	private CTabelaDinamica tabela;
	private ECategoria categoria;


	public CTelaEmprestimo()
	{
	}

	@PostConstruct
	public void ini()
	{
			instanciarItens();
			setarInformacoes();
	}

	private void instanciarItens()
	{
		topo = new HtmlPanelGroup();

		instanciarTabela();
	}

	private void instanciarTabela()
	{
		tabela = new CTabelaDinamica()
		{

			@Override
			public List<?> arrayList()
			{
				ArrayList<ECategoria> aa = new ArrayList<ECategoria>();

				CSessao sessao = new CSessao();
				sessao.abrirSessao();

				Query q = sessao
						.createQuery("SELECT categoria FROM br.edu.utfpr.baggins.entidades.ECategoria categoria");

				aa = (ArrayList<ECategoria>) q.list();
				return aa;
			}
			
			@Override
			public Class objeto()
			{
				// TODO Auto-generated method stub
				return ECategoria.class;
			}
		};
	}

	private void setarInformacoes()
	{

		topo.setLayout("block");
		topo.getChildren().add(tabela.getPrincipal());

	}

	public HtmlPanelGroup getTopo()
	{
		return topo;
	}

	public void setTopo(HtmlPanelGroup topo)
	{
		this.topo = topo;
	}

}
