package com.commmon.setup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.AmountField;
import com.common.share.AmountCommaSeperator;
import com.common.share.CommonButton;
import com.common.share.MessageBox;
import com.common.share.SessionFactoryUtil;
import com.common.share.MessageBox.ButtonType;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.Notification;

public class UserCreate extends Window{

	AbsoluteLayout mainLayout;
	
	Label lblUserName,lblPassword,lblConfirmPass,lblEmailId,lblMobileNo,lblUserType,
	lblEditDeleteLimit,lblDays,lblActive;

	private TextField txtUserName,txtEmailId,txtMobileNo;
	private PasswordField txtPassword,txtConfirmPass;
	private ComboBox cmbUserType;
	private NativeSelect cmbActive;
	private AmountField txtEditDeleteDays;
	
	private ArrayList<Label> tblblId=new ArrayList<Label>();
	private ArrayList<CheckBox> tbchkSel=new ArrayList<CheckBox>();
	private ArrayList<Label> tblblModuleName=new ArrayList<Label>();
	
	private Table table;
	
	private ListSelect listFind;

	CommonButton commonButton=new CommonButton("New", "Save", "Edit", "Delete", "Refresh", 
			"", "", "", "", "");
	
	public UserCreate(){
		this.setWidth("800px");
		this.setHeight("315px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("USER CREATE :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setImmediate(true);

		listFind = new ListSelect();
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(true);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		listFind.setHeight("245px");
		listFind.setWidth("170px");
		mainLayout.addComponent(listFind,"top:15px; left:10px;");
		
		lblUserName=new Label("User Name :");
		mainLayout.addComponent(lblUserName, "top:16px;left:205px");
		
		txtUserName=new TextField();
		txtUserName.setWidth("175px");
		txtUserName.setHeight("25px");
		txtUserName.setImmediate(true);
		mainLayout.addComponent(txtUserName, "top:13px;left:315px");
		
		lblPassword=new Label("Password :");
		mainLayout.addComponent(lblPassword, "top:42px;left:205px");
		
		txtPassword=new PasswordField();
		txtPassword.setWidth("175px");
		txtPassword.setHeight("25px");
		txtPassword.setImmediate(true);
		mainLayout.addComponent(txtPassword, "top:39px;left:315px");
		
		lblConfirmPass=new Label("Confirm Password :");
		mainLayout.addComponent(lblConfirmPass, "top:68px;left:205px");
		
		txtConfirmPass=new PasswordField();
		txtConfirmPass.setWidth("175px");
		txtConfirmPass.setHeight("25px");
		txtConfirmPass.setImmediate(true);
		mainLayout.addComponent(txtConfirmPass, "top:65px;left:315px");
		
		lblEmailId=new Label("Email Id :");
		mainLayout.addComponent(lblEmailId, "top:94px;left:205px");
		
		txtEmailId=new TextField();
		txtEmailId.setWidth("210px");
		txtEmailId.setHeight("25px");
		txtEmailId.setInputPrompt("abdc123@gmail.com");
		txtEmailId.setImmediate(true);
		mainLayout.addComponent(txtEmailId, "top:91px;left:315px");
		
		lblMobileNo=new Label("Mobile :");
		mainLayout.addComponent(lblMobileNo, "top:120px;left:205px");
		
		txtMobileNo=new TextField();
		txtMobileNo.setWidth("175px");
		txtMobileNo.setHeight("25px");
		txtMobileNo.setInputPrompt("+88018********");
		txtMobileNo.setImmediate(true);
		mainLayout.addComponent(txtMobileNo, "top:117px;left:315px");
		
		lblUserType=new Label("User Type :");
		mainLayout.addComponent(lblUserType, "top:146px;left:205px");
		
		cmbUserType=new ComboBox();
		cmbUserType.setWidth("175px");
		cmbUserType.setHeight("25px");
		cmbUserType.setImmediate(true);
		cmbUserType.addItem("General");
		cmbUserType.addItem("Admin");
		cmbUserType.addItem("Super Admin");
		cmbUserType.select("General");
		mainLayout.addComponent(cmbUserType, "top:143px;left:315px");
		
		lblEditDeleteLimit=new Label("Edit/Delete Limit :");
		mainLayout.addComponent(lblEditDeleteLimit, "top:172px;left:205px");
		
		txtEditDeleteDays=new AmountField();
		txtEditDeleteDays.setWidth("50px");
		txtEditDeleteDays.setHeight("25px");
		txtEditDeleteDays.setImmediate(true);
		mainLayout.addComponent(txtEditDeleteDays, "top:169px;left:315px");
		
		lblDays=new Label("Days");
		mainLayout.addComponent(lblDays, "top:172px;left:370px");
		
		lblActive=new Label("Active :");
		mainLayout.addComponent(lblActive, "top:198px;left:205px");
		
		cmbActive=new NativeSelect();
		cmbActive.setWidth("110px");
		cmbActive.setHeight("25px");
		cmbActive.setImmediate(true);
		cmbActive.addItem("1");
		cmbActive.addItem("0");
		cmbActive.setItemCaption("1", "Active");
		cmbActive.setItemCaption("0", "Inactive");
		cmbActive.setValue("1");
		mainLayout.addComponent(cmbActive, "top:195px;left:315px");

		mainLayout.addComponent(commonButton, "top:230px;left:250px");
		commonButton.setStyleName("buttonStyle");
		
		table=new Table();
		table.setWidth("250px");
		table.setHeight("207px");
		table.setColumnCollapsingAllowed(true);
		table.setFooterVisible(false);
		
		table.addContainerProperty("Id", Label.class, new Label());
		table.setColumnWidth("Id", 50);	
		table.setColumnCollapsed("Id", true);
		
		table.addContainerProperty("Sel", CheckBox.class, new CheckBox());
		table.setColumnWidth("Sel", 30);
		
		table.addContainerProperty("Module Name", Label.class, new Label());
		table.setColumnWidth("Module Name", 190);
		
		mainLayout.addComponent(table,"top:13px; right:5px;");
		tableRowIni();

		return  mainLayout;
	}
	private void tableRowIni(){
		for(int a=0; a<=6; a++){
			tableRowAdd(a);
		}
	}
	private void tableRowAdd(int a){
		tblblId.add(a, new Label());
		tblblId.get(a).setWidth("100%");
		tblblId.get(a).setValue(a);
		tblblId.get(a).setImmediate(true);
		
		tbchkSel.add(a, new CheckBox());
		tbchkSel.get(a).setWidth("100%");
		tbchkSel.get(a).setImmediate(true);
		
		tblblModuleName.add(a, new Label());
		tblblModuleName.get(a).setWidth("100%");
		tblblModuleName.get(a).setImmediate(true);
		
		table.addItem(new Object[]{tblblId.get(a),tbchkSel.get(a),tblblModuleName.get(a)},a);
	}
}
