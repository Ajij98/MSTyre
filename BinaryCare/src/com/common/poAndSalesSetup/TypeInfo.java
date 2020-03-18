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
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.Notification;

public class TypeInfo extends Window 
{
	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("New", "Save", "Edit", "", "Refresh", "Find",
			"", "", "", "Exit");
	
	private TextRead txtTypeId;
	private TextField txtTypeName;
	
	ComboBox cmbTypeNameFind=new ComboBox("Type Name");
	
	ListSelect listFind;
	ArrayList<Component> allComp = new ArrayList<Component>();
	
	public TypeInfo()
	{
		this.setWidth("640px");
		this.setHeight("280px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("TYPE INFORMATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("630px");
		mainLayout.setHeight("220px");

		cmbTypeNameFind.setWidth("210px");
		cmbTypeNameFind.setImmediate(true);
		mainLayout.addComponent(cmbTypeNameFind,"top:20.0px; left:20.0px");
		
		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(false);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("120px");
		listFind.setWidth("210px");
		mainLayout.addComponent(listFind,"top:50.0px; left:20.0px;");
		
		mainLayout.addComponent(new Label("Type ID :"),"top:60.0px; left:240.0px;");

		txtTypeId = new TextRead();
		txtTypeId.setImmediate(false);
		txtTypeId.setWidth("100px");
		txtTypeId.setHeight("24px");
		mainLayout.addComponent(txtTypeId,"top:58.0px; left:320.0px;");

		mainLayout.addComponent(new Label("Type Name :"),"top:90px;left:240.0px;");

		txtTypeName = new TextField();
		txtTypeName.setImmediate(false);
		txtTypeName.setWidth("250px");
		txtTypeName.setHeight("-1px");
		txtTypeName.setSecret(false);
		mainLayout.addComponent(txtTypeName,"top:88.0px; left:320.0px;");

		mainLayout.addComponent(commonButton, "top:190.0px;left:70.0px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
