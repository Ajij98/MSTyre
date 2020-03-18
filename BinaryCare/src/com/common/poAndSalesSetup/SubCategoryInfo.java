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
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.Notification;

public class SubCategoryInfo extends Window 
{
	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("New", "Save", "Edit", "", "Refresh", "Find",
			"", "", "", "Exit");
	
	private TextRead txtSubCategoryId;
	private ComboBox cmbCategoryName;
	private TextField txtSubCategoryName;
	private TextField txtSubCategoryDes;
	private NativeButton nbCategory;
	
	ComboBox cmbSubCategoryNameFind=new ComboBox("Sub Category Name");
	
	ListSelect listFind;
	ArrayList<Component> allComp = new ArrayList<Component>();
	
	public SubCategoryInfo()
	{
		this.setWidth("690px");
		this.setHeight("290px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("SUBCATEGORY INFORMATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("670px");
		mainLayout.setHeight("250px");

		cmbSubCategoryNameFind.setWidth("210px");
		cmbSubCategoryNameFind.setImmediate(true);
		mainLayout.addComponent(cmbSubCategoryNameFind,"top:20.0px; left:20.0px");
		
		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(false);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("140px");
		listFind.setWidth("210px");
		mainLayout.addComponent(listFind,"top:50.0px; left:20.0px;");
		
		mainLayout.addComponent(new Label("Sub Category ID :"),"top:50.0px; left:240.0px;");
		txtSubCategoryId = new TextRead();
		txtSubCategoryId.setImmediate(true);
		txtSubCategoryId.setWidth("80px");
		txtSubCategoryId.setHeight("24px");
		mainLayout.addComponent(txtSubCategoryId,"top:48.0px; left:360.0px;");

		mainLayout.addComponent(new Label("Category Name:"),"top:80px;left:240.0px;");
		cmbCategoryName = new ComboBox();
		cmbCategoryName.setImmediate(true);
		cmbCategoryName.setWidth("250px");
		cmbCategoryName.setHeight("-1px");
		mainLayout.addComponent(cmbCategoryName,"top:78.0px; left:360.0px;");
		
		nbCategory = new NativeButton();
		nbCategory.setIcon(new ThemeResource("./icons/add.png"));
		nbCategory.setImmediate(true);
		nbCategory.setWidth("30px");
		nbCategory.setHeight("23px");
		mainLayout.addComponent(nbCategory, "top:78.0px;left:620.0px;");

		mainLayout.addComponent(new Label("Sub Category Name:"),"top:110px;left:240.0px;");
		txtSubCategoryName = new TextField();
		txtSubCategoryName.setImmediate(true);
		txtSubCategoryName.setWidth("250px");
		txtSubCategoryName.setHeight("-1px");
		mainLayout.addComponent(txtSubCategoryName,"top:108.0px; left:360.0px;");
		
		mainLayout.addComponent(new Label("Description :"),"top:140px;left:240.0px;");
		txtSubCategoryDes = new TextField();
		txtSubCategoryDes.setImmediate(true);
		txtSubCategoryDes.setWidth("250px");
		txtSubCategoryDes.setHeight("48px");
		mainLayout.addComponent(txtSubCategoryDes,"top:138.0px; left:360.0px;");

		mainLayout.addComponent(commonButton, "top:200.0px;left:70.0px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
