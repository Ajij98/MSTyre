package common.common.setupReport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.common.share.CommonButton;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Window;

public class SupplierReport extends Window{
	
	AbsoluteLayout mainLayout;
	
	Label lblSupplierName;
	ComboBox cmbSupplierName;
	CheckBox chkAll;
	List<String> rd=Arrays.asList("PDF","Other");
	OptionGroup optionGrp;
	
	CommonButton commonButton=new CommonButton("", "", "", "", "", "", "", "Preview", "", "Exit");

	public SupplierReport(){
		this.setWidth("440px");
		this.setHeight("180px");
		this.setClosable(true);
		this.setModal(false);
		this.setResizable(false);
		this.setCaption("SUPPLIER REPORT :: M. S. TYRE HOUSE");
		this.setImmediate(true);
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout() {
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("420px");
		mainLayout.setHeight("140px");
		mainLayout.setImmediate(true);
		
		lblSupplierName=new Label("Supplier Name :");
		mainLayout.addComponent(lblSupplierName, "top:15px;left:20px");
		
		cmbSupplierName=new ComboBox();
		cmbSupplierName.setWidth("250px");
		cmbSupplierName.setHeight("25px");
		cmbSupplierName.setImmediate(true);
		mainLayout.addComponent(cmbSupplierName, "top:13px;left:110px");
		
		chkAll=new CheckBox("All");
		chkAll.setWidth("-1px");
		chkAll.setHeight("-1px");
		chkAll.setImmediate(true);
		mainLayout.addComponent(chkAll, "top:15px;left:370px");
		
		optionGrp=new OptionGroup("", rd);
		optionGrp.setImmediate(true);
		optionGrp.setValue("PDF");
		mainLayout.addComponent(optionGrp, "top:45;left:105px");
		optionGrp.setStyleName("radioButton");
		
		mainLayout.addComponent(commonButton, "top:95;left:130px");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}
}
