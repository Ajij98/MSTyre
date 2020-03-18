package com.common.poAndSalesSetup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.CommonButton;
import com.common.share.MessageBox;
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

public class CategoryInfo extends Window {
	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("New", "Save", "Edit", "", "Refresh", 
			"Find", "", "", "", "Exit");

	private TextRead txtCategoryId;
	private TextField txtCategoryName;
	private TextField txtCategoryDes;
	
	ComboBox cmbCategoryNameFind=new ComboBox("Category Name");
	
	ListSelect listFind;
	ArrayList<Component> allComp = new ArrayList<Component>();
	
	public CategoryInfo()
	{
		this.setWidth("640px");
		this.setHeight("290px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("CATEGORY INFORMATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){	
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("630px");
		mainLayout.setHeight("250px");
		
		cmbCategoryNameFind.setWidth("210px");
		cmbCategoryNameFind.setImmediate(true);
		mainLayout.addComponent(cmbCategoryNameFind,"top:20.0px; left:20.0px");
		
		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(false);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("120px");
		listFind.setWidth("210px");
		mainLayout.addComponent(listFind,"top:50.0px; left:20.0px;");
		
		mainLayout.addComponent(new Label("Category ID :"),"top:50.0px; left:240.0px;");
		txtCategoryId = new TextRead();
		txtCategoryId.setImmediate(true);
		txtCategoryId.setWidth("80px");
		txtCategoryId.setHeight("24px");
		mainLayout.addComponent(txtCategoryId,"top:48.0px; left:340.0px;");

		mainLayout.addComponent(new Label("Category Name :"),"top:80px;left:240.0px;");
		txtCategoryName = new TextField();
		txtCategoryName.setImmediate(true);
		txtCategoryName.setWidth("250px");
		txtCategoryName.setHeight("-1px");
		mainLayout.addComponent(txtCategoryName,"top:78.0px; left:340.0px;");

		
		mainLayout.addComponent(new Label("Description :"),"top:110px;left:240.0px;");
		txtCategoryDes = new TextField();
		txtCategoryDes.setImmediate(true);
		txtCategoryDes.setWidth("250px");
		txtCategoryDes.setHeight("48px");
		mainLayout.addComponent(txtCategoryDes,"top:108.0px; left:340.0px;");

		mainLayout.addComponent(commonButton, "top:200.0px;left:70.0px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
