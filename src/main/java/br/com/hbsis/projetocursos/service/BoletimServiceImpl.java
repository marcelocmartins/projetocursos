package br.com.hbsis.projetocursos.service;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.hbsis.projetocursos.entity.BoletimDTO;
import org.apache.commons.io.FileUtils;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class BoletimServiceImpl implements BoletimService{
	
	private BoletimRepositoryImpl boletimRepository;
	
	@Autowired
	public BoletimServiceImpl(BoletimRepositoryImpl theBoletimRepository) {
		this.boletimRepository= theBoletimRepository;
		
	}

	@Override
	public void generateBoletimFromFile(HttpServletResponse response) throws Exception {
		File boletim = new File("C:\\Users\\marcelo.martins\\Pictures\\Winterhold\\Gatekeeper_(Achievement).png");
		byte[] content = FileUtils.readFileToByteArray(boletim);
		Path path = boletim.toPath();
		String nome = boletim.getName();
		int tamanho = (int) boletim.length();

		response.setContentType("image/png"); // Tipo do Conteúdo
		response.setContentLength(tamanho); // Opcional
		response.setHeader("Content-Disposition", "attachment; filename=\"" + nome + "\"");

		OutputStream output = response.getOutputStream();
		output.write(content);
		output.flush();
		output.close();

	}

	@Override
	public List<BoletimDTO> findBoletimByAlunoId(int alunoId) {
		return boletimRepository.findBoletimByAlunoId(alunoId);
	}


}
