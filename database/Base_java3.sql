CREATE TABLE AnneeScolaire(
	Id int(8) NOT NULL PRIMARY KEY
);

INSERT INTO AnneeScolaire (Id) VALUES (2018);
INSERT INTO AnneeScolaire (Id) VALUES (2019);

CREATE TABLE Ecole(
	Id int(8) NOT NULL PRIMARY KEY,
	Nom varchar(255) NOT NULL
);

INSERT INTO Ecole (Id, Nom) VALUES (100,"ECE Paris");

CREATE TABLE Niveau(
	Id int(8) NOT NULL PRIMARY KEY,
	Nom varchar(255) NOT NULL
);

INSERT INTO Niveau (Id, Nom) VALUES (150,"ING1");
INSERT INTO Niveau (Id, Nom) VALUES (151,"ING2");

CREATE TABLE Personne(
	Id int(8) NOT NULL PRIMARY KEY,
	Nom varchar(255) NOT NULL,
	Prenom varchar(255) NOT NULL,
	Type varchar(255) NOT NULL
);

INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (200,"Segado","Jean-Pierre", "Enseignant");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (201,"Hina","Manolo", "Enseignant");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (202,"Djoko","Novac", "Eleve");
INSERT INTO Personne (Id, Nom, Prenom, Type) VALUES (203,"Federer","Roger", "Eleve");

CREATE TABLE Classe(
	Id int(8) NOT NULL PRIMARY KEY,
	IdEcole int(8) NOT NULL,
	IdAnneeScolaire int(8) NOT NULL,
	IdNiveau int(8) NOT NULL,
	Nom varchar(255) NOT NULL,

	FOREIGN KEY (IdEcole) REFERENCES Ecole(Id),
	FOREIGN KEY (IdAnneeScolaire) REFERENCES AnneeScolaire(Id),
	FOREIGN KEY (IdNiveau) REFERENCES Niveau(Id)
);

INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (250,100,2018,150, "TD1");
INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (251,100,2018,150, "TD2");
INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (252,100,2019,151, "TD1");
INSERT INTO Classe (Id, IdEcole, IdAnneeScolaire, IdNiveau, Nom) VALUES (253,100,2019,151, "TD2");

CREATE TABLE Inscription(
	Id int(8) NOT NULL PRIMARY KEY,
	IdClasse int(8) NOT NULL,
	IdPersonne int(8) NOT NULL,

	FOREIGN KEY (IdClasse) REFERENCES Classe(Id),
	FOREIGN KEY (IdPersonne) REFERENCES Personne(Id)
);

INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (300,250,202);
INSERT INTO Inscription (Id, IdClasse, IdPersonne) VALUES (301,251,203);


CREATE TABLE Trimestre(
	Id int(8) NOT NULL PRIMARY KEY,
	IdAnneeScolaire int(8) NOT NULL,
	Numero int(8) NOT NULL,
	Debut DATE NOT NULL,
	Fin DATE NOT NULL,

	FOREIGN KEY (IdAnneeScolaire) REFERENCES AnneeScolaire(Id)
);

INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (350,2018,1,'2018-09-01','2018-12-01');
INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (351,2018,2,'2018-12-02','2019-02-01');
INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (352,2018,3,'2019-02-02','2019-05-01');

INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (353,2019,1,'2019-09-01','2019-12-01');
INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (354,2019,2,'2019-12-02','2020-02-01');
INSERT INTO Trimestre (Id, IdAnneeScolaire, Numero, Debut, Fin) VALUES (355,2019,3,'2020-02-02','2020-05-01');

CREATE TABLE Bulletin(
	Id int(8) NOT NULL PRIMARY KEY,
	IdTrimestre int(8) NOT NULL,
	IdInscription int(8) NOT NULL,
	Appreciation varchar(255) NOT NULL,

	FOREIGN KEY (IdTrimestre) REFERENCES Trimestre(Id),
	FOREIGN KEY (IdInscription) REFERENCES Inscription(Id)
);
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (400,351,300,"Un excellent trimestre, Bravo !");
INSERT INTO Bulletin (Id, IdTrimestre, IdInscription, Appreciation) VALUES (401,351,301,"Un excellent trimestre, Bravo !");

CREATE TABLE Discipline(
	Id int(8) NOT NULL PRIMARY KEY,
	Nom varchar(255) NOT NULL
);
INSERT INTO Discipline (Id, Nom) VALUES (450,"Informatique");
INSERT INTO Discipline (Id, Nom) VALUES (451,"Mathematiques");

CREATE TABLE Enseignement(
	Id int(8) NOT NULL PRIMARY KEY,
	IdClasse int(8) NOT NULL,
	IdDiscipline int(8) NOT NULL,
	IdPersonne int(8) NOT NULL,

	FOREIGN KEY (IdClasse) REFERENCES Classe(Id),
	FOREIGN KEY (IdDiscipline) REFERENCES Discipline(Id),
	FOREIGN KEY (IdPersonne) REFERENCES Personne(Id)
);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (500,250,450,200);
INSERT INTO Enseignement (Id, IdClasse, IdDiscipline, IdPersonne) VALUES (501,251,451,201);


CREATE TABLE DetailBulletin(
	Id int(8) NOT NULL PRIMARY KEY,
	IdEnseignement int(8) NOT NULL,
	IdBulletin int(8) NOT NULL,
	Appreciation varchar(255) NOT NULL,

	FOREIGN KEY (IdEnseignement) REFERENCES Enseignement(Id),
	FOREIGN KEY (IdBulletin) REFERENCES Bulletin(Id)
);

INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (550,500,400,"Un excellent trimestre, Bravo !");
INSERT INTO DetailBulletin (Id, IdEnseignement, IdBulletin, Appreciation) VALUES (551,501,401,"Un excellent trimestre, Bravo !");


CREATE TABLE Evaluation(
	Id int(8) NOT NULL PRIMARY KEY,
	IdDetailBulletin int(8) NOT NULL,
	Note int(8) NOT NULL,
	Appreciation varchar(255) NOT NULL,

	FOREIGN KEY (IdDetailBulletin) REFERENCES DetailBulletin(Id)
);

INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(600,550,18,"un excellent travail");
INSERT INTO Evaluation (Id, IdDetailBulletin, Note, Appreciation) VALUES(601,551,18,"un excellent travail");





