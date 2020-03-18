package com.common.poAndSalesRpt;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.AmountCommaSeperator;
import com.common.share.AmountField;
import com.common.share.CommonButton;
import com.common.share.SessionFactoryUtil;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.Window.Notification;

public class StockSummary extends Window{

	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("", "", "", "", "", "", "", "Preview", 
			"", "Exit");
	
	private CheckBox chkAllSize,chkAllPattern,chkAllProductName;
	private ComboBox cmbBrand,cmbSize,cmbPattern,cmbProductName;
	private List<String> rd=Arrays.asList("PDF","Other");
	private OptionGroup optionGrp;
		
	PopupDateField dateAsOnDate;
	
	public StockSummary(){
		this.setWidth("440px");
		this.setHeight("250px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("STOCK SUMMARY :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("420px");
		mainLayout.setHeight("230px");
		
		mainLayout.addComponent(new Label("Brand Name :"), "top:10.0px; left:10.0px;");
		cmbBrand = new ComboBox();
		cmbBrand.setImmediate(false);
		cmbBrand.setWidth("260px");
		cmbBrand.setNullSelectionAllowed(false);
		cmbBrand.setNewItemsAllowed(false);
		mainLayout.addComponent(cmbBrand, "top:10.0px; left:100.0px;");
		
		mainLayout.addComponent(new Label("Size :"), "top:40.0px; left:10.0px;");
		cmbSize = new ComboBox();
		cmbSize.setImmediate(false);
		cmbSize.setWidth("260px");
		cmbSize.setNullSelectionAllowed(false);
		cmbSize.setNewItemsAllowed(false);
		mainLayout.addComponent(cmbSize, "top:40.0px; left:100.0px;");
		chkAllSize = new CheckBox("All");
		chkAllSize.setHeight("-1px");
		chkAllSize.setWidth("-1px");
		chkAllSize.setImmediate(true);
		mainLayout.addComponent(chkAllSize, "top:40px; left:360.0px;");
		
		mainLayout.addComponent(new Label("Pattern :"), "top:70.0px; left:10.0px;");
		cmbPattern = new ComboBox();
		cmbPattern.setImmediate(false);
		cmbPattern.setWidth("260px");
		cmbPattern.setNullSelectionAllowed(false);
		cmbPattern.setNewItemsAllowed(false);
		mainLayout.addComponent(cmbPattern, "top:70.0px; left:100.0px;");
		chkAllPattern = new CheckBox("All");
		chkAllPattern.setHeight("-1px");
		chkAllPattern.setWidth("-1px");
		chkAllPattern.setImmediate(true);
		mainLayout.addComponent(chkAllPattern, "top:70px; left:360.0px;");
		

		mainLayout.addComponent(new Label("Product Name :"), "top:100.0px; left:10.0px;");
		cmbProductName = new ComboBox();
		cmbProductName.setImmediate(false);
		cmbProductName.setWidth("260px");
		cmbProductName.setNullSelectionAllowed(false);
		cmbProductName.setNewItemsAllowed(false);
		mainLayout.addComponent(cmbProductName, "top:100.0px; left:100.0px;");
		chkAllProductName = new CheckBox("All");
		chkAllProductName.setHeight("-1px");
		chkAllProductName.setWidth("-1px");
		chkAllProductName.setImmediate(true);
		mainLayout.addComponent(chkAllProductName, "top:100px; left:360.0px;");
		

		mainLayout.addComponent(new Label("As On:"), "top:130.0px; left:10.0px;");
		dateAsOnDate=new PopupDateField();
		dateAsOnDate.setWidth("110px");
		dateAsOnDate.setHeight("24px");
		dateAsOnDate.setDateFormat("dd-MM-yyyy");
		dateAsOnDate.setValue(new java.util.Date());
		dateAsOnDate.setResolution(PopupDateField.RESOLUTION_DAY);
		dateAsOnDate.setImmediate(true);
		//mainLayout.addComponent(new Label("To: "),"top:120.0px; left:20.0px");
		mainLayout.addComponent(dateAsOnDate,"top:130.0px; left:100.0px");
		
		optionGrp = new OptionGroup("",rd);
		optionGrp.setImmediate(true);
		optionGrp.setStyleName("horizontal");
		optionGrp.setValue("PDF");
		mainLayout.addComponent(optionGrp, "top:160.0px;left:100.0px;");		

		mainLayout.addComponent(commonButton,"top:190px; left:100.0px;");
		commonButton.setStyleName("buttonStyle");

		return mainLayout;
	}
}
