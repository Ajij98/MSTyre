package com.common.Account_Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.BaseTheme;

public class Bank_Received extends Window{
	
	AbsoluteLayout mainLayout;
	
	private Label lblType,lblReceivedFrom,lblDepositeBankAC,lblBalance,lblBudget,lblDate,
	lblVoucherNo,lblDescription,lblChequeNo,lblChequeDate,lblClientBankName,lblClientBranchName;
	
	private List<String> rd=Arrays.asList("Cheque","Online Debit/Credit");
	OptionGroup optionGrp;
	private TextField txtVoucherNo,txtChequeNo;
	private TextRead txtBalance,txtBudget;
	private ComboBox cmbReceivedFrom,cmbDepositeBankAC,cmbDescription,cmbClientBankName,
	cmbClientBranchName;
	private PopupDateField dDate,dChequeDate;
	private NativeButton btnBankHead;
	private Button btnBillPreview,btnChequePreview;
	
	private ArrayList<ComboBox> tbCmbLedgerName = new ArrayList<ComboBox>();
	private ArrayList<ComboBox> tbCmbCostCentreMulti = new ArrayList<ComboBox>();
	private ArrayList<TextRead> tbTxtbudget = new ArrayList<TextRead>();
	private ArrayList<TextRead> tbTxtbalance = new ArrayList<TextRead>();
	private ArrayList<AmountCommaSeperator> tbAmtCreditAmount = new ArrayList<AmountCommaSeperator>();
	
	private Table table;
	
	CommonButton commonButton=new CommonButton("New", "Save", "Edit", "Delete", "Refresh", 
			"Find", "", "Preview", "", "Exit");

	public Bank_Received() {
		this.setWidth("950px");
		this.setHeight("420px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("BANK PAYMENT VOUCHER :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setImmediate(true);
		
		lblType = new Label("Type :");
		mainLayout.addComponent(lblType, "top:20px;left:20px;");
		
		optionGrp=new OptionGroup("", rd);
		optionGrp.setImmediate(true);
		optionGrp.setValue("Cheque");
		optionGrp.setStyleName("horizontal");
		mainLayout.addComponent(optionGrp,"top:20px; left:130px;");
		
		lblReceivedFrom=new Label("Received From :");
		mainLayout.addComponent(lblReceivedFrom, "top:45px;left:20px;");
		
		cmbReceivedFrom=new ComboBox();
		cmbReceivedFrom.setWidth("180px");
		cmbReceivedFrom.setHeight("-1px");
		cmbReceivedFrom.setImmediate(true);
		mainLayout.addComponent(cmbReceivedFrom, "top:45px;left:128px;");
		
		lblDepositeBankAC = new Label("Deposite Bank A/C :");
		mainLayout.addComponent(lblDepositeBankAC, "top:95px;left:20px;");
		
		cmbDepositeBankAC=new ComboBox();
		cmbDepositeBankAC.setWidth("270px");
		cmbDepositeBankAC.setHeight("-1px");
		cmbDepositeBankAC.setImmediate(true);
		mainLayout.addComponent(cmbDepositeBankAC, "top:95px;left:128px;");
		
		btnBankHead = new NativeButton();
		btnBankHead.setWidth("28px");
		btnBankHead.setHeight("24px");
		btnBankHead.setImmediate(true);
		btnBankHead.setIcon(new ThemeResource("./icons/add.png"));
		mainLayout.addComponent(btnBankHead,"top:95px;left:403px;");
		
		lblBudget = new Label("Budget :");
		mainLayout.addComponent(lblBudget, "top:120px;left:20px;");
		
		txtBudget=new TextRead();
		txtBudget.setWidth("120px");
		txtBudget.setHeight("-1px");
		txtBudget.setImmediate(true);
		mainLayout.addComponent(txtBudget, "top:120px;left:128px;");
		
		lblBalance=new Label("Balance :");
		mainLayout.addComponent(lblBalance, "top:145px;left:256px;");

		txtBalance=new TextRead();
		txtBalance.setWidth("120px");
		txtBalance.setHeight("-1px");
		txtBalance.setImmediate(true);
		mainLayout.addComponent(txtBalance, "top:145px;left:311px;");
		
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
		
		lblChequeNo=new Label("Cheque No :");
		mainLayout.addComponent(lblChequeNo, "top:70px;left:450px;");

		txtChequeNo=new TextField();
		txtChequeNo.setWidth("120px");
		txtChequeNo.setHeight("-1px");
		txtChequeNo.setImmediate(true);
		mainLayout.addComponent(txtChequeNo, "top:70px;left:530px;");

		lblChequeDate=new Label("Cheque Date :");
		mainLayout.addComponent(lblChequeDate, "top:95px;left:450px;");

		dChequeDate=new PopupDateField();
		dChequeDate.setValue(new Date());
		dChequeDate.setResolution(PopupDateField.RESOLUTION_DAY);
		dChequeDate.setDateFormat("dd-MM-yyyy");
		dChequeDate.setInvalidAllowed(false);
		dChequeDate.setImmediate(true);
		mainLayout.addComponent(dChequeDate, "top:95px;left:530px;");
		
		lblClientBankName=new Label("Client Bank Name :");
		mainLayout.addComponent(lblClientBankName, "top:120px;left:415.0px;");

		cmbClientBankName=new ComboBox();
		cmbClientBankName.setImmediate(true);
		cmbClientBankName.setHeight("-1px");
		cmbClientBankName.setWidth("270px");
		cmbClientBankName.setImmediate(true);
		cmbClientBankName.setNullSelectionAllowed(false);
		mainLayout.addComponent(cmbClientBankName, "top:120px;left:530.0px;");

		lblClientBranchName=new Label("Client Branch Name :");
		mainLayout.addComponent(lblClientBranchName, "top:145px;left:405.0px;");

		cmbClientBranchName=new ComboBox();
		cmbClientBranchName.setImmediate(true);
		cmbClientBranchName.setHeight("-1px");
		cmbClientBranchName.setWidth("270px");
		cmbClientBranchName.setImmediate(true);
		cmbClientBranchName.setNullSelectionAllowed(false);
		mainLayout.addComponent(cmbClientBranchName, "top:145px;left:530.0px;");
		
		btnBillPreview = new Button("Bill Preview");
		btnBillPreview.setStyleName(BaseTheme.BUTTON_LINK);
		btnBillPreview.addStyleName("icon-after-caption");
		btnBillPreview.setImmediate(true);
		btnBillPreview.setIcon(new ThemeResource("./icons/document-pdf.png"));
		mainLayout.addComponent(btnBillPreview, "top:45px;left:780px;");
		
		btnChequePreview = new Button("Cheque Preview");
		btnChequePreview.setStyleName(BaseTheme.BUTTON_LINK);
		btnChequePreview.addStyleName("icon-after-caption");
		btnChequePreview.setImmediate(true);
		btnChequePreview.setIcon(new ThemeResource("./icons/document-pdf.png"));
		mainLayout.addComponent(btnChequePreview, "top:97px;left:780px;");
		
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
		table.setHeight("80px");
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
		
		table.addContainerProperty("Credit AMOUNT", AmountCommaSeperator.class, new AmountCommaSeperator(),null,null,Table.ALIGN_CENTER);
		table.setColumnWidth("Debit",90);
		
		tableRowIni();
		
		return mainLayout;
	}
	private void tableRowIni(){
		for(int i=0; i<1; i++){
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

		tbAmtCreditAmount.add(i, new AmountCommaSeperator());
		tbAmtCreditAmount.get(i).setStyleName("fright");
		tbAmtCreditAmount.get(i).setWidth("100%");
		table.setColumnAlignment("Debit", Table.ALIGN_RIGHT);
		
		table.addItem(new Object[]{tbCmbLedgerName.get(i), tbCmbCostCentreMulti.get(i),tbTxtbudget.get(i),
				tbTxtbalance.get(i),tbAmtCreditAmount.get(i)},i);
	}

}
