package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.*;
import net.sf.jasperreports.engine.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperServiceImpl implements JasperService {

    private final BoletimService boletimService;
    private final AlunoService alunoService;
    private final TurmaService turmaService;

    @Autowired
    public JasperServiceImpl(BoletimService boletimService, AlunoService alunoService, TurmaService turmaService, TurmaService turmaService1) {
        this.boletimService = boletimService;
        this.alunoService = alunoService;
        this.turmaService = turmaService1;
    }


    @Override
    public void generateBoletim(HttpServletResponse response, int theId) throws Exception {

        // Cria um HashMap e carrega as informações do aluno e do boletim nas variáveis
        Map<String, Object> parameters = new HashMap<String, Object>();
        Aluno theAluno = alunoService.findById(theId);
        List<Boletim> boletim = boletimService.findBoletimByAlunoId(theId);
        List<String> notas = boletimService.generateNotasForBoletim(boletim);
        AlunoListagemDTO alunoListagemDTO = new AlunoListagemDTO().transformAlunoIntoAlunoListagem(theAluno, theAluno.getTurma().getNomeTurma(), notas);




        // Insere os parâmetros do template .jasper baseado nos campos dos registros recuperados do banco nas variáveis aluno e boletim
        parameters.put("id_alunos", alunoListagemDTO.getId());
        parameters.put("nome", alunoListagemDTO.getNome());
        parameters.put("idade", alunoListagemDTO.getIdade());
        parameters.put("id_turma", alunoListagemDTO.getTurma());
        parameters.put("nota", alunoListagemDTO.getBoletim()); // Aqui o retorno é uma lista, no template é apenas um campo String

        // Cria um input stream para inserir a imagem no pdf como um resource
        InputStream cherryInputStream = JasperServiceImpl.class.getResourceAsStream("/jasper/cherry.jpg");

        // Insere a imagem no template .jasper como parâmetro, transformando o input stream em um array de bytes
        parameters.put("cherry", IOUtils.toByteArray(cherryInputStream));

        // Cria um input stream do template .jasper para ser usado como resource
        InputStream boletinInputStream = JasperServiceImpl.class.getResourceAsStream("/jasper/Boletim.jasper");

        // Cria um dataSource vazio e usa o JasperPrint para montar e preencher o template do boletim
        JRDataSource jrDataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(boletinInputStream, parameters, jrDataSource);

        // Cria um array de bytes para exportar para download do navegador
        byte[] reportToPdf = JasperExportManager.exportReportToPdf(jasperPrint);

        // coloca informações necessarias no HttpResponse para o navegador fazer download do arquivo em pdf
        response.setContentType("application/pdf"); // Tipo do Conteúdo
        response.setContentLength(reportToPdf.length); // Opcional
        response.setHeader("Content-Disposition", "attachment; filename=" + alunoListagemDTO.getNome() + "-boletim.pdf");

        // Gera o output para o navegador
        OutputStream output = response.getOutputStream();
        output.write(reportToPdf);
        output.flush();
        output.close();
    }
}

