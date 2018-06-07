package com.yb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.yb.thread.AccessTokenThread;
public class  InitServlet extends HttpServlet{
    private static  final  long  serialVersionUID = 1L;
    public void  init(ServletConfig config) throws ServletException {
        new Thread(new AccessTokenThread()).start(); 
    }
}
