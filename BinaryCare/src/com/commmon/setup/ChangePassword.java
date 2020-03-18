package com.commmon.setup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.common.share.CommonButton;
import com.vaadin.data.Property.*;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class ChangePassword extends Window{
	
	AbsoluteLayout mainLayout;
	
	Label lblUserName,lblPresentPassword,lblNewPassword,lblConfirmNewPass,lblUser;

	private PasswordField txtPresentPassword, txtNewPassword,txtConfirmNewPass;

	CommonButton commonButton=new CommonButton("", "", "Edit", "Delete", "", 
			"", "", "", "", "");

	public ChangePassword(){
		this.setWidth("500px");
		this.setHeight("280px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.setCloseShortcut(KeyCode.ESCAPE);
		this.setCaption("CHANGE PASSWORD :: M. S. TYRE HOUSE");
		this.center();
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		lblUserName=new Label("User Name :");
		mainLayout.addComponent(lblUserName, "top:40px;left:60px");
		
		lblUser=new Label("Admin");
		mainLayout.addComponent(lblUser, "top:40px;left:210px");
		
		lblPresentPassword=new Label("Present Password :");
		mainLayout.addComponent(lblPresentPassword, "top:70px;left:60px");
		
		txtPresentPassword=new PasswordField();
		txtPresentPassword.setWidth("250px");
		txtPresentPassword.setHeight("25px");
		txtPresentPassword.setImmediate(true);
		mainLayout.addComponent(txtPresentPassword, "top:67px;left:210px");
		
		lblNewPassword=new Label("New Password :");
		mainLayout.addComponent(lblNewPassword, "top:100px;left:60px");
		
		txtNewPassword=new PasswordField();
		txtNewPassword.setWidth("250px");
		txtNewPassword.setHeight("25px");
		txtNewPassword.setImmediate(true);
		mainLayout.addComponent(txtNewPassword, "top:97px;left:210px");
		
		lblConfirmNewPass=new Label("Confirm New Password :");
		mainLayout.addComponent(lblConfirmNewPass, "top:130px;left:60px");
		
		txtConfirmNewPass=new PasswordField();
		txtConfirmNewPass.setWidth("250px");
		txtConfirmNewPass.setHeight("25px");
		txtConfirmNewPass.setImmediate(true);
		mainLayout.addComponent(txtConfirmNewPass, "top:127px;left:210px");
		
		mainLayout.addComponent(commonButton, "top:180px;left:160px");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}
}
