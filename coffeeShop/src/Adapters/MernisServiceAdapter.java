package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result = proxy.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()), 
					customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), 
					customer.getDateOfBirth().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
