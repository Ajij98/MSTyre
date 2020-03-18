package com.common.Account_Setup;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.share.CommonButton;
import com.common.share.MessageBox;
import com.common.share.SessionFactoryUtil;
import com.common.share.TextRead;
import com.common.share.MessageBox.ButtonType;
import com.common.share.MessageBox.EventListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class CreateGroup extends Window{

	private AbsoluteLayout mainLayout;

	CommonButton commonButton = new CommonButton("New", "Save", "Edit", "Delete", "Refresh", "", 
			"", "", "","");

	private ComboBox cmbPrimaryCat;
	private List<String> rd=Arrays.asList("All","Assets","Liabilities","Income","Expenses");
	private OptionGroup optionGrp;
	private ListSelect groupList;
	private TextField txtGroupName;

	public CreateGroup()
	{
		this.setWidth("860px");
		this.setHeight("430px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("CREATE GROUP :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("830px");
		mainLayout.setHeight("370px");

		optionGrp = new OptionGroup("",rd);
		optionGrp.setImmediate(true);
		optionGrp.setValue("All");
		mainLayout.addComponent(optionGrp, "top:40px;left:30px;");

		cmbPrimaryCat = new ComboBox("Primary Category :");
		cmbPrimaryCat.setImmediate(true);
		cmbPrimaryCat.setWidth("300px");
		cmbPrimaryCat.setNullSelectionAllowed(false);
		cmbPrimaryCat.setNewItemsAllowed(false);
		mainLayout.addComponent(cmbPrimaryCat, "top:170px; left:30px;");
		
		groupList = new ListSelect("Group List :");
		groupList.setImmediate(true);
		groupList.setNullSelectionAllowed(false);
		groupList.setNewItemsAllowed(false);
		groupList.setHeight("140px");
		groupList.setWidth("300px");
		mainLayout.addComponent(groupList,"top:220px; left:30px;");
		
		mainLayout.addComponent(new Label("Group Name :"),"top:170px; left:350px;");
		txtGroupName=new TextField();
		txtGroupName.setImmediate(true);
		txtGroupName.setWidth("320px");
		txtGroupName.setHeight("-1px");
		mainLayout.addComponent(txtGroupName,"top:170px; left:430px;");

		mainLayout.addComponent(commonButton,"top:270px; left:350px;");
		commonButton.setStyleName("buttonStyle");

		return mainLayout;
	}
}