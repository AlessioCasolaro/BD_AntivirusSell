CREATE DATABASE antivirus;
USE antivirus;

-- -----------------------------------------------------
-- Tabella cliente
-- -----------------------------------------------------
CREATE TABLE  cliente (
  codice INT UNSIGNED NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) NOT NULL,
  telefono varchar(10) NOT NULL,
  PRIMARY KEY (codice))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabella antivirus
-- -----------------------------------------------------
CREATE TABLE  antivirus (
  nome VARCHAR(45) NOT NULL,
  versione INT UNSIGNED NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  PRIMARY KEY (nome))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabella licenza
-- -----------------------------------------------------
CREATE TABLE  licenza (
  seriale VARCHAR(45) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  prezzo FLOAT UNSIGNED NOT NULL,
  scadenza DATE NOT NULL,
  cliente_codice INT UNSIGNED NOT NULL,
  antivirus_nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (seriale),
    FOREIGN KEY (cliente_codice)
    REFERENCES cliente (codice)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (antivirus_nome)
    REFERENCES antivirus (nome)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabella virus_conosciuto
-- -----------------------------------------------------
CREATE TABLE  virus_conosciuto (
  nome VARCHAR(45) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  data_primo_rilevamento DATE NOT NULL,
  data_aggiornamento DATE NULL,
  PRIMARY KEY (nome))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabella privato
-- -----------------------------------------------------
CREATE TABLE  privato (
  codice_fiscale VARCHAR(45) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  cognome VARCHAR(45) NOT NULL,
  cliente_codice INT UNSIGNED NOT NULL,
  PRIMARY KEY (codice_fiscale),
    FOREIGN KEY (cliente_codice)
    REFERENCES cliente (codice)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabella azienda
-- -----------------------------------------------------
CREATE TABLE  azienda (
  p_iva VARCHAR(45) NOT NULL,
  nome_azienda VARCHAR(45) NOT NULL,
  nome_titolare VARCHAR(45) NOT NULL,
  cognome_titolare VARCHAR(45) NOT NULL,
  n_licenze INT UNSIGNED NOT NULL,
  cliente_codice INT UNSIGNED NOT NULL,
  PRIMARY KEY (p_iva),
    FOREIGN KEY (cliente_codice)
    REFERENCES cliente (codice)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabella quarantena
-- -----------------------------------------------------
CREATE TABLE  quarantena (
  motivo VARCHAR(100) NOT NULL,
  dataq DATE NOT NULL,
  dimensione FLOAT UNSIGNED NOT NULL,
  n_totale INT UNSIGNED NOT NULL,
  PRIMARY KEY (motivo))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabella sistema_afflitto
-- -----------------------------------------------------
CREATE TABLE  sistema_afflitto (
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (nome))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabella virus
-- -----------------------------------------------------
CREATE TABLE  virus (
  nome VARCHAR(45) NOT NULL,
  data_rilevamento DATE NOT NULL,
  percorso VARCHAR(100) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  quarantena_motivo VARCHAR(45),
  PRIMARY KEY (nome),
    FOREIGN KEY (quarantena_motivo)
    REFERENCES quarantena (motivo)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabella log_scansione
-- -----------------------------------------------------
CREATE TABLE  log_scansione (
  codice INT UNSIGNED NOT NULL AUTO_INCREMENT,
  data_inizio DATETIME(6) NOT NULL,
  data_completamento DATETIME(6) NOT NULL,
  n_oggetti_controllati INT UNSIGNED NOT NULL,
  versione_database INT UNSIGNED NOT NULL,
  antivirus_nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (codice),
    FOREIGN KEY (antivirus_nome)
    REFERENCES antivirus (nome)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabella rileva
-- -----------------------------------------------------
CREATE TABLE  rileva (
  virus_nome VARCHAR(45) NOT NULL,
  antivirus_nome VARCHAR(45) NOT NULL,
  n_virus_rilevati INT UNSIGNED NOT NULL,
  PRIMARY KEY (virus_nome, antivirus_nome),
    FOREIGN KEY (virus_nome)
    REFERENCES virus (nome)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (antivirus_nome)
    REFERENCES antivirus (nome)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabella fa_riferimento
-- -----------------------------------------------------
CREATE TABLE  fa_riferimento (
  antivirus_nome VARCHAR(45) NOT NULL,
  virus_conosciuto_nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (antivirus_nome, virus_conosciuto_nome),
    FOREIGN KEY (antivirus_nome)
    REFERENCES antivirus (nome)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (virus_conosciuto_nome)
    REFERENCES virus_conosciuto (nome)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabella attacca
-- -----------------------------------------------------
CREATE TABLE  attacca (
  virus_conosciuto_nome VARCHAR(45) NOT NULL,
  sistema_afflitto_nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (virus_conosciuto_nome, sistema_afflitto_nome),
    FOREIGN KEY (virus_conosciuto_nome)
    REFERENCES virus_conosciuto (nome)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (sistema_afflitto_nome)
    REFERENCES sistema_afflitto (nome)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
