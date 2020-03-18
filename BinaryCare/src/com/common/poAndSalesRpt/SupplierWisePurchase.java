package com.common.poAndSalesRpt;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

public class SupplierWisePurchase extends Window{
	
	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("", "", "", "", "", "", "", "Preview", 
			"", "Exit");

	private ComboBox cmbSupplierName;
	private List<String> rd=Arrays.asList("PDF","Other");
	private OptionGroup optionGrp;
	
	PopupDateField dateFromDate,dateToDate;
	
	public SupplierWisePurchase(){
		this.setWidth("440px");
		this.setHeight("200px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("SUPPLIER WISE PURCHASES :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("420px");
		mainLayout.setHeight("180px");
		
		mainLayout.addComponent(new Label("Supplier Name :"), "top:10.0px; left:10.0px;");
		cmbSupplierName = new ComboBox();
		cmbSupplierName.setImmediate(false);
		cmbSupplierName.setWidth("260px");
		cmbSupplierName.setNullSelectionAllowed(false);
		cmbSupplierName.setNewItemsAllowed(false);
		mainLayout.addComponent(cmbSupplierName, "top:10.0px; left:100.0px;");
		

		mainLayout.addComponent(new Label("From Date :"), "top:40.0px; left:10.0px;");
		dateFromDate=new PopupDateField();
		dateFromDate.setWidth("110px");
		dateFromDate.setHeight("24px");
		dateFromDate.setDateFormat("dd-MM-yyyy");
		dateFromDate.setValue(new Date());
		dateFromDate.setResolution(PopupDateField.RESOLUTION_DAY);
		dateFromDate.setImmediate(true);
		//mainLayout.addComponent(new Label("To: "),"top:120.0px; left:20.0px");
		mainLayout.addComponent(dateFromDate,"top:40.0px; left:100.0px");
		

		mainLayout.addComponent(new Label("To Date :"), "top:70.0px; left:10.0px;");
		dateToDate=new PopupDateField();
		dateToDate.setWidth("110px");
		dateToDate.setHeight("24px");
		dateToDate.setDateFormat("dd-MM-yyyy");
		dateToDate.setValue(new java.util.Date());
		dateToDate.setResolution(PopupDateField.RESOLUTION_DAY);
		dateToDate.setImmediate(true);
		//mainLayout.addComponent(new Label("To: "),"top:120.0px; left:20.0px");
		mainLayout.addComponent(dateToDate,"top:70.0px; left:100.0px");
		
		optionGrp = new OptionGroup("",rd);
		optionGrp.setImmediate(true);
		optionGrp.setStyleName("horizontal");
		optionGrp.setValue("PDF");
		mainLayout.addComponent(optionGrp, "top:100.0px;left:100.0px;");		

		mainLayout.addComponent(commonButton,"top:130px; left:100.0px;");
		commonButton.setStyleName("buttonStyle");

		return mainLayout;
	}
}
