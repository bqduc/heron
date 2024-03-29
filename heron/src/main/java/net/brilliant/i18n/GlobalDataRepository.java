/**
 * 
 */
package net.brilliant.i18n;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import lombok.Builder;
import net.brilliant.common.CollectionsUtility;
import net.brilliant.common.CommonUtility;

/**
 * @author ducbui
 *
 */
@Builder
@SessionScoped
@Component
public class GlobalDataRepository {
	public static final String SESSION_LOCALE = "locale";

	private static List<Locale> supportedLocales = CollectionsUtility.createArrayList();
	private static Map<String, Locale> supportedLocaleMap = CollectionsUtility.createMap();

	@Builder.Default
	private Locale defaultLocale = CommonUtility.LOCALE_VIETNAMESE;// = getVietnameseLocale();

	public Locale getDefaultLocale() {
		return this.defaultLocale;
	}

	public Locale switchLocale(Locale locale) {
		this.defaultLocale = locale;
		return this.defaultLocale;
	}

	public List<Locale> getSupportLocales(){
		if (CommonUtility.isNotEmpty(supportedLocales))
			return supportedLocales;

		Iterator<Locale> itr = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
		while (itr.hasNext()) {
			supportedLocales.add(itr.next());
		}

		return supportedLocales;
	}

	public Map<String, Locale> getSupportedLocaleMap(){
		if (supportedLocaleMap.isEmpty()) {
  		List<Locale> supportedLocales = getSupportLocales();
  		for (Locale supportedLocale :supportedLocales) {
  			supportedLocaleMap.put(supportedLocale.toString(), supportedLocale);
  		}
		}
		return supportedLocaleMap;
	}
}
