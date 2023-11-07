package com.example.sd18204.servlet;

import com.example.sd18204.entity.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/add",

})
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SinhVien> list = new ArrayList<>();
        list.add(new SinhVien("1", "SV1", "Nguyen Van A", "SD12345", "Nam"));
        list.add(new SinhVien("2", "SV2", "Nguyen Van B", "SD12346", "Nam"));
        list.add(new SinhVien("3", "SV3", "Nguyen Van C", "SD12347", "Nu"));
        list.add(new SinhVien("4", "SV4", "Nguyen Van D", "SD12345", "Nam"));
        request.setAttribute("listSinhVien", list);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");

    }
}
