/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

package com.mobile_widgets_variables.services.countryinfoservice.services;
import com.mobile_widgets_variables.services.countryinfoservice.*;
import java.util.List;

import com.wavemaker.runtime.soap.util.SoapSettingsResolver;
import com.wavemaker.runtime.soap.SoapServiceSettings;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.xml.ws.BindingProvider;



@Service
public class CountryInfoServiceService{

    @Autowired
    @Qualifier("CountryInfoServiceSoapServiceSettings")
    private SoapServiceSettings soapServiceSettings;


	public FullCountryInfoResponse fullCountryInfo(  com.mobile_widgets_variables.services.countryinfoservice.FullCountryInfo parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.fullCountryInfo(parameters );
	}

	public CountryFlagResponse countryFlag(  com.mobile_widgets_variables.services.countryinfoservice.CountryFlag parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.countryFlag(parameters );
	}

	public CountryNameResponse countryName(  com.mobile_widgets_variables.services.countryinfoservice.CountryName parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.countryName(parameters );
	}

	public CountryCurrencyResponse countryCurrency(  com.mobile_widgets_variables.services.countryinfoservice.CountryCurrency parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.countryCurrency(parameters );
	}

	public ListOfCountryNamesByCodeResponse listOfCountryNamesByCode(  com.mobile_widgets_variables.services.countryinfoservice.ListOfCountryNamesByCode parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfCountryNamesByCode(parameters );
	}

	public ListOfCurrenciesByNameResponse listOfCurrenciesByName(  com.mobile_widgets_variables.services.countryinfoservice.ListOfCurrenciesByName parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfCurrenciesByName(parameters );
	}

	public CountryIntPhoneCodeResponse countryIntPhoneCode(  com.mobile_widgets_variables.services.countryinfoservice.CountryIntPhoneCode parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.countryIntPhoneCode(parameters );
	}

	public CurrencyNameResponse currencyName(  com.mobile_widgets_variables.services.countryinfoservice.CurrencyName parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.currencyName(parameters );
	}

	public ListOfCurrenciesByCodeResponse listOfCurrenciesByCode(  com.mobile_widgets_variables.services.countryinfoservice.ListOfCurrenciesByCode parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfCurrenciesByCode(parameters );
	}

	public ListOfLanguagesByCodeResponse listOfLanguagesByCode(  com.mobile_widgets_variables.services.countryinfoservice.ListOfLanguagesByCode parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfLanguagesByCode(parameters );
	}

	public LanguageISOCodeResponse languageISOCode(  com.mobile_widgets_variables.services.countryinfoservice.LanguageISOCode parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.languageISOCode(parameters );
	}

	public CapitalCityResponse capitalCity(  com.mobile_widgets_variables.services.countryinfoservice.CapitalCity parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.capitalCity(parameters );
	}

	public ListOfLanguagesByNameResponse listOfLanguagesByName(  com.mobile_widgets_variables.services.countryinfoservice.ListOfLanguagesByName parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfLanguagesByName(parameters );
	}

	public ListOfCountryNamesGroupedByContinentResponse listOfCountryNamesGroupedByContinent(  com.mobile_widgets_variables.services.countryinfoservice.ListOfCountryNamesGroupedByContinent parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfCountryNamesGroupedByContinent(parameters );
	}

	public ListOfCountryNamesByNameResponse listOfCountryNamesByName(  com.mobile_widgets_variables.services.countryinfoservice.ListOfCountryNamesByName parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfCountryNamesByName(parameters );
	}

	public ListOfContinentsByNameResponse listOfContinentsByName(  com.mobile_widgets_variables.services.countryinfoservice.ListOfContinentsByName parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfContinentsByName(parameters );
	}

	public LanguageNameResponse languageName(  com.mobile_widgets_variables.services.countryinfoservice.LanguageName parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.languageName(parameters );
	}

	public ListOfContinentsByCodeResponse listOfContinentsByCode(  com.mobile_widgets_variables.services.countryinfoservice.ListOfContinentsByCode parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.listOfContinentsByCode(parameters );
	}

	public CountriesUsingCurrencyResponse countriesUsingCurrency(  com.mobile_widgets_variables.services.countryinfoservice.CountriesUsingCurrency parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.countriesUsingCurrency(parameters );
	}

	public CountryISOCodeResponse countryISOCode(  com.mobile_widgets_variables.services.countryinfoservice.CountryISOCode parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.countryISOCode(parameters );
	}

	public FullCountryInfoAllCountriesResponse fullCountryInfoAllCountries(  com.mobile_widgets_variables.services.countryinfoservice.FullCountryInfoAllCountries parameters )
	          {
 	    CountryInfoService countryinfoservice = new CountryInfoService();
 CountryInfoServiceSoapType countryinfoservicesoaptype = countryinfoservice.getCountryInfoServiceSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)countryinfoservicesoaptype, soapServiceSettings);
 return countryinfoservicesoaptype.fullCountryInfoAllCountries(parameters );
	}
}
