package com.example.sd18204.servlet;

import com.example.sd18204.entity.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // get
        "/sinh-vien/add",
        "/sinh-vien/detail", //get

})
public class SinhVienServlet extends HttpServlet {
    ArrayList<SinhVien> list = new ArrayList<>();
    ArrayList<String> lops = new ArrayList<>();

    public SinhVienServlet() {
        list.add(new SinhVien("1", "SV1", "Nguyen Van A", "SD12345", "Nam"));
        list.add(new SinhVien("2", "SV2", "Nguyen Van B", "SD12346", "Nam"));
        list.add(new SinhVien("3", "SV3", "Nguyen Van C", "SD12347", "Nu"));
        list.add(new SinhVien("4", "SV4", "Nguyen Van D", "SD12345", "Nam"));
        lops.add("SD12345");
        lops.add("SD12346");
        lops.add("SD12347");
        lops.add("SD12349");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            this.getList(request, response);
        } else if (uri.contains("/detail")) {
            this.detail(request, response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sinhVienDetail = new SinhVien();
        for (SinhVien sinhVien : list) {
            if (sinhVien.getId().equals(id)) {
                sinhVienDetail = sinhVien;
            }
        }
        request.setAttribute("sinhVien", sinhVienDetail);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lops", lops);
        request.setAttribute("listSinhVien", list);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");

    }
}
