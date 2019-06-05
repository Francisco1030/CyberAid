package br.com.cyberair.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cyberair.model.Doador;

@FacesConverter(forClass = Doador.class, value = "doadorConverter")
public class DoadorConveter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.isEmpty())
			return null;
		System.out.println(arg1.getAttributes().get(string));
		return arg1.getAttributes().get(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		Doador doador = (Doador) object;
		if (doador == null || doador.getNome() == null)
			return null;
		arg1.getAttributes().put(String.valueOf(doador.getNome()), doador);
		System.out.println(String.valueOf(doador.getId()));
		return String.valueOf(doador.getNome());
	}

}