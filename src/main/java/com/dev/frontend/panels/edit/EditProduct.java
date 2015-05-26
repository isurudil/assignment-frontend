package com.dev.frontend.panels.edit;

import com.dev.frontend.entity.Customer;
import com.dev.frontend.entity.Product;
import com.dev.frontend.services.Services;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.logging.Logger;

public class EditProduct extends EditContentPanel {
    private static final long serialVersionUID = -8971249970444644844L;
    private static Logger logger = Logger.getLogger(EditProduct.class.getName());
    private JTextField txtCode = new JTextField();
    private JTextField txtDescription = new JTextField();
    private JTextField txtQuantity = new JTextField();
    private JTextField txtPrice = new JTextField();

    public EditProduct() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Code"), gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCode, gbc);
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        txtCode.setColumns(10);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Description"), gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        add(txtDescription, gbc);
        txtDescription.setColumns(28);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Price"), gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        add(txtPrice, gbc);
        txtPrice.setColumns(10);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(new JLabel("Quantity"), gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 15);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        add(txtQuantity, gbc);
        txtQuantity.setColumns(10);
    }

    public Object guiToObject() {
        Product product = new Product();
        product.setPrice(new BigDecimal(txtPrice.getText()));
        product.setDescription(txtDescription.getText());
        product.setCode(txtCode.getText());
        product.setQuantity(Integer.parseInt(txtQuantity.getText()));

        logger.info("Set product from gui : { price :" + product.getPrice() + " description : " + product.getDescription() +
                "code : " + product.getCode() + " quantity : " + product.getQuantity());
        return product;
    }

    public int getObjectType() {
        return Services.TYPE_PRODUCT;
    }

    @Override
    public String getCurrentCode() {
        return txtCode.getText();
    }

    @Override
    public boolean bindToGUI(Object o) {
        return false;
    }

    public void clear() {
        txtCode.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
    }

    public void onInit() {

    }
}
