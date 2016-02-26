package com.sfm.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.UploadedFile;


import com.sfm.erp.model.*;
import com.sfm.erp.service.ISharedService;

	@ManagedBean
	@ViewScoped
	public class PersonnelBean  implements Serializable  {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@ManagedProperty(value = "#{sharedService}")
		private ISharedService sService;
		private Personnel personnel ;
		private Personnel personnelSelected = new Personnel();
		private Emploiprecedent emploiprec  ;
		private Emploiprecedent emploiprecSelected = new Emploiprecedent();

		private Diplome dip ;
		private Diplome  dipSelected = new Diplome();
		private Document document= new Document() ;
		private Document documentSelected = new Document();
		private UploadedFile file;	
	 private List<Document> documents = new ArrayList<Document>();
	 private List<Personnel> personnels = new ArrayList<Personnel>();
	 private List<Diplome> dips  = new ArrayList<Diplome>();
	 private List<Emploiprecedent> emploiprecs  = new ArrayList<Emploiprecedent>();
	 
	 
	 private List<Cong> conges  = new ArrayList<Cong>();
	 private List<Evaluation> evales  = new ArrayList<Evaluation>();
	 private List<Diplome> diplomes  = new ArrayList<Diplome>();
	 
	 private List<Emploiprecedent> emploipreces  = new ArrayList<Emploiprecedent>();
	 private List<Formation> formations  = new ArrayList<Formation>();
	 private List<Demandesortie> demandes  = new ArrayList<Demandesortie>();
		@PostConstruct
		public void init() {
			
			personnel= new Personnel();
			setPersonnels(sService.listperso());
			
			dip = new Diplome();
			emploiprec= new Emploiprecedent();
			emploipreces  = new ArrayList<Emploiprecedent>();
		
			}
		
		
		public void createpersonnel() {
			try {
			
				Personnel per= new Personnel();
				per = sService.createperso(personnel);
				setPersonnels(sService.listperso());
				
				for (Emploiprecedent emploi : getEmploipreces())
				{
					emploi.setPersonn(per);
					sService.createemploiprec(emploi);
					per.getEmploi_precs().add(emploi);
					
				}
				
				for(Diplome diplome : diplomes)
				{
					
					diplome.setPerson(per);
					 sService.createdep(diplome);
					 per.getDiplomes().add(diplome);
					 
				}
				
			
				
			     sService.updatepersonnel(personnel);
			
				 info("Entité ajouté avec success");

           
			
			 
			 

				}
				
		
			catch (Exception e) {
				error("Erreur de  création !");
			
			}
		}
		public void deletepersonnel() {
			try {
				sService.deleteperso(personnelSelected.getIdpersonnel());
				info("Personnel supprimé avec succés");
			} catch (Exception e) {
				error("erreur de suppression");

			}

		}
		public void updatepersonnel() {
			try {
				sService.updatepersonnel(personnelSelected);
				info("Les informations du personnels sont modifiées ");
			} catch (Exception e) {
				error("erreur de modification");

			}

		}
		
		public void info( String msg) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							msg));
		}
	

		public void error( String msg ) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							msg));
		}
		
		public ISharedService getsService() {
			return sService;
		}
		public void setsService(ISharedService sService) {
			this.sService = sService;
		}


		public Personnel getPersonnel() {
			return personnel;
		}


		public void setPersonnel(Personnel personnel) {
			this.personnel = personnel;
		}


		public List<Personnel> getPersonnels() {
			return personnels;
		}


		public void setPersonnels(List<Personnel> personnels) {
			this.personnels = personnels;
		}


		public Personnel getPersonnelSelected() {
			return personnelSelected;
		}


		public void setPersonnelSelected(Personnel personnelSelected) {
			this.personnelSelected = personnelSelected;
		}


	
		
		public void onRowSelect(final SelectEvent event) {
			this.personnel = personnelSelected;
		setConges(sService.trouvercong(personnelSelected.getIdpersonnel()));
		 setEvales(sService.trouvereval(personnelSelected.getIdpersonnel())); 
		  setDiplomes(sService.trouverdip(personnelSelected.getIdpersonnel()));  
		  setEmploipreces(sService.trouveremploi(personnelSelected.getIdpersonnel()));
	
		 setDemandes(sService.trouverdemande(personnelSelected.getIdpersonnel())); 

		}
		public void onRowSelect1() {
			this.emploiprec = emploiprecSelected;

		}
		public void onRowSelect2(final SelectEvent event) {
			this.dip= dipSelected;

		}

		
		public void handleToggle(ToggleEvent event) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Toggled", "Visibility:" + event.getVisibility());
			FacesContext.getCurrentInstance().addMessage(null, msg);
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


		public UploadedFile getFile() {
			return file;
		}


		public void setFile(UploadedFile file) {
			this.file = file;
		}


		public List<Document> getDocuments() {
			return documents;
		}


		public void setDocuments(List<Document> documents) {
			this.documents = documents;
		}
		

		
		

		public PersonnelBean() {
		
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
				info("fichier upload");
				
					document.setNom(fileName);
					documents.add(document);
			}
			
			 catch (IOException e) {
				System.out.println(e.getMessage());
				
			}
		}
		
	
		
	

		public Emploiprecedent getEmploiprec() {
			return emploiprec;
		}


		public void setEmploiprec(Emploiprecedent emploiprec) {
			this.emploiprec = emploiprec;
		}


		public Emploiprecedent getEmploiprecSelected() {
			return emploiprecSelected;
		}


		public void setEmploiprecSelected(Emploiprecedent emploiprecSelected) {
			this.emploiprecSelected = emploiprecSelected;
		}


		public Diplome getDip() {
			return dip;
		}


		public void setDip(Diplome dip) {
			this.dip = dip;
		}


		public Diplome getDipSelected() {
			return dipSelected;
		}


		public void setDipSelected(Diplome dipSelected) {
			this.dipSelected = dipSelected;
		}


		public List<Diplome> getDips() {
			return dips;
		}


		public void setDips(List<Diplome> dips) {
			this.dips = dips;
		}


		public List<Emploiprecedent> getEmploiprecs() {
			return emploiprecs;
		}


		public void setEmploiprecs(List<Emploiprecedent> emploiprecs) {
			this.emploiprecs = emploiprecs;
		}


	
		public void deleteemploiprec() {
			try {
				sService.deleteemploiprec(emploiprecSelected.getIdemploi());
				
				info("Entité supprimé avec success");
			} catch (Exception e) {
				error("erreur de suppression ! ");

			}

		}

	

		public void updateemploiprec() {
			try {
				sService.updateemploiprec(emploiprecSelected);
				info("Entité modifié");
			} catch (Exception e) {
				error("erreur de modification");

			}
			
			

		}
		
		public void updatedip() {
			try {
				sService.updatedep(dipSelected);
				info("Entité modifiée avec success");
			} catch (Exception e) {
				
		
				error("erreur de modification");
			}

			}

		
			public void deletedip() {
				try {
					sService.deleteeval(dipSelected.getIddiplome());
					
					info("Entité supprimé avec success");
				} catch (Exception e) {
					error("erreur de suppression");

				}

			}
			
			
			
			public void length()
			{
				if(personnel.getCin().length()!=8)
				{
					
					error("la longeur de numero de CIN doit être egale à 8 chiffres ");
					
				}
			
				
			}
				public void length1()
				{
					if(personnel.getNum_compte_bancaire().length()!=16)
					{
						error("la longeur de numero de CIN doit être egale à 16 chiffres ");
					}
					
					
				}
		

				public void create() {
					try {
						
		 sService.createperso(personnel);
					
						setPersonnels(sService.listperso());
			
					
						info("Entité ajouté avec success");
						
						}
					
					catch (Exception e) {
						error("erreur de suppression");

					}
						
					}


				public List<Cong> getConges() {
					return conges;
				}


				public void setConges(List<Cong> conges) {
					this.conges = conges;
				}


				public List<Evaluation> getEvales() {
					return evales;
				}


				public void setEvales(List<Evaluation> evales) {
					this.evales = evales;
				}


				public List<Diplome> getDiplomes() {
					return diplomes;
				}


				public void setDiplomes(List<Diplome> diplomes) {
					this.diplomes = diplomes;
				}


				public List<Emploiprecedent> getEmploipreces() {
					return emploipreces;
				}


				public void setEmploipreces(List<Emploiprecedent> emploipreces) {
					this.emploipreces = emploipreces;
				}


				public List<Formation> getFormations() {
					return formations;
				}


				public void setFormations(List<Formation> formations) {
					this.formations = formations;
				}


				public List<Demandesortie> getDemandes() {
					return demandes;
				}


				public void setDemandes(List<Demandesortie> demandes) {
					this.demandes = demandes;
				}
				
				
				public void createemploiprec() {
					try {
						
						this.emploipreces.add(emploiprec);
						System.out.println("***********************************************");
					
						info("Entité ajoutée avec success");
					} catch (Exception e) {
						error("Erreur de creation ");
					}
				}
				
				
				
				public void createdip() {
					try {
						
					
						this.diplomes.add(dip);
					   
						info("diplome  ajouté avec success");
					} catch (Exception e) {
						error("erreur de creation");
					}
				}
				
				
				
				
		}
	
	