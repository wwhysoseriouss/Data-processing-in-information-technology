package servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Shoe;
import service.ShoeService;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shoes/*")
public class ShoeServlet extends HttpServlet {
    private ShoeService shoeService = new ShoeService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        List<Shoe> shoes = shoeService.getAll();
        resp.getWriter().write(gson.toJson(shoes));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Shoe newShoe = gson.fromJson(req.getReader(), Shoe.class);
        shoeService.add(newShoe);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write(gson.toJson(newShoe));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID is missing");
            return;
        }
        int id = Integer.parseInt(pathInfo.substring(1));
        Shoe shoeToUpdate = gson.fromJson(req.getReader(), Shoe.class);
        shoeToUpdate.setId(id);

        if (shoeService.update(shoeToUpdate)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write(gson.toJson(shoeToUpdate));
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Shoe not found");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID is missing");
            return;
        }
        int id = Integer.parseInt(pathInfo.substring(1));

        if (shoeService.delete(id)) {
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Shoe not found");
        }
    }
}
