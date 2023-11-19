package com.example.sd18204.servlet;

import com.example.sd18204.entity.SinhVien;
import com.example.sd18204.service.SinhVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // get
        "/sinh-vien/add",
        "/sinh-vien/update",
        "/sinh-vien/detail", //get
        "/sinh-vien/delete", //get

})
public class SinhVienServlet extends HttpServlet {
    ArrayList<SinhVien> list = new ArrayList<>();
    ArrayList<String> lops = new ArrayList<>();
    // Servlet => Service => Repository
    SinhVienService sinhVienService = new SinhVienService();




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            this.getList(request, response);
        } else if (uri.contains("/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        list.remove(index);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sinhVienDetail = new SinhVien();
        for (SinhVien sinhVien : list) {
            if (sinhVien.getId().equals(id)) {
                sinhVienDetail = sinhVien;
            }
        }
        request.setAttribute("lops", lops);
        request.setAttribute("sinhVien", sinhVienDetail);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lops", lops);

        // => thay the bằng service.getList()
        ArrayList<SinhVien> list = sinhVienService.getAll();
        request.setAttribute("listSinhVien", list);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            this.addNew(request, response);
        } else if (uri.contains("/update")) {
            this.update(request, response);
        }


    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String hoTen = request.getParameter("hoTen");
        String lop = request.getParameter("lop");
        String gioiTinh = request.getParameter("gioiTinh");
        // Tạo đối tượng sinh vieen từ thông tin vừa lấy được
//            SinhVien sinhVienNew = new SinhVien(id, ma, hoTen, lop, gioiTinh);
//        for (SinhVien sv : list) {
//            if (sv.getId().equals(id)) {
//                sv.setMa(ma);
//                sv.setHoTen(hoTen);
//                sv.setLop(lop);
//                sv.setGioiTinh(gioiTinh);
//            }
//        }
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void addNew(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // lấy thông tin trên form xuống
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String hoTen = request.getParameter("hoTen");
        String lop = request.getParameter("lop");
        String gioiTinh = request.getParameter("gioiTinh");
        // Tạo đối tượng sinh vieen từ thông tin vừa lấy được
//        SinhVien sinhVien = new SinhVien(id, ma, hoTen, lop, gioiTinh);
//
//        // add sinh viên vào list
//        list.add(sinhVien);

        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
