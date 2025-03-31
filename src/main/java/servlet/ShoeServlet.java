package servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Shoe;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shoes")
public class ShoeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Shoe> shoes = new ArrayList<>();
        shoes.add(new Shoe("Nike", "Air Max", 120.99, "42", "https://example.com/nike-air-max.jpg"));
        shoes.add(new Shoe("Adidas", "UltraBoost", 140.50, "41", "https://example.com/adidas-ultraboost.jpg"));
        shoes.add(new Shoe("Puma", "RS-X", 110.00, "43", "https://example.com/puma-rsx.jpg"));

        String json = new Gson().toJson(shoes);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}