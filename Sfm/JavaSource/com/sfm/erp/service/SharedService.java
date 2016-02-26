package com.sfm.erp.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sfm.erp.dao.*;
import com.sfm.erp.model.*;

@Service("sharedService")
@Transactional
public class SharedService implements Serializable, ISharedService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	IFormationDao frdao;
	@Autowired
	IDiplomeDao depdao;
	
	@Autowired
	IEmploiprecedentDao emploidao;
	
	
	@Autowired
	INotificationDao notidao;
	
	@Autowired
	IDocumentDao docsdao;
	
	@Autowired
	IDemandesortieDao demdao;
	
	@Autowired
	IConsultantDao consdao ; 
	@Autowired
	IEventDao eventdao ;
	
	public IFormationDao getFrdao() {
		return frdao;
	}

	public void setFrdao(IFormationDao frdao) {
		this.frdao = frdao;
	}

	@Autowired
	ICompteDao cdao;
	@Autowired
	IEvaluationDao evaldao;
	@Autowired
	ICongDao congdao;

	
	@Autowired
	IBanqueDao bdao;
	@Autowired
	ISfmDao sdao;
	@Autowired
	IPersonnelDao persodao;
	@Autowired
	IpropositionDao pdao;
	@Autowired
	IClientDao cldao;
	@Autowired
	IOffreDao odao;


	@Autowired
	ICompetenceDao compdao;
	@Autowired
	ITypecongeDao typedao;
	@Autowired
	IThemeDao themedao;
	@Autowired
	IDepartementDao deaprtementdao;
	public IBanqueDao getBdao() {
		return bdao;
	}

	public ITypecongeDao getTypedao() {
		return typedao;
	}

	public void setTypedao(ITypecongeDao typedao) {
		this.typedao = typedao;
	}

	public IThemeDao getThemedao() {
		return themedao;
	}

	public void setThemedao(IThemeDao themedao) {
		this.themedao = themedao;
	}

	public IDepartementDao getDeaprtementdao() {
		return deaprtementdao;
	}

	public void setDeaprtementdao(IDepartementDao deaprtementdao) {
		this.deaprtementdao = deaprtementdao;
	}

	public void setBdao(IBanqueDao bdao) {
		this.bdao = bdao;
	}

	public ISfmDao getSdao() {
		return sdao;
	}

	public void setSdao(ISfmDao sdao) {
		this.sdao = sdao;
	}

	public IpropositionDao getPdao() {
		return pdao;
	}

	public void setPdao(IpropositionDao pdao) {
		this.pdao = pdao;
	}

	public IClientDao getCldao() {
		return cldao;
	}

	public void setCldao(IClientDao cldao) {
		this.cldao = cldao;
	}

	public IOffreDao getOdao() {
		return odao;
	}

	public void setOdao(IOffreDao odao) {
		this.odao = odao;
	}

	public void setCdao(ICompteDao cdao) {
		this.cdao = cdao;
	}

	
	
	public IDiplomeDao getDepdao() {
		return depdao;
	}

	public void setDepdao(IDiplomeDao depdao) {
		this.depdao = depdao;
	}

	public IEmploiprecedentDao getEmploidao() {
		return emploidao;
	}

	public void setEmploidao(IEmploiprecedentDao emploidao) {
		this.emploidao = emploidao;
	}

	public ICompetenceDao getCompdao() {
		return compdao;
	}

	public void setCompdao(ICompetenceDao compdao) {
		this.compdao = compdao;
	}
	
	
	public IEvaluationDao getEvaldao() {
		return evaldao;
	}

	public void setEvaldao(IEvaluationDao evaldao) {
		this.evaldao = evaldao;
	}

	public ICongDao getCongdao() {
		return congdao;
	}

	public void setCongdao(ICongDao congdao) {
		this.congdao = congdao;
	}

	// creation des objets
	@Override
	public SFM createS(SFM sfm) {

		return sdao.create(sfm);
	}
	
	
	
	@Override
 public Notification createnoti(Notification noti ) 
	{
		return notidao.create(noti);
		
	}
	
	
	@Override
	public   Document createdocs(Document docs)
	{
		
		return docsdao.create(docs);
	}

	@Override
	public Evaluation createeval(Evaluation eval) {

		return evaldao.create(eval);
	}
	
	@Override
	public Cong createcong(Cong cong) {

		return congdao.create(cong);
	}
	@Override
	public void deletecong(Object id)
	{
		congdao.delete(id);
	}
	
	
	@Override
	public void deleteeval(Object id)
	{
		evaldao.delete(id);
	}
	
	
	@Override
public void deletenoti(Object id)
{
	notidao.delete(id);
}
	
	
	public Cong updatecong(Cong cong )
	{
		return congdao.update(cong);	
	}

	
	
	
	public Notification updatenoti(Notification noti )
	{return notidao.update(noti);
		
	}
	
	public List<Document> listdocs()
	{
		return docsdao.list();
	}


	public Document updatedocs(Document docs)
	{
		return docsdao.update(docs);	
	}
	
	@Override
	public List<Cong> listcong()
	{
		return congdao.list();
		
	}
	
	@Override
	public List<Notification> listnoti()
	{
		return notidao.list();
	}
	
	@Override
	public List<Evaluation> listeval()
	{
		return evaldao.list();
		
	}
	
	
	
	
	
	@Override
	public Typeconge createty(Typeconge typeconge)
	{
		return typedao.create(typeconge);
	
	}
	
	@Override
	public  Theme createthe(Theme th)
	{
		return themedao.create(th);	
	}
	
	@Override
	public Departement  createdepar(Departement dep)
	{
		return deaprtementdao.create(dep);
	}


	@Override
	public Competence createCo(Competence com) {

		return compdao.create(com);
	}

	


	@Override
	public Formation createFor(Formation frm) {
		return frdao.create(frm);
	}
	
	
	@Override
    public Demandesortie createdem(Demandesortie dem) 
    {
    	return demdao.create(dem);
    }

	@Override
	public Banque createB(Banque b) {

		return bdao.create(b);
	}

	@Override
	public Compte createC(Compte c) {

		return cdao.create(c);
	}

	// listage des objets
	
	
	@Override
	public List<SFM> listSFM() {

		return sdao.list();
	}
	
	
	
	@Override
	public List<Demandesortie> listdem()
	{
		return demdao.list();
	}
	
	
	@Override
	public List<Typeconge> listtype()
	{
		
		return typedao.list();
	}
	
	@Override
	public List<Theme> listtheme()
	{
		return themedao.list();
		
	}
	
	@Override
	public List<Departement> listdepartement()
	{
		return  deaprtementdao.list();
	}


	@Override
	public List<Formation> listFRM() {
		
		return frdao.list();
	}

	@Override
	public List<Banque> listB() {

		return bdao.list();
	}

	@Override
	public List<Compte> listC() {

		return cdao.list();
	}
	@Override
	public List<Competence> listCompetence() {

		return compdao.list();
	}

	// update des objets
	@Override
	public SFM updateS(SFM sfm) {

		return sdao.update(sfm);
	}
	
	@Override
	public Demandesortie updatedem(Demandesortie dem)
	{
		return demdao.update(dem);
	}

	@Override
	public Evaluation updateeval(Evaluation eval) {

		return evaldao.update(eval);
	}
	
	
	@Override
	public Competence updateCompetence(Competence competence) {

		return compdao.update(competence);
	}

	@Override
	public Banque updateB(Banque b) {

		return bdao.update(b);
	}

	@Override
	public Compte updateC(Compte c) {

		return cdao.update(c);
	}

	// suppression des objets
	@Override
	public void deleteS(Object id) {
		sdao.delete(id);

	}
	
	
	
	@Override
	public void deletedem(Object id )
	{
		demdao.delete(id);
	}
	
	
	@Override
	public void deleteCompet(Object id) {
		compdao.delete(id);

	}

	@Override
	public void deleteB(Object id) {
		bdao.delete(id);
	}




	// recherche des objetsS
	@Override
	public SFM findS(Object id) {

		return sdao.find(id);
	}

	@Override
	public Banque findB(Object id) {

		return bdao.find(id);
	}
	


	@Override
	public Compte findC(Object id) {

		return cdao.find(id);
	}

	public ICompteDao getCdao() {
		return cdao;
	}

	@Override
	public Proposition createP(Proposition p) {
		return pdao.create(p);

	}

	@Override
	public List<Proposition> listP() {
		return pdao.list();

	}

	@Override
	public Proposition updateP(Proposition p) {

		return pdao.update(p);
	}

	@Override
	public void deleteP(Object id) {
		pdao.delete(id);
	}

	@Override
	public Proposition findP(Object id) {
		return pdao.find(id);

	}

	@Override
	public Client createCl(Client cl) {
		return cldao.create(cl);

	}

	@Override
	public List<Client> listCl() {
		return cldao.list();
	}

	@Override
	public Client updateCl(Client cl) {

		return cldao.update(cl);
	}

	@Override
	public void deleteCl(Object id) {
		cldao.delete(id);

	}
	

	@Override
	public void deletedocs(Object id){
		docsdao.delete(id);

	}
	

	@Override
	public Client findCl(Object id) {

		return cldao.find(id);
	}

	@Override
	public Offre createOff(Offre off) {

		return odao.create(off);
	}
	public Event createevent(Event event)
	
	{
		return eventdao.create(event);
	}

	@Override
	public List<Offre> listOffre() {

		return odao.list();
	}

	@Override
	public Offre updateOff(Offre off) {

		return odao.update(off);
	}

	@Override
	public void deleteOff(Object id) {
		odao.delete(id);

	}

	@Override
	public Offre findOff(Object id) {

		return odao.find(id);
	}

	
	@Override
	public Formation updateFrm(Formation frm) {
		return frdao.update(frm);
	}

	
	public Typeconge updatetype(Typeconge type)
	{return typedao.update(type);
		
	}
	@Override
	public void deleteFRM(Object id) {
		frdao.delete(id);

	}

	@Override
	public Formation findFRM(Object id) {
		
		return  frdao.find(id);
	}


	@Override
	public void deleteth(Object id)
	{
		themedao.delete(id);	
	}
	
	@Override
	public void deletetype(Object id)
	{
		typedao.delete(id);
	}
	
	@Override
	public void deletedepartement(Object id)
	{
		deaprtementdao.delete(id);
	}
	
	@Override
	public Personnel createperso(Personnel perso)
	{
		return persodao.create(perso);	
	}
	
	public Personnel updatepersonnel(Personnel personnel)
	{
		return persodao.update(personnel);	
	}

	public 	Consultant updatecons(	Consultant  cons)
	{
		return consdao.update(cons);	
		
	}
	
	
	public Diplome createdep(Diplome dep)
	{	
		return depdao.create(dep);
		
	}
	public Emploiprecedent createemploiprec(Emploiprecedent emploiprec)
	{
		return emploidao.create(emploiprec);
	}
	
	public Consultant createcons(Consultant cons)
	{
		return consdao.create(cons);
	}
	@Override
	public List<Personnel> listperso()
	{
		return persodao.list();
		
	}
	
	public List<Event> listevent()
	{
		return eventdao.list();
	}
	
	
	public List<Diplome> listdep()
	{
		return depdao.list();
		
	}
	public List<Consultant> listcons()
	{return consdao.list();
		
	}
	
	public List<Emploiprecedent> listemploi()
	{
		return emploidao.list();
	}
	public Diplome updatedep(Diplome  dep)
	{
		return depdao.update(dep);	
	}
	public Emploiprecedent updateemploiprec(Emploiprecedent emploiprec)
	{
		return emploidao.update(emploiprec);	
	}
	
	public Event updateevent(Event event)
	{
		return eventdao.update(event);
	}
	
	
	public void deletedep(Object id)
	{
		depdao.delete(id);
	}
	public void deleteemploiprec(Object id)
	
	{
		emploidao.delete(id);
		
	}
	
	public void deleteevent(Object id)
	{
		eventdao.delete(id);
	}
	
	@Override
	public void deleteperso(Object id)
	{
		persodao.delete(id);
	}

	public void deletecons(Object id)
	{
          consdao.delete(id);
	}


	public IPersonnelDao getPersodao() {
		return persodao;
	}

	public void setPersodao(IPersonnelDao persodao) {
		this.persodao = persodao;
	}

	@Override
	public Competence findcomp(Object id) {
		return compdao.find(id);
	}

	public Personnel findperso(Object id)
	{	
		return persodao.find(id);
		
	}
	public Typeconge findtypeconge(Object id)
	{
		return typedao.find(id);
	}


	public Diplome  finddep(Object id)
	{
		return depdao.find(id);
	}
	public Emploiprecedent findemploiprec(Object id)
	{
		return emploidao.find(id);
		
	}

	public IConsultantDao getConsdao() {
		return consdao;
	}

	public void setConsdao(IConsultantDao consdao) {
		this.consdao = consdao;
	}

	public IEventDao getEventdao() {
		return eventdao;
	}

	public void setEventdao(IEventDao eventdao) {
		this.eventdao = eventdao;
	}

	public IDocumentDao getDocsdao() {
		return docsdao;
	}

	public void setDocsdao(IDocumentDao docsdao) {
		this.docsdao = docsdao;
	}

	public IDemandesortieDao getDemdao() {
		return demdao;
	}

	public void setDemdao(IDemandesortieDao demdao) {
		this.demdao = demdao;
	}

	public INotificationDao getNotidao() {
		return notidao;
	}

	public void setNotidao(INotificationDao notidao) {
		this.notidao = notidao;
	}
	
	public List<Cong> trouvercong(int  idpersonnel)
	{
		return congdao.findCongByPerson( idpersonnel );
	}
	
	public List<Evaluation>  trouvereval(int idpersonnel)
	{
		return evaldao.findEvalByPerson( idpersonnel );
	}
	public List<Diplome>  trouverdip(int idpersonnel)
	{
		return depdao.findDiplomelByPerson( idpersonnel );
		
	}
	public List<Emploiprecedent>  trouveremploi(int idpersonnel)
	{
		return emploidao.findEmploiByPerson( idpersonnel );
	}
	
	public List<Demandesortie> trouverdemande(int idpersonnel)
	{
		return demdao.findDemandeByPerson( idpersonnel );
		
	}


	
	
}
