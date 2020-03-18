package com.common.Account_Setup;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.common.share.AmountCommaSeperator;
import com.common.share.CommaSeparator;
import com.common.share.CommonButton;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class CreateLedger extends Window{
	
	private AbsoluteLayout mainLayout;
	
	private Label lblPrimaryCat;
	private Label lblMainCat;
	private Label lblGroupList;
	private Label lblSubGroupList;
	private Label lblLedgerList;
	private Label lblLedgerName;
	private Label lblDebAmt;
	private Label lblCrdAmt;
	private Label lblOpyear;
	
	private NativeSelect primaryCat;
	private NativeSelect mainCat;
	private NativeSelect groupList;
	private NativeSelect subGroupList;
	
	private ListSelect ledgerList;
	
	private TextField ledgerName;
	private TextField opyear;
	
	private NativeButton btnGroup;
	private NativeButton btnSubGroup;
	
	private Label lblLed = new Label("<B><u>Ledger Information</u></B>",Label.CONTENT_XHTML);
	private Label lblOpen = new Label("<B><u>Opening Balance Information</u></B>",Label.CONTENT_XHTML);
	
	private AmountCommaSeperator debAmt;
	private AmountCommaSeperator crdAmt;
	
	private CheckBox chkCompany = new CheckBox("All Company");

	CommonButton commonButton = new CommonButton("New", "Save", "Edit", "Delete", "Refresh", "",
			"", "", "","");

	private CommaSeparator cms = new CommaSeparator();	

	private NumberFormat fmt = new DecimalFormat("#0.00");

	public CreateLedger() {
		this.setWidth("860px");
		this.setHeight("450px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("LEDGER :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);

		lblPrimaryCat = new Label();
		lblPrimaryCat.setImmediate(true);
		lblPrimaryCat.setWidth("-1px");
		lblPrimaryCat.setHeight("-1px");
		lblPrimaryCat.setValue("Primary Category:");
		mainLayout.addComponent(lblPrimaryCat, "top:20.0px;left:20.0px;");

		primaryCat  = new NativeSelect();
		primaryCat.setImmediate(true);
		primaryCat.setWidth("150px");
		primaryCat.addItem("1");
		primaryCat.setItemCaption("1", "All");
		primaryCat.addItem("2");
		primaryCat.setItemCaption("2", "Assets");
		primaryCat.addItem("5");
		primaryCat.setItemCaption("5", "Expenses");
		primaryCat.addItem("4");
		primaryCat.setItemCaption("4", "Income");
		primaryCat.addItem("3");
		primaryCat.setItemCaption("3", "Liabilities");
		
		primaryCat.setImmediate(true);
		primaryCat.setValue("1");
		primaryCat.setNullSelectionAllowed(false);
		mainLayout.addComponent(primaryCat, "top:42.0px;left:20.0px;");

		lblMainCat = new Label();
		lblMainCat.setImmediate(true);
		lblMainCat.setWidth("-1px");
		lblMainCat.setHeight("-1px");
		lblMainCat.setValue("Main Category:");
		mainLayout.addComponent(lblMainCat, "top:67.0px;left:20.0px;");

		mainCat  = new NativeSelect();
		mainCat.setWidth("270px");
		mainCat.setImmediate(true);
		mainLayout.addComponent(mainCat, "top:87.0px;left:20.0px;");

		lblGroupList = new Label();
		lblGroupList.setImmediate(true);
		lblGroupList.setWidth("-1px");
		lblGroupList.setHeight("-1px");
		lblGroupList.setValue("Group List:");
		mainLayout.addComponent(lblGroupList, "top:117.0px;left:20.0px;");

		groupList   = new NativeSelect();
		groupList.setWidth("270px");
		groupList.setImmediate(true);
		mainLayout.addComponent(groupList, "top:137.0px;left:20.0px;");

		btnGroup = new NativeButton();
		btnGroup.setCaption("");
		btnGroup.setImmediate(true);
		btnGroup.setWidth("28px");
		btnGroup.setHeight("24px");
		btnGroup.setIcon(new ThemeResource("./icons/add.png"));
		mainLayout.addComponent(btnGroup,"top:137.0px;left:295.0px;");

		lblSubGroupList = new Label();
		lblSubGroupList.setImmediate(true);
		lblSubGroupList.setWidth("-1px");
		lblSubGroupList.setHeight("-1px");
		lblSubGroupList.setValue("Sub-Group List:");
		mainLayout.addComponent(lblSubGroupList, "top:167.0px;left:20.0px;");

		subGroupList  = new NativeSelect();
		subGroupList.setWidth("270px");
		subGroupList.setImmediate(true);
		mainLayout.addComponent(subGroupList, "top:187.0px;left:20.0px;");

		btnSubGroup = new NativeButton();
		btnSubGroup.setCaption("");
		btnSubGroup.setImmediate(true);
		btnSubGroup.setWidth("28px");
		btnSubGroup.setHeight("24px");
		btnSubGroup.setIcon(new ThemeResource("./icons/add.png"));
		mainLayout.addComponent(btnSubGroup,"top:187.0px;left:295.0px;");

		lblLedgerList = new Label();
		lblLedgerList.setImmediate(true);
		lblLedgerList.setWidth("-1px");
		lblLedgerList.setHeight("-1px");
		lblLedgerList.setValue("Ledger List:");
		mainLayout.addComponent(lblLedgerList, "top:217.0px;left:20.0px;");

		ledgerList = new ListSelect();
		ledgerList.setImmediate(true);
		ledgerList.setHeight("-1px");
		ledgerList.setWidth("300px");
		ledgerList.setNullSelectionAllowed(false);
		mainLayout.addComponent(ledgerList, "top:237.0px;left:20.0px;");

		lblLed.setImmediate(true);
		lblLed.setWidth("-1px");
		lblLed.setHeight("-1px");
		mainLayout.addComponent(lblLed, "top:112.0px;left:340.0px;");

		lblLedgerName = new Label();
		lblLedgerName.setImmediate(true);
		lblLedgerName.setWidth("-1px");
		lblLedgerName.setHeight("-1px");
		lblLedgerName.setValue("Ledger Name:");
		mainLayout.addComponent(lblLedgerName, "top:142.0px;left:340.0px;");

		ledgerName = new TextField();
		ledgerName.setImmediate(true);
		ledgerName.setWidth("300px");
		ledgerName.setHeight("-1px");
		mainLayout.addComponent(ledgerName, "top:142.0px;left:425.0px;");

		chkCompany.setImmediate(true);
		chkCompany.setHeight("-1px");
		chkCompany.setWidth("220px");		
		chkCompany.setVisible(false);
		mainLayout.addComponent(chkCompany, "top:150.0px;left:425.0px;");

		lblOpen.setImmediate(true);
		lblOpen.setWidth("-1px");
		lblOpen.setHeight("-1px");
		mainLayout.addComponent(lblOpen, "top:222.0px;left:340.0px;");

		lblDebAmt = new Label();
		lblDebAmt.setImmediate(true);
		lblDebAmt.setWidth("-1px");
		lblDebAmt.setHeight("-1px");
		lblDebAmt.setValue("Debit Amount:");
		mainLayout.addComponent(lblDebAmt, "top:252.0px;left:340.0px;");

		debAmt = new AmountCommaSeperator();
		debAmt.setImmediate(true);
		debAmt.setWidth("120px");
		debAmt.setHeight("-1px");
		debAmt.setStyleName("fright");
		mainLayout.addComponent(debAmt, "top:272.0px;left:340.0px;");

		lblCrdAmt = new Label();
		lblCrdAmt.setImmediate(true);
		lblCrdAmt.setWidth("-1px");
		lblCrdAmt.setHeight("-1px");
		lblCrdAmt.setValue("Credit Amount:");
		mainLayout.addComponent(lblCrdAmt, "top:252.0px;left:505.0px;");

		crdAmt = new AmountCommaSeperator();
		crdAmt.setImmediate(true);
		crdAmt.setWidth("120px");
		crdAmt.setHeight("-1px");
		crdAmt.setStyleName("fright");
		mainLayout.addComponent(crdAmt, "top:272.0px;left:505.0px;");

		lblOpyear = new Label();
		lblOpyear.setImmediate(true);
		lblOpyear.setWidth("-1px");
		lblOpyear.setHeight("-1px");
		lblOpyear.setValue("Opening Year");
		mainLayout.addComponent(lblOpyear, "top:252.0px;left:670.0px;");

		opyear  = new TextField();
		opyear.setImmediate(true);
		opyear.setWidth("120px");
		opyear.setHeight("-1px");
		opyear.setStyleName("fright");
		mainLayout.addComponent(opyear, "top:272.0px;left:670.0px;");

		mainLayout.addComponent(commonButton, "top:330.0px;left:350.0px;");
		commonButton.setStyleName("buttonStyle");

		return mainLayout;
	}

}
