package com.common.Account_Setup;

import java.util.Date;

import com.common.share.CommonButton;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class Narration extends Window{
	
	private AbsoluteLayout mainLayout;
	
	private Label lblNarrationId,lblVoucherType,lblNarration;
	
	private NativeSelect narrationId;
	private NativeSelect voucherType;
	private TextField txtNarration;
	
	CommonButton commonButton = new CommonButton("New", "Save", "Edit", "Delete", "Refresh", "",
			"", "", "","");

	public Narration() {
		this.setWidth("500px");
		this.setHeight("250px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("NARRATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");

		lblNarrationId = new Label("Narration ID :");
		lblNarrationId.setImmediate(true);
		lblNarrationId.setWidth("-1px");
		lblNarrationId.setHeight("-1px");
		mainLayout.addComponent(lblNarrationId, "top:22px;left:90px;");

		narrationId = new NativeSelect();
		narrationId.setImmediate(true);
		narrationId.setWidth("230px");
		narrationId.setHeight("-1px");
		narrationId.setNullSelectionAllowed(true);
		mainLayout.addComponent(narrationId, "top:22px;left:180px;");

		lblVoucherType = new Label("Voucher Type :");
		lblVoucherType.setImmediate(true);
		lblVoucherType.setWidth("-1px");
		lblVoucherType.setHeight("-1px");
		mainLayout.addComponent(lblVoucherType, "top:47px;left:90px;");

		voucherType = new NativeSelect();
		voucherType.setImmediate(true);
		voucherType.setWidth("230px");
		voucherType.setHeight("-1px");
		voucherType.setNullSelectionAllowed(true);
		mainLayout.addComponent(voucherType, "top:47px;left:180px;");

		lblNarration = new Label("Narration :");
		lblNarration.setImmediate(true);
		lblNarration.setWidth("-1px");
		lblNarration.setHeight("-1px");
		mainLayout.addComponent(lblNarration, "top:72px;left:90px;");

		txtNarration = new TextField();
		txtNarration.setImmediate(true);
		txtNarration.setWidth("230px");
		txtNarration.setHeight("48px");
		mainLayout.addComponent(txtNarration,"top:72px;left:180px;");

		mainLayout.addComponent(commonButton, "top:150px;left:25px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}

}
