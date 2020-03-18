package com.common.share;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;

@SuppressWarnings("serial")
public class CommonButton extends HorizontalLayout
{
	public NativeButton btnNew = new NativeButton("New");
	public NativeButton btnEdit = new NativeButton("Edit");
	public NativeButton btnSave = new NativeButton("Save");
	public NativeButton btnRefresh = new NativeButton("Refresh");
	public NativeButton btnDelete = new NativeButton("Delete");
	public NativeButton btnFind = new NativeButton("Find");
	public NativeButton btnCancel = new NativeButton("Cancel");
	public NativeButton btnPreview = new NativeButton("Preview");
	public NativeButton btnChequePrint = new NativeButton("CQ Print");
	public NativeButton btnExit = new NativeButton("Exit");

	public CommonButton(String New, String Save, String Edit, String Delete, String Refresh,
			String Find, String Cancel, String Preview, String ChequePrint,String Exit)
	{
		setSpacing(true);	 
		if(New.equals("New"))
		{
			buttonsize(btnNew);			
			btnNew.setIcon(new ThemeResource("./btnIcons/new.png"));			
			addComponent(btnNew);			
		}
		if(Save.equals("Save"))
		{
			buttonsize(btnSave);
			btnSave.setIcon(new ThemeResource("./btnIcons/add.png"));
			addComponent(btnSave);
		}
		if(Edit.equals("Edit"))
		{
			buttonsize(btnEdit);	
			btnEdit.setIcon(new ThemeResource("./btnIcons/edit.png"));
			addComponent(btnEdit);
		}
		if(Delete.equals("Delete"))
		{
			buttonsize(btnDelete);
			btnDelete.setIcon(new ThemeResource("./btnIcons/delete.png"));
			addComponent(btnDelete);
		}
		if(Refresh.equals("Refresh"))
		{
			buttonsize(btnRefresh);
			btnRefresh.setIcon(new ThemeResource("./btnIcons/refresh.png"));
			addComponent(btnRefresh);
		}
		if(Find.equals("Find"))
		{
			buttonsize(btnFind);
			btnFind.setIcon(new ThemeResource("./btnIcons/find.png"));
			addComponent(btnFind);
		}
		if(Cancel.equals("Cancel"))
		{
			buttonsize(btnCancel);
			btnCancel.setIcon(new ThemeResource("./btnIcons/cancel.png"));
			addComponent(btnCancel);
		}
		if(Preview.equals("Preview"))
		{
			buttonsize(btnPreview);
			btnPreview.setIcon(new ThemeResource("./icons/preview.png"));
			addComponent(btnPreview);
		}
		if(ChequePrint.equals("CQ Print"))
		{
			btnChequePrint.setWidth("90px");
			btnChequePrint.setHeight("28px");
			btnChequePrint.setIcon(new ThemeResource("./icons/print.png"));
			addComponent(btnChequePrint);
		}
		if(Exit.equals("Exit"))
		{
			buttonsize(btnExit);
			btnExit.setIcon(new ThemeResource("./btnIcons/exit.png"));
			addComponent(btnExit);
		}
	}

	private void buttonsize(Button btn)
	{
		btn.setWidth("85px");
		btn.setHeight("28px");
	}
}