package com.tecsus.ddc.view.controller;

import com.tecsus.ddc.controller.service.WaterBillService;
import com.tecsus.ddc.controller.service.
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.bills.water.WaterBill;

public class WaterBillController {
	
	private WaterBillService service;
	private AbstractBillService absService;
	
	public WaterBillController() {
		this.service = new WaterBillService(new Connector());
		this.absService = new AbstractBillService(new Connector());
	}
	
	public void pushBill(WaterBill bill) {
		absService.insert(bill.getBill());
		service.insert(bill);
	}
}