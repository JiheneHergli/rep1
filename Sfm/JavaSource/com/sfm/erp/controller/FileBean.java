package com.sfm.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.UploadedFile;

import com.sfm.erp.model.Document;
import com.sfm.erp.model.Personnel;
import com.sfm.erp.service.ISharedService;

	@ManagedBean
	@ViewScoped

public class FileBean  implements Serializable  {



		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@ManagedProperty(value = "#{sharedService}")
		private ISharedService sService;
		private Document document ;
		private Document documentSelected = null;
		private UploadedFile file;
		private Personnel personnel ; 
		
		
		private List<Document> documents = new ArrayList<>();
		
		
		@PostConstruct
		public void init() {
			
			document= new Document();
			setDocuments(sService.listdocs());
			}
		
		
		public void createdocument() {
			try {
				sService.createdocs(document);
				setDocuments(sService.listdocs());
				info();
			}
			catch (Exception e) {
				error();
			
			}
		}
		public void deletedocument() {
			try {
				sService.deletedocs(documentSelected.getIddoc());
				info1();
			} catch (Exception e) {
				error1();

			}

		}
		public void updatedocument() {
			try {
				sService.updatedocs(documentSelected);
				info2();
			} catch (Exception e) {
				error2();

			}

		}
		
		public void info() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Entité ajouté avec success"));
		}
		public void info1() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Entité supprimée"));
		}
		
		
		public void info3() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Fichier uploaded"));
		}
		
		
		

		
		
		public void info2() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Entité modifiée"));
		}


		public void error() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							"Erreur création !"));
		}
		public void error3() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							"Veuillez saisir le nom de personnel "));
		}

		public ISharedService getsService() {
			return sService;
		}
		public void setsService(ISharedService sService) {
			this.sService = sService;
		}


		
		public void handleToggle(ToggleEvent event) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Toggled", "Visibility:" + event.getVisibility());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		  
		  
		public void error1() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							"Erreur de modification !"));
		}
		public void error2() {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							"Erreur de suppression !"));
		}


		public Document getDocument() {
			return document;
		}


		public void setDocument(Document document) {
			this.document = document;
		}


		public Document getDocumentSelected() {
			return documentSelected;
		}


		public void setDocumentSelected(Document documentSelected) {
			this.documentSelected = documentSelected;
		}


		public List<Document> getDocuments() {
			return documents;
		}


		public void setDocuments(List<Document> documents) {
			this.documents = documents;
		}
		

		
		
		
		
		public void upload(FileUploadEvent event) {
			try {
				copyFile(event.getFile().getFileName(), event.getFile()
						.getInputstream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public void copyFile(String fileName, InputStream in) {
			try {
				// write the inputStream to a FileOutputStream
			
					String dirName = "D:\\pfe_fac_sfm\\SFM\\"
							+ "hjhjhj" + "\\";
					File dir = new File(dirName);
					dir.mkdirs();
					OutputStream out = new FileOutputStream(new File(dirName
							+ fileName));
					int read = 0;
					byte[] bytes = new byte[1024];
					while ((read = in.read(bytes)) != -1) {
						out.write(bytes, 0, read);
					}
					in.close();
					out.flush();
					out.close();
					System.out.println("New file created!");
				info3();
				
					document.setNom(fileName);
					documents.add(document);
			}
			
			 catch (IOException e) {
				System.out.println(e.getMessage());
				
			}
		}


		public UploadedFile getFile() {
			return file;
		}


		public void setFile(UploadedFile file) {
			this.file = file;
		}
		
		
		
		
}
	
	