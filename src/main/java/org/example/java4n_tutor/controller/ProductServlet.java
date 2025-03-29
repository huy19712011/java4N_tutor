package org.example.java4n_tutor.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.java4n_tutor.entity.Product;
import org.example.java4n_tutor.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {
        "/products"
})
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        switch (path) {

            case "/products":
                listProducts(request, response);
                break;
        }
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