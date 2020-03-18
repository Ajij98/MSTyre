package com.example.binarycare;

import com.common.share.Login;
import com.vaadin.Application;
import com.vaadin.data.Property.*;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.*;

public class BinarycareApplication extends Application {
	
	/*Label label = new Label("Hello Vaadin user");
	Button btnOk=new Button("ok");
	TextField txtUserName=new TextField("UserName:");
	TextField txtPassword=new TextField("Password:");*/

	public void init() {
		Window mainWindow = new Window("Binarycare Application");
		setMainWindow(mainWindow);
		Login lg=new Login();
		mainWindow.addWindow(lg);
		setTheme("binarycaretheme");
		
		/*mainWindow.addComponent(label);
		mainWindow.addComponent(btnOk);
		mainWindow.addComponent(txtUserName);
		txtUserName.setImmediate(true);
		mainWindow.addComponent(txtPassword);
		txtPassword.setImmediate(true);
		txtPassword.setSecret(true);
		//btnAction();*/	
	}
	/*private void btnAction(){
		btnOk.addListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				mainWindow.showNotification("Button is clicked", Notification.TYPE_WARNING_MESSAGE);
			}
		});
		txtUserName.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				mainWindow.showNotification("Value is:"+txtUserName.getValue(), Notification.TYPE_HUMANIZED_MESSAGE);
			}
		});
		txtPassword.addListener(new TextChangeListener() {
			public void textChange(TextChangeEvent event) {
				mainWindow.showNotification("Value is:"+event.getText(), Notification.TYPE_TRAY_NOTIFICATION); 
			}
		});
	}*/
}

