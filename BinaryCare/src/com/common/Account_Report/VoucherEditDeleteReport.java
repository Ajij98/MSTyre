package com.common.Account_Report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.CommonButton;
import com.common.share.SessionFactoryUtil;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class VoucherEditDeleteReport extends Window
{
	private AbsoluteLayout mainLayout;

	private Label lblUser,lblFromDate,lblToDate; 
	private ComboBox cmbUser;
	private PopupDateField dFromDate,dToDate;
	private CheckBox chkAll;

	CommonButton commonButton = new CommonButton("", "", "", "","","","","Preview","","Exit");

	public VoucherEditDeleteReport()
	{
		this.setWidth("420px");
		this.setHeight("200px");
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
		dToDate.setValue(new java.util.Date());
		dToDate.setResolution(PopupDateField.RESOLUTION_DAY);
		mainLayout.addComponent(dToDate, "top:45.0px; left:130.0px;");

		lblUser = new Label();
		lblUser.setImmediate(true);
		lblUser.setWidth("-1px");
		lblUser.setHeight("-1px");
		lblUser.setValue("User : ");
		mainLayout.addComponent(lblUser, "top:75; left:60.0px;");

		cmbUser = new ComboBox();
		cmbUser.setImmediate(true);
		cmbUser.setEnabled(true);
		cmbUser.setHeight("-1px");
		cmbUser.setWidth("200px");
		cmbUser.setNullSelectionAllowed(true);
		mainLayout.addComponent(cmbUser, "top:73.0px; left:130.0px;");

		chkAll = new CheckBox("All");
		chkAll.setImmediate(true);
		chkAll.setWidth("-1px");
		chkAll.setHeight("-1px");
		chkAll.setValue(true);
		mainLayout.addComponent(chkAll, "top:75.0px; left:335.0px;");

		mainLayout.addComponent(commonButton, "top:110.0px; left:130.0px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
