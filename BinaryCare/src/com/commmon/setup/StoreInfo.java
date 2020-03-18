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

public class StoreInfo extends Window{

	AbsoluteLayout mainLayout;
	
	Label lblStoreId,lblStoreName,lblStoreAddress,lblTelephone,lblMobile,lblEmail,lblStoreIncharge,
	lblDesignation,lblCmbStoreName;

	private TextField txtStoreId, txtStoreName,txtTelephone,txtMobile,txtEmail,
	txtStoreIncharge,txtDesignation;
	
	private TextArea txtStoreAddress;
	
	private ComboBox cmbStoreName;
	ListSelect listFind;

	CommonButton commonButton=new CommonButton("New", "Save", "Edit", "Delete", "Refresh", 
			"Find", "", "", "", "");
	
	public StoreInfo(){
		this.setWidth("650px");
		this.setHeight("440px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("STORE INFORMATION :: M. S. TYRE HOUSE");
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
		
		lblCmbStoreName=new Label("Store Name");
		mainLayout.addComponent(lblCmbStoreName, "top:5px;left:20px");

		cmbStoreName=new ComboBox();
		cmbStoreName.setWidth("220px");
		cmbStoreName.setInputPrompt("search here...");
		cmbStoreName.setImmediate(true);
		cmbStoreName.setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		mainLayout.addComponent(cmbStoreName,"top:22px; left:20px");

		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(true);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("280px");
		listFind.setWidth("220px");
		mainLayout.addComponent(listFind,"top:52px; left:20px;");
		
		lblStoreId=new Label("Store Id :");
		mainLayout.addComponent(lblStoreId, "top:60px;left:260px");
		
		txtStoreId=new TextField();
		txtStoreId.setWidth("150px");
		txtStoreId.setHeight("25px");
		txtStoreId.setImmediate(true);
		mainLayout.addComponent(txtStoreId, "top:57px;left:350px");
		
		lblStoreName=new Label("Store Name :");
		mainLayout.addComponent(lblStoreName, "top:89px;left:260px");
		
		txtStoreName=new TextField();
		txtStoreName.setWidth("270px");
		txtStoreName.setHeight("25px");
		txtStoreName.setImmediate(true);
		mainLayout.addComponent(txtStoreName, "top:84px;left:350px");
		
		lblStoreAddress=new Label("Store Address :");
		mainLayout.addComponent(lblStoreAddress, "top:116px;left:260px");
		
		txtStoreAddress=new TextArea();
		txtStoreAddress.setWidth("270px");
		txtStoreAddress.setHeight("40px");
		txtStoreAddress.setImmediate(true);
		mainLayout.addComponent(txtStoreAddress, "top:111px;left:350px");
		
		lblTelephone=new Label("Telephone :");
		mainLayout.addComponent(lblTelephone, "top:156px;left:260px");
		
		txtTelephone=new TextField();
		txtTelephone.setWidth("210px");
		txtTelephone.setHeight("25px");
		txtTelephone.setImmediate(true);
		mainLayout.addComponent(txtTelephone, "top:153px;left:350px");
		
		lblMobile=new Label("Mobile :");
		mainLayout.addComponent(lblMobile, "top:183px;left:260px");
		
		txtMobile=new TextField();
		txtMobile.setWidth("210px");
		txtMobile.setHeight("25px");
		txtMobile.setImmediate(true);
		mainLayout.addComponent(txtMobile, "top:180px;left:350px");
		
		lblEmail=new Label("Email :");
		mainLayout.addComponent(lblEmail, "top:210px;left:260px");
		
		txtEmail=new TextField();
		txtEmail.setWidth("210px");
		txtEmail.setHeight("25px");
		txtEmail.setImmediate(true);
		mainLayout.addComponent(txtEmail, "top:207px;left:350px");
		
		lblStoreIncharge=new Label("Store Incharge :");
		mainLayout.addComponent(lblStoreIncharge, "top:237px;left:260px");
		
		txtStoreIncharge=new TextField();
		txtStoreIncharge.setWidth("210px");
		txtStoreIncharge.setHeight("25px");
		txtStoreIncharge.setImmediate(true);
		mainLayout.addComponent(txtStoreIncharge, "top:234px;left:350px");
		
		lblDesignation=new Label("Designation :");
		mainLayout.addComponent(lblDesignation, "top:264px;left:260px");
		
		txtDesignation=new TextField();
		txtDesignation.setWidth("210px");
		txtDesignation.setHeight("25px");
		txtDesignation.setImmediate(true);
		mainLayout.addComponent(txtDesignation, "top:261px;left:350px");

		mainLayout.addComponent(commonButton, "top:350px;left:60px");
		commonButton.setStyleName("buttonStyle");

		return  mainLayout;
	}
}
