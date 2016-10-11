package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryActivity;
import com.attozoic.categories.services.ServiceCategoryActivity;

@RestController
@RequestMapping("/categoryActivity")
public class ControllerCategoryActivity {

	@Autowired
	ServiceCategoryActivity serviceActivity;
	
	@RequestMapping(method=RequestMethod.GET)
	Page<CategoryActivity> getAllActivitiyCategories() {
		return serviceActivity.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	CategoryActivity addActivityCategory(@RequestBody CategoryActivity activity) {
		return serviceActivity.save(activity);
	}
		
}
