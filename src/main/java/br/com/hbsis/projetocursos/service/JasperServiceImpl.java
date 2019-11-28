package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.BoletimDTO;
import net.sf.jasperreports.engine.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperServiceImpl implements JasperService {

    private final BoletimService boletimService;
    private final AlunoService alunoService;

    @Autowired
    public JasperServiceImpl(BoletimService boletimService, AlunoService alunoService) {
        this.boletimService = boletimService;
        this.alunoService = alunoService;
    }


    @Override
    public void generateBoletim(HttpServletResponse response, int theId) throws Exception {

        Map<String, Object> parameters = new HashMap<String, Object>();
        AlunoDTO aluno = alunoService.findAlunoById(theId);
        List<BoletimDTO> boletim = boletimService.findBoletimByAlunoId(theId);

        parameters.put("id_alunos", aluno.getId());
        parameters.put("nome", String.valueOf(aluno.getNome()));
        parameters.put("idade", aluno.getIdade());
        parameters.put("id_turma", 1);
        parameters.put("nota", String.valueOf(boletim.get(0).getNota()));

        InputStream cherryInputStream = JasperServiceImpl.class.getResourceAsStream("/jasper/cherry.jpg");

        parameters.put("cherry", IOUtils.toByteArray(cherryInputStream));

        InputStream boletinInputStream = JasperServiceImpl.class.getResourceAsStream("/jasper/Boletim.jasper");

        JRDataSource jrDataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(boletinInputStream, parameters, jrDataSource);

        byte[] reportToPdf = JasperExportManager.exportReportToPdf(jasperPrint);

        response.setContentType("application/pdf"); // Tipo do Conteúdo
        response.setContentLength(reportToPdf.length); // Opcional
        response.setHeader("Content-Disposition", "attachment; filename=" + aluno.getNome() + "-boletim.pdf");

        OutputStream output = response.getOutputStream();
        output.write(reportToPdf);
        output.flush();
        output.close();
    }
}

