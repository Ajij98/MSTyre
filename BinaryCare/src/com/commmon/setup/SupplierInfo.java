package com.commmon.setup;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.AmountField;
import com.common.share.AmountCommaSeperator;
import com.common.share.CommonButton;
import com.common.share.MessageBox;
import com.common.share.SessionFactoryUtil;
import com.common.share.MessageBox.ButtonType;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.Notification;

public class SupplierInfo extends Window{

	AbsoluteLayout mainLayout;
	
	Label lblSupplierCode,lblSupplierName,lblAddress,lblTelephone,lblMobile,lblFax,lblEmail,lblContactPerson,
	lblDesignation,lblPersonalMobile,lblIsActive,lblCreditPeriod,lblOpeningBalance,lblDebitAmount,
	lblCreditAmount,lblCmbSupplierName;

	private TextField txtSupplierCode, txtSupplierName,txtTelephone,txtMobile,txtFax,txtEmail,
	txtContactPerson,txtDesignation,txtPersonMobile;
	
	private TextArea txtAddress;
	private NativeSelect cmbIsActive;
	private AmountCommaSeperator debitAmount;
	private AmountCommaSeperator creditAmount;
	private AmountField txtCreditPeriod;
	
	private ComboBox cmbSupplierName;
	ListSelect listFind;

	CommonButton commonButton=new CommonButton("New", "Save", "Edit", "Delete", "Refresh", 
			"Find", "", "", "", "");
	
	public SupplierInfo(){
		this.setWidth("850px");
		this.setHeight("510px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("SUPPLIER INFORMATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private void btnIni(boolean b){
		commonButton.btnNew.setEnabled(b);
		commonButton.btnSave.setEnabled(!b);
		commonButton.btnEdit.setEnabled(b);
		commonButton.btnRefresh.setEnabled(!b);
		commonButton.btnDelete.setEnabled(b);
		commonButton.btnFind.setEnabled(b);
	}
	
	private AbsoluteLayout buildMainLayout(){
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setImmediate(true);
		
		lblCmbSupplierName=new Label("Supplier Name");
		mainLayout.addComponent(lblCmbSupplierName, "top:5px;left:20px");

		cmbSupplierName=new ComboBox();
		cmbSupplierName.setWidth("250px");
		cmbSupplierName.setInputPrompt("search here...");
		cmbSupplierName.setImmediate(true);
		cmbSupplierName.setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		mainLayout.addComponent(cmbSupplierName,"top:22px; left:20px");

		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(true);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("400px");
		listFind.setWidth("250px");
		mainLayout.addComponent(listFind,"top:52px; left:20px;");
		
		lblSupplierCode=new Label("Supplier Code :");
		mainLayout.addComponent(lblSupplierCode, "top:25px;left:300px");
		
		txtSupplierCode=new TextField();
		txtSupplierCode.setWidth("170px");
		txtSupplierCode.setHeight("25px");
		txtSupplierCode.setImmediate(true);
		mainLayout.addComponent(txtSupplierCode, "top:22px;left:430px");
		
		lblSupplierName=new Label("Supplier Name :");
		mainLayout.addComponent(lblSupplierName, "top:51px;left:300px");
		
		txtSupplierName=new TextField();
		txtSupplierName.setWidth("320px");
		txtSupplierName.setHeight("25px");
		txtSupplierName.setImmediate(true);
		mainLayout.addComponent(txtSupplierName, "top:48px;left:430px");
		
		lblAddress=new Label("Address :");
		mainLayout.addComponent(lblAddress, "top:77px;left:300px");
		
		txtAddress=new TextArea();
		txtAddress.setWidth("320px");
		txtAddress.setHeight("40px");
		txtAddress.setImmediate(true);
		mainLayout.addComponent(txtAddress, "top:74px;left:430px");
		
		lblTelephone=new Label("Telephone :");
		mainLayout.addComponent(lblTelephone, "top:119px;left:300px");
		
		txtTelephone=new TextField();
		txtTelephone.setWidth("170px");
		txtTelephone.setHeight("25px");
		txtTelephone.setImmediate(true);
		mainLayout.addComponent(txtTelephone, "top:116px;left:430px");
		
		lblMobile=new Label("Mobile :");
		mainLayout.addComponent(lblMobile, "top:145px;left:300px");
		
		txtMobile=new TextField();
		txtMobile.setWidth("170px");
		txtMobile.setHeight("25px");
		txtMobile.setImmediate(true);
		mainLayout.addComponent(txtMobile, "top:142px;left:430px");
		
		lblFax=new Label("Fax :");
		mainLayout.addComponent(lblFax, "top:171px;left:300px");
		
		txtFax=new TextField();
		txtFax.setWidth("170px");
		txtFax.setHeight("25px");
		txtFax.setImmediate(true);
		mainLayout.addComponent(txtFax, "top:168px;left:430px");
		
		lblEmail=new Label("Email :");
		mainLayout.addComponent(lblEmail, "top:197px;left:300px");
		
		txtEmail=new TextField();
		txtEmail.setWidth("320px");
		txtEmail.setHeight("25px");
		txtEmail.setImmediate(true);
		mainLayout.addComponent(txtEmail, "top:194px;left:430px");
		
		lblContactPerson=new Label("Contact Person :");
		mainLayout.addComponent(lblContactPerson, "top:223px;left:300px");
		
		txtContactPerson=new TextField();
		txtContactPerson.setWidth("320px");
		txtContactPerson.setHeight("25px");
		txtContactPerson.setImmediate(true);
		mainLayout.addComponent(txtContactPerson, "top:220px;left:430px");
		
		lblDesignation=new Label("Designation :");
		mainLayout.addComponent(lblDesignation, "top:249px;left:300px");
		
		txtDesignation=new TextField();
		txtDesignation.setWidth("320px");
		txtDesignation.setHeight("25px");
		txtDesignation.setImmediate(true);
		mainLayout.addComponent(txtDesignation, "top:246px;left:430px");
		
		lblPersonalMobile=new Label("Personal Mobile :");
		mainLayout.addComponent(lblPersonalMobile, "top:275px;left:300px");
		
		txtPersonMobile=new TextField();
		txtPersonMobile.setWidth("170px");
		txtPersonMobile.setHeight("25px");
		txtPersonMobile.setImmediate(true);
		mainLayout.addComponent(txtPersonMobile, "top:272px;left:430px");
		
		lblIsActive=new Label("Is Active :");
		mainLayout.addComponent(lblIsActive, "top:301px;left:300px");
		
		cmbIsActive=new NativeSelect();
		cmbIsActive.setWidth("150px");
		cmbIsActive.setHeight("25px");
		cmbIsActive.setImmediate(true);
		cmbIsActive.addItem("1");
		cmbIsActive.addItem("0");
		cmbIsActive.setItemCaption("1", "Active");
		cmbIsActive.setItemCaption("0", "Inactive");
		cmbIsActive.setValue("1");
		mainLayout.addComponent(cmbIsActive, "top:298px;left:430px");
		
		lblCreditPeriod=new Label("Credit Period[Days] :");
		mainLayout.addComponent(lblCreditPeriod, "top:327px;left:300px");
		
		txtCreditPeriod=new AmountField();
		txtCreditPeriod.setWidth("150px");
		txtCreditPeriod.setHeight("25px");
		txtCreditPeriod.setImmediate(true);
		txtCreditPeriod.setStyleName("fright");
		mainLayout.addComponent(txtCreditPeriod, "top:324px;left:430px");
		
		lblOpeningBalance=new Label("<B><u>Opening Balance Information</u></B>",Label.CONTENT_XHTML);
		mainLayout.addComponent(lblOpeningBalance, "top:353px;left:300px");
		
		lblDebitAmount=new Label("Debit Amount :");
		mainLayout.addComponent(lblDebitAmount, "top:380px;left:300px");
		
		debitAmount=new AmountCommaSeperator();
		debitAmount.setWidth("140px");
		debitAmount.setHeight("25px");
		debitAmount.setImmediate(true);
		debitAmount.setValue("0.0");
		debitAmount.setStyleName("fright");
		mainLayout.addComponent(debitAmount, "top:377px;left:430px");
		
		lblCreditAmount=new Label("Credit Amount :");
		mainLayout.addComponent(lblCreditAmount, "top:380px;left:580px");
		
		creditAmount=new AmountCommaSeperator();
		creditAmount.setWidth("140px");
		creditAmount.setHeight("25px");
		creditAmount.setImmediate(true);
		creditAmount.setValue("0.0");
		creditAmount.setStyleName("fright");
		mainLayout.addComponent(creditAmount, "top:377px;left:680px");

		mainLayout.addComponent(commonButton, "top:425px;left:290px");
		commonButton.setStyleName("buttonStyle");

		return  mainLayout;
	}
}
