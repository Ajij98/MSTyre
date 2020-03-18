package com.common.poAndSalesSetup;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.common.share.AmountField;
import com.common.share.CommonButton;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class ProductInfo extends Window{

	AbsoluteLayout mainLayout;

	private ComboBox cmbProductNameFind=new ComboBox("Product Name");

	private ListSelect listFind;

	private PopupDateField popDate;
	private ComboBox cmbBrandName,cmbCatName,cmbSubcatName,cmbSize,cmbPattern,cmbType,cmbUnit;
	private NativeButton nbBrandName,nbCategory,nbsubcategory,nbSize,nbPattern,nbType;
	private TextField txtProductCode,txtProductName;
	private AmountField amtDealerPrice,amtTradePrice;
	private List<String> rd=Arrays.asList("Active","Inactive");
	OptionGroup optionGrp;

	CommonButton commonButton=new CommonButton("New", "Save", "Edit", "", "Refresh", "Find", "",
			"", "", "Exit");

	public ProductInfo(){
		this.setWidth("780px");
		this.setHeight("530px");
		this.setClosable(true);
		this.setDraggable(true);
		this.setResizable(false);
		this.setModal(false);
		this.center();
		this.setCaption("PRODUCT INFORMATION :: M. S. TYRE HOUSE");
		this.setContent(buildMainLayout());
	}
	private AbsoluteLayout buildMainLayout(){
		mainLayout=new AbsoluteLayout();
		mainLayout.setWidth("750px");
		mainLayout.setHeight("490px");
		mainLayout.setImmediate(true);

		cmbProductNameFind.setWidth("220px");
		cmbProductNameFind.setHeight("25px");
		cmbProductNameFind.setImmediate(true);
		mainLayout.addComponent(cmbProductNameFind,"top:20.0px; left:20.0px");

		listFind = new ListSelect();
		listFind.setHeight("360px");
		listFind.setWidth("220px");
		listFind.setImmediate(true);
		listFind.setNullSelectionAllowed(false);
		listFind.setNewItemsAllowed(false);
		listFind.setDescription("Select to update information.");
		mainLayout.addComponent(listFind,"top:50.0px; left:20.0px;");

		mainLayout.addComponent(new Label("Date :"),"top:30.0px; left:250.0px;");
		popDate = new PopupDateField();
		popDate.setImmediate(true);
		popDate.setWidth("110px");
		popDate.setHeight("-1px");
		popDate.setDateFormat("yyyy-MM-dd");
		popDate.setData(new Date());
		mainLayout.addComponent(popDate,"top:28.0px; left:370.0px;");

		mainLayout.addComponent(new Label("Brand Name :"),"top:60px;left:250.0px;");
		cmbBrandName = new ComboBox();
		cmbBrandName.setWidth("250px");
		cmbBrandName.setHeight("-1px");
		cmbBrandName.setImmediate(true);
		mainLayout.addComponent(cmbBrandName,"top:58.0px; left:370.0px;");

		nbBrandName = new NativeButton();
		nbBrandName.setIcon(new ThemeResource("./icons/add.png"));
		nbBrandName.setImmediate(true);
		nbBrandName.setWidth("30px");
		nbBrandName.setHeight("23px");
		mainLayout.addComponent(nbBrandName, "top:58.0px;left:625.0px;");

		mainLayout.addComponent(new Label("Category Name :"),"top:90px;left:250.0px;");
		cmbCatName = new ComboBox();
		cmbCatName.setWidth("250px");
		cmbCatName.setHeight("-1px");
		cmbCatName.setImmediate(true);
		mainLayout.addComponent(cmbCatName,"top:88.0px; left:370.0px;");

		nbCategory = new NativeButton();
		nbCategory.setIcon(new ThemeResource("./icons/add.png"));
		nbCategory.setImmediate(true);
		nbCategory.setWidth("30px");
		nbCategory.setHeight("23px");
		mainLayout.addComponent(nbCategory, "top:88.0px;left:625.0px;");

		mainLayout.addComponent(new Label("Sub-Category Name :"),"top:120px;left:250.0px;");
		cmbSubcatName = new ComboBox();
		cmbSubcatName.setWidth("250px");
		cmbSubcatName.setHeight("-1px");
		cmbSubcatName.setImmediate(true);
		mainLayout.addComponent(cmbSubcatName,"top:118.0px; left:370.0px;");

		nbsubcategory = new NativeButton();
		nbsubcategory.setIcon(new ThemeResource("./icons/add.png"));
		nbsubcategory.setImmediate(true);
		nbsubcategory.setWidth("30px");
		nbsubcategory.setHeight("23px");
		mainLayout.addComponent(nbsubcategory, "top:118.0px;left:625.0px;");

		mainLayout.addComponent(new Label("Size :"),"top:150px;left:250.0px;");
		cmbSize = new ComboBox();
		cmbSize.setWidth("250px");
		cmbSize.setHeight("-1px");
		cmbSize.setImmediate(true);
		mainLayout.addComponent(cmbSize,"top:148.0px; left:370.0px;");
		
		nbSize = new NativeButton();
		nbSize.setIcon(new ThemeResource("./icons/add.png"));
		nbSize.setImmediate(true);
		nbSize.setWidth("30px");
		nbSize.setHeight("23px");
		mainLayout.addComponent(nbSize, "top:148.0px;left:625.0px;");
		
		mainLayout.addComponent(new Label("Pattern :"),"top:180px;left:250.0px;");
		cmbPattern = new ComboBox();
		cmbPattern.setWidth("250px");
		cmbPattern.setHeight("-1px");
		cmbPattern.setImmediate(true);
		mainLayout.addComponent(cmbPattern,"top:178.0px; left:370.0px;");
		
		nbPattern = new NativeButton();
		nbPattern.setIcon(new ThemeResource("./icons/add.png"));
		nbPattern.setImmediate(true);
		nbPattern.setWidth("30px");
		nbPattern.setHeight("23px");
		mainLayout.addComponent(nbPattern, "top:178.0px;left:625.0px;");
		
		mainLayout.addComponent(new Label("Type :"),"top:210px;left:250.0px;");
		cmbType = new ComboBox();
		cmbType.setWidth("250px");
		cmbType.setHeight("-1px");
		cmbType.setImmediate(true);
		mainLayout.addComponent(cmbType,"top:208.0px; left:370.0px;");
		
		nbType = new NativeButton();
		nbType.setIcon(new ThemeResource("./icons/add.png"));
		nbType.setImmediate(true);
		nbType.setWidth("30px");
		nbType.setHeight("23px");
		mainLayout.addComponent(nbType, "top:208.0px;left:625.0px;");
		
		mainLayout.addComponent(new Label("Product Code :"),"top:240px;left:250.0px;");
		txtProductCode = new TextField();
		txtProductCode.setImmediate(true);
		txtProductCode.setWidth("110px");
		txtProductCode.setHeight("-1px");
		mainLayout.addComponent(txtProductCode,"top:238.0px; left:370.0px;");
		
		mainLayout.addComponent(new Label("Product Name :"),"top:270px;left:250.0px;");
		txtProductName = new TextField();
		txtProductName.setImmediate(true);
		txtProductName.setWidth("350px");
		txtProductName.setHeight("-1px");
		mainLayout.addComponent(txtProductName,"top:268.0px; left:370.0px;");

		mainLayout.addComponent(new Label("Unit :"),"top:300px;left:250.0px;");
		cmbUnit = new ComboBox();
		cmbUnit.setWidth("110px");
		cmbUnit.setHeight("-1px");
		cmbUnit.setImmediate(true);
		cmbUnit.setNullSelectionAllowed(true);
		cmbUnit.addItem("Pcs");
		cmbUnit.addItem("Dozon");
		mainLayout.addComponent(cmbUnit,"top:298.0px; left:370.0px;");
		
		mainLayout.addComponent(new Label("Dealer Price(DP) :"),"top:330px;left:250.0px;");
		amtDealerPrice = new AmountField();
		amtDealerPrice.setWidth("110px");
		amtDealerPrice.setHeight("-1px");
		amtDealerPrice.setImmediate(true);
		mainLayout.addComponent(amtDealerPrice,"top:328.0px; left:370.0px;");
		
		mainLayout.addComponent(new Label("Trade Price(TP) :"),"top:360px;left:250.0px;");
		amtTradePrice = new AmountField();
		amtTradePrice.setWidth("110px");
		amtTradePrice.setHeight("-1px");
		amtTradePrice.setImmediate(true);
		mainLayout.addComponent(amtTradePrice,"top:358.0px; left:370.0px;");

		mainLayout.addComponent(new Label("Status :"),"top:390px;left:250.0px;");
		optionGrp=new OptionGroup("", rd);
		optionGrp.setImmediate(true);
		optionGrp.setValue("Active");
		optionGrp.setStyleName("horizontal");
		mainLayout.addComponent(optionGrp,"top:388.0px; left:370.0px;");
		
		mainLayout.addComponent(commonButton, "top:430.0px;left:120px;");
		commonButton.setStyleName("buttonStyle");
		
		return mainLayout;
	}
}
