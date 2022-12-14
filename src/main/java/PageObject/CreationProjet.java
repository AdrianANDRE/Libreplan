package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CreationProjet {



        public CreationProjet(WebDriver driver) {


            super();
        }
        @FindBy(xpath = "//*[@class=\"z-button-cm\"]" )
        public WebElement ajouter;

        @FindBy(xpath = "//div/input")
        public WebElement nomProjet;

        @FindBy(xpath = "//*[@checked=\"checked\"]")
        public WebElement decocher;

        @FindBy(xpath = "//td[1]/input")
        public WebElement codeProjet;

        @FindBy(xpath = "//tr[2]/td[contains(.,'Accepter')]")
        public WebElement accepter;



        @FindBy(xpath = "//*[@title=\"Annuler l'édition\"]")
        public WebElement annulerEdition;

        @FindBy(xpath = "//*[@class=\"z-messagebox-btn z-button\"]//td[contains(.,'Annuler')]")
        public WebElement annuler;


        @FindBy(xpath = " //*[@class=\"z-button-cm\"][contains(.,'Annuler')]")
        public WebElement annulerCreation;

        @FindBy(xpath = "//tbody/tr[2]/td[contains(.,'OK')]")
        public WebElement ok;

        @FindBy(xpath = "//td[2]/div/button[contains(.,'Calendrier')]")
        public WebElement menuCalendrier;

        @FindBy(xpath = "//*[@href=\"/libreplan/planner/index.zul;orders_list\"]")
        public WebElement menuProjet;

        @FindBy(xpath = "//tr[4]/td[2]/div/i/input")
        public WebElement debutProjet;

        @FindBy(xpath = "//tr[5]/td[2]/div/i/input")
        public WebElement finProjet;

        @FindBy(xpath = "//*[@title=\"Supprimer\"]")
        public WebElement supprimerProjet;

        @FindBy(xpath = "//tr[6]/td[2]/div/span/i/input")
        public WebElement champClient;

        @FindBy(xpath = "//tr[2]/td[2]/div/span/i/input")
        public WebElement modele;

        @FindBy(xpath="//*[@class=\"z-textbox z-textbox-disd z-textbox-text-disd\"]")
        public WebElement champGrise;

        @FindBy(xpath="//*[@class=\"z-combobox-inp\"][@value=\"Default\"]")
        public WebElement calendrierDefault;

        @FindBy(xpath="//*[@class=\"z-window-modal-cnt\"]")
        public WebElement popUpSortie;


        @FindBy(xpath="//span[@class=\"z-tab-text\"][contains(text(),'WBS')]")
        public WebElement WBS;



        @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(),'Détail du projet')]")
        public WebElement detailProjet;



        @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(),'Planification des projets')]")
        public WebElement planificationDesProjets;

        @FindBy(xpath="//span[@class=\"z-label\"][contains(text(),'PROJET_TEST1')]")
        public WebElement verifProjet;


        @FindBy(xpath="//td[@class=\"z-button-cm\"][contains(text(),'Liste des projets')]")
        public WebElement listeDesProjets;

        @FindBy(xpath="//img[@src=\"/libreplan/common/img/ico_save.png\"]")
        public WebElement disquette;
        @FindBy(xpath="//table[@class=\"z-button-over\"]")
        public WebElement infoBulle;










        public void  creerUnprojet(String nomDuProjet, String numerosProjet, String dateDebutprojet, String dateFinProjet) {




                //Cliquer sur l'icône "Créer un nouveau projet" (1ère icône "+" située en dessous du logo "LibrePlan").
                ajouter.click();
                //Affichage d'une pop-up "Créer un nouveau projet"
                //Nom : Champ de saisie non renseigné
                assertTrue(nomProjet.getText().isEmpty());

                assertTrue(decocher.isDisplayed());
                //Modèle : Liste déroulante non renseignée
                assertTrue(modele.getText().isEmpty());
                // Code : Champ de saisie renseigné avec une valeur par défaut non modifiable et grisé. La case "Générer le code" associée à ce champ est cochée par défaut
                assertTrue(champGrise.isDisplayed());
                // Date de début : champ de saisie de date associé à un calendrier. Par défaut, la date affichée est la date du jour. Le format de la date correspond à l'exemple suivant : "25 janv. 2017"
                assertTrue(debutProjet.isDisplayed());
                // Echéance : champ de saisie de date associé à un calendrier. Par défaut, le champ n'est pas renseigné.
                assertTrue(finProjet.getText().isEmpty());

                // Client : Champ de saisie non renseigné
                assertTrue(champClient.getText().isEmpty());

                // Calendrier : Liste déroulante avec pour valeur par défaut "Default"
                assertTrue(calendrierDefault.isDisplayed());

                // Boutons [Accepter] et [Annuler]
                assertTrue(accepter.isDisplayed());
                assertTrue(annulerCreation.isDisplayed());





                //Select select = new Select(dropdownType);
                //        String dropdownDefaultValue = select.getFirstSelectedOption().getText();
                //        assertEquals("Ressource normale",dropdownDefaultValue);

                //Renseigner l'ensemble des champs avec les valeurs suivantes :
                //Nom : PROJET_TEST1
                nomProjet.sendKeys(nomDuProjet);
                //Code : décocher la case "Générer le code"
                // puis saisir la valeur suivante dans le champ de saisie qui devient éditable : "PRJTEST001"
                decocher.click();
                codeProjet.clear();
                codeProjet.sendKeys(numerosProjet);
                //Date de début :  date J+5
                debutProjet.clear();
                debutProjet.sendKeys(dateDebutprojet);
                //Echeance :  date J+15
                finProjet.sendKeys(dateFinProjet);
                //Cliquer sur le bouton [Accepter].
                accepter.click();
                //Le projet est créé :

                //Dans le menu vertical à gauche de la page -> menu affiché = "Détail du projet"
                assertTrue(detailProjet.isDisplayed());

                //Dans le menu horizontal -> onglet affiché = "WBS (tâches)"
                assertTrue(WBS.isDisplayed());

        }

        public void supprimerLeProjet(){
                supprimerProjet.click();
                ok.click();

        }



        public void testVerifButton1(WebDriver driver) {
                Actions a = new Actions(driver);

                //Vérifier la présence des boutons d'enregistrement et d'annulation de l'édition du projet.
                //- Bouton d'enregistrement :
                //icône représentant une disquette
                //infobulle associée à l'icône "Enregistrer le projet"
                a.moveToElement(disquette).perform();
                assertTrue(infoBulle.isDisplayed());

                //- Bouton d'annulation de l'édition : icône représentant une flèche retour
                a.moveToElement(annulerEdition).perform();
                assertTrue(infoBulle.isDisplayed());
                //infobulle associée à l'icône "Annuler l'édition"


        }


        public void testAnnulerEdition1 (){

                //Vérifier la présence des boutons d'enregistrement et d'annulation de l'édition du projet.
                //- Bouton d'enregistrement :
                //icône représentant une disquette
                //infobulle associée à l'icône "Enregistrer le projet"
                //- Bouton d'annulation de l'édition : icône représentant une flèche retour
                assertTrue(annulerEdition.isDisplayed());
                //infobulle associée à l'icône "Annuler l'édition"


               // Cliquer sur le bouton d'annulation de l'édition du projet.
                annulerEdition.click();
                //Affichage d'une pop-up "Confirmer la fenêtre de sortie" contenant :le message suivant :"Les modifications non enregistrées seront perdues
                //Etes-vous sûr ?"
                assertTrue(popUpSortie.isDisplayed());
                //les boutons [OK] et [Annuler]
                assertTrue(annuler.isDisplayed());
                assertTrue(ok.isDisplayed());

                //Dans la pop-up, cliquer sur le bouton [Annuler].
                annuler.click();

                //Fermeture de la pop-up "Confirmer la fenêtre de sortie"
                //Dans le menu vertical à gauche de la page -> menu affiché = "Détail du projet"
                assertTrue(detailProjet.isDisplayed());

                //Dans le menu horizontal -> onglet affiché = "WBS (tâches)"
                assertTrue(WBS.isDisplayed());


        }
        public void testAnnulerEdition2(){
                //Cliquer sur le bouton d'annulation de l'édition du projet.
                annulerEdition.click();


                //Dans la pop-up, cliquer sur le bouton [OK].
                ok.click();
               // Fermeture de la pop-up "Confirmer la fenêtre de sortie"


                //Dans le menu vertical à gauche de la page -> menu affiché = "Planification des projets"
                assertTrue(planificationDesProjets.isDisplayed());


        }

        public void  afficherProjets (WebDriver driver){
                //Passer la souris sur l'onglet "Calendrier" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Projets".

                Actions a = new Actions(driver);
                a.moveToElement(menuCalendrier).perform();
                menuProjet.click();
                //La liste est affichée à droite du menu vertical, le projet créé y est présent.
                assertTrue(verifProjet.isDisplayed());
                //Dans le menu vertical à gauche de la page -> menu affiché = "Liste des projets".
                assertTrue(listeDesProjets.isDisplayed());
                //Vérifier la conformité des informations affichées pour le projet dans la liste affichée.

                // Nom : PROJET_TEST1
                //Code : PRJTEST001

                // Date de début : date J+5

                //Echéance : date J+15

                //Client : champ non renseigné

                //Budget total : 0 €

                // Heures : 0

                // : PRE-VENTES

                // Opérations : 4 icones : modifier, supprimer, voir la prévision, créer un modèl


        }



}
