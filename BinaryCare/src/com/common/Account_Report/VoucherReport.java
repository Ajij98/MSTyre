package com.common.Account_Report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.CommonButton;
import com.common.share.SessionFactoryUtil;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class VoucherReport extends Window {
	
	private AbsoluteLayout mainLayout;
	
	private Label lblVoucherType,lblFromDate,lblToDate,lblVoucherList; 
	
	private NativeSelect voucherType;
	private ListSelect voucherList;
	
	private PopupDateField dFromDate,dToDate;
	
	private NativeButton btnSelectAll;
	
	CommonButton commonButton1 = new CommonButton("", "", "", "", "", "Find", "", 
			"", "", "");
	
	CommonButton commonButton2 = new CommonButton("", "", "", "", "", "", "", 
			"Preview", "", "Exit");

	public VoucherReport()
	{
		this.setWidth("460px");
		this.setHeight("320px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("VOUCHER EDIT/DELETE REPORT :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		lblVoucherType = new Label("Voucher Type :");
		lblVoucherType.setImmediate(true);
		lblVoucherType.setWidth("-1px");
		lblVoucherType.setHeight("-1px");
		mainLayout.addComponent(lblVoucherType, "top:67.0px;left:20.0px;");

		voucherType  = new NativeSelect();
		voucherType.setWidth("200px");
		voucherType.setImmediate(true);
		mainLayout.addComponent(voucherType, "top:87.0px;left:20.0px;");

		lblFromDate = new Label();
		lblFromDate.setImmediate(true);
		lblFromDate.setWidth("-1px");
		lblFromDate.setHeight("-1px");
		lblFromDate.setValue("From : ");
		mainLayout.addComponent(lblFromDate, "top:20.0px; left:60.0px;");

		dFromDate=new PopupDateField();
		dFromDate.setWidth("110px");
		dFromDate.setDateFormat("dd-MM-yyyy");
		dFromDate.setValue(new Date());
		dFromDate.setResolution(PopupDateField.RESOLUTION_DAY);
		mainLayout.addComponent(dFromDate, "top:18.0px; left:130.0px;");

		lblToDate = new Label();
		lblToDate.setImmediate(true);
		lblToDate.setWidth("-1px");
		lblToDate.setHeight("-1px");
		lblToDate.setValue("To : ");
		mainLayout.addComponent(lblToDate, "top:48.0px; left:60.0px;");

		dToDate=new PopupDateField();
		dToDate.setWidth("110px");
		dToDate.setDateFormat("dd-MM-yyyy");
		dToDate.setValue(new Date());
		dToDate.setResolution(PopupDateField.RESOLUTION_DAY);
		mainLayout.addComponent(dToDate, "top:45.0px; left:130.0px;");

		mainLayout.addComponent(commonButton1, "top:110.0px; left:130.0px;");
		commonButton1.setStyleName("buttonStyle");
		
		lblVoucherList = new Label("Voucher List :");
		lblVoucherList.setImmediate(true);
		lblVoucherList.setWidth("-1px");
		lblVoucherList.setHeight("-1px");
		mainLayout.addComponent(lblVoucherList, "top:67.0px;left:20.0px;");
		
		voucherList = new ListSelect();
		voucherList.setImmediate(true);
		voucherList.setHeight("-1px");
		voucherList.setWidth("300px");
		voucherList.setNullSelectionAllowed(false);
		mainLayout.addComponent(voucherList, "top:237.0px;left:20.0px;");
		
		mainLayout.addComponent(btnSelectAll, "top:237.0px;left:20.0px;");
		btnSelectAll.setWidth("150px");
		btnSelectAll.setHeight("220px");
		btnSelectAll.setStyleName(Button.STYLE_LINK);
		
		mainLayout.addComponent(commonButton2, "top:110.0px; left:130.0px;");
		commonButton2.setStyleName("buttonStyle");
		
		return mainLayout;
	}
}
