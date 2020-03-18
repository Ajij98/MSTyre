package com.common.Account_Setup;

import java.util.Date;

import com.common.share.CommonButton;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class CheckBookCancel extends Window{

	private AbsoluteLayout mainLayout;
	
	private Label lblBankAccount,lblFolioNo,lblDate,lblReason;
	
	private ComboBox cmbBankAccount,cmbFolioNo;
	private TextField txtReason;
	private PopupDateField date;
	private NativeButton btnbankHead;
	
	CommonButton commonButton = new CommonButton("New", "Save", "Edit", "", "Refresh", "", 
			"", "", "", "Exit");
	
	public CheckBookCancel() {
		this.setWidth("620px");
		this.setHeight("270px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("CHECK BOOK CANCEL :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}

	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		lblBankAccount = new Label();
		lblBankAccount.setImmediate(true);
		lblBankAccount.setWidth("-1px");
		lblBankAccount.setHeight("-1px");
		lblBankAccount.setValue("Bank AC Name :");
		mainLayout.addComponent(lblBankAccount, "top:22px;left:100px;");

		cmbBankAccount = new ComboBox();
		cmbBankAccount.setImmediate(true);
		cmbBankAccount.setHeight("-1px");
		cmbBankAccount.setWidth("270px");
		cmbBankAccount.setNullSelectionAllowed(true);
		cmbBankAccount.setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		mainLayout.addComponent(cmbBankAccount, "top:22px;left:210px;");

		btnbankHead = new NativeButton();
		btnbankHead.setImmediate(true);
		btnbankHead.setWidth("28px");
		btnbankHead.setHeight("24px");
		btnbankHead.setIcon(new ThemeResource("./icons/add.png"));
		mainLayout.addComponent(btnbankHead,"top:22px;left:485px;");

		lblFolioNo = new Label("Folio No :");
		lblFolioNo.setImmediate(true);
		lblFolioNo.setWidth("-1px");
		lblFolioNo.setHeight("-1px");
		mainLayout.addComponent(lblFolioNo, "top:47px;left:100px;");

		cmbFolioNo = new ComboBox();
		cmbFolioNo.setImmediate(true);
		cmbFolioNo.setWidth("130px");
		cmbFolioNo.setHeight("-1px");
		mainLayout.addComponent(cmbFolioNo, "top:47px;left:210px;");

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

		lblReason = new Label("Reason :");
		lblReason.setImmediate(true);
		lblReason.setWidth("-1px");
		lblReason.setHeight("-1px");
		mainLayout.addComponent(lblReason, "top:97px;left:100px;");

		txtReason = new TextField();
		txtReason.setImmediate(true);
		txtReason.setWidth("270px");
		txtReason.setHeight("44px");
		mainLayout.addComponent(txtReason, "top:97px;left:210px;");

		mainLayout.addComponent(commonButton, "top:160px;left:80px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
