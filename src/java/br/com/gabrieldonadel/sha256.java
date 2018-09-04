/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gabrieldonadel;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Donadel Dall'Agnol
 */
@WebServlet(name = "hash", urlPatterns = {"/hash"})
public class sha256 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String dados = request.getParameter("dados");
        response.setContentType("text/html;charset=UTF-8");
        byte[] sha256 = getSha256(dados);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Gerador sha256</title>"); 
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/styles/style.css' />");
            out.println("</head>");
            out.println("<body><div class=\"container\"><div class=\"result\">");
            out.println("<h1>" + dados + "</h1>");
            out.println("<p>hex: " + bytesToHex(sha256) + "</p>");
            out.println("<p>h:e:x: " + hexColons(bytesToHex(sha256)) + "</p>");
            out.println("<p>HEX: " + bytesToHex(sha256).toUpperCase() + "</p>");
            out.println("<p>base64: " + bytesToBase64(sha256) + "</p>");
            out.println("</div></div></body></html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    public static byte[] getSha256(String value) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes());
            return md.digest();
            
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static String bytesToHex(byte[] bytes) {
       StringBuffer result = new StringBuffer();
       for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
       return result.toString();
    }
    
    public static String bytesToBase64(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }
    
    public static String hexColons(String s){
        s = s.replaceAll("(.{2})", "$1:");
        return s.substring(0,s.length()-1);
    }

}
