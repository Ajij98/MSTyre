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

public class PatternInfo extends Window 
{
	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("New", "Save", "Edit", "", "Refresh",
			"Find", "", "", "", "Exit");
	
	private TextRead txtPatternId;
	private TextField txtPatternName;
	private TextField txtPatternDes;
	
	ComboBox cmbPatternNameFind=new ComboBox("Pattern Name");
	
	ListSelect listFind;
	ArrayList<Component> allComp = new ArrayList<Component>();
	
	public PatternInfo()
	{
		this.setWidth("640px");
		this.setHeight("290px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("PATTERN INFORMATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("630px");
		mainLayout.setHeight("250px");

		cmbPatternNameFind.setWidth("210px");
		mainLayout.addComponent(cmbPatternNameFind,"top:20.0px; left:20.0px");
		
		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(false);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("120px");
		listFind.setWidth("210px");
		mainLayout.addComponent(listFind,"top:50.0px; left:20.0px;");
		
		mainLayout.addComponent(new Label("Pattern ID :"),"top:50.0px; left:240.0px;");
		txtPatternId = new TextRead();
		txtPatternId.setImmediate(true);
		txtPatternId.setWidth("80px");
		txtPatternId.setHeight("24px");
		mainLayout.addComponent(txtPatternId,"top:48.0px; left:360.0px;");

		mainLayout.addComponent(new Label("Pattern Name :"),"top:80px;left:240.0px;");
		txtPatternName = new TextField();
		txtPatternName.setImmediate(true);
		txtPatternName.setWidth("250px");
		txtPatternName.setHeight("-1px");
		mainLayout.addComponent(txtPatternName,"top:78.0px; left:360.0px;");

		mainLayout.addComponent(new Label("Description :"),"top:110px;left:240.0px;");
		txtPatternDes = new TextField();
		txtPatternDes.setImmediate(true);
		txtPatternDes.setWidth("250px");
		txtPatternDes.setHeight("48px");
		mainLayout.addComponent(txtPatternDes,"top:108.0px; left:360.0px;");

		mainLayout.addComponent(commonButton, "top:200.0px;left:70.0px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
