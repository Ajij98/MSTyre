package com.common.Account_Setup;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.share.CommonButton;
import com.common.share.TextRead;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class CheckBookEntry extends Window{
	
	private AbsoluteLayout mainLayout;

	private Label lblBankAccount,lblBookNo,lblDate,lblFolioFrom,lblFolioTo;

	private ComboBox cmbBankAccount;
	private TextField txtBookNo,txtFolioFrom,txtFolioTo;
	private PopupDateField date;
	private NativeButton btnbankHead;

	CommonButton commonButton = new CommonButton("New", "Save", "Edit", "Delete", "Refresh", 
			"Find", "", "", "", "Exit");

	public CheckBookEntry() {
		this.setWidth("650px");
		this.setHeight("280px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("CHECK BOOK ENTRY :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");

		lblBankAccount = new Label("Bank AC Name :");
		lblBankAccount.setImmediate(true);
		lblBankAccount.setWidth("-1px");
		lblBankAccount.setHeight("-1px");
		mainLayout.addComponent(lblBankAccount, "top:22px;left:100px;");

		cmbBankAccount = new ComboBox();
		cmbBankAccount.setImmediate(true);
		cmbBankAccount.setWidth("270px");
		cmbBankAccount.setHeight("-1px");
		cmbBankAccount.setNullSelectionAllowed(true);
		cmbBankAccount.setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		mainLayout.addComponent(cmbBankAccount, "top:22px;left:210px;");

		btnbankHead = new NativeButton();
		btnbankHead.setCaption("");
		btnbankHead.setImmediate(true);
		btnbankHead.setWidth("28px");
		btnbankHead.setHeight("24px");
		btnbankHead.setIcon(new ThemeResource("./icons/add.png"));
		mainLayout.addComponent(btnbankHead,"top:22px;left:485px;");

		lblBookNo = new Label("Cheque Book No :");
		lblBookNo.setImmediate(true);
		lblBookNo.setWidth("-1px");
		lblBookNo.setHeight("-1px");
		mainLayout.addComponent(lblBookNo, "top:47px;left:100px;");

		txtBookNo = new TextField();
		txtBookNo.setImmediate(true);
		txtBookNo.setWidth("180px");
		txtBookNo.setHeight("-1px");
		mainLayout.addComponent(txtBookNo, "top:47px;left:210px;");

		lblDate = new Label("Date :");
		lblDate.setImmediate(true);
		lblDate.setWidth("-1px");
		lblDate.setHeight("-1px");
		mainLayout.addComponent(lblDate, "top:72px;left:100px;");

		date = new PopupDateField();
		date.setImmediate(true);
		date.setValue(new Date());
		date.setDateFormat("dd-MM-yyyy");
		date.setInvalidAllowed(false);
		date.setResolution(PopupDateField.RESOLUTION_DAY);
		mainLayout.addComponent(date,"top:72px;left:210px;");

		lblFolioFrom = new Label("Folio From :");
		lblFolioFrom.setImmediate(true);
		lblFolioFrom.setWidth("-1px");
		lblFolioFrom.setHeight("-1px");
		mainLayout.addComponent(lblFolioFrom, "top:97px;left:100px;");

		txtFolioFrom = new TextField();
		txtFolioFrom.setImmediate(true);
		txtFolioFrom.setWidth("180px");
		txtFolioFrom.setHeight("-1px");
		mainLayout.addComponent(txtFolioFrom, "top:97px;left:210px;");

		lblFolioTo = new Label("Folio To :");
		lblFolioTo.setImmediate(true);
		lblFolioTo.setWidth("-1px");
		lblFolioTo.setHeight("-1px");
		mainLayout.addComponent(lblFolioTo, "top:122px;left:100px;");

		txtFolioTo = new TextField();
		txtFolioTo.setImmediate(true);
		txtFolioTo.setWidth("180px");
		txtFolioTo.setHeight("-1px");
		mainLayout.addComponent(txtFolioTo, "top:122px;left:210px;");

		mainLayout.addComponent(commonButton, "top:170px;left:10px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
