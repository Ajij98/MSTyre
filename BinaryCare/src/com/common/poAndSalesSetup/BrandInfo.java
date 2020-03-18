package com.common.poAndSalesSetup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.CommonButton;
import com.common.share.MessageBox;
import com.common.share.MessageBox.ButtonType;
import com.common.share.TextRead;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.Notification;

public class BrandInfo extends Window {

	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("New", "Save", "Edit", "", "Refresh", 
			"Find", "", "", "", "Exit");

	private TextRead txtBrandId;
	private TextField txtBrandName;

	ComboBox cmbBrandNameFind=new ComboBox("Brand Name");

	ListSelect listFind;
	ArrayList<Component> allComp = new ArrayList<Component>();

	public BrandInfo()
	{
		this.setWidth("640px");
		this.setHeight("270px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("BRAND INFORMATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("630px");
		mainLayout.setHeight("230px");

		cmbBrandNameFind.setWidth("210px");
		cmbBrandNameFind.setImmediate(true);
		mainLayout.addComponent(cmbBrandNameFind,"top:20.0px; left:20.0px");

		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(false);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("120px");
		listFind.setWidth("210px");
		mainLayout.addComponent(listFind,"top:50.0px; left:20.0px;");

		mainLayout.addComponent(new Label("Brand ID :"),"top:60.0px; left:240.0px;");
		txtBrandId = new TextRead();
		txtBrandId.setImmediate(true);
		txtBrandId.setWidth("100px");
		txtBrandId.setHeight("24px");
		mainLayout.addComponent(txtBrandId,"top:58.0px; left:320.0px;");

		mainLayout.addComponent(new Label("Brand Name :"),"top:90px;left:240.0px;");
		txtBrandName = new TextField();
		txtBrandName.setImmediate(true);
		txtBrandName.setWidth("250px");
		txtBrandName.setHeight("-1px");
		mainLayout.addComponent(txtBrandName,"top:88.0px; left:320.0px;");

		mainLayout.addComponent(commonButton, "top:185.0px;left:70.0px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
