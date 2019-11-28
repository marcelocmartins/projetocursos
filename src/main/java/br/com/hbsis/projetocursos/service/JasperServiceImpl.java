package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.Aluno;
import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.BoletimDTO;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();
        AlunoDTO aluno = alunoService.findAlunoById(theId);
        List<BoletimDTO> boletim = boletimService.findBoletimByAlunoId(theId);

        parameters.put("id_alunos", aluno.getId());
        parameters.put("nome", aluno.getNome());
        parameters.put("idade", aluno.getIdade());
        parameters.put("id_turma", "Turma Teste");
        parameters.put("nota", boletim.get(0).getNota());


        // Compile jrxml file
        JasperReport jasperReport = JasperCompileManager.compileReport("Boletim.jasper");

        // Empty data source
        JRDataSource jrDataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\marcelo.martins\\Documents\\Java_codigos\\PROJETOS\\projeto cursos\\BoletinsGerados");

        // create a temp PDF file
        File boletimPdf = File.createTempFile("Boletim", ".pdf");

        // initiate a FileOutputStream

    }
}

