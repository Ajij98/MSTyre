package com.common.poAndSalesSetup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.CommonButton;
import com.common.share.MessageBox;
import com.common.share.SessionFactoryUtil;
import com.common.share.TextRead;
import com.common.share.MessageBox.ButtonType;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.Notification;

public class SizeInfo extends Window {
	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("New", "Save", "Edit", "", "Refresh", "Find", 
			"", "", "", "Exit");
	
	private TextRead txtSizeId;
	private TextField txtSizeName;
	private TextField txtSizeDes;
	
	ComboBox cmbSizeNameFind=new ComboBox("Size Name");
	
	ListSelect listFind;
	ArrayList<Component> allComp = new ArrayList<Component>();
	
	public SizeInfo()
	{
		this.setWidth("640px");
		this.setHeight("290px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("SIZE INFORMATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("630px");
		mainLayout.setHeight("250px");

		cmbSizeNameFind.setWidth("210px");
		cmbSizeNameFind.setImmediate(true);
		mainLayout.addComponent(cmbSizeNameFind,"top:20.0px; left:20.0px");
		
		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(false);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("120px");
		listFind.setWidth("210px");
		mainLayout.addComponent(listFind,"top:50.0px; left:20.0px;");
		
		mainLayout.addComponent(new Label("Size ID :"),"top:50.0px; left:240.0px;");
		txtSizeId = new TextRead();
		txtSizeId.setImmediate(true);
		txtSizeId.setWidth("80px");
		txtSizeId.setHeight("24px");
		mainLayout.addComponent(txtSizeId,"top:48.0px; left:360.0px;");

		mainLayout.addComponent(new Label("Size Name :"),"top:80px;left:240.0px;");
		txtSizeName = new TextField();
		txtSizeName.setImmediate(true);
		txtSizeName.setWidth("250px");
		txtSizeName.setHeight("-1px");
		mainLayout.addComponent(txtSizeName,"top:78.0px; left:360.0px;");

		mainLayout.addComponent(new Label("Description :"),"top:110px;left:240.0px;");
		txtSizeDes = new TextField();
		txtSizeDes.setImmediate(true);
		txtSizeDes.setWidth("250px");
		txtSizeDes.setHeight("48px");
		mainLayout.addComponent(txtSizeDes,"top:108.0px; left:360.0px;");

		mainLayout.addComponent(commonButton, "top:200.0px;left:70.0px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
