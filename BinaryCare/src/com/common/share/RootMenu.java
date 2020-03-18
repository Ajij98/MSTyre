package com.common.share;

import java.util.Arrays;
import java.util.List;

import com.commmon.setup.ChangePassword;
import com.commmon.setup.CompanyInfo;
import com.commmon.setup.PartyInfo;
import com.commmon.setup.StoreInfo;
import com.commmon.setup.SupplierInfo;
import com.commmon.setup.UserAuthentication;
import com.commmon.setup.UserCreate;
import com.common.Account_Report.VoucherEditDeleteReport;
import com.common.Account_Report.VoucherReport;
import com.common.Account_Setup.CheckBookCancel;
import com.common.Account_Setup.CheckBookEntry;
import com.common.Account_Setup.CreateGroup;
import com.common.Account_Setup.CreateLedger;
import com.common.Account_Setup.CreateSubGroup;
import com.common.Account_Setup.Narration;
import com.common.Account_Transaction.Bank_Payment;
import com.common.Account_Transaction.Cash_Payment;
import com.common.Account_Transaction.Cash_Received;
import com.common.poAndSalesRpt.DemandOrderRpt;
import com.common.poAndSalesRpt.ItemReceiptRpt;
import com.common.poAndSalesRpt.ItemReturnRpt;
import com.common.poAndSalesRpt.ItemWisePurchase;
import com.common.poAndSalesRpt.OpeningStockRpt;
import com.common.poAndSalesRpt.ProductInfoRpt;
import com.common.poAndSalesRpt.SalesInvoiceRpt;
import com.common.poAndSalesRpt.StockSummary;
import com.common.poAndSalesRpt.SupplierWisePurchase;
import com.common.poAndSalesSetup.BrandInfo;
import com.common.poAndSalesSetup.CategoryInfo;
import com.common.poAndSalesSetup.PatternInfo;
import com.common.poAndSalesSetup.ProductInfo;
import com.common.poAndSalesSetup.SizeInfo;
import com.common.poAndSalesSetup.SubCategoryInfo;
import com.common.poAndSalesSetup.TypeInfo;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.data.Property.*;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Tree.TreeTargetDetails;

import common.common.setupReport.PartyReport;
import common.common.setupReport.StoreReport;
import common.common.setupReport.SupplierReport;

public class RootMenu extends Panel{
	
	AbsoluteLayout mainLayout,rightLayout;
	VerticalLayout menuLayout;
	HorizontalLayout hrLayout;
	
	AbsoluteLayout setupLayout=new AbsoluteLayout();
	AbsoluteLayout polSalesLayout=new AbsoluteLayout();
	AbsoluteLayout accountLayout=new AbsoluteLayout();
	
	Label lblName,lblSetup,lblTransaction,lblReport;
	
	private Accordion a;
	
	private Tree treeSetup1,treeReport1,treeSetup2,treeTransaction2,treeReport2,treeSetup3,
	treeTransaction3,treeReport3;
	
	//(SETUP PART)
	
		//SETUP
		CompanyInfo companyInfo;
		PartyInfo partyInfo;
		SupplierInfo supplierInfo;
		StoreInfo storeInfo;
		UserCreate userCreate;
		UserAuthentication userAuthentication;
		ChangePassword changePassword;
		
		//REPORT
		SupplierReport supplierReport;
		PartyReport partyReport;
		StoreReport storeReport;
	
	//(PO&SALES PART)
	
		//SETUP
		BrandInfo brandInfo;
		CategoryInfo categoryInfo;
		SubCategoryInfo subCatInfo;
		PatternInfo patternInfo;
		SizeInfo sizeInfo;
		TypeInfo typeInfo;
		ProductInfo productInfo;
	
		//REPORT
		OpeningStockRpt openingStockRpt;
		ProductInfoRpt productInfoRpt;
		ItemReceiptRpt itemReceiptRpt;
		ItemReturnRpt itemReturnRpt;
		DemandOrderRpt demandOrderRpt;
		SalesInvoiceRpt salesInvoiceRpt;
		ItemWisePurchase itemWisePurchase;
		SupplierWisePurchase supplierWisePurchase;
		StockSummary stockSummary;
	
	//(ACCOUNTS PART)
	
		//SETUP
		CreateGroup createGroup;
		CreateSubGroup createSubGroup;
		CreateLedger createLedger;
		CheckBookEntry checkBookEntry;
		CheckBookCancel checkBookCancel;
		Narration narration;
		
		//TRANSACTION
		Cash_Payment cash_Payment;
		Bank_Payment bank_Payment;
		Cash_Received cash_Received;
		
		//REPORT
		VoucherReport voucherReport;
		VoucherEditDeleteReport voucherEditDeleteReport;
	
	public RootMenu(){
		this.setSizeFull();
		//this.setWidth("250px");
		this.setContent(buildMainlayout());
		btnAction();
	}
	private void btnAction(){
		treeSetup1.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				if(treeSetup1.getValue().toString().trim().equals("COMPANY INFORMATION")){
					companyInfo=new CompanyInfo();
					getApplication().getMainWindow().addWindow(companyInfo);
				}
				else if(treeSetup1.getValue().toString().trim().equals("PARTY INFORMATION")){
					partyInfo=new PartyInfo();
					getApplication().getMainWindow().addWindow(partyInfo);
				}
				else if(treeSetup1.getValue().toString().trim().equals("SUPPLIER INFORMATION")){
					supplierInfo=new SupplierInfo();
					getApplication().getMainWindow().addWindow(supplierInfo);
				}
				else if(treeSetup1.getValue().toString().trim().equals("STORE INFORMATION")){
					storeInfo=new StoreInfo();
					getApplication().getMainWindow().addWindow(storeInfo);
				}
				else if(treeSetup1.getValue().toString().trim().equals("CHANGE PASSWORD")){
					changePassword=new ChangePassword();
					getApplication().getMainWindow().addWindow(changePassword);
				}
				else if(treeSetup1.getValue().toString().trim().equals("USER CREATE")){
					userCreate=new UserCreate();
					getApplication().getMainWindow().addWindow(userCreate);
				}
				else if(treeSetup1.getValue().toString().trim().equals("USER AUTHENTICATION")){
					userAuthentication=new UserAuthentication();
					getApplication().getMainWindow().addWindow(userAuthentication);
				}
			}
		});
		treeReport1.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				if(treeReport1.getValue().toString().trim().equals("SUPPLIER REPORT")){
					supplierReport=new SupplierReport();
					getApplication().getMainWindow().addWindow(supplierReport);
				}
				else if(treeReport1.getValue().toString().trim().equals("PARTY REPORT")){
					partyReport=new PartyReport();
					getApplication().getMainWindow().addWindow(partyReport);
				}
				else if(treeReport1.getValue().toString().trim().equals("STORE REPORT")){
					storeReport=new StoreReport();
					getApplication().getMainWindow().addWindow(storeReport);
				}
			}
		});
		treeSetup2.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				if(treeSetup2.getValue().toString().trim().equals("BRAND INFORMATION")){
					brandInfo=new BrandInfo();
					getApplication().getMainWindow().addWindow(brandInfo);
				}
				else if(treeSetup2.getValue().toString().trim().equals("CATEGORY INFORMATION")){
					categoryInfo=new CategoryInfo();
					getApplication().getMainWindow().addWindow(categoryInfo);
				}
				else if(treeSetup2.getValue().toString().trim().equals("SUB-CAT INFORMATION")){
					subCatInfo=new SubCategoryInfo();
					getApplication().getMainWindow().addWindow(subCatInfo);
				}
				else if(treeSetup2.getValue().toString().trim().equals("PATTERN INFORMATION")){
					patternInfo=new PatternInfo();
					getApplication().getMainWindow().addWindow(patternInfo);
				}
				else if(treeSetup2.getValue().toString().trim().equals("SIZE INFORMATION")){
					sizeInfo=new SizeInfo();
					getApplication().getMainWindow().addWindow(sizeInfo);
				}
				else if(treeSetup2.getValue().toString().trim().equals("TYPE INFORMATION")){
					typeInfo=new TypeInfo();
					getApplication().getMainWindow().addWindow(typeInfo);
				}
				else if(treeSetup2.getValue().toString().trim().equals("PRODUCT INFORMATION")){
					productInfo=new ProductInfo();
					getApplication().getMainWindow().addWindow(productInfo);
				}
			}
		});
		treeReport2.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				if(treeReport2.getValue().toString().trim().equals("OPENING STOCK REPORT")){
					openingStockRpt=new OpeningStockRpt();
					getApplication().getMainWindow().addWindow(openingStockRpt);
				}
				else if(treeReport2.getValue().toString().trim().equals("PRODUCT INFO REPORT")){
					productInfoRpt=new ProductInfoRpt();
					getApplication().getMainWindow().addWindow(productInfoRpt);
				}
				else if(treeReport2.getValue().toString().trim().equals("ITEM RECEIPT REPORT")){
					itemReceiptRpt=new ItemReceiptRpt();
					getApplication().getMainWindow().addWindow(itemReceiptRpt);
				}
				else if(treeReport2.getValue().toString().trim().equals("ITEM RETURN REPORT")){
					itemReturnRpt=new ItemReturnRpt();
					getApplication().getMainWindow().addWindow(itemReturnRpt);
				}
				else if(treeReport2.getValue().toString().trim().equals("DEMAND ORDER REPORT")){
					demandOrderRpt=new DemandOrderRpt();
					getApplication().getMainWindow().addWindow(demandOrderRpt);
				}
				else if(treeReport2.getValue().toString().trim().equals("SALES INVOICE REPORT")){
					salesInvoiceRpt=new SalesInvoiceRpt();
					getApplication().getMainWindow().addWindow(salesInvoiceRpt);
				}
				else if(treeReport2.getValue().toString().trim().equals("ITEM WISE PURCHASE")){
					itemWisePurchase=new ItemWisePurchase();
					getApplication().getMainWindow().addWindow(itemWisePurchase);
				}
				else if(treeReport2.getValue().toString().trim().equals("SUPPLIER WISE PURCHASE")){
					supplierWisePurchase=new SupplierWisePurchase();
					getApplication().getMainWindow().addWindow(supplierWisePurchase);
				}
				else if(treeReport2.getValue().toString().trim().equals("STOCK SUMMARY")){
					stockSummary=new StockSummary();
					getApplication().getMainWindow().addWindow(stockSummary);
				}
			}
		});
		treeSetup3.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				if(treeSetup3.getValue().toString().trim().equals("CREATE GROUP")){
					createGroup=new CreateGroup();
					getApplication().getMainWindow().addWindow(createGroup);
				}
				else if(treeSetup3.getValue().toString().trim().equals("CREATE SUB-GROUP")){
					createSubGroup=new CreateSubGroup();
					getApplication().getMainWindow().addWindow(createSubGroup);
				}
				else if(treeSetup3.getValue().toString().trim().equals("CHCQUE BOOK ENTRY")){
					checkBookEntry=new CheckBookEntry();
					getApplication().getMainWindow().addWindow(checkBookEntry);
				}
				else if(treeSetup3.getValue().toString().trim().equals("CHCQUE BOOK CANCEL")){
					checkBookCancel=new CheckBookCancel();
					getApplication().getMainWindow().addWindow(checkBookCancel);
				}
				else if(treeSetup3.getValue().toString().trim().equals("NARRATION")){
					narration=new Narration();
					getApplication().getMainWindow().addWindow(narration);
				}
				else if(treeSetup3.getValue().toString().trim().equals("CREATE LEDGER")){
					createLedger=new CreateLedger();
					getApplication().getMainWindow().addWindow(createLedger);
				}
			}
		});
		treeTransaction3.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				if(treeTransaction3.getValue().toString().trim().equals("CASH PAYMENT")){
					cash_Payment=new Cash_Payment();
					getApplication().getMainWindow().addWindow(cash_Payment);
				}
				else if(treeTransaction3.getValue().toString().trim().equals("BANK PAYMENT")){
					bank_Payment=new Bank_Payment();
					getApplication().getMainWindow().addWindow(bank_Payment);
				}
				else if(treeTransaction3.getValue().toString().trim().equals("CASH RECEIVED")){
					cash_Received=new Cash_Received();
					getApplication().getMainWindow().addWindow(cash_Received);
				}
			}
		});
		treeReport3.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				if(treeReport3.getValue().toString().trim().equals("VOUCHER REPORT")){
					voucherReport=new VoucherReport();
					getApplication().getMainWindow().addWindow(voucherReport);
				}
				else if(treeReport3.getValue().toString().trim().equals("VOUCHER DELETE/UPDATE")){
					voucherEditDeleteReport=new VoucherEditDeleteReport();
					getApplication().getMainWindow().addWindow(voucherEditDeleteReport);
				}
				else if(treeReport3.getValue().toString().trim().equals("CHCQUE BOOK ENTRY")){
					checkBookEntry=new CheckBookEntry();
					getApplication().getMainWindow().addWindow(checkBookEntry);
				}
			}
		});
	}
	private AbsoluteLayout buildMainlayout() {
		mainLayout=new AbsoluteLayout();
		mainLayout.setSizeFull();
		mainLayout.setImmediate(true);
		mainLayout.setStyleName("mainLayout");
		
		hrLayout=new HorizontalLayout();
		hrLayout.setWidth("100%");
		hrLayout.setHeight("45px");
		mainLayout.addComponent(hrLayout, "top:0px;left:0px");

		lblName=new Label("M. S.  TYRE  HOUSE");
		hrLayout.addComponent(lblName);
		lblName.setStyleName("nameStyle");
		
		rightLayout=new AbsoluteLayout();
		rightLayout.setWidth("1085px");
		rightLayout.setHeight("610px");
		rightLayout.setImmediate(true);
		mainLayout.addComponent(rightLayout, "top:45px;left:280px");
		rightLayout.setStyleName("rightLayout");
		
		menuLayout=new VerticalLayout();
		menuLayout.setWidth("280px");
		menuLayout.setHeight("607px");
		menuLayout.setImmediate(true);
		menuLayout.setStyleName("vertical");
		mainLayout.addComponent(menuLayout, "top:45px;left:0px");
		
		a=new Accordion();
		a.setWidth("280px");
		a.setHeight("607px");
		a.addTab(setupLayout, "SETUP", null);
		setupLayout();
		a.addTab(polSalesLayout, "PO & SALES", null);
		polSalesLayout();
		a.addTab(accountLayout, "ACCOUNTS", null);
		accountLayout();
		menuLayout.addComponent(a);
		
		return mainLayout;
	}
	private void setupLayout() {
		setupLayout.setWidth("278px");
		setupLayout.setHeight("545px");	
		setupLayout.setImmediate(true);
		setupLayout.setStyleName("menuStyle");
		
		lblSetup=new Label("<B><u>SETUP</u></B>",Label.CONTENT_XHTML);
		setupLayout.addComponent(lblSetup, "top:10px;left:10px");
		lblSetup.setStyleName("lblStyle");
		
		treeSetup1 = new Tree();
		treeSetup1.setImmediate(true);
		treeSetup1.setWidth("100%");
		treeSetup1.setHeight("100%");
		setupLayout.addComponent(treeSetup1, "top:40px;left:20px");
		
		treeSetup1.addItem("COMPANY INFORMATION");
		treeSetup1.addItem("PARTY INFORMATION");
		treeSetup1.addItem("SUPPLIER INFORMATION");
		treeSetup1.addItem("STORE INFORMATION");
		treeSetup1.addItem("USER CREATE");
		treeSetup1.addItem("USER AUTHENTICATION");
		treeSetup1.addItem("CHANGE PASSWORD");
		
		lblTransaction=new Label("<B><u>TRANSACTION</u></B>",Label.CONTENT_XHTML);
		setupLayout.addComponent(lblTransaction, "top:190px;left:10px");
		lblTransaction.setStyleName("lblStyle");
		
		lblReport=new Label("<B><u>REPORT</u></B>",Label.CONTENT_XHTML);
		setupLayout.addComponent(lblReport, "top:220px;left:10px");
		lblReport.setStyleName("lblStyle");
		
		treeReport1 = new Tree();
		treeReport1.setImmediate(true);
		treeReport1.setWidth("100%");
		treeReport1.setHeight("100%");
		setupLayout.addComponent(treeReport1, "top:250px;left:20px");
		
		treeReport1.addItem("SUPPLIER REPORT");
		treeReport1.addItem("PARTY REPORT");
		treeReport1.addItem("STORE REPORT");
	}
	private void polSalesLayout() {
		polSalesLayout.setWidth("278px");
		polSalesLayout.setHeight("545px");	
		polSalesLayout.setImmediate(true);
		polSalesLayout.setStyleName("menuStyle");
		
		lblSetup=new Label("<B><u>SETUP</u></B>",Label.CONTENT_XHTML);
		polSalesLayout.addComponent(lblSetup, "top:10px;left:10px");
		lblSetup.setStyleName("lblStyle");
		
		treeSetup2 = new Tree();
		treeSetup2.setImmediate(true);
		treeSetup2.setWidth("100%");
		treeSetup2.setHeight("100%");
		polSalesLayout.addComponent(treeSetup2, "top:30px;left:20px");
		
		treeSetup2.addItem("BRAND INFORMATION");
		treeSetup2.addItem("CATEGORY INFORMATION");
		treeSetup2.addItem("SUB-CAT INFORMATION");
		treeSetup2.addItem("SIZE INFORMATION");
		treeSetup2.addItem("PATTERN INFORMATION");
		treeSetup2.addItem("TYPE INFORMATION");
		treeSetup2.addItem("PRODUCT INFORMATION");
		
		lblTransaction=new Label("<B><u>TRANSACTION</u></B>",Label.CONTENT_XHTML);
		polSalesLayout.addComponent(lblTransaction, "top:170px;left:10px");
		lblTransaction.setStyleName("lblStyle");
		
		treeTransaction2 = new Tree();
		treeTransaction2.setImmediate(true);
		treeTransaction2.setWidth("100%");
		treeTransaction2.setHeight("100%");
		polSalesLayout.addComponent(treeTransaction2, "top:190px;left:20px");
		
		treeTransaction2.addItem("OPENING STOCK");
		treeTransaction2.addItem("ITEM RECEIPT");
		treeTransaction2.addItem("ITEM RECEIPT RETURN");
		treeTransaction2.addItem("DEMAND ORDER");
		treeTransaction2.addItem("SALES INVOICE");
		treeTransaction2.addItem("WASTAGE/BROKEN");
		
		lblReport=new Label("<B><u>REPORT</u></B>",Label.CONTENT_XHTML);
		polSalesLayout.addComponent(lblReport, "top:310px;left:10px");
		lblReport.setStyleName("lblStyle");
		
		treeReport2 = new Tree();
		treeReport2.setImmediate(true);
		treeReport2.setWidth("100%");
		treeReport2.setHeight("100%");
		polSalesLayout.addComponent(treeReport2, "top:330px;left:20px");
		
		treeReport2.addItem("OPENING STOCK REPORT");
		treeReport2.addItem("PRODUCT INFO REPORT");
		treeReport2.addItem("ITEM RECEIPT REPORT");
		treeReport2.addItem("ITEM RETURN REPORT");
		treeReport2.addItem("DEMAND ORDER REPORT");
		treeReport2.addItem("SALES INVOICE REPORT");
		treeReport2.addItem("ITEM WISE PURCHASE");
		treeReport2.addItem("SUPPLIER WISE PURCHASE");
		treeReport2.addItem("STOCK SUMMARY");
		treeReport2.addItem("STOCK SUMMARY DETAILS");
	}
	private void accountLayout() {
		accountLayout.setWidth("278px");
		accountLayout.setHeight("545px");	
		accountLayout.setImmediate(true);
		accountLayout.setStyleName("menuStyle");
		
		lblSetup=new Label("<B><u>SETUP</u></B>",Label.CONTENT_XHTML);
		accountLayout.addComponent(lblSetup, "top:10px;left:10px");
		lblSetup.setStyleName("lblStyle");
		
		treeSetup3 = new Tree();
		treeSetup3.setImmediate(true);
		treeSetup3.setWidth("100%");
		treeSetup3.setHeight("100%");
		accountLayout.addComponent(treeSetup3, "top:40px;left:20px");
		
		treeSetup3.addItem("CREATE GROUP");
		treeSetup3.addItem("CREATE SUB-GROUP");
		treeSetup3.addItem("CREATE LEDGER");
		treeSetup3.addItem("CHCQUE BOOK ENTRY");
		treeSetup3.addItem("CHCQUE BOOK CANCEL");
		treeSetup3.addItem("NARRATION");
		
		lblTransaction=new Label("<B><u>TRANSACTION</u></B>",Label.CONTENT_XHTML);
		accountLayout.addComponent(lblTransaction, "top:170px;left:10px");
		lblTransaction.setStyleName("lblStyle");
		
		treeTransaction3 = new Tree();
		treeTransaction3.setImmediate(true);
		treeTransaction3.setWidth("100%");
		treeTransaction3.setHeight("100%");
		accountLayout.addComponent(treeTransaction3, "top:200px;left:20px");
		
		treeTransaction3.addItem("CASH PAYMENT");
		treeTransaction3.addItem("BANK PAYMENT");
		treeTransaction3.addItem("CASH RECEIVED");
		treeTransaction3.addItem("BANK RECEIVED");
		
		lblReport=new Label("<B><u>REPORT</u></B>",Label.CONTENT_XHTML);
		accountLayout.addComponent(lblReport, "top:290px;left:10px");
		lblReport.setStyleName("lblStyle");
		
		treeReport3 = new Tree();
		treeReport3.setImmediate(true);
		treeReport3.setWidth("100%");
		treeReport3.setHeight("100%");
		accountLayout.addComponent(treeReport3, "top:320px;left:20px");
		
		treeReport3.addItem("LEDGER TRANSACTION REPORT");
		treeReport3.addItem("VOUCHER REPORT");
		treeReport3.addItem("VOUCHER DELETE/UPDATE");
	}
}
