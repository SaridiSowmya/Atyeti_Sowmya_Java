package validation;
import exception.InvalidCountryException;
import model.Order;

import java.util.Set;

public class CountryValidator {
    private static final Set<String> ALLOWED_COUNTRIES = Set.of("US", "UK", "IN", "SG", "JP", "DE", "FR");
    public static void validate(String countryCode) throws InvalidCountryException {
        if (countryCode == null || countryCode.length() != 2 || !ALLOWED_COUNTRIES.contains(countryCode.toUpperCase())) {
            throw new InvalidCountryException(countryCode);
        }
    }
}
