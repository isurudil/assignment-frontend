package com.dev.frontend.panels.list;

import com.dev.frontend.entity.Customer;
import com.dev.frontend.services.Services;

import java.util.List;

public class CustomerDataModel extends ListDataModel {
    private static final long serialVersionUID = 7526529951747613655L;

    public CustomerDataModel() {
        super(new String[]{"Code", "Name", "Phone", "Current Credit"}, 0);
    }

    @Override
    public int getObjectType() {
        return Services.TYPE_CUSTOMER;
    }

    @Override
    public String[][] convertRecordsListToTableModel(List<Object> list) {

        int recordSize = list.size();
        String[][] modeledData = new String[recordSize][1];

        for (int i = 0; i < recordSize; i++) {
            Object row = list.get(i);
            Customer customer = (Customer) row;

            modeledData[i] = toStringArray(customer);
        }
        return modeledData;
    }

    public String[] toStringArray(Customer customer) {
        return new String[]{customer.getCode(), customer.getName(), customer.getPhoneNo1(), String.valueOf(customer.getCurrentCredit())};
    }
}
