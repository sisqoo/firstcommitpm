package com.am.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Tproduct;
import com.am.service.ProductService;

//http://localhost:8181/user/userList
@RestController
@RequestMapping("/product")
public class ProductResource {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tproduct> productList() {
		return productService.findAll();
	}
	// commented
	/*
	 * @RequestMapping(value = "/productlistquery", method = RequestMethod.GET)
	 * 
	 * @CrossOrigin public List<Tproduct> productQuery(@RequestBody Tproduct
	 * tproduct) { return productService.findQuery(tproduct); }
	 */

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tproduct geTproduct(@RequestParam(required = false, value = "id") Long id,@RequestParam(required = false, value = "nameproduct") String nameproduct) {
		if(nameproduct!=null)
			return productService.findByNameproduct(nameproduct);
		else if (id != null)
			return productService.findByIdproduct(id);
		return null;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tproduct> save(@RequestBody Tproduct tproduct) {
		Tproduct tproductsave = productService.save(tproduct);
		return new ResponseEntity<Tproduct>(tproductsave, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		productService.delete(id);
	}

}
