package com.sfm.erp.service;

import java.util.List;
import java.util.Map;


import com.sfm.erp.model.*;

public interface ISharedService {
	public Typeconge createty(Typeconge typeconge);
	public  Theme createthe(Theme th);
	public   Document createdocs(Document docs);
	public Departement  createdepar(Departement dep);
	public Evaluation createeval(Evaluation eval);
	public Diplome createdep(Diplome dep);
	public Consultant createcons(Consultant cons);
	public Emploiprecedent createemploiprec(Emploiprecedent emploiprec);
	public Event createevent(Event event);
    public Demandesortie createdem(Demandesortie dem) ;
    public Notification createnoti(Notification noti ) ;	
	public Cong createcong(Cong cong);
	public Banque createB(Banque b);
	public SFM createS(SFM sfm);
	public Personnel createperso(Personnel perso);
  
	public Compte createC(Compte c);
	public Competence createCo(Competence co);


	public Proposition createP(Proposition p);

	public Client createCl(Client cl);

	public Offre createOff(Offre off);

	public Formation createFor(Formation frm);

	public List<SFM> listSFM();
	public List<Consultant> listcons();
	public List<Notification> listnoti();
	public List<Document> listdocs();
	public List<Cong> listcong();
	public List<Event> listevent();
	public List<Diplome> listdep();
	public List<Emploiprecedent> listemploi();
	public List<Typeconge> listtype();
	public List<Theme> listtheme();
	public List<Departement> listdepartement();
	
	public List<Personnel> listperso();
	public List<Formation> listFRM();

	public List<Demandesortie> listdem();

	public List<Offre> listOffre();

	public List<Banque> listB();
	public List<Evaluation> listeval();

	public List<Compte> listC();

	public List<Proposition> listP();

	public List<Client> listCl();
	public List<Competence> listCompetence() ;

	public Formation updateFrm(Formation frm);
	public Document updatedocs(Document docs);
	public Consultant updatecons(Consultant cons);

	public SFM updateS(SFM sfm);
	public Notification updatenoti(Notification noti );
	public Cong updatecong(Cong cong);
	public Diplome updatedep(Diplome  dep);
	
	public Demandesortie updatedem(Demandesortie dem);

	public Emploiprecedent updateemploiprec(Emploiprecedent emploiprec);

	public Typeconge updatetype(Typeconge type);

	public Competence updateCompetence(Competence competence);
	public Personnel updatepersonnel(Personnel personnel);

	public Banque updateB(Banque b);

	public Compte updateC(Compte c);
	public Evaluation updateeval(Evaluation eval);

	public Proposition updateP(Proposition p);

	public Client updateCl(Client cl);

	public Offre updateOff(Offre off);
	public Event updateevent(Event event);

	public void deleteFRM(Object id);
	public void deletecons(Object id);
	public void deletecong(Object id);
	public void deleteperso(Object id);
	public void deleteS(Object id);
	public void deletedep(Object id);
	public void deletedocs(Object id);
	public void deleteemploiprec(Object id);
	public void deletedem(Object id);
	public void deletenoti(Object id);
	public void deleteeval(Object id);

	public void deleteB(Object id);
	public void deleteevent(Object id);

	public void deleteP(Object id);
	public void deleteCompet(Object id);

	public void deleteCl(Object id);
	public void deleteth(Object id);
	public void deletetype(Object id);
	public void deletedepartement(Object id);

	public void deleteOff(Object id);

	public Formation findFRM(Object id);

	public Proposition findP(Object id);

	public SFM findS(Object id);
	public Diplome  finddep(Object id);
	public Emploiprecedent findemploiprec(Object id);

	public Banque findB(Object id);

	public Compte findC(Object id);

	public Client findCl(Object id);
	public Personnel findperso(Object id);

	public Offre findOff(Object id);
	public List<Cong> trouvercong( int idpersonnel);
	public List<Evaluation>  trouvereval(int idpersonnel);
	public List<Diplome>  trouverdip(int idpersonnel);  
	public List<Emploiprecedent>  trouveremploi(int idpersonnel);
	
	public List<Demandesortie> trouverdemande(int idpersonnel);

	public Typeconge findtypeconge(Object id);
	public Competence findcomp(Object id);
	
	
}

