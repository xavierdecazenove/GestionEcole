CREATE TABLE AnneeScolaire(
	Id int(8) NOT NULL PRIMARY KEY
);

CREATE TABLE Ecole(
	Id int(8) NOT NULL PRIMARY KEY,
	Nom varchar(255) NOT NULL
);


CREATE TABLE Niveau(
	Id int(8) NOT NULL PRIMARY KEY,
	Nom varchar(255) NOT NULL
);


CREATE TABLE Personne(
	Id int(8) NOT NULL PRIMARY KEY,
	Nom varchar(255) NOT NULL,
	Prenom varchar(255) NOT NULL,
	Type varchar(255) NOT NULL
);


CREATE TABLE Classe(
	Id int(8) NOT NULL PRIMARY KEY,
	IdEcole int(8) NOT NULL,
	IdAnneeScolaire int(8) NOT NULL,
	IdNiveau int(8) NOT NULL,
	Nom varchar(255) NOT NULL,

	FOREIGN KEY (IdEcole) REFERENCES Ecole(Id) ON DELETE CASCADE,
	FOREIGN KEY (IdAnneeScolaire) REFERENCES AnneeScolaire(Id) ON DELETE CASCADE,
	FOREIGN KEY (IdNiveau) REFERENCES Niveau(Id) ON DELETE CASCADE
);

CREATE TABLE Inscription(
	Id int(8) NOT NULL PRIMARY KEY,
	IdClasse int(8) NOT NULL,
	IdPersonne int(8) NOT NULL,

	FOREIGN KEY (IdClasse) REFERENCES Classe(Id) ON DELETE CASCADE,
	FOREIGN KEY (IdPersonne) REFERENCES Personne(Id) ON DELETE CASCADE
);


CREATE TABLE Trimestre(
	Id int(8) NOT NULL PRIMARY KEY,
	IdAnneeScolaire int(8) NOT NULL,
	Numero int(8) NOT NULL,
	Debut DATE NOT NULL,
	Fin DATE NOT NULL,

	FOREIGN KEY (IdAnneeScolaire) REFERENCES AnneeScolaire(Id) ON DELETE CASCADE
);

CREATE TABLE Bulletin(
	Id int(8) NOT NULL PRIMARY KEY,
	IdTrimestre int(8) NOT NULL,
	IdInscription int(8) NOT NULL,
	Appreciation varchar(255) NOT NULL,

	FOREIGN KEY (IdTrimestre) REFERENCES Trimestre(Id) ON DELETE CASCADE,
	FOREIGN KEY (IdInscription) REFERENCES Inscription(Id) ON DELETE CASCADE
);

CREATE TABLE Discipline(
	Id int(8) NOT NULL PRIMARY KEY,
	Nom varchar(255) NOT NULL
);


CREATE TABLE Enseignement(
	Id int(8) NOT NULL PRIMARY KEY,
	IdClasse int(8) NOT NULL,
	IdDiscipline int(8) NOT NULL,
	IdPersonne int(8) NOT NULL,

	FOREIGN KEY (IdClasse) REFERENCES Classe(Id) ON DELETE CASCADE,
	FOREIGN KEY (IdDiscipline) REFERENCES Discipline(Id) ON DELETE CASCADE,
	FOREIGN KEY (IdPersonne) REFERENCES Personne(Id) ON DELETE CASCADE
);

CREATE TABLE DetailBulletin(
	Id int(8) NOT NULL PRIMARY KEY,
	IdEnseignement int(8) NOT NULL,
	IdBulletin int(8) NOT NULL,
	Appreciation varchar(255) NOT NULL,

	FOREIGN KEY (IdEnseignement) REFERENCES Enseignement(Id) ON DELETE CASCADE,
	FOREIGN KEY (IdBulletin) REFERENCES Bulletin(Id) ON DELETE CASCADE
);

CREATE TABLE Evaluation(
	Id int(8) NOT NULL PRIMARY KEY,
	IdDetailBulletin int(8) NOT NULL,
	Note int(8) NOT NULL,
	Appreciation varchar(255) NOT NULL,

	FOREIGN KEY (IdDetailBulletin) REFERENCES DetailBulletin(Id) ON DELETE CASCADE
);




-- Annee --
INSERT INTO AnneeScolaire (Id) VALUES (2018);
INSERT INTO AnneeScolaire (Id) VALUES (2019);



-- Ecole --
INSERT INTO Ecole (Id, Nom) VALUES (100,"ECE Paris");


-- Niveau --
INSERT INTO Niveau (Id, Nom) VALUES (150,"ING12018");
INSERT INTO Niveau (Id, Nom) VALUES (151,"ING22018");
INSERT INTO Niveau (Id, Nom) VALUES (152,"ING12019");
INSERT INTO Niveau (Id, Nom) VALUES (153,"ING22019");



-- Personnes --
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (200,"Segado","Jean-Pierre", "Enseignant");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (201,"Hina","Manolo", "Enseignant");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (202,"Djoko","Novac", "Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (203,"Federer","Roger", "Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (204,"Dupont","Julia","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (205,"Merlin","Denise","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (206,"Lebrun","Jerome","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (207,"Xerato","Fabien","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (208,"Duvail","Antoinette","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (209,"Lomet","Bernard","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (210,"Monet","Joelle","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (211,"Minard","Clotilde","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (212,"Kikou","Laetitia","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (213,"De la Rivière","Giselle","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (214,"Monet","Joelle","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (215,"Martin de la Court","Cléophée","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (216,"Cristaline","Elena","Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (217,"Bonheur","Rosa","Eleve");








INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (250,100,2018,150, "TD1");
INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (251,100,2018,150, "TD2");

INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (252,100,2018,151, "TD1");
INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (253,100,2018,151, "TD2");

INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (254,100,2019,152, "TD1");
INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (255,100,2019,152, "TD2");

INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (256,100,2019,153, "TD1");
INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (257,100,2019,153, "TD2");







-- 2018 --
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (300,250,202);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (301,250,203);

INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (302,251,204);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (303,251,205);

INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (304,252,206);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (305,252,207);

INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (306,253,208);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (307,253,209);
-- 2019 --
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (308,254,210);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (309,254,211);

INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (310,255,212);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (311,255,213);

INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (312,256,214);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (313,256,215);

INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (314,257,216);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (315,257,217);









INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (350,2018,1,'2018-09-01','2018-12-01');
INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (351,2018,2,'2018-12-02','2019-02-01');
INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (352,2018,3,'2019-02-02','2019-05-01');

INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (353,2019,1,'2019-09-01','2019-12-01');
INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (354,2019,2,'2019-12-02','2020-02-01');
INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (355,2019,3,'2020-02-02','2020-05-01');








-- Bulletin inscription 300  TD1 ING1 2018 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (401,350,300,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (402,351,300,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (403,352,300,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 301  TD1 ING1 2018 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (448,352,301,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (404,351,301,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (405,352,301,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 302  TD2 ING1 2018 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (406,350,302,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (407,351,302,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (408,352,302,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 303  TD2 ING1 2018 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (409,350,303,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (410,351,303,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (411,352,303,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 304  TD1 ING2 2018 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (412,350,304,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (413,351,304,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (414,352,304,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 305  TD1 ING2 2018 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (415,350,305,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (416,351,305,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (417,352,305,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 306  TD2 ING2 2018 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (418,350,306,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (419,351,306,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (420,352,306,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 307  TD2 ING2 2018 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (421,350,307,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (422,351,307,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (423,352,307,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 308  TD1 ING1 2019 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (424,353,308,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (425,354,308,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (426,355,308,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 309  TD1 ING1 2019 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (427,353,309,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (428,354,309,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (429,355,309,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 310  TD2 ING1 2019 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (430,353,310,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (431,354,310,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (432,355,310,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 311  TD2 ING1 2019 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (433,353,311,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (434,354,311,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (435,355,311,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 312  TD1 ING2 2019 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (447,353,312,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (436,354,312,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (437,355,312,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 313  TD1 ING2 2019 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (438,353,313,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (439,354,313,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (440,355,313,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 314  TD2 ING2 2019 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (441,353,314,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (442,354,314,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (443,355,314,"Un excellent trimestre, Bravo !");
-- Bulletin inscription 315  TD2 ING2 2019 trimestre 1,2,3 --
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (444,353,315,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (445,354,315,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (446,355,315,"Un excellent trimestre, Bravo !");







-- Discipline --
INSERT INTO Discipline (Id, Nom) VALUES (450,"Informatique");
INSERT INTO Discipline (Id, Nom) VALUES (451,"Mathematiques");








INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (500,250,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (501,250,451,201);

INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (502,251,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (503,251,451,201);

INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (504,252,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (505,252,451,201);

INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (506,253,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (507,253,451,201);

INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (508,253,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (509,253,451,201);

INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (510,254,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (511,254,451,201);

INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (512,255,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (513,255,451,201);

INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (514,256,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (515,256,451,201);

INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (516,257,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (517,257,451,201);







-- 3 bulletins par personne --
-- detail bulletin avec 2 detailbulletin 500/501 par bulletin --

-- eleve inscription 300, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5500,500,401,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5501,501,401,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5502,500,402,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5503,501,402,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5504,500,403,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5505,501,403,"Un excellent trimestre, Bravo !");


-- eleve inscription 301, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5506,500,448,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5507,501,448,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5508,500,404,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (5509,501,404,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55010,500,405,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55011,501,405,"Un excellent trimestre, Bravo !");

-- eleve inscription 302, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55012,500,406,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55013,501,406,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55014,500,407,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55015,501,407,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55016,500,408,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55017,501,408,"Un excellent trimestre, Bravo !");

-- eleve inscription 303, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55018,500,409,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55019,501,409,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55020,500,410,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55021,501,410,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55022,500,411,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55023,501,411,"Un excellent trimestre, Bravo !");

-- eleve inscription 304, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55024,500,412,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55025,501,412,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55026,500,413,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55027,501,413,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55028,500,414,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55029,501,414,"Un excellent trimestre, Bravo !");

-- eleve inscription 305, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55030,500,415,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55031,501,415,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55032,500,416,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55033,501,416,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55034,500,417,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55035,501,417,"Un excellent trimestre, Bravo !");

-- eleve inscription 306, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55036,500,418,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55037,501,418,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55038,500,419,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55039,501,419,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55040,500,420,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55041,501,420,"Un excellent trimestre, Bravo !");

-- eleve inscription 307, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55042,500,421,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55043,501,421,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55044,500,422,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55045,501,422,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55046,500,423,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55047,501,423,"Un excellent trimestre, Bravo !");

-- eleve inscription 308, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55048,500,424,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55049,501,424,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55050,500,425,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55051,501,425,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55052,500,426,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55053,501,426,"Un excellent trimestre, Bravo !");

-- eleve inscription 309, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55054,500,427,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55055,501,427,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55056,500,428,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55057,501,428,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55058,500,429,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55059,501,429,"Un excellent trimestre, Bravo !");

-- eleve inscription 310, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55060,500,430,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55061,501,430,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55062,500,431,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55063,501,431,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55064,500,432,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55065,501,432,"Un excellent trimestre, Bravo !");

-- eleve inscription 311, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55066,500,433,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55067,501,433,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55068,500,434,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55069,501,434,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55070,500,435,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55071,501,435,"Un excellent trimestre, Bravo !");

-- eleve inscription 312, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55072,500,447,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55073,501,447,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55074,500,436,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55075,501,436,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55076,500,437,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55077,501,437,"Un excellent trimestre, Bravo !");

-- eleve inscription 313, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55078,500,438,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55079,501,438,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55080,500,439,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55081,501,439,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55082,500,440,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55083,501,440,"Un excellent trimestre, Bravo !");

-- eleve inscription 314, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55084,500,441,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55085,501,441,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55086,500,442,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55087,501,442,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55088,500,443,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55089,501,443,"Un excellent trimestre, Bravo !");

-- eleve inscription 315, pour ses trois bulletins --
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55090,500,444,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55091,501,444,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55092,500,445,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55093,501,445,"Un excellent trimestre, Bravo !");

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55094,500,446,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (55095,501,446,"Un excellent trimestre, Bravo !");













-- Note pour les bulletins eleve inscription 300 --
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6000,5500,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6001,5500,12,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6002,5501,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6003,5501,19,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6004,5502,16,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6005,5502,11,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6006,5503,17,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6007,5503,11,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6008,5504,12,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6009,5504,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60010,5505,1,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60011,5505,18,"un excellent travail");



-- Note pour les bulletins eleve inscription 301 --
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60012,5506,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60013,5506,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60014,5507,19,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60015,5507,20,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60016,5508,2,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60017,5508,8,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60018,5509,10,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60019,5509,11,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60020,55010,14,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60021,55010,4,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60022,55011,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60023,55011,19,"un excellent travail");


-- Note pour les bulletins eleve inscription 302 --
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60024,55012,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60025,55012,15,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60026,55013,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60027,55013,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60028,55014,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60029,55014,16,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60030,55015,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60031,55015,16,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60032,55016,12,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60033,55016,8,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60034,55017,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60035,55017,12,"un excellent travail");

-- Note pour les bulletins eleve inscription 303 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60036,55018,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60037,55018,18,"un excellent travail");



INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60040,55019,2,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60041,55019,17,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60042,55020,16,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60043,55020,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60044,55021,10,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60045,55021,11,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60046,55022,13,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60047,55022,12,"un excellent travail");



INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60048,55023,19,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60049,55023,20,"un excellent travail");

-- Note pour les bulletins eleve inscription 304 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60050,55024,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60051,55024,8,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60052,55025,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60053,55025,12,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60054,55026,19,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60055,55026,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60056,55027,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60057,55027,20,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60058,55028,10,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60059,55028,12,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60060,55029,19,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60061,55029,17,"un excellent travail");


-- Note pour les bulletins eleve inscription 305 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60062,55030,17,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60063,55030,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60064,55031,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60065,55031,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60066,55032,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60067,55032,12,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60068,55033,1,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60069,55033,8,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60070,55034,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60071,55034,18,"un excellent travail");


INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60072,55035,19,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60073,55035,10,"un excellent travail");

-- Note pour les bulletins eleve inscription 306 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60074,55036,19,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60075,55036,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60076,55037,16,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60077,55037,14,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60078,55038,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60079,55038,13,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60080,55039,19,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60081,55039,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60082,55040,10,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60083,55040,11,"un excellent travail");



INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60084,55041,13,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60085,55041,11,"un excellent travail");

-- Note pour les bulletins eleve inscription 307 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60086,55042,13,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60087,55042,17,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60088,55043,14,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60089,55043,15,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60090,55044,1,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60091,55044,0,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60092,55045,1,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60093,55045,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60094,55046,1,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60095,55046,8,"un excellent travail");


INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60096,55047,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60097,55047,17,"un excellent travail");

-- Note pour les bulletins eleve inscription 308 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60098,55048,10,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60099,55048,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600100,55049,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600101,55049,12,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600102,55050,13,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600103,55050,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6567,55051,16,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6987,55051,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6576,55052,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600104,55052,7,"un excellent travail");



INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(65467,55053,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(69823,55053,18,"un excellent travail");

-- Note pour les bulletins eleve inscription 309 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(36376,55054,10,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(98938,55054,1,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(89378,55055,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(898776,55055,13,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(98987,55056,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600345,55056,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(63560,55057,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(69990,55057,12,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6880,55058,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(69999,55058,18,"un excellent travail");


INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(61110,55059,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6123400,55059,18,"un excellent travail");

-- Note pour les bulletins eleve inscription 310 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6090900,55060,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600000,55060,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600090,55061,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60067676,55061,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6098900,55062,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60900,55062,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600099,55063,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6078870,55063,11,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(69820,55064,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6090,55064,1,"un excellent travail");



INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(1,55065,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(2,55065,18,"un excellent travail");

-- Note pour les bulletins eleve inscription 311 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3,55066,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(4,55066,16,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(5,55067,15,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(6,55067,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(7,55068,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(8,55068,8,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(9,55069,13,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(10,55069,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(111,55070,13,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(1234,55070,8,"un excellent travail");



INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(7676,55071,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(78,55071,10,"un excellent travail");

-- Note pour les bulletins eleve inscription 312 --
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(81,55072,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(90,55072,8,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60,55073,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(60134,55073,20,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(2345,55074,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(123,55074,14,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(25,55075,14,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(901,55075,19,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(909,55076,0,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(9001,55076,14,"un excellent travail");



INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(9191,55077,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(9292,55077,12,"un excellent travail");

-- Note pour les bulletins eleve inscription 313 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(15015,55078,12,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(16106,55078,13,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(17170,55079,15,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(18180,55079,9,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(190190,55080,9,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(20200,55080,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3000,55081,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3010,55081,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3002,55082,6,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3003,55082,8,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3004,55083,4,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3030,55083,18,"un excellent travail");

-- Note pour les bulletins eleve inscription 314 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(15151,55084,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(16116,55084,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(17117,55085,13,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(18118,55085,12,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(191019,55086,15,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(20120,55086,15,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3100,55087,10,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3101,55087,18,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3014,55088,16,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3011,55088,17,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3012,55089,2,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3013,55089,3,"un excellent travail");


-- Note pour les bulletins eleve inscription 315 --

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(15215,55090,11,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(16216,55090,10,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(17217,55091,10,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(18218,55091,2,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(192019,55092,8,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(20220,55092,1,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3020,55093,7,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3201,55093,11,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3021,55094,3,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3022,55094,12,"un excellent travail");

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3023,55095,16,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(3024,55095,13,"un excellent travail");


