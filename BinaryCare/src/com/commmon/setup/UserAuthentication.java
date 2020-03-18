package com.commmon.setup;

import java.util.ArrayList;

import com.common.share.CommonButton;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Window;

public class UserAuthentication extends Window{
	
	AbsoluteLayout mainLayout;
	
	private Label lblUserName;
	private ComboBox cmbUserName;
	
	private Panel panelUp = new Panel();
	private Tree menuTree;
	
	private Table table;
	
	private ArrayList<Label> tblblMenuId = new ArrayList<Label>();
	private ArrayList<Label> tblblEntryReportFormName = new ArrayList<Label>();
	private ArrayList<CheckBox> tbChkBlock = new ArrayList<CheckBox>();
	private ArrayList<CheckBox> tbChkUnBlock = new ArrayList<CheckBox>();
	private ArrayList<CheckBox> tbChkSave = new ArrayList<CheckBox>();
	private ArrayList<CheckBox> tbChkEdit = new ArrayList<CheckBox>();
	private ArrayList<CheckBox> tbChkDelete = new ArrayList<CheckBox>();
	private ArrayList<CheckBox> tbChkPreview = new ArrayList<CheckBox>();
	
	private CommonButton commonButton=new CommonButton("", "Save", "", "Delete", "Refresh", 
			"", "", "", "", "");

	public UserAuthentication(){
		this.setWidth("950px");
		this.setHeight("440px");
		this.center();
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.setCaption("USER AUTHENTICATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setImmediate(true);
		
		lblUserName=new Label("User Name :");
		mainLayout.addComponent(lblUserName, "top:20px;left:10px");
		
		cmbUserName=new ComboBox();
		cmbUserName.setWidth("210px");
		cmbUserName.setHeight("25px");
		cmbUserName.setImmediate(true);
		cmbUserName.setNewItemsAllowed(false);
		cmbUserName.setNullSelectionAllowed(true);
		cmbUserName.setInputPrompt("select username");
		mainLayout.addComponent(cmbUserName, "top:17px;left:85px");
		
		menuTree = new Tree();
		menuTree.setCaption("LIST OF MODULES");
		menuTree.setImmediate(true);
		menuTree.setWidth("100%");
		menuTree.setHeight("100%");
		//menuTree.setStyleName("aa");

		panelUp.setHeight("300px");
		panelUp.setWidth("280px");
		panelUp.setScrollable(true);
		panelUp.addComponent(menuTree);
		mainLayout.addComponent(panelUp, "top:50px; left:10px");
		
		table=new Table();
		table.setWidth("640px");
		table.setHeight("328px");
		table.setColumnCollapsingAllowed(true);
		table.setFooterVisible(false);
		
		table.addContainerProperty("MENU ID", Label.class, new Label(),null,null,Table.ALIGN_LEFT);
		table.setColumnWidth("MENU ID", 50);	
		table.setColumnCollapsed("MENU ID", true);
		
		table.addContainerProperty("ENTRY/REPORT FORM NAME", Label.class, new Label(),null,null,Table.ALIGN_LEFT);
		table.setColumnWidth("ENTRY/REPORT FORM NAME", 265);
		
		table.addContainerProperty("BLOCK", CheckBox.class, new CheckBox(),null,null,Table.ALIGN_LEFT);
		table.setColumnWidth("BLOCK", 40);
		
		table.addContainerProperty("UNBLOCK", CheckBox.class, new CheckBox(),null,null,Table.ALIGN_LEFT);
		table.setColumnWidth("UNBLOCK", 50);
		
		table.addContainerProperty("SAVE", CheckBox.class, new CheckBox(),null,null,Table.ALIGN_LEFT);
		table.setColumnWidth("SAVE", 40);
		
		table.addContainerProperty("EDIT", CheckBox.class, new CheckBox(),null,null,Table.ALIGN_LEFT);
		table.setColumnWidth("EDIT", 40);
		
		table.addContainerProperty("DELETE", CheckBox.class, new CheckBox(),null,null,Table.ALIGN_LEFT);
		table.setColumnWidth("DELETE", 40);
		
		table.addContainerProperty("PREVIEW", CheckBox.class, new CheckBox(),null,null,Table.ALIGN_LEFT);
		table.setColumnWidth("PREVIEW", 45);
		
		mainLayout.addComponent(table,"top:20px; right:5px;");
		tableRowIni();
		
		mainLayout.addComponent(commonButton, "bottom:13px; left:350px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
		
	}
	private void tableRowIni(){
		for(int a=0; a<=9; a++){
			tableRowAdd(a);
		}
	}
	private void tableRowAdd(int a){
		tblblMenuId.add(a, new Label());
		tblblMenuId.get(a).setWidth("100%");
		tblblMenuId.get(a).setImmediate(true);
		
		tblblEntryReportFormName.add(a, new Label());
		tblblEntryReportFormName.get(a).setWidth("100%");
		tblblEntryReportFormName.get(a).setImmediate(true);
		
		tbChkBlock.add(a, new CheckBox());
		tbChkBlock.get(a).setWidth("100%");
		tbChkBlock.get(a).setImmediate(true);
		
		tbChkUnBlock.add(a, new CheckBox());
		tbChkUnBlock.get(a).setWidth("100%");
		tbChkUnBlock.get(a).setImmediate(true);
		
		tbChkSave.add(a, new CheckBox());
		tbChkSave.get(a).setWidth("100%");
		tbChkSave.get(a).setImmediate(true);
		
		tbChkEdit.add(a, new CheckBox());
		tbChkEdit.get(a).setWidth("100%");
		tbChkEdit.get(a).setImmediate(true);
		
		tbChkDelete.add(a, new CheckBox());
		tbChkDelete.get(a).setWidth("100%");
		tbChkDelete.get(a).setImmediate(true);
		
		tbChkPreview.add(a, new CheckBox());
		tbChkPreview.get(a).setWidth("100%");
		tbChkPreview.get(a).setImmediate(true);
		
		table.addItem(new Object[]{tblblMenuId.get(a),tblblEntryReportFormName.get(a),
				tbChkBlock.get(a),tbChkUnBlock.get(a),tbChkSave.get(a),tbChkEdit.get(a),
				tbChkDelete.get(a),tbChkPreview.get(a)},a);
	}
	
}
