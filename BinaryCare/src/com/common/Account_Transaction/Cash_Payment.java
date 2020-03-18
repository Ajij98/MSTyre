package com.common.Account_Transaction;

import java.util.ArrayList;
import java.util.Date;

import com.common.share.AmountCommaSeperator;
import com.common.share.CommonButton;
import com.common.share.TextRead;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.BaseTheme;

public class Cash_Payment extends Window{
	
	AbsoluteLayout mainLayout;
	
	private Label lblPaidTo,lblCashAC,lblBalance,lblBudget,lblDate,lblVoucherNo,lblDescription;
	
	private TextField txtPaidTo,txtVoucherNo;
	private TextRead txtBalance,txtBudget;
	private ComboBox cmbCashAC,cmbDescription;
	private PopupDateField dDate;
	private NativeButton btnBankHead;
	private Button btnBillPreview;
	
	private ArrayList<ComboBox> tbCmbLedgerName = new ArrayList<ComboBox>();
	private ArrayList<ComboBox> tbCmbCostCentreMulti = new ArrayList<ComboBox>();
	private ArrayList<TextRead> tbTxtbudget = new ArrayList<TextRead>();
	private ArrayList<TextRead> tbTxtbalance = new ArrayList<TextRead>();
	private ArrayList<AmountCommaSeperator> tbAmtDebitAmount = new ArrayList<AmountCommaSeperator>();
	
	private Table table;
	
	CommonButton commonButton=new CommonButton("New", "Save", "Edit", "Delete", "Refresh", 
			"Find", "", "Preview", "", "Exit");

	public Cash_Payment() {
		this.setWidth("950px");
		this.setHeight("570px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("CASH PAYMENT VOUCHER :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setImmediate(true);
		
		lblPaidTo = new Label("Paid To :");
		mainLayout.addComponent(lblPaidTo, "top:20px;left:20px;");
		
		txtPaidTo=new TextField();
		txtPaidTo.setWidth("180px");
		txtPaidTo.setHeight("-1px");
		txtPaidTo.setImmediate(true);
		mainLayout.addComponent(txtPaidTo, "top:20px;left:115px;");
		
		lblCashAC = new Label("Cash A/C :");
		mainLayout.addComponent(lblCashAC, "top:70px;left:20px;");
		
		cmbCashAC=new ComboBox();
		cmbCashAC.setWidth("270px");
		cmbCashAC.setHeight("-1px");
		cmbCashAC.setImmediate(true);
		mainLayout.addComponent(cmbCashAC, "top:70px;left:115px;");
		
		btnBankHead = new NativeButton();
		btnBankHead.setWidth("28px");
		btnBankHead.setHeight("24px");
		btnBankHead.setImmediate(true);
		btnBankHead.setIcon(new ThemeResource("./icons/add.png"));
		mainLayout.addComponent(btnBankHead,"top:70px;left:390px;");
		
		lblBudget = new Label("Budget :");
		mainLayout.addComponent(lblBudget, "top:95px;left:20px;");
		
		txtBudget=new TextRead();
		txtBudget.setWidth("120px");
		txtBudget.setHeight("-1px");
		txtBudget.setImmediate(true);
		mainLayout.addComponent(txtBudget, "top:97px;left:115px;");
		
		lblBalance=new Label("Balance :");
		mainLayout.addComponent(lblBalance, "top:95px;left:243px;");

		txtBalance=new TextRead();
		txtBalance.setWidth("120px");
		txtBalance.setHeight("-1px");
		txtBalance.setImmediate(true);
		mainLayout.addComponent(txtBalance, "top:97px;left:298px;");
		
		lblDate=new Label("Date :");
		mainLayout.addComponent(lblDate, "top:20px;left:450px;");
		
		dDate=new PopupDateField();
		dDate.setValue(new Date());
		dDate.setResolution(PopupDateField.RESOLUTION_DAY);
		dDate.setDateFormat("dd-MM-yyyy");
		dDate.setInvalidAllowed(false);
		dDate.setImmediate(true);
		mainLayout.addComponent(dDate,"top:20px;left:530px;");
		
		lblVoucherNo=new Label("Voucher No :");
		mainLayout.addComponent(lblVoucherNo, "top:45px;left:450px;");

		txtVoucherNo=new TextField();
		txtVoucherNo.setWidth("120px");
		txtVoucherNo.setHeight("-1px");
		txtVoucherNo.setImmediate(true);
		mainLayout.addComponent(txtVoucherNo, "top:45px;left:530px;");
		
		btnBillPreview = new Button("Bill Preview");
		btnBillPreview.setStyleName(BaseTheme.BUTTON_LINK);
		btnBillPreview.addStyleName("icon-after-caption");
		btnBillPreview.setImmediate(true);
		btnBillPreview.setIcon(new ThemeResource("./icons/document-pdf.png"));
		mainLayout.addComponent(btnBillPreview, "top:45px;left:780px;");
		
		lblDescription=new Label("Description :");
		mainLayout.addComponent(lblDescription, "top:400px;left:20px;");

		cmbDescription=new ComboBox();
		cmbDescription.setWidth("650px");
		cmbDescription.setHeight("-1px");
		cmbDescription.setImmediate(true);
		cmbDescription.setNullSelectionAllowed(false);
		cmbDescription.setNewItemsAllowed(true);
		cmbDescription.setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		mainLayout.addComponent(cmbDescription, "top:400px;left:100px;");

		mainLayout.addComponent(commonButton, "top:455px;left:110px;");
		commonButton.setStyleName("buttonStyle");
		
		table=new Table();
		table.setWidth("910px");
		table.setHeight("260px");
		table.setColumnCollapsingAllowed(true);
		table.setFooterVisible(true);
		mainLayout.addComponent(table, "top:130px;left:20px;");
		
		table.addContainerProperty("LEDGER NAME", ComboBox.class, new ComboBox(),null,null,Table.ALIGN_CENTER);
		table.setColumnWidth("LEDGER NAME",550);
		table.setColumnFooter("LEDGER NAME", "Total :");
		
		table.addContainerProperty("Cost Centre", ComboBox.class, new ComboBox(),null,null,Table.ALIGN_CENTER);
		table.setColumnWidth("Cost Centre", 210);
		table.setColumnCollapsed("Cost Centre", true);
		
		table.addContainerProperty("Budget", TextRead.class, new TextRead(),null,null,Table.ALIGN_CENTER);
		table.setColumnWidth("Budget",90);
		
		table.addContainerProperty("Balance", TextRead.class, new TextRead(),null,null,Table.ALIGN_CENTER);
		table.setColumnWidth("Balance", 90);
		
		table.addContainerProperty("Debit AMOUNT", AmountCommaSeperator.class, new AmountCommaSeperator(),null,null,Table.ALIGN_CENTER);
		table.setColumnWidth("Debit",90);
		
		tableRowIni();
		
		return mainLayout;
	}
	private void tableRowIni(){
		for(int i=0; i<=9; i++){
			tableRowAdd(i);
		}
	}
	private void tableRowAdd(int i) {
		tbCmbLedgerName.add(i, new ComboBox());
		tbCmbLedgerName.get(i).setNullSelectionAllowed(false);
		tbCmbLedgerName.get(i).setWidth("100%");
		tbCmbLedgerName.get(i).setImmediate(true);
		tbCmbLedgerName.get(i).setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		tbCmbLedgerName.get(i).removeAllItems();

		tbCmbCostCentreMulti.add(i, new ComboBox());
		tbCmbCostCentreMulti.get(i).setWidth("100%");
		tbCmbCostCentreMulti.get(i).setImmediate(true);
		tbCmbCostCentreMulti.get(i).setNullSelectionAllowed(false);
		tbCmbCostCentreMulti.get(i).setEnabled(false);
		
		tbTxtbudget.add(i, new TextRead());
		tbTxtbudget.get(i).setWidth("100%");
		tbTxtbudget.get(i).setStyleName("fright");

		tbTxtbalance.add(i, new TextRead());
		tbTxtbalance.get(i).setWidth("100%");
		tbTxtbalance.get(i).setStyleName("fright");

		tbAmtDebitAmount.add(i, new AmountCommaSeperator());
		tbAmtDebitAmount.get(i).setStyleName("fright");
		tbAmtDebitAmount.get(i).setWidth("100%");
		table.setColumnAlignment("Debit", Table.ALIGN_RIGHT);
		
		table.addItem(new Object[]{tbCmbLedgerName.get(i), tbCmbCostCentreMulti.get(i),tbTxtbudget.get(i),
				tbTxtbalance.get(i),tbAmtDebitAmount.get(i)},i);
	}

}
