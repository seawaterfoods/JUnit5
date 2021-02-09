package assertions;

import entry.Customer;
import org.assertj.core.api.*;

public class CustomerAssert extends AbstractAssert<CustomerAssert, Customer> {

    public CustomerAssert(Customer customer) {
        super(customer, CustomerAssert.class);
    }

    public static CustomerAssert assertCustomer(Customer customer){
        return new CustomerAssert(customer);
    }

    public CustomerAssert isActivate() {
        SoftAssertions assertions = new SoftAssertions();

        assertions.assertThat(actual.isActivate())
                .overridingErrorMessage(
                        "會員認證必需是為true, 但是為: %s",
                        actual.isActivate()
                )
                .isEqualTo(true);

        assertions.assertThat(actual.getActivateDate())
                .overridingErrorMessage(
                        "會員認證後必需有啟動日期，但是它的日期紀錄為: %s",
                        actual.getActivateDate()
                )
                .isNotNull();

        assertions.assertAll();
        return this;
    }
}
