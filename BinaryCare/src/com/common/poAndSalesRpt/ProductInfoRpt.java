package com.common.poAndSalesRpt;

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
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.Window.Notification;

public class ProductInfoRpt extends Window{
	
	private AbsoluteLayout mainLayout;
	
	private CommonButton commonButton = new CommonButton("", "", "", "", "", "", "", 
			"Preview", "", "Exit");
	
	private ComboBox cmbProductName;
	private CheckBox chkAll;
	private List<String> rd=Arrays.asList("PDF","Other");
	private OptionGroup optionGrp;
	
	public ProductInfoRpt(){
		this.setWidth("440px");
		this.setHeight("160px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("PRODUCT INFO REPORT :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("420px");
		mainLayout.setHeight("140px");
		mainLayout.setMargin(false);
		
		mainLayout.addComponent(new Label("Product Name :"), "top:20.0px; left:10.0px;");

		cmbProductName = new ComboBox();
		cmbProductName.setImmediate(true);
		cmbProductName.setWidth("260px");
		cmbProductName.setNullSelectionAllowed(false);
		cmbProductName.setNewItemsAllowed(false);
		mainLayout.addComponent(cmbProductName, "top:20.0px; left:100.0px;");
		
		chkAll = new CheckBox("All");
		chkAll.setHeight("-1px");
		chkAll.setWidth("-1px");
		chkAll.setImmediate(true);
		mainLayout.addComponent(chkAll, "top:20px; left:360.0px;");
		
		optionGrp = new OptionGroup("",rd);
		optionGrp.setImmediate(true);
		optionGrp.setStyleName("horizontal");
		optionGrp.setValue("PDF");
		mainLayout.addComponent(optionGrp, "top:50.0px;left:100.0px;");		

		mainLayout.addComponent(commonButton,"top:80px; left:100.0px;");
		commonButton.setStyleName("buttonStyle");

		return mainLayout;
	}
}
