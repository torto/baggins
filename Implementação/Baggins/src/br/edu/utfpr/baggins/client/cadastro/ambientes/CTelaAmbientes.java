package br.edu.utfpr.baggins.client.cadastro.ambientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlPanelGroup;

import org.hibernate.Query;

import br.edu.utfpr.baggins.client.componentes.ctabeladinamica.CTabelaDinamica;
import br.edu.utfpr.baggins.entidades.EAmbiente;
import br.edu.utfpr.baggins.util.CSessao;

@ManagedBean
@RequestScoped
public class CTelaAmbientes implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HtmlPanelGroup pgPagina;

	private CTabelaDinamica tabela;

	private ArrayList<EAmbiente> array;

	private EAmbiente ambiente;

	public CTelaAmbientes()
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

		pgPagina = new HtmlPanelGroup();

		tabela = new CTabelaDinamica()
		{

			@Override
			public List<?> arrayList()
			{

				CSessao sessao = new CSessao();
				sessao.abrirSessao();

				Query q = sessao
						.createQuery("SELECT ambiente FROM br.edu.utfpr.baggins.entidades.EAmbiente ambiente");

				array = (ArrayList<EAmbiente>) q.list();

				return array;
			}
			
			@Override
			public Class objeto()
			{
				return EAmbiente.class;
			}
			
		};

	}

	private void setarInformacoes()
	{

		pgPagina.setLayout("block");
		pgPagina.getChildren().add(tabela.getPrincipal());

	}

	public HtmlPanelGroup getPgPagina()
	{
		return pgPagina;
	}

	public void setPgPagina(HtmlPanelGroup pgPagina)
	{
		this.pgPagina = pgPagina;
	}

}
