package cz.etn.etnshop.controller;

import cz.etn.etnshop.dao.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.validation.BindingResult;

import cz.etn.etnshop.service.ProductService;




@Controller
@RequestMapping("/product")
public class ProductController {

	private static String serialNumberErr="Nastala chyba. Prosím zadajte číslo";

	@Autowired
	private ProductService productService;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("product/list");
		modelAndView.addObject("products", productService.getProducts());
		return modelAndView;
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(value="query") String query) {
		ModelAndView modelAndView = new ModelAndView("product/list");
		modelAndView.addObject("products", productService.searchProducts(query));
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("product/form", "product", new Product());
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public ModelAndView showEditForm(@PathVariable(value="id") Integer id) {
		Product product = productService.getById(id);
		return new ModelAndView("product/form", "product", product);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submit(@ModelAttribute("product")Product product,
						 BindingResult result, ModelMap model) {
		System.out.println(product);
		if (result.hasErrors()) {
			if(product.getSerialNumber() == null)
				model.addAttribute("serialNumberErr",ProductController.serialNumberErr);
			return "product/form";
		}

		productService.saveProduct(product);
		return "redirect:/product/list";
	}






}
