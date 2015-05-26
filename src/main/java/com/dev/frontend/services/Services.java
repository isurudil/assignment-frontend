package com.dev.frontend.services;

import com.dev.frontend.entity.ApiEntity;
import com.dev.frontend.entity.Customer;
import com.dev.frontend.panels.ComboBoxItem;
import com.dev.frontend.util.ConnectionManager;
import com.dev.frontend.util.PropertyLoader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Services {
    public static final int TYPE_PRODUCT = 1;
    public static final int TYPE_CUSTOMER = 2;
    public static final int TYPE_SALES_ORDER = 3;
    private static Logger logger = Logger.getLogger(Services.class.getName());

    public static Object save(Object object, int objectType) throws IOException {
        //TODO by the candidate
        /*
         * This method is called eventually after you click save on any edit screen
		 * object parameter is the return object from calling method guiToObject on edit screen
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALES_ORDER
		 */
        String url = null;
        switch (objectType) {
            case 1:
                url = PropertyLoader.getProperty("service.endpoint") + PropertyLoader.getProperty("service.add.products");
                break;
            case 2:
                url = PropertyLoader.getProperty("service.endpoint") + PropertyLoader.getProperty("service.add.customers");
                break;
        }
        ApiEntity entity = ConnectionManager.POST(url, (ApiEntity) object);
        logger.info("Response received from  API with status code : " + entity.getStatusCode()
                + " and status message : " + entity.getStatusMessage());
        return entity;
    }

    public static Object readRecordByCode(String code, int objectType) {
        //TODO by the candidate
        /*
		 * This method is called when you select record in list view of any entity
		 * and also called after you save a record to re-bind the record again
		 * the code parameter is the first column of the row you have selected
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALES_ORDER */
        return null;
    }

    public static boolean deleteRecordByCode(String code, int objectType) {
        //TODO by the candidate
		/*
		 * This method is called when you click delete button on an edit view
		 * the code parameter is the code of (Customer - PRoduct ) or order number of Sales Order
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALES_ORDER
		 */
        return true;
    }

    public static List<Object> listCurrentRecords(int objectType) throws IOException {
        //TODO by the candidate
		/*
		 * This method is called when you open any list screen and should return all records of the specified type
		 */
        String url = null;
        List<Object> objectList = null;
        switch (objectType) {
            case 1:
                url = PropertyLoader.getProperty("service.endpoint") + PropertyLoader.getProperty("service.get.all.products");
                break;
            case 2:
                url = PropertyLoader.getProperty("service.endpoint") + PropertyLoader.getProperty("service.get.all.customers");
                String jsonString = ConnectionManager.GET(url);
                objectList = objectMapper(jsonString, Customer.class);
                Customer apiEntity = (Customer) objectList.get(0);
                logger.info("Received list of objects , ApiEntity :" + apiEntity.getStatusCode());
                break;
        }
//
//        ApiEntity apiEntity = (ApiEntity) objectList.get(0);
//
//        logger.info("Received list of objects , ApiEntity :" + apiEntity.getStatusCode());
        return objectList ;
    }

    public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
        //TODO by the candidate
		/*
		 * This method is called when a Combo Box need to be initialized and should
		 * return list of ComboBoxItem which contains code and description/name for all records of specified type
		 */
        return new ArrayList<ComboBoxItem>();
    }

    public static double getProductPrice(String productCode) {
        //TODO by the candidate
		/*
		 * This method is used to get unit price of product with the code passed as a parameter
		 */
        return 1;
    }

    public static List objectMapper(String jsonString, Class aClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, aClass));
    }
}
