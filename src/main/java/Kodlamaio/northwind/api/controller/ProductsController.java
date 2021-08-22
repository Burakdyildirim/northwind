package Kodlamaio.northwind.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlamaio.northwind.business.abstracts.ProductService;
import Kodlamaio.northwind.core.utilities.results.DataResult;
import Kodlamaio.northwind.core.utilities.results.Result;
import Kodlamaio.northwind.entities.concretes.Product;
import Kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products/")
@CrossOrigin
public class ProductsController {
	
	
	private ProductService productService;
	
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}



	@GetMapping("getAll")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	@GetMapping("getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByProductNameAndCategory(productName, categoryId);
	}
	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("getByPage")
	public DataResult<List<Product>> getAll(@RequestParam int pageNo,@RequestParam int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	@GetMapping("getBySorted")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	@GetMapping("getProductWithCategoryDetail")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
}
