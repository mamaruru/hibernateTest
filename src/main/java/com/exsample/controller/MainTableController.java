package com.exsample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exsample.entity.MainTable;
import com.exsample.entity.MainTableId;
import com.exsample.service.MainTableService;

import com.exsample.entity.RefTable;
import com.exsample.entity.User;

@Controller
public class MainTableController {
	// Constructor based Dependency Injection
    private MainTableService mainTableService;

	public MainTableController() {

	}

	@Autowired
	public MainTableController(MainTableService mainTableService) {
		this.mainTableService = mainTableService;
	}

	// Get All Users
	@RequestMapping(value = "/allMainTables", method = RequestMethod.POST)
	public ModelAndView displayAllMainTables() {
		System.out.println("User Page Requested : All MainTables");
		ModelAndView mv = new ModelAndView();
		
		/*
		MainTable mainTable = new MainTable();
        mainTable.addRefTable(new RefTable());
        mainTable.addRefTable(new RefTable());		
        mainTableService.saveMainTable(mainTable);
        */
		
		List<MainTable> mainTableList = mainTableService.getAllMainTables();

		for (MainTable entry : mainTableList ) {
            System.out.println("MAIN :" + entry.getId() + " : " + entry.getSubId());
            
            List<RefTable> list = entry.getRefTables();
            for(RefTable ref: list) {
                System.out.println("Sub :" + ref.getRefId() + " : " + ref.getRefSubId());
            }
        }
		
		MainTableId pk = new MainTableId(new Long(1), new Long(1));
		MainTable mainT = mainTableService.getMainTableById(pk);
		
		if (mainT != null) {
        System.out.println("MAIN :" + mainT.getId() + " : " + mainT.getSubId());
        List<RefTable> list = mainT.getRefTables();
        for(RefTable ref: list) {
            System.out.println("Sub :" + ref.getRefId() + " : " + ref.getRefSubId());
        }
        
		}
		
		List<MainTableId> keys;
		keys = new ArrayList<MainTableId>();
		
		keys.add(new MainTableId(new Long(1), new Long(1)));
		mainTableList = mainTableService.getMainTableByIds(keys);
		
		for (MainTable entry : mainTableList ) {
            System.out.println("MAIN :" + entry.getId() + " : " + entry.getSubId());
            
            List<RefTable> list = entry.getRefTables();
            for(RefTable ref: list) {
                System.out.println("Sub :" + ref.getRefId() + " : " + ref.getRefSubId());
            }
        }
		
		
		mv.addObject("mainTableList", mainTableList);
		mv.setViewName("allMainTables");
		
		return mv;
	}


	@RequestMapping(value = "/addMainTable", method = RequestMethod.GET)
	public ModelAndView displayNewUserForm() {
		ModelAndView mv = new ModelAndView("addMainTable");
		mv.addObject("headerMessage", "Add MainTable Details");
		mv.addObject("mainTable", new MainTable());
		return mv;
	}

	@RequestMapping(value = "/addMainTable", method = RequestMethod.POST)
	public ModelAndView saveNewMainTable(@ModelAttribute MainTable mainTable, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/home");

		if (result.hasErrors()) {
			return new ModelAndView("error");
		}
		boolean isAdded = mainTableService.saveMainTable(mainTable);
		if (isAdded) {
			mv.addObject("message", "New mainTable successfully added");
		} else {
			return new ModelAndView("error");
		}

		return mv;
	}

}

