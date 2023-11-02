package com.example.sd18204.servlet;

import com.example.sd18204.entity.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SinhVienServlet", value = "/sinh-vien/hien-thi")
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setHoTen("Nguyen Van A");
        sinhVien.setNamSinh(1990);
        sinhVien.setDiaChi("Ha Noi");
        sinhVien.setTrangThai("Hoc lai");
        request.setAttribute("sinhVien", sinhVien);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");

    }
}
