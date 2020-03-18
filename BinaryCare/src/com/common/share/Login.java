package com.common.share;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javafx.scene.control.Tab;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class Login extends Window{
	
	AbsoluteLayout mainLayout,rootLayout;
	
	Label lblUserName,lblPassword,lblPop,lblInline,lblComboBox,lblNetiveSelect,
	lblRadioButton,lblCheckBox,lblTable;
	TextField txtUserName;
	PasswordField txtPassword;
	PopupDateField datePop;
	InlineDateField dateInline;
	ComboBox cmb;
	NativeSelect cmbNetive;
	List<String> radio=Arrays.asList("One","Two","Three");
	OptionGroup optionGrp;
	CheckBox chk1,chk2,chk3;
	NativeButton btnLogin;
	
	private ArrayList<Label> tblblSl=new ArrayList<Label>();
	private ArrayList<TextField> tbtxtProductId=new ArrayList<TextField>();
	private ArrayList<ComboBox> tbcmbProductName=new ArrayList<ComboBox>();
	private ArrayList<TextField> tbtxtAmount=new ArrayList<TextField>();
	
	Table table;
	
	public Login(){
		this.setWidth("900px");
		this.setHeight("600px");
		this.center();
		this.setCaption("Login");
		this.setImmediate(true);
		this.setDraggable(true);
		this.setClosable(true);
		this.setResizable(true);
		this.setContent(buildMainLayout());
		btnAction();
	}
	public void btnAction(){
		btnLogin.addListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				loginAction();
			}
		});
	}
	private void loginAction(){
		getApplication().getMainWindow().setContent(buildRootLayout());
		this.close();
	}
	private AbsoluteLayout buildRootLayout(){
		rootLayout=new AbsoluteLayout();
		rootLayout.setSizeFull();
		RootMenu rm=new RootMenu();
		rootLayout.addComponent(rm, "top:0px;left:0px");
		
		return rootLayout;
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("90%");
		mainLayout.setHeight("90%");
		mainLayout.setImmediate(true);
		
		lblUserName=new Label("UserName :");
		mainLayout.addComponent(lblUserName, "top:20px;left:20px");
		
		txtUserName=new TextField();
		txtUserName.setWidth("-1px");
		txtUserName.setHeight("25px");
		txtUserName.setInputPrompt("Username");
		txtUserName.setImmediate(true);
		mainLayout.addComponent(txtUserName, "top:20px;left:90px");
		
		lblPassword=new Label("Password :");
		mainLayout.addComponent(lblPassword, "top:60px;left:20px");
		
		txtPassword=new PasswordField();
		txtPassword.setWidth("-1px");
		txtPassword.setHeight("25px");
		txtPassword.setInputPrompt("Password");
		txtPassword.setImmediate(true);
		mainLayout.addComponent(txtPassword, "top:60px;left:90px");
		
		lblPop=new Label("PopupDate :");
		mainLayout.addComponent(lblPop, "top:100px;left:20px");
		
		datePop=new PopupDateField();
		datePop.setWidth("-1px");
		datePop.setHeight("-1px");
		datePop.setImmediate(true);
		datePop.setDateFormat("dd-MM-yyyy");
		datePop.setValue(new Date());
		datePop.setResolution(PopupDateField.RESOLUTION_DAY);
		mainLayout.addComponent(datePop, "top:100px;left:90px");
		
		lblInline=new Label("InlineDate :");
		mainLayout.addComponent(lblInline, "top:140px;left:20px");
		
		dateInline=new InlineDateField();
		dateInline.setWidth("-1px");
		dateInline.setHeight("-1px");
		dateInline.setImmediate(true);
		dateInline.setDateFormat("dd-MM-yyyy");
		dateInline.setValue(new Date());
		dateInline.setResolution(InlineDateField.RESOLUTION_SEC);
		mainLayout.addComponent(dateInline, "top:140px;left:90px");
		
		lblComboBox=new Label("ComboBox :");
		mainLayout.addComponent(lblComboBox, "top:320px;left:20px");
		
		cmb=new ComboBox();
		cmb.setWidth("-1px");
		cmb.setHeight("-1px");
		cmb.setImmediate(true);
		cmb.setInputPrompt("Select please");
		cmb.setNewItemsAllowed(true);
		cmb.setNullSelectionAllowed(false);
		cmb.setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		mainLayout.addComponent(cmb, "top:320px;left:90px");
		
		lblNetiveSelect=new Label("NetiveSelect :");
		mainLayout.addComponent(lblNetiveSelect, "top:360px;left:20px");
		
		cmbNetive=new NativeSelect();
		cmbNetive.setWidth("180px");
		cmbNetive.setHeight("25px");
		cmbNetive.setImmediate(true);
		mainLayout.addComponent(cmbNetive, "top:360px;left:95px");
		
		lblRadioButton=new Label("RadioButton :");
		mainLayout.addComponent(lblRadioButton, "top:400px;left:20px");
		
		optionGrp=new OptionGroup("", radio);
		optionGrp.select("One");
		optionGrp.setStyleName("Vertical");
		mainLayout.addComponent(optionGrp, "top:400px;left:95px");
		
		lblCheckBox=new Label("CheckBox :");
		mainLayout.addComponent(lblCheckBox, "top:460px;left:20px");
		
		chk1=new CheckBox("One");
		chk1.setWidth("-1px");
		chk1.setHeight("-1px");
		chk1.setImmediate(true);
		mainLayout.addComponent(chk1, "top:460px;left:95px");
		
		chk2=new CheckBox("Two");
		chk2.setWidth("-1px");
		chk2.setHeight("-1px");
		chk2.setImmediate(true);
		mainLayout.addComponent(chk2, "top:480px;left:95px");
		
		chk3=new CheckBox("Three");
		chk3.setWidth("-1px");
		chk3.setHeight("-1px");
		chk3.setImmediate(true);
		mainLayout.addComponent(chk3, "top:500px;left:95px");
		
		btnLogin=new NativeButton("Login");
		btnLogin.setWidth("150px");
		btnLogin.setHeight("30px");
		btnLogin.setImmediate(true);
		mainLayout.addComponent(btnLogin, "top:250px;left:300px");
		
		lblTable=new Label("Table :");
		mainLayout.addComponent(lblTable, "top:20px;left:400px");
		
		table=new Table();
		table.setWidth("400px");
		table.setHeight("180px");
		table.setColumnCollapsingAllowed(true);
		table.setFooterVisible(true);
		mainLayout.addComponent(table, "top:40px;left:400px;");
		
		table.addContainerProperty("SL", Label.class, new Label());
		table.setColumnWidth("Sl", 10);
		
		table.addContainerProperty("Product Id", TextField.class, new TextField());
		table.setColumnWidth("Product Id", 100);
		
		table.addContainerProperty("Product Name", ComboBox.class, new ComboBox());
		table.setColumnWidth("Product Name", 120);
		
		table.addContainerProperty("Price", TextField.class, new TextField());
		table.setColumnWidth("Price", 100);
		
		tableRowIni();
		
		return mainLayout;
	}
	private void tableRowIni(){
		for(int i=0; i<=9; i++){
			tableRowAdd(i);
		}
	}
	private void tableRowAdd(int i){
		tblblSl.add(i, new Label());
		tblblSl.get(i).setWidth("100%");
		tblblSl.get(i).setValue(i+1);
		
		tbtxtProductId.add(i, new TextField());
		tbtxtProductId.get(i).setWidth("100%");
		tbtxtProductId.get(i).setImmediate(true);
		
		tbcmbProductName.add(i, new ComboBox());
		tbcmbProductName.get(i).setWidth("100%");
		tbcmbProductName.get(i).setImmediate(true);
		
		tbtxtAmount.add(i, new TextField());
		tbtxtAmount.get(i).setWidth("100%");
		tbtxtAmount.get(i).setImmediate(true);
		
		table.addItem(new Object[]{tblblSl.get(i),tbtxtProductId.get(i),tbcmbProductName.get(i),
				tbtxtAmount.get(i)},i);
	}
	
}
