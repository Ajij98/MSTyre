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
import com.vaadin.terminal.ThemeResource;
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
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
public class CreateSubGroup extends Window{

	private AbsoluteLayout mainLayout;

	CommonButton commonButton = new CommonButton("New", "Save", "Edit", "Delete", "Refresh", "", 
			"", "", "","");

	private ComboBox cmbGroup;
	private NativeButton btnGroup; 
	private List<String> rd=Arrays.asList("All","Assets","Liabilities","Income","Expenses");
	private OptionGroup optionGrp;
	private ListSelect subGroupList;
	private TextField txtSubGroupName;

	public CreateSubGroup()
	{
		this.setWidth("860px");
		this.setHeight("430px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("CREATE SUB-GROUP :: M. S. TYRE HOUSE");
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

		cmbGroup = new ComboBox("Group :");
		cmbGroup.setImmediate(true);
		cmbGroup.setWidth("300px");
		cmbGroup.setNullSelectionAllowed(false);
		cmbGroup.setNewItemsAllowed(false);
		mainLayout.addComponent(cmbGroup, "top:170px; left:30px;");
		
		btnGroup = new NativeButton();
		btnGroup.setImmediate(true);
		btnGroup.setWidth("28px");
		btnGroup.setHeight("24px");
		btnGroup.setIcon(new ThemeResource("./icons/add.png"));
		mainLayout.addComponent(btnGroup,"top:170px;left:335px;");
		
		subGroupList = new ListSelect("Group List :");
		subGroupList.setImmediate(true);
		subGroupList.setNullSelectionAllowed(false);
		subGroupList.setNewItemsAllowed(false);
		subGroupList.setHeight("140px");
		subGroupList.setWidth("300px");
		mainLayout.addComponent(subGroupList,"top:220px; left:30px;");
		
		mainLayout.addComponent(new Label("Sub-Group Name :"),"top:220px; left:350px;");
		txtSubGroupName=new TextField();
		txtSubGroupName.setImmediate(true);
		txtSubGroupName.setWidth("320px");
		txtSubGroupName.setHeight("-1px");
		mainLayout.addComponent(txtSubGroupName,"top:218px; left:460px;");

		mainLayout.addComponent(commonButton,"top:290px; left:350px;");
		commonButton.setStyleName("buttonStyle");

		return mainLayout;
	}
}