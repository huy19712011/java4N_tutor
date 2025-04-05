package org.example.java4n_tutor.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.java4n_tutor.entity.Category;
import org.example.java4n_tutor.entity.Product;
import org.example.java4n_tutor.service.CategoryService;
import org.example.java4n_tutor.service.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {
        "/products",
        "/products/new",
        "/products/insert",
        "/products/edit",
        "/products/update",
        "/products/delete"
})
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        switch (path) {

            case "/products":
                listProducts(request, response);
                break;
            case "/products/new":
                showNewForm(request, response);
                break;
            case "/products/insert":
                insertProduct(request, response);
                break;
            case "/products/edit":
                editProduct(request, response);
                break;
            case "/products/update":
                updateProduct(request, response);
                break;
            case "/products/delete":
                deleteProduct(request, response);
                break;

        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        productService.deleteProduct(id);

        response.sendRedirect("/products");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read product from form
        Product product = getProductFromForm(request);

        // update
        productService.updateProduct(product);

        // redirect
        response.sendRedirect("/products");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // load product to form
        Long id = Long.parseLong(request.getParameter("id"));
        Product product = productService.getProductById(id);
        request.setAttribute("product", product);

        List<Category> categories = categoryService.getCategories();
        request.setAttribute("categories", categories);
        request.setAttribute("categoryId", product.getCategory().getId());

        //
        request.getRequestDispatcher("/view/updateProductForm.jsp")
                .forward(request, response);

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read data from form
        Product product = getProductFromForm(request);

        // save product to db
        productService.addProduct(product);

        // redirect list of products
        response.sendRedirect("/products");
    }

    private Product getProductFromForm(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        long categoryId = Long.parseLong(request.getParameter("category_id"));
        Category category = categoryService.getCategoryById(categoryId);

        // product object
        Product product = new Product(id, name);
        product.setCategory(category);

        return product;
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get all categories for combobox
        List<Category> categories = categoryService.getCategories();

        request.setAttribute("categories", categories);

        //
        request.getRequestDispatcher("/view/addProductForm.jsp")
                .forward(request, response);

    }



    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products = productService.getProducts();

        request.setAttribute("products", products);

        request.getRequestDispatcher("/view/productList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}