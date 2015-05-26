package com.dev.frontend.panels.list;

import com.dev.frontend.entity.Customer;
import com.dev.frontend.services.Services;
import com.google.gson.Gson;

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
        //TODO by the candidate
        /*
         * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
        int recordSize = list.size();
        int columnSize = 4;
        System.out.println("****** recordSize " + recordSize);
        String[][] modeledData = new String[recordSize][1];

        for (int i = 0; i < recordSize; i++) {
            Object row = list.get(i);
            Customer customer = (Customer) row;
            String jsonString = new Gson().toJson(row);

            modeledData[i] = toStringArray(customer);
        }
        String[][] sampleData = new String[][]{{"01", "Customer 1", "+201011121314", "23.4"}, {"02", "Customer 2", "+201112131415", "1.4"}};
        return modeledData;
    }

    public String[] toStringArray(Customer customer) {
        return new String[]{customer.getCode(), customer.getName(), customer.getPhoneNo1(), String.valueOf(customer.getCurrentCredit())};
    }
}
