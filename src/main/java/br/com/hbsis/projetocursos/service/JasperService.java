package br.com.hbsis.projetocursos.service;

import javax.servlet.http.HttpServletResponse;

public interface JasperService {

    public void generateBoletim (HttpServletResponse response, int theId) throws Exception;
}
