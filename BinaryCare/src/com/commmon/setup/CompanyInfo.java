package com.commmon.setup;

import java.util.Date;
import java.util.EventListener;
import java.util.Iterator;

import org.apache.tools.ant.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.MessageBox;
import com.common.share.MessageBox.ButtonType;
import com.common.share.CommonButton;
import com.common.share.SessionFactoryUtil;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.Notification;

public class CompanyInfo extends Window{

	AbsoluteLayout mainLayout;

	private Label lblCompanyName,lblAddress,lblPhone,lblFax,lblEmail,lblCompanyLogo,lblRegistrationNo,
	lblTINNo,lblVatRegNo,lblTradeLicenseNo,lblStatus,lblRenewDate;
	
	private TextField txtCompanyName,txtPhone,txtFax,txtEmail,txtCompanyLogo,txtRegNo,txtTinNo,txtVatRegNo,
	txtTradeLicenseNo,txtStatus;
	private TextArea txtAddress;
	private PopupDateField dateRegDate,dateTinDate,dateVatRegDate,dateTradeLicenseDate;
	private NativeSelect cmbStatus;

	private ListSelect listFind;

	private CommonButton commonButton=new CommonButton("", "Save", "Edit", "Delete", "Refresh", 
			"", "", "", "", "");
	
	public CompanyInfo(){
		this.setWidth("740px");
		this.setHeight("440px");
		this.setClosable(true);
		this.setModal(false);
		this.setResizable(false);
		this.setCaption("COMPANY INFORMATION :: M. S. TYRE HOUSE");
		this.setImmediate(true);
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

		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(true);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("370px");
		listFind.setWidth("230px");
		mainLayout.addComponent(listFind,"top:15px; left:10px;");
		
		lblCompanyName=new Label("Company Name :");
		mainLayout.addComponent(lblCompanyName, "top:15px;left:260px");
		
		txtCompanyName=new TextField();
		txtCompanyName.setWidth("325px");
		txtCompanyName.setHeight("25px");
		txtCompanyName.setImmediate(true);
		mainLayout.addComponent(txtCompanyName, "top:15px;left:380px");
		
		lblAddress=new Label("Address :");
		mainLayout.addComponent(lblAddress, "top:42px;left:260px");
		
		txtAddress=new TextArea();
		txtAddress.setWidth("325px");
		txtAddress.setHeight("40px");
		txtAddress.setImmediate(true);
		mainLayout.addComponent(txtAddress, "top:42px;left:380px");
			
		lblPhone=new Label("Phone :");
		mainLayout.addComponent(lblPhone, "top:84px;left:260px");
		
		txtPhone=new TextField();
		txtPhone.setWidth("325px");
		txtPhone.setHeight("25px");
		txtPhone.setImmediate(true);
		mainLayout.addComponent(txtPhone, "top:84px;left:380px");
			
		lblFax=new Label("Fax :");
		mainLayout.addComponent(lblFax, "top:111px;left:260px");
		
		txtFax=new TextField();
		txtFax.setWidth("325px");
		txtFax.setHeight("25px");
		txtFax.setImmediate(true);
		mainLayout.addComponent(txtFax, "top:111px;left:380px");
		
		lblEmail=new Label("Email :");
		mainLayout.addComponent(lblEmail, "top:137px;left:260px");
		
		txtEmail=new TextField();
		txtEmail.setWidth("325px");
		txtEmail.setHeight("25px");
		txtEmail.setImmediate(true);
		mainLayout.addComponent(txtEmail, "top:137px;left:380px");
		
		lblCompanyLogo=new Label("Company Logo :");
		mainLayout.addComponent(lblCompanyLogo, "top:168px;left:260px");
		
		txtCompanyLogo=new TextField();
		txtCompanyLogo.setWidth("120px");
		txtCompanyLogo.setHeight("25px");
		txtCompanyLogo.setImmediate(true);
		mainLayout.addComponent(txtCompanyLogo, "top:168px;left:380px");
		
		lblRegistrationNo=new Label("Registration No :");
		mainLayout.addComponent(lblRegistrationNo, "top:198px;left:260px");
		
		txtRegNo=new TextField();
		txtRegNo.setWidth("120px");
		txtRegNo.setHeight("25px");
		txtRegNo.setImmediate(true);
		mainLayout.addComponent(txtRegNo, "top:198px;left:380px");
		
		lblTINNo=new Label("TIN No :");
		mainLayout.addComponent(lblTINNo, "top:225px;left:260px");
		
		txtTinNo=new TextField();
		txtTinNo.setWidth("120px");
		txtTinNo.setHeight("25px");
		txtTinNo.setImmediate(true);
		mainLayout.addComponent(txtTinNo, "top:225px;left:380px");
		
		lblVatRegNo=new Label("VAT Reg No :");
		mainLayout.addComponent(lblVatRegNo, "top:252px;left:260px");
		
		txtVatRegNo=new TextField();
		txtVatRegNo.setWidth("120px");
		txtVatRegNo.setHeight("25px");
		txtVatRegNo.setImmediate(true);
		mainLayout.addComponent(txtVatRegNo, "top:252px;left:380px");
		
		lblTradeLicenseNo=new Label("Trade License No :");
		mainLayout.addComponent(lblTradeLicenseNo, "top:278px;left:260px");
		
		txtTradeLicenseNo=new TextField();
		txtTradeLicenseNo.setWidth("120px");
		txtTradeLicenseNo.setHeight("25px");
		txtTradeLicenseNo.setImmediate(true);
		mainLayout.addComponent(txtTradeLicenseNo, "top:278px;left:380px");
		
		lblStatus=new Label("Status :");
		mainLayout.addComponent(lblStatus, "top:306px;left:260px");
		
		cmbStatus=new NativeSelect();
		cmbStatus.setWidth("100px");
		cmbStatus.setHeight("25px");
		cmbStatus.setImmediate(true);
		cmbStatus.addItem("Active");
		cmbStatus.addItem("Inactive");
		cmbStatus.select("Active");
		mainLayout.addComponent(cmbStatus, "top:306px;left:380px");
		
		lblRenewDate=new Label("Renew date :");
		mainLayout.addComponent(lblRenewDate, "top:198px;left:510px");
		
		dateRegDate=new PopupDateField();
		dateRegDate.setWidth("120px");
		dateRegDate.setHeight("25px");
		dateRegDate.setImmediate(true);
		dateRegDate.setData(new Date());
		dateRegDate.setDateFormat("dd-MM-yyyy");
		mainLayout.addComponent(dateRegDate, "top:198px;left:590px");
		
		lblRenewDate=new Label("Renew date :");
		mainLayout.addComponent(lblRenewDate, "top:225px;left:510px");
		
		dateTinDate=new PopupDateField();
		dateTinDate.setWidth("120px");
		dateTinDate.setHeight("25px");
		dateTinDate.setImmediate(true);
		dateTinDate.setData(new Date());
		dateTinDate.setDateFormat("dd-MM-yyyy");
		mainLayout.addComponent(dateTinDate, "top:225px;left:590px");
		
		lblRenewDate=new Label("Renew date :");
		mainLayout.addComponent(lblRenewDate, "top:252px;left:510px");
		
		dateVatRegDate=new PopupDateField();
		dateVatRegDate.setWidth("120px");
		dateVatRegDate.setHeight("25px");
		dateVatRegDate.setImmediate(true);
		dateVatRegDate.setData(new Date());
		dateVatRegDate.setDateFormat("dd-MM-yyyy");
		mainLayout.addComponent(dateVatRegDate, "top:252px;left:590px");
		
		lblRenewDate=new Label("Renew date :");
		mainLayout.addComponent(lblRenewDate, "top:278px;left:510px");
		
		dateTradeLicenseDate=new PopupDateField();
		dateTradeLicenseDate.setWidth("120px");
		dateTradeLicenseDate.setHeight("25px");
		dateTradeLicenseDate.setImmediate(true);
		dateTradeLicenseDate.setData(new Date());
		dateTradeLicenseDate.setDateFormat("dd-MM-yyyy");
		mainLayout.addComponent(dateTradeLicenseDate, "top:278px;left:590px");
		
		mainLayout.addComponent(commonButton, "top:355px;left:310px");
		commonButton.setStyleName("buttonStyle");

		return mainLayout;
	}
}
