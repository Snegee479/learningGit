package com.example.appController;



import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.AdminDAO;
import com.example.dao.BuyerDAO;
import com.example.dao.CategoryDAO;
import com.example.dao.ProductDAO;
import com.example.dao.PurchaseListDAO;
import com.example.pojo.Admin;
import com.example.pojo.Buyer;
import com.example.pojo.Category;
import com.example.pojo.Product;
import com.example.pojo.PurchaseList;



@Controller
public class MainController {
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	BuyerDAO buyerDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	PurchaseListDAO pdao;
	@Autowired
	AdminDAO admindao;
	Logger logger=Logger.getAnonymousLogger();
	
	@RequestMapping("/insertCategory")
	public void insertCategory(HttpServletRequest req,HttpServletResponse res,@RequestParam("categoryName") String categoryName) throws IOException { 
	logger.info("inside controller's insertCategory method, the value of category name obtained from jsp is "+ categoryName);
	
	Category category=new Category();
	category.setCategoryName(categoryName);
	logger.info("created pojo and inserted values");
	categoryDAO.insert(category);
	
	logger.info("inserted successfully") ;
	res.sendRedirect("http://localhost:8080/getAllCategory");
	}
	@RequestMapping("/insertProducts")
	public void insert(HttpServletRequest req,HttpServletResponse res,@RequestParam("productName") String productName) throws IOException { 
		double productPrice=Double.parseDouble(req.getParameter("productPrice"));
		String productDescription=req.getParameter("productDescription");
		Category category=new Category();
		System.out.println(req.getParameter("categoryId"));
		logger.info("categoryId is "+req.getParameter("categoryId"));
		category=categoryDAO.findByCategoryId(Integer.parseInt(req.getParameter("categoryId")));
	logger.info("inside controller's insertProduct method, the value of product id, product name, product price, product desc, and category obtained from jsp ");
	
	Product product=new Product();
	product.setCategory(category);
	product.setProductDescription(productDescription);
	product.setProductName(productName);
	product.setProductPrice(productPrice);
	productDAO.insert(product);
	
	logger.info("inserted "+product+" successfully") ;
	res.sendRedirect("/getAllProducts");
	}
	
	@RequestMapping("/getAllCategory")
	public void getAll(HttpServletRequest req,HttpServletResponse res) throws IOException  { 
	logger.info("inside controller's getAll method ");
	List<Category> categoryList=	categoryDAO.getAll();
	logger.info("got the list of category from dao class");
	HttpSession session = req.getSession();
	session.setAttribute("categoryList", categoryList);
	res.sendRedirect("display.jsp");
	}
	@RequestMapping("/getAllProducts")
	public void getAllProducts(HttpServletRequest req,HttpServletResponse res) throws IOException  { 
	logger.info("inside controller's getAllProducts method ");
	List<Product> productList=	productDAO.getAll();
	logger.info("got the list of product from dao class");
	HttpSession session = req.getSession();
	for(Product p:productList) {
		logger.info(p.getCategory()+" is the value of category in "+ p.getProductName());
	}
	session.setAttribute("productList", productList);
	res.sendRedirect("getListOfproduct.jsp");
	}
	
	@RequestMapping("/getAllBuyers")
	public void getAllBuyers(HttpServletRequest req,HttpServletResponse res) throws IOException  { 
	logger.info("inside controller's getAllBuyers method ");
	List<Buyer> buyerList=buyerDAO.getAllBuyers();
	logger.info("got the list of buyers from buyer dao class");
	HttpSession session = req.getSession();
	session.setAttribute("buyerList", buyerList);
	res.sendRedirect("buyerList.jsp");
	}
	
	@RequestMapping("/delete/{categoryId}")
	public void delete(HttpServletRequest req,HttpServletResponse res,@PathVariable("categoryId") String categoryId) throws IOException { 
	logger.info("inside controller's delete method ");
	categoryDAO.deleteById(Integer.parseInt(categoryId));
	logger.info("deleted the category using dao class's deletebyid method");
	logger.info( "deleted successfully") ;
	res.sendRedirect("http://localhost:8080/getAllCategory");
	}
	@RequestMapping("/updateCategory")
	public void update(HttpServletRequest req,HttpServletResponse res,@RequestParam("categoryId") String categoryId,@RequestParam("categoryName") String categoryName) throws IOException { 
	logger.info("inside controller's update method ");
	Category category=new Category();
	category.setCategoryId(Integer.parseInt(categoryId));
	category.setCategoryName(categoryName);
	logger.info("pojo of category is created and set to to values that have to be updated");
	categoryDAO.update(category);
	logger.info("updated the category using dao class's update method");
	logger.info( "updated successfully" );
	res.sendRedirect("http://localhost:8080/getAllCategory");
	
	}
	@RequestMapping("/deleteProduct/{productId}")
	public void deleteProduct(HttpServletRequest req,HttpServletResponse res,@PathVariable("productId") String productId) throws IOException { 
	logger.info("inside controller's deleteProduct method ");
	productDAO.deleteById(Integer.parseInt(productId));
	logger.info("deleted the product using dao class's deletebyid method");
	res.sendRedirect("http://localhost:8080/getAllProducts");
	logger.info( "deleted successfully" );
	}
	@RequestMapping("/editProduct/{productId}")
	public void editProduct(HttpServletRequest req,HttpServletResponse res,@PathVariable("productId") String productId) throws IOException { 
	logger.info("inside controller's editProduct form method and the productId to be editted is "+ productId);
	HttpSession session = req.getSession();
	session.setAttribute("productId", productId);
	res.sendRedirect("http://localhost:8080/editProduct.jsp");
	logger.info("sent to editProduct.jsp successfully") ;
	
	}
	@RequestMapping("/updateProduct")
	public void updateProduct(HttpServletRequest req,HttpServletResponse res,@RequestParam("productDescription") String productDescription,@RequestParam("productPrice") String productPrice,@RequestParam("categoryId") String categoryId,@RequestParam("productId") String productId,@RequestParam("productName") String productName) throws IOException { 
	logger.info("inside controller's updateProduct method ");
//	logger.info("i the value of product id, product name, product price, product desc, and categoryId obtained from jsp "+categoryId);
	Category category=new Category();
	logger.info("categoryId is "+req.getParameter("categoryId"));
	category=categoryDAO.findByCategoryId(Integer.parseInt(req.getParameter("categoryId")));
	logger.info(category+" is the category obtained from category id + categoryId");
	Product product=new Product();
	product.setProductId(Integer.parseInt(productId));
	product.setProductName(productName);
	
	product.setCategory(category);product.setProductDescription(productDescription);product.setProductPrice(Double.parseDouble(productPrice));
	logger.info("pojo of Product is created and set to to values that have to be updated");
	logger.info("inside controller's updateProduct method, the value of product id, product name, product price, product desc, and categoryId obtained from jsp "+product+categoryId);

	productDAO.update(product);
	logger.info("updated the Product using dao class's updateProduct method");

	logger.info( "updated successfully") ;
	res.sendRedirect("getAllProducts");
	}
	
	@RequestMapping("/buyProduct")
	public void buyProduct(HttpServletRequest req,HttpServletResponse res,@RequestParam("productId") String productId,@RequestParam("productName") String productName) throws IOException { 
		double productPrice=Double.parseDouble(req.getParameter("productPrice"));
		String productDescription=req.getParameter("productDescription");
		Category category=new Category();
		System.out.println(req.getParameter("categoryId"));
		logger.info("categoryId is "+req.getParameter("categoryId"));
		category=categoryDAO.findByCategoryId(Integer.parseInt(req.getParameter("categoryId")));
	logger.info("inside controller's buyProduct method, the value of product id, product name, product price, product desc, and category obtained from jsp ");
	
	PurchaseList p=new PurchaseList();
	p.setProductId(Integer.parseInt(productId));
	p.setCategory(category);
	p.setProductDescription(productDescription);
	p.setProductName(productName);
	p.setProductPrice(productPrice);
	pdao.insert(p);
	
	logger.info("inserted successfully") ;
	res.sendRedirect("PurchaseList.jsp");
	}	
	@RequestMapping("/getAllPurchaseList")
	public void getAllpurchaseList(HttpServletRequest req,HttpServletResponse res) throws IOException { 
		logger.info("inside controller's getAllPurchaseList method ");
		List<PurchaseList> plist=	pdao.getAll();
		logger.info("got the list of product from dao class");
		HttpSession session = req.getSession();
		session.setAttribute("plist", plist);
		res.sendRedirect("getAllPurchaseList.jsp");
	}	
	
	@RequestMapping("/edit/{categoryId}")
	public void update(HttpServletRequest req,HttpServletResponse res,@PathVariable("categoryId") String categoryId) throws IOException { 
	logger.info("inside controller's edit form method and the category id to be editted is "+ categoryId);
	HttpSession session = req.getSession();
	session.setAttribute("categoryId", categoryId);
	res.sendRedirect("http://localhost:8080/edit.jsp");
	logger.info("sent to edit.jsp successfully") ;
	
	}
	@RequestMapping("/registerBuyer")
	public void register(HttpServletRequest req,HttpServletResponse res,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("password") String password) throws IOException
	{
		Buyer buyer=new Buyer();
		buyer.setFirstName(firstName);buyer.setPassword(password); buyer.setLastName(lastName);buyer.setEmail(email);buyer.setEmail(email);
		logger.info("pojo created and set with values obtained from jsp");
		buyerDAO.insert(buyer);
		logger.info("registered successfully");
		HttpSession session = req.getSession();
		session.setAttribute("firstName", firstName);
		List<Category> categoryList=categoryDAO.getAll();
		session.setAttribute("categoryList", categoryList);
		res.sendRedirect("http://localhost:8080/success.jsp");
	}


	
	@RequestMapping("/register")
	public void registerBuyer(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.sendRedirect("register.jsp");
	}
	@RequestMapping("/logout")
	private void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
}

	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse res,@RequestParam("password") String password) throws IOException {
		String Email=request.getParameter("email");
		logger.info("inside the request mapping of login");
		logger.info("object from user"+admindao.findByEmail(Email));
		Admin admin=admindao.findByPassword(password);
		HttpSession session = request.getSession();
		session.setAttribute("admin", admin);
		logger.info("admin from password is "+admindao.findByPassword(password));
		logger.info("admin from email is "+admindao.findByEmail(Email));
		if(admindao.findByEmail(Email).equals(admindao.findByPassword(password))) {
			logger.info("validation of the admin is successfull");
			logger.info(((Admin)session.getAttribute("admin")).getName()+"this is what is stored in validated admin's name detail");
			//req.setAttribute( user, user);
			res.sendRedirect("getAllCategory");

			return"Login is successfull";
		}
		else {
			logger.info("failed");
			res.sendRedirect("Error.jsp");
		return "login failed ! please check your credentials ";
		}
		
	}


}
