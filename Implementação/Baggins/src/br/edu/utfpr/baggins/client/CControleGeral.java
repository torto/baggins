package br.edu.utfpr.baggins.client;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.primefaces.component.graphicimage.GraphicImage;

public class CControleGeral
{

	public CControleGeral()
	{
		// TODO Auto-generated constructor stub
	}

	public static UIComponent getUIComponent(String id)
	{
		return FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
	}

	public static void campoIcones(boolean validacao, String idCampoImagem, String campoValidacao)
	{

		if (validacao)
		{
			GraphicImage img = (GraphicImage) CControleGeral.getUIComponent(idCampoImagem);

			if (campoValidacao.isEmpty())
			{
				img.setName("alerta.png");
			}
			else
			{
				img.setName("error.png");
			}
		}
		else
		{
			GraphicImage img = (GraphicImage) CControleGeral.getUIComponent(idCampoImagem);
			img.setName("check.png");
		}

	}

}
