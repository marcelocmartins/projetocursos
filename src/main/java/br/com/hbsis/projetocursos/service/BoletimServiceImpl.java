package br.com.hbsis.projetocursos.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsis.projetocursos.dao.BoletimRepositoryImpl;
import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.Boletim;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


@Service
public class BoletimServiceImpl implements BoletimService{
	
	private BoletimRepositoryImpl boletimRepository;
	
	@Autowired
	public BoletimServiceImpl(BoletimRepositoryImpl theBoletimRepository) {
		this.boletimRepository= theBoletimRepository;
		
	}
	
	@Override
	public void generateBoletim (AlunoDTO boletimAluno) throws Exception {
		
		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		// Compile jrxml file
		JasperReport jasperReport = JasperCompileManager.compileReport("Boletim.jrxml");
		
		// Empty data source
		JRDataSource jrDataSource = new JREmptyDataSource();
		
//		jrDataSource = boletimRepository;
		
		
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
		
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\marcelo.martins\\Documents\\Java_codigos\\PROJETOS\\projeto cursos\\BoletinsGerados");
		
		// create a temp PDF file
		File boletimPdf = File.createTempFile("Boletim", ".pdf");
		
		// initiate a FileOutputStream
		
	}

}
