package br.com.cyberair.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cyberair.model.Ong;

@FacesConverter(forClass = Ong.class, value = "ongConverter")
public class OngConveter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.isEmpty())
			return null;
		return arg1.getAttributes().get(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		Ong ong = (Ong) object;
		if (ong == null || ong.getId() == null)
			return null;
		arg1.getAttributes().put(String.valueOf(ong.getId()), ong);
		return String.valueOf(ong.getId());
	}

}